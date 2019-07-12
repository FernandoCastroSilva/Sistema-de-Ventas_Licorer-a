
package tienda;

import java.io.FileInputStream; // importamos librerias 
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class clientemenu extends javax.swing.JInternalFrame {

    //INSTANCIAMOS UN ARRAYLIST DE TIPO CLIENTE Y LO HACEMOS STATIC PARA PODER USARLA EN OTRAS CLASES SIN QUE LOS
    // DATOS INGRESADOS SE PIERDAN
   public static ArrayList<cliente> listac =new ArrayList();
    public clientemenu() {
        initComponents();
        this.setLocation(300, 100); // ubicacion dela ventana
    }

    //METODOS
    public void limpiar(){ // metodos que limpiara los campos
         txtnom.setText("");
        txtape.setText("");
        txtdni.setText("");
        txtcel.setText("");
        txttar.setText("");
        txtmon.setText("");
    }
    
    public boolean validar ( int dni, int cel ,int tar  ){ // creamos un metodo de tipo boolean para validar si un cliente ya hasido registrado
        
        for (cliente c : listac) { // recorremos el array para comparar si ya fue registrado DNI CEL O TARJETA
            if( c.getDni()==dni|| c.getCell()==cel||c.getTarjeta()==tar) // SI cumple uno de cualkiera de las condiciones  
              return false;  // retorna falso
            
        }
        // SI NO ENCUENTRA UN ELEMENTO REPETIDO ADQUIERE EL VALOR DE VERDAD
        return true;
        
        
    }
    
    
     public void  listar(){ // metodo para registrar en la tabla 
        // Instnciamos un matriz de tipo STRING :filas ( tamaño del arreglo )-columnas(6) 
        String matriz[][]= new String[listac.size()][6];
        for (int i = 0; i < listac.size(); i++) { // se llena la matriz con los campos ingresados en el arreglo
            matriz[i][0]=listac.get(i).getNombre(); // se registra el nombre
            matriz[i][1]=listac.get(i).getApellido();// se registra el apellido
            matriz[i][2]=String.valueOf(listac.get(i).getDni()); // convertimos a cadena los datos enteros 
            matriz[i][3]=String.valueOf(listac.get(i).getCell());// como DNI  CELL TAJETA Y MONTO
            matriz[i][4]=String.valueOf(listac.get(i).getTarjeta());
            matriz[i][5]=String.valueOf(listac.get(i).getMonto());
                
        }
        
        // SE LLENA LA TABLA PARA MOSTRARLA
        tblcliente.setModel(new javax.swing.table.DefaultTableModel(
        matriz, // a la tabla clientes le asignamos el arreglo matriz 
        new String [] {
        "NOMBRE", "APELLIDO", "DNI", "CELL", "TARJETA", "MONTO" // cabezeras de las columnas
         }));    
    }
    
    public  void guardar(){
         try{ 
            FileOutputStream registrocliente=new FileOutputStream("clientes.dat"); //  archivo de salida .dat con nomnbre cliente
            ObjectOutputStream objc= new ObjectOutputStream(registrocliente); // creamos un flujo de salida (obc)
            if(objc!=null){ // comparamos  que el flujo no sea nulo para poder escribbir en el
                objc.writeObject(listac); // asignamos al flujo el array listac 
                objc.close(); // cerramos flujo
                JOptionPane.showMessageDialog(null, "SE GUARDO CORRECTAMENTE"); // mandamos mensaje de confirmacion
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "ERROR AL GUARDAR"); // si ay un error ..manda mensaje de error
            
        }
        
    }
    
    public  void cargar(){ // metodo cargar 
    
        try{
         FileInputStream registrocliente =new FileInputStream("clientes.dat");// archivo de entrada clientes.dat  
          ObjectInputStream objc=new ObjectInputStream(registrocliente); // flujo de entrada objc 
        
        if(objc != null){ // comparamo ke no sea nulo 
          listac=(ArrayList<cliente>) objc.readObject(); // leemos objeto OBC y lo convertimos en array de tipo cliente
         listar(); // ulitizamos metodo listar para que aparesca en la tabla cliente 
         objc.close(); // cerramos flujo 
         JOptionPane.showMessageDialog(null,"SE CARGO EL REGISTRO "); // mensaje de confirmacion 
        }
       
        }
          
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, "ERROR AL ABRIR"); // mensaje de error 
            
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
        jLabel7 = new javax.swing.JLabel();
        txtnom = new javax.swing.JTextField();
        txtape = new javax.swing.JTextField();
        txtdni = new javax.swing.JTextField();
        txtcel = new javax.swing.JTextField();
        txttar = new javax.swing.JTextField();
        txtmon = new javax.swing.JTextField();
        btnregistro = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblcliente = new javax.swing.JTable();
        btnbuscar = new javax.swing.JButton();
        btneliminar = new javax.swing.JButton();
        btnguadar = new javax.swing.JButton();
        btncargar = new javax.swing.JButton();
        btnlimpiar = new javax.swing.JButton();
        btnactualizar = new javax.swing.JButton();

        setBorder(null);
        setClosable(true);
        setIconifiable(true);

        jPanel1.setBackground(new java.awt.Color(153, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CLIENTE", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 255));
        jLabel1.setText("REGISTRO");

        jLabel2.setText("NOMBRE");

        jLabel3.setText("APELLIDOS");

        jLabel4.setText("DNI");

        jLabel5.setText("CELL");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("TARJETA");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("MONTO ");

        txtnom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnomActionPerformed(evt);
            }
        });

        txttar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttarActionPerformed(evt);
            }
        });

        txtmon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtmonActionPerformed(evt);
            }
        });

        btnregistro.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnregistro.setText("REGISTRAR");
        btnregistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnregistroActionPerformed(evt);
            }
        });

        tblcliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "NOMBRE", "APELLIDO", "DNI", "CELL", "TARJETA", "MONTO"
            }
        ));
        jScrollPane1.setViewportView(tblcliente);

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

        btnguadar.setForeground(new java.awt.Color(255, 0, 51));
        btnguadar.setText("GUARDAR REGISTRO");
        btnguadar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnguadar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguadarActionPerformed(evt);
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

        btnlimpiar.setText("LIMPIAR");
        btnlimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlimpiarActionPerformed(evt);
            }
        });

        btnactualizar.setText("ACTUALIZAR MONTO");
        btnactualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnactualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtmon)
                            .addComponent(txttar)
                            .addComponent(txtcel)
                            .addComponent(txtape, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(txtnom)
                            .addComponent(txtdni))
                        .addGap(66, 66, 66)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnregistro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnbuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btneliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnlimpiar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(132, 132, 132)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnguadar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btncargar)
                            .addComponent(btnactualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addComponent(jLabel1)))
                .addContainerGap(130, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 45, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 775, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtnom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnregistro)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jLabel2)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jLabel3))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(txtape, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(btnguadar)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(btncargar)
                        .addGap(11, 11, 11)
                        .addComponent(btnbuscar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(txtdni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtcel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txttar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(btnactualizar))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtmon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(btneliminar)
                        .addGap(29, 29, 29)
                        .addComponent(btnlimpiar)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtnomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnomActionPerformed

    private void txttarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttarActionPerformed

    private void txtmonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtmonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtmonActionPerformed

    private void btnregistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnregistroActionPerformed
        
        try{
         //OBTENEMOS DATOS QUE FuERON REGISTRADOS EN LOS CAMPOS
            String nom= txtnom.getText();
            String ape=txtape.getText();
            String sdni=txtdni.getText();
            String scel=txtcel.getText();
            String star=txttar.getText();
            String smon= txtmon.getText();
            
            // VALIDMOS QUE NO HAYA  CAMPOS EN BLANCOS
            boolean vacio= false ; // declaramos la variable y le damos valor de false
            if( "".equals(nom)) vacio = true;    // si es que cumple una de estas condiciones 
            if( "".equals(ape)) vacio = true;     // el valor de la variable cambia a true Y NO ENTRA AL IF
            if( "".equals(sdni)) vacio = true;
            if( "".equals(scel)) vacio = true;              
            if( "".equals(star)) vacio = true;
            if("".equals(smon)) vacio = true;

             // SI NO SE INGRESA  TODOS LOS CAMPOS  LA VARIABLE VACIO TIENE VALOR DE FALSE
            // Y ENTRA AL IF MOSTRANDO UN ERROR
            if(vacio){
                JOptionPane.showMessageDialog(null, "DEBE INGRESSAR TODOS LOS CAMPOS");
                return;
            }
        
            // SI SE LLENAN  TODOS LOS DATOS CONVERTIMOS A VALORES numericos DNI CELL TARJETA Y MONTO ;
            int dni=Integer.parseInt(sdni);
            int cel =Integer.parseInt(scel);
            int tar =Integer.parseInt(star);
            double mon = Double.parseDouble(smon);
        
           // instanciamos un objeto de la clase CLIENTE para luego añadirla al arraylist LISTC
            // PERO ANTES DE ESO VALIDAMOS QUE NO HAYA DATOS ANTERIORES REGISTRADOS REPETIDOS con el
            // metodo validar()

            if( validar(dni,cel,tar)){
                cliente c =new cliente(tar, mon, nom, ape, dni, cel);
                listac.add(c); // añadimos 
                limpiar(); // limpiamos campos 
                listar(); // lo mostramos en la tabla
                JOptionPane.showMessageDialog(null,"SE REGISTRO CORRECTAMENTE"); // mesnaje de confirmcion 

            }
            else{
                JOptionPane.showMessageDialog(null,"ERROR- DNI CELL O TARJETA  YA HA SIDO REGISTRADO"); // mensaje de error 
            }
        
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "DEBE INGRESAR DATOS NUMERICOS");// mensaje de error 
        }
        
        
        
    }//GEN-LAST:event_btnregistroActionPerformed

    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed
       // PEDIMOS EL CODIGO DE CLIENTE A BUSCAR
        String star=JOptionPane.showInputDialog("INGRESE LA TAJETA DEL CLIENTE ");
        // VERIFICAMOS QUE SE LLENE EL CAMPO CON UN IF
        if("".equals(star)){
            JOptionPane.showMessageDialog(null," DEBE INGRESAR LA TARJETA DEL CLIENTE");
            return;
        }

        try{
            //SI EL CAMPO NO ESTA VACIO BUSCAMOS EN LA LISTA pero antes lo convertimos a entero 
            int tar=Integer.parseInt(star);
            for (cliente c : listac) { // recooremos el array con un for 
                if(c.getTarjeta()==tar){ // si encontramos un datoTARJETA que concide con el dato qu hemos ingresado
                    // SE MUESTRA LOS CAMPOS
                    txtnom.setText(c.getNombre());
                    txtnom.setEditable(false);// no te permite modifificar el campo ;
                    txtape.setText(c.getApellido());
                    txtape.setEditable(false);
                    txtcel.setText(String.valueOf(c.getCell()));
                    txtcel.setEditable(false);
                    txtdni.setText(String.valueOf(c.getDni()));
                    txtdni.setEditable(false);
                    txttar.setText(String.valueOf(c.getTarjeta()));
                    txttar.setEditable(false);
                    txtmon.setText(String.valueOf(c.getMonto()));
                    txtmon.setEditable(false);
                    return;
                }

            }

            JOptionPane.showMessageDialog(null,"CLIENTE NO ENCONTRADO"); // mesnaje de error si es ke no encotramos 

        }

        catch(Exception e){

            JOptionPane.showMessageDialog(null,"ERROR- LA TARJETA DEBE SER NUMERICO"); // mensaje de error si es ke no es numerico 

        }

        
        
        
        
    }//GEN-LAST:event_btnbuscarActionPerformed

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
        
        String star=JOptionPane.showInputDialog("INGRESE LA TARJETA DEL CLIENTE A ELIMINAR");
        // VERIFICAMOS QUE SE INGRESE INFORMACION A BUSCAR
        if("".equals(star)){
            JOptionPane.showMessageDialog(null," DEBE INGRESAR LA TARJETA DEL CLIENTE");
            return;
        }

        try{
            //SI EL CAMPO NO ESTA VACIO BUSCAMOS EN LA LISTA pero antes lo converitmos a entero
            int tar=Integer.parseInt(star);
            for (cliente c : listac) { // recorremos con un for 
                if(c.getTarjeta()==tar){ // buscamos en el arreglo  .
                    String nombre= c.getNombre(); // se extrae el nombre
                    String apellido=c.getApellido();// se extrae el apeelido
                    JOptionPane.showMessageDialog(null,nombre+ " " + apellido+" se elimino del registro ");
                    listac.remove(c); // eliminamos del arreglo 
                    listar(); // mostramos en tabla 
                    limpiar(); // limpamos campos 
                    return;
                }

            }

            JOptionPane.showMessageDialog(null,"CLIENTE NO ENCONTRADO"); // mensaje d eerror si no lo encotramos 

        }

        catch(Exception e){

            JOptionPane.showMessageDialog(null,"ERROR- LA TARJETA DEBE SER NUMERICA");

        }

        
    }//GEN-LAST:event_btneliminarActionPerformed

    private void btnguadarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguadarActionPerformed
       guardar(); 
    }//GEN-LAST:event_btnguadarActionPerformed

    private void btncargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncargarActionPerformed
        cargar();
    }//GEN-LAST:event_btncargarActionPerformed

    private void btnlimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlimpiarActionPerformed
        limpiar();
        txtnom.setEditable(true);
        txtape.setEditable(true);
        txtdni.setEditable(true);
        txtcel.setEditable(true);
        txttar.setEditable(true);
        txtmon.setEditable(true);
    }//GEN-LAST:event_btnlimpiarActionPerformed

    private void btnactualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnactualizarActionPerformed
       
        // PEDIMOS EL numero de tarjeta  A BUSCAR
        String star=JOptionPane.showInputDialog("INGRESE NUMERO DE TARJETA ");
        // VERIFICAMOS QUE SE LLENE EL CAMPO CON UN IF
        if("".equals(star)){
            JOptionPane.showMessageDialog(null," ERROR- DEBE INGRESAR EL NUMERO DE TARJETA ");
            return;
        }
        
        try{
            //SI EL CAMPO NO ESTA VACIO BUSCAMOS EN LA LISTA
             int tar=Integer.parseInt(star);
            for (cliente c: listac) { //recorremos el arreglo para buscar el numero de tarjeta
                if(c.getTarjeta()==tar){ // si se encunetra manda un mesanje para pedir el monto ke se deea aumentar
                    int mon=Integer.parseInt(JOptionPane.showInputDialog("INGRESE CANTIDAD A AUMENTAR"));
                    // SE MUESTRA LOS CAMPOS
                    txtnom.setText(c.getNombre());
                    txtnom.setEditable(false);// no te permite modifificar el campo ;
                    txtape.setText(c.getApellido());
                    txtape.setEditable(false);
                    txttar.setText(String.valueOf(c.getTarjeta()));
                    txttar.setEditable(false);
                    
                     c.setMonto(c.getMonto()+mon);// asigamos el nuevo monto de la tarjeta pero antes le sumamos la cantidad
                                                   // que emos ingresado 
                   txtmon.setText(String.valueOf(c.getMonto())); // mostramos el nuevo  mono 
                   listac.remove(c); // elinamos 
                    listac.add(c); // volvemos a añadir para actualizar el nuevo monto 
                    txtmon.setEditable(false); 
                   guardar(); // guardamos el nuevo registro con el metodo guardar
                
                listar(); // mostramos en la tabla con el monto  actualizado 
                JOptionPane.showMessageDialog(null,"MONTO DE LA TARJETA SE ACTUALIZO CORRECTAMENTE");
                    
                    
                    
                    return;
                }

            }

            JOptionPane.showMessageDialog(null,"CLIENTE NO ENCONTRADO"); // mensaje de error si es ke no encotramos al cleinte 

        }

        catch(Exception e){

            JOptionPane.showMessageDialog(null,"ERROR- EL NUMEERO DE TARJETA DEBE SER NUMERICO"); // mensaje de error

        }
        
        
        
        
        
        
        
    }//GEN-LAST:event_btnactualizarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnactualizar;
    private javax.swing.JButton btnbuscar;
    private javax.swing.JButton btncargar;
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btnguadar;
    private javax.swing.JButton btnlimpiar;
    private javax.swing.JButton btnregistro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblcliente;
    private javax.swing.JTextField txtape;
    private javax.swing.JTextField txtcel;
    private javax.swing.JTextField txtdni;
    private javax.swing.JTextField txtmon;
    private javax.swing.JTextField txtnom;
    private javax.swing.JTextField txttar;
    // End of variables declaration//GEN-END:variables

    
}
