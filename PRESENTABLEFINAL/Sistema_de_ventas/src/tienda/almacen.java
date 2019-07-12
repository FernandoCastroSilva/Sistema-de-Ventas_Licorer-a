
package tienda;

import java.io.FileInputStream; // importamos 
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;
//import static tienda.clientemenu.listac; // importamos el  array  de tipo  cliente que fue creada en la ventana clientemenu


public class almacen extends javax.swing.JInternalFrame {

    public static ArrayList<producto>listap= new ArrayList(); // creamoa lista statica de tipo producto
    
    public almacen() {
    initComponents();
     this.setLocation(300, 100);
    
    }
//METODOS
    public void limpiar(){ 
         txtnom.setText("");
        txtcod.setText("");
        txtven.setText("");
        txtcos.setText("");
        txtstock.setText("");
        
    }
    
public boolean validar ( int cod  ){
        
         // COMPARAMOS SI HAY UN Codigo YA REGISTRADOS EN EL ARRAY LIST
        for (producto p : listap) { // recorremos el arreglo con un for 
            if( p.getCodigo()==cod)  // buscamos 
              return false;
            //  SI ENCUENTRA UN ELEMENTO QUE YA FUE REGISTRADO RETORNA UN VALOR FALSO
        }
        // SI NO ENCUENTRA UN ELEMENTO REPETIDO ADQUIERE EL VALOR DE VERDAD
        return true;
        
        
    }    
    
    
     public void  listar(){ // metodo para registrar en la tabla 
        // Instnciamos un matriz de tipo STRING :filas ( tamaño del arreglo )-columnas(5) 
        String matriz[][]= new String[listap.size()][5];
        for (int i = 0; i < listap.size(); i++) { // se llena la matriz con los campos ingresados en el arreglo
            matriz[i][0]=String.valueOf(listap.get(i).getCodigo()); // se registra el codigo
            matriz[i][1]=listap.get(i).getNombre();// se registra el nombre
            matriz[i][2]=String.valueOf(listap.get(i).getPventa());  
            matriz[i][3]=String.valueOf(listap.get(i).getPcosto());
            matriz[i][4]=String.valueOf(listap.get(i).getStock());       
        }
        
        // SE LLENA LA TABLA PARA MOSTRARLA
        tablap.setModel(new javax.swing.table.DefaultTableModel(
        matriz,
        new String [] {
        "CODIGO", "NOMBRE", "PRECIO VENTA", "PRECIO COSTO", "STOCK"

        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        }));    
    }
    
 // METODO GUARDAR
    public  void guardar(){
         try{ 
            FileOutputStream registroproducto=new FileOutputStream("productos.dat");
            ObjectOutputStream objp= new ObjectOutputStream(registroproducto);
            if(objp!=null){
                objp.writeObject(listap);
                objp.close();
                JOptionPane.showMessageDialog(null, "SE GUARDO CORRECTAMENTE");
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "ERROR AL GUARDAR");
            
        }
        
    }
     
