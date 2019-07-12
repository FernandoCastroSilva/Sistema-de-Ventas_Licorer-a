
package tienda;

import java.io.Serializable;

// creamos clase cliente que hereda de persona y implementamos SERIALIZABLE para poder guardarla en un archivo
public class cliente extends persona implements Serializable{
    // atributos
    private int tarjeta ;
    private double monto ;
    
   
    public cliente(){
        
    }
     // para los que tienen tajeta
    public cliente(int tarjeta, double monto, String nombre, String apellido, int dni, int cell) {
        super(nombre, apellido, dni, cell);
        this.tarjeta = tarjeta;
        this.monto = monto;
    }
    

    // getres and seters
    public int getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(int tarjeta) {
        this.tarjeta = tarjeta;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }
    
    
    
    
    
    
    
    
    
    
}
