package modelo;

public class Gasolina {
    
    private int idGasolina;
    private String tipo;
    private float precio;
    
    public Gasolina(){
        
    }
    
    public Gasolina(int x,String y, float z){
        idGasolina=x;
        tipo=y;
        precio=z;
    }
    
    public Gasolina(Gasolina Glina){
        
    }
    
    public void setIdGasolina(int x){
        idGasolina=x;
    }
    public int getIdGasolina(){
        return idGasolina;
    }
    public void setTipo(String y){
        tipo=y;
    }
    public String getTipo(){
        return tipo;
    }
    public void setPrecio(float z){
        precio=z;
    }
    public float getPrecio(){
       return precio; 
    }
        
}