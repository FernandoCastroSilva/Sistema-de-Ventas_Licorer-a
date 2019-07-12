
package tienda;

import java.io.Serializable;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 
public class persona implements Serializable{
   // ATRIBUTOS 
    private String nombre ;
    private String apellido;
    private int dni;
    private int cell;
    // CONSTRUCTORES
    public persona(){
        
    }

    public persona(String nombre, String apellido, int dni, int cell) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.cell = cell;
    }
    
  

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public int getCell() {
        return cell;
    }

    public void setCell(int cell) {
        this.cell = cell;
    }
    
    
}