    // METODO CARGAR
    public  void cargar(){
    
        try{
         FileInputStream registroproducto =new FileInputStream("productos.dat");
         ObjectInputStream objp=new ObjectInputStream(registroproducto);
        
        if(objp != null){
          listap=(ArrayList<producto>) objp.readObject();
         listar();
         objp.close();
         JOptionPane.showMessageDialog(null,"SE CARGO EL REGISTRO ");
        }
       
        }
          
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, "ERROR AL ABRIR");
            
        }
        
        
    }
    
    
     
     
     
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtcod = new javax.swing.JTextField();
        txtnom = new javax.swing.JTextField();
        txtven = new javax.swing.JTextField();
        txtcos = new javax.swing.JTextField();
        txtstock = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablap = new javax.swing.JTable();
        btnagregar = new javax.swing.JButton();
        btnbuscar = new javax.swing.JButton();
        btneliminar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        btnguardar = new javax.swing.JButton();
        btncargar = new javax.swing.JButton();
        btnaumentar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);

        jPanel1.setBackground(new java.awt.Color(153, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "PRODUCTOS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 204));
        jLabel1.setText("REGISTRO");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("CODIGO");

        jLabel3.setText("NOMBRE");

        jLabel4.setText("PRECIO VENTA");

        jLabel5.setText("PRECIO COSTO");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("STOCK ");

        txtnom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnomActionPerformed(evt);
            }
        });

        tablap.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "CODIGO", "NOMBRE", "PRECIO VENTA", "PRECIO COSTO", "STOCK"
            }
        ));
        jScrollPane1.setViewportView(tablap);

        btnagregar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnagregar.setText("AGREGAR");
        btnagregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnagregarActionPerformed(evt);
            }
        });

        btnbuscar.setText("BUSCAR");
        btnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarActionPerformed(evt);
            }
        });

        btneliminar.setText("ELIMINAR");
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
            }
        });

        jButton2.setText("LIMPIAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        btnguardar.setForeground(new java.awt.Color(255, 0, 0));
        btnguardar.setText("GUARDAR REGISTRO");
        btnguardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });

        btncargar.setForeground(new java.awt.Color(255, 0, 0));
        btncargar.setText("CARGAR REGISTRO");
        btncargar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btncargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncargarActionPerformed(evt);
            }
        });

        btnaumentar.setText("AUMENTAR STOCK");
        btnaumentar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaumentarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1)
                            .addComponent(txtnom, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                            .addComponent(txtcod)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtstock, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                                .addComponent(txtcos, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtven, javax.swing.GroupLayout.Alignment.LEADING)))
                        .addGap(66, 66, 66)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btnbuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btneliminar, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
                                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(btnagregar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(99, 99, 99)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btncargar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnguardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnaumentar)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 712, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtcod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnagregar)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(btnguardar)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel4)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtnom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addComponent(txtven, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btncargar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnbuscar)))
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addGap(45, 45, 45))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtcos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btneliminar, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(jButton2))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnaumentar)
                                    .addComponent(txtstock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtnomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnomActionPerformed

    private void btnagregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnagregarActionPerformed
      
        
     try{
         //OBTENEMOS DATOS QUE FuERON REGISTRADOS EN LOS CAMPOS
            String nom= txtnom.getText();
            String  scod=txtcod.getText();
            String spc=txtcos.getText();
            String spv=txtven.getText();
            String sstock=txtstock.getText();
            
            
            // VALIDMOS QUE NO HAYA  CAMPOS EN BLANCOS
            boolean vacio= false ; // declaramos la variable y le damos valor de false
            if( "".equals(nom)) vacio = true;    // si es que cumple una de estas condiciones 
            if( "".equals(scod)) vacio = true;     // el valor de la variable cambia a true Y NO ENTRA AL IF
            if( "".equals(spc)) vacio = true;
            if( "".equals(spv)) vacio = true;              
            if( "".equals(sstock)) vacio = true;

             // SI NO SE INGRESA  TODOS LOS CAMPOS  LA VARIABLE VACIO TIENE VALOR DE FALSE
            // Y ENTRA AL IF MOSTRANDO UN ERROR
            if(vacio){
                JOptionPane.showMessageDialog(null, "DEBE INGRESSAR TODOS LOS CAMPOS");
                return;
            }
        
            // SI SE LLENAN  TODOS LOS DATOS CONVERTIMOS A VALORES numericos  ;
            int cod=Integer.parseInt(scod);
            double pc = Double.parseDouble(spc);
            double pv = Double.parseDouble(spv);
            int stock=Integer.parseInt(sstock);
            
           // instanciamos un objeto de la clase CLIENTE para luego añadirla al arraylist LISTC
            // PERO ANTES DE ESO VALIDAMOS QUE NO HAYA DATOS ANTERIORES REGISTRADOS REPETIDOS con el
            // metodo validar()

            if( validar(cod)){
                producto p = new producto(cod, nom, pc, pv, stock);
                listap.add(p);
                limpiar();
                listar();
                JOptionPane.showMessageDialog(null," PRODUCTO REGISTRADO CORRECTAMENTE");

            }
            else{
                JOptionPane.showMessageDialog(null,"ERROR- PRODUCTO YA HA SIDO REGISTRADO");
            }
        
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "DEBE INGRESAR DATOS NUMERICOS");
        }
        
        
    }//GEN-LAST:event_btnagregarActionPerformed

    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed
      
        // PEDIMOS EL CODIGO DE PRODUCTO A BUSCAR
        String scod=JOptionPane.showInputDialog("INGRESE EL CODIGO DE PRODUCTO ");
        // VERIFICAMOS QUE SE LLENE EL CAMPO CON UN IF
        if("".equals(scod)){
            JOptionPane.showMessageDialog(null," DEBE INGRESAR EL CODIGO ");
            return;
        }

        try{
            //SI EL CAMPO NO ESTA VACIO BUSCAMOS EN LA LISTA
            int cod=Integer.parseInt(scod);
            for (producto p : listap) {
                if(p.getCodigo()==cod){
                    // SE MUESTRA LOS CAMPOS
                    txtnom.setText(p.getNombre());
                    txtnom.setEditable(false);// no te permite modifificar el campo ;
                    txtcod.setText(String.valueOf(p.getCodigo()));
                    txtcod.setEditable(false);
                    txtven.setText(String.valueOf(p.getPventa()));
                    txtven.setEditable(false);
                    txtcos.setText(String.valueOf(p.getPcosto()));
                    txtcos.setEditable(false);
                    txtstock.setText(String.valueOf(p.getStock()));
                    txtstock.setEditable(false);
                    return;
                }

            }

            JOptionPane.showMessageDialog(null,"PRODUCTO  NO ENCONTRADO");

        }

        catch(Exception e){

            JOptionPane.showMessageDialog(null,"ERROR- EL CODIGO DEBE SER NUMERICO");

        }

        
    }//GEN-LAST:event_btnbuscarActionPerformed

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
        String scod=JOptionPane.showInputDialog("INGRESE EL CODIGO A  ELIMINAR");
        // VERIFICAMOS QUE SE INGRESE INFORMACION A BUSCAR
        if("".equals(scod)){
            JOptionPane.showMessageDialog(null," DEBE INGRESAR CODIGO DE PRODUCTO");
            return;
        }

        try{
            //SI EL CAMPO NO ESTA VACIO BUSCAMOS EN LA LISTA
            int cod=Integer.parseInt(scod);
            for (producto p : listap) {
                if(p.getCodigo()==cod){
                    String nombre= p.getNombre(); // se extrae el nombre
                    JOptionPane.showMessageDialog(null,nombre+ " " +" se elimino del registro ");
                    listap.remove(p);
                    listar();
                    limpiar();
                    return;
                }

            }

            JOptionPane.showMessageDialog(null,"PRODUCTO NO ENCONTRADO");

        }

        catch(Exception e){

            JOptionPane.showMessageDialog(null,"ERROR- EL CODIGO DEBE SER NUMERICA");

        }        
        
        
    }//GEN-LAST:event_btneliminarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        limpiar();
        txtnom.setEditable(true);
        txtcod.setEditable(true);
        txtven.setEditable(true);
        txtcos.setEditable(true);
        txtstock.setEditable(true);
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        guardar();
    }//GEN-LAST:event_btnguardarActionPerformed

    private void btncargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncargarActionPerformed
        cargar();
    }//GEN-LAST:event_btncargarActionPerformed

    private void btnaumentarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaumentarActionPerformed
        
        // PEDIMOS EL CODIGO DE PRODUCTO A BUSCAR
        String scod=JOptionPane.showInputDialog("INGRESE EL CODIGO DE PRODUCTO ");
        // VERIFICAMOS QUE SE LLENE EL CAMPO CON UN IF
        if("".equals(scod)){
            JOptionPane.showMessageDialog(null," ERROR- DEBE INGRESAR EL CODIGO ");
            return;
        }
        
        try{
            //SI EL CAMPO NO ESTA VACIO BUSCAMOS EN LA LISTA
            int cod=Integer.parseInt(scod);
            for (producto p : listap) {
                if(p.getCodigo()==cod){
                    int can=Integer.parseInt(JOptionPane.showInputDialog("INGRESE CANTIDAD A AUMENTAR"));
                    // SE MUESTRA LOS CAMPOS
                    txtnom.setText(p.getNombre());
                    txtnom.setEditable(false);// no te permite modifificar el campo ;
                   
                     p.setStock(p.getStock()+can);// asiganamos nuevo  stcok pero antes le agregamos la cantidad que se
                                                  // ha ingresado 
                    
                   txtstock.setText(String.valueOf(p.getStock())); // mosntramos n el campo el nuevo stock
                   listap.remove(p); // eliminamos 
                    listap.add(p); // añadimos el nuevo  dato con el stock actualizado
                    txtstock.setEditable(false); 
                   guardar(); // guardsmoa
                 
                listar(); // mostramos en la tabla con el stock actualizado
                 JOptionPane.showMessageDialog(null," STOCK ACTUALIZADO CORRECTAMENTE");
                    
                    
                    
                    return;
                }

            }

            JOptionPane.showMessageDialog(null,"PRODUCTO  NO ENCONTRADO");

        }

        catch(Exception e){

            JOptionPane.showMessageDialog(null,"ERROR- EL CODIGO DEBE SER NUMERICO");

        }

        
    }//GEN-LAST:event_btnaumentarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnagregar;
    private javax.swing.JButton btnaumentar;
    private javax.swing.JButton btnbuscar;
    private javax.swing.JButton btncargar;
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablap;
    private javax.swing.JTextField txtcod;
    private javax.swing.JTextField txtcos;
    private javax.swing.JTextField txtnom;
    private javax.swing.JTextField txtstock;
    private javax.swing.JTextField txtven;
    // End of variables declaration//GEN-END:variables
}
