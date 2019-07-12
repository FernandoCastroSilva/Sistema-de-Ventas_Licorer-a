
package tienda;
// creampos clase ventacontarjeta 
public class ventacontarjeta {
  
    // atributos
    private String nombre;
    private int tarjeta;
    private String pago;
    private double total;
    // contructores
    
    public ventacontarjeta(){
        
    }

    public ventacontarjeta(String nombre, int tarjeta, String pago, double total) {
        this.nombre = nombre;
        this.tarjeta = tarjeta;
        this.pago = pago;
        this.total = total;
    }

    // geterse y seters 
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

    public int getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(int tarjeta) {
        this.tarjeta = tarjeta;
    }

    public String getPago() {
        return pago;
    }

    public void setPago(String pago) {
        this.pago = pago;
    }
    
    
    
    
    
    
}
