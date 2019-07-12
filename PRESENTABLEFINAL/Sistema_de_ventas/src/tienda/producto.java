
package tienda;

import java.io.Serializable;


public class producto implements Serializable{
    
    private int codigo; 
    private String nombre;
    private double pcosto;
    private double pventa;
     private int stock;
    
    public producto(){
        
    }

    public producto(int codigo, String nombre, double pcosto, double pventa, int stock) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.pcosto = pcosto;
        this.pventa = pventa;
        this.stock = stock;
    }

    
    public double getPventa() {
        return pventa;
    }

    public void setPventa(double pventa) {
        this.pventa = pventa;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPcosto() {
        return pcosto;
    }

    public void setPcosto(double pcosto) {
        this.pcosto = pcosto;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    
    
    
    
    
    
    
    
}
