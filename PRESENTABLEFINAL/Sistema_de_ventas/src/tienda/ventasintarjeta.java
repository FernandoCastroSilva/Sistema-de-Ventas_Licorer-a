
package tienda;


public class ventasintarjeta {
   // atributos    
    private String nombre;
    private String pago;
    private double total;
    
    // costructores
    public ventasintarjeta(){
        
    }

    public ventasintarjeta(String nombre, String pago, double total) {
        this.nombre = nombre;
        this.pago = pago;
        this.total = total;
    }

    // get y seter
    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPago() {
        return pago;
    }

    public void setPago(String pago) {
        this.pago = pago;
    }
    
    
    
    
    
    
    
    
    
    
    
    
}
