package Controlador;

import modelo.Bomba;
import vista.dlgBombas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import modelo.Gasolina;

public class Controlador implements ActionListener {

    private Bomba Bma;
    private dlgBombas vista;
    private int aVentas = 1;
    private float validacion;

    public Controlador(Bomba Bma, dlgBombas vista) {

        this.Bma = Bma;
        this.vista = vista;

        //Escuche los botones
        vista.btnIBomba.addActionListener(this);
        vista.btnRegistrar.addActionListener(this);
    }

    private void IniciarVista() {
        vista.setTitle("--:: Gasolineria ::--");
        vista.setSize(580, 450);
        vista.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnIBomba) {
            float pre;
            pre = CapturaDatos();

            if (VEspVIBomba() == true) {
                try {
                    Bma.IniciarBomba(Integer.parseInt(vista.txtNBomba.getText()),
                            new Gasolina(vista.ComboTGas.getSelectedIndex(),
                                    vista.ComboTGas.getSelectedItem().toString(), pre),
                            vista.SliderCBomba.getValue(), 0f);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(vista, "A ocurrido un error: " + ex);

                } catch (Exception ex2) {
                    JOptionPane.showMessageDialog(vista, "A ocurrido un error: " + ex2);
                }
                vista.txtPVentas.setText(String.valueOf(Bma.getGas().getPrecio()));
                vista.txtCVentas.setText("0");

                vista.txtCantidad.setEnabled(true);
                vista.btnRegistrar.setEnabled(true);

                vista.txtNBomba.setEnabled(false);
                vista.ComboTGas.setEnabled(false);
                vista.SliderCBomba.setEnabled(false);
            } else {
                JOptionPane.showMessageDialog(vista, "No espacios en blanco");
            }

        }

        if (e.getSource() == vista.btnRegistrar) {

            if (VEspVRegistrar() == true) {
                try {
                    validacion = Bma.VenderGasolina(Float.parseFloat(vista.txtCantidad.getText()));

                    if (validacion == 0) {
                        JOptionPane.showMessageDialog(vista, "Tanque sin capacidad");
                    } else {
                        vista.txtCVentas.setText(String.valueOf(aVentas++));
                        vista.SliderCBomba.setValue((int) (Bma.getCBomba() - Bma.getALitros()));
                        vista.txtTVentas.setText(String.valueOf(Bma.VentasTotales()));
                        vista.txtCosto.setText(String.valueOf(validacion));

                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(vista, "A ocurrido un error: " + ex);

                } catch (Exception ex2) {
                    JOptionPane.showMessageDialog(vista, "A ocurrido un error: " + ex2);
                }

            } else {
                JOptionPane.showMessageDialog(vista, "No espacios en blanco");
            }

        }
    }

    public boolean VEspVIBomba() {
        if (!vista.txtNBomba.getText().isEmpty()
                && vista.ComboTGas.getSelectedItem() != " "
                && vista.SliderCBomba.getValue() != 0) {
            return true;

        } else {
            return false;
        }
    }

    public boolean VEspVRegistrar() {
        if (!vista.txtCantidad.getText().isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public float CapturaDatos() {
        if (vista.ComboTGas.getSelectedItem() == "Regular") {
            return 20.05f;
        } else if (vista.ComboTGas.getSelectedItem() == "Premium") {
            return 23.98f;
        } else if (vista.ComboTGas.getSelectedItem() == "Diesel") {
            return 24.71f;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        Bomba Bma = new Bomba();
        dlgBombas vista = new dlgBombas();

        Controlador contr = new Controlador(Bma, vista);
        contr.IniciarVista();
    }
}
