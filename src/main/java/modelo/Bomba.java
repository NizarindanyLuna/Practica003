package modelo;

public class Bomba {    
    private int nBomba;
    private float cBomba,aLitros;
    private Gasolina gas;
    
    public Bomba(){
        nBomba=0;
        cBomba=0;
        aLitros=0;
    }

    public Bomba(int nBomba, float cBomba, float aLitros, Gasolina gas) {
        this.nBomba = nBomba;
        this.cBomba = cBomba;
        this.aLitros = aLitros;
        this.gas = gas;
    }
    
    public Bomba(Bomba Bomb){
        
    }

    public void setNBomba(int nBomba) {
        this.nBomba = nBomba;
    }

    public void setCBomba(float cBomba) {
        this.cBomba = cBomba;
    }

    public void setALitros(float aLitros) {
        this.aLitros += aLitros;
    }

    public void setGas(Gasolina gas) {
        this.gas=gas;
    }

    public int getNBomba() {
        return nBomba;
    }

    public float getCBomba() {
        return cBomba;
    }

    public float getALitros() {
        return aLitros;
    }

    public Gasolina getGas() {
        return gas;
    }
    
    public void IniciarBomba(int nBomba,Gasolina gas, float cBomba,float aLitros){
        setNBomba(nBomba);
        setALitros(aLitros);
        setCBomba(cBomba);
        setGas(gas);
        
    }
    
    public float InventarioGasolina(){
        return getCBomba()-getALitros();
    }
    
    public float VenderGasolina(float cantidad){
        if(InventarioGasolina()>=cantidad){
            setALitros(cantidad);
            return cantidad*gas.getPrecio();
            
        }
        else{
          return 0;  
        }
    }
    
    public float VentasTotales(){
        return getALitros()*getGas().getPrecio();
    }
    
}