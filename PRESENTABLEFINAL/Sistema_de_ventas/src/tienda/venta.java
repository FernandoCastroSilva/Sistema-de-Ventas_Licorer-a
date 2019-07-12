
package tienda;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static tienda.clientemenu.listac; // importamos arreglos staticos para 
import static tienda.almacen.listap;// poder usar los datos registrados 

 

public class venta extends javax.swing.JInternalFrame {

    DefaultTableModel modelo= new DefaultTableModel(); // instanciamos la tabla modelo 
    ArrayList<ventasintarjeta>listast=new ArrayList(); // arays qu ya han sido creados en otros jfrme
    ArrayList<ventacontarjeta>listact=new ArrayList();
    public venta() {
        initComponents();
        this.setLocation(300, 100);
        this.tblventa.setModel(modelo);// asignamos tabla
        modelo.addColumn("NOMBRE");// adañimos columnas
        modelo.addColumn("PAGO");
        modelo.addColumn("PRODUCTO");
        modelo.addColumn("PRECIO");
        modelo.addColumn("CANTIDAD");
        modelo.addColumn("TOTAL");
    }

   
// METODOS

    
    public void limpiar(){
     this.txtape.setText(""); // limpiaa campos 
        this.txtnom.setText("");
        this.txttar.setText("");
        this.txtsal.setText("");
        this.txtdni.setText("");
        this.txtcodc.setText("");
        this.txtprec.setText("");
        this.txtcanc.setText("");
        this.txtnomc.setText("");
        this.txtstock.setText("");
        this.txttotal.setText("");
        this.txtpago.setText("");
        this.cbtipo.setSelectedIndex(0); // cbvox selecionamos la primera opcion 
        this.btncontarjeta.setEnabled(true); // habilitmos botones 
        this.btnsintarjeta.setEnabled(true);
        int filas=modelo.getRowCount();
        for (int i = 0; i <= filas; i++) { // hacemos  un for para limpiar tabla 
            modelo.removeRow(0); // 
        }   
        
    }
    
    
    
    
    public void introducirtabla(){ // metodo  que sirve para agregar los datos ingresado en los campos  a la tabla  
         this.modelo.addRow(new Object[]{ // add row ( añadir fila)
        this.txtnom.getText(),this.cbtipo.getSelectedItem(),this.txtnomc.getText(),this.txtprec.getText(),
        this.txtcanc.getText(),this.txttotal.getText()
      
      
      });
    }
public void  saldo(){
     double pre=Double.parseDouble(txtprec.getText());
      int can=Integer.parseInt(txtcanc.getText());
      double total = pre*can;
    
            //SE BUSCA LA TARJETA PARA VERIFICAR EL MONTO
            int tar=Integer.parseInt(txttar.getText());
               for (cliente c : listac){
                    if(c.getTarjeta()==tar){
                        
                        // obtenemos el monto de la tarjeta y le restamos el total 
                        double saldo1= c.getMonto()-total;
                       
                        if(saldo1<0){
                            JOptionPane.showMessageDialog(null,"SALDO INSUFICIENTE");
                           // saldo1=c.getMonto()+total;
                            modelo.removeRow(modelo.getRowCount()-1);
                            return ;
                        }
                        c.setMonto(saldo1);
                        
                        
                        txtsal.setText(String.valueOf(saldo1));
                       
                        return ;
               }
                
               }

}


public boolean stock(){
    
      int can=Integer.parseInt(txtcanc.getText());  // convertimos valores string a enteros 
      int cod=Integer.parseInt(txtcodc.getText());
       for (producto p : listap){ // recorremos el arreglo con un for 
                    if(p.getCodigo()==cod){ // buscamos 
                        
                        // obtenemoS LA CANTIDAD de elementos en el almacen y le restamos la cantidad
                     
                        int sf= p.getStock()-can;
                      if(sf<0){ // si sale negativo sf mostrar mensaje de error 
                            JOptionPane.showMessageDialog(null,"STOCK INSUFICIENTE ACTUALIZE EL STOCK");
                            sf=p.getStock()+can;
                            //modelo.removeRow(modelo.getRowCount()-1);
                            return false; // retonamos valor de falso
                        }
                      
                        // asiganmos el nuevo stock restante en el alamacen
                        p.setStock(sf);
                        introducirtabla(); // introducimos un nueva flia con los datos ingresados a la tabla 
      
                     txtstock.setText(String.valueOf(sf));
      
      
                    }
       }
   return true;
    
}


public void calcular(){
       
      int can=Integer.parseInt(txtcanc.getText()); // converitmos a nmericos los datos 
      int cod=Integer.parseInt(txtcodc.getText());
      double pre=Double.parseDouble(txtprec.getText());    
      double total = pre*can; // calculamos el total a pagar 
      boolean a =true; // creamos una variable booleana 
      int sf=0; // inicializamos sf con valor 0 
      
      if (a) {
      for (producto p : listap){ // recorremos la listap con un for 
                    if(p.getCodigo()==cod){ // buscamos en el arreglo  con un if 
                        if(p.getStock()>can){ // si lo encontramo obtemos el stock actual de el producto  y verificamos ke sea mayor ala cantidad
                                               // qu queremos comprar
                        // obtenemoS LA CANTIDAD de elementos en el almacen y le restamos la cantidad
                        // y la asignamos ala variable  sf 
                         sf= p.getStock()-can;
                        p.setStock(sf); // asigamos el nuevo  valor de stock (sf)
                     txtstock.setText(String.valueOf(sf)); // mostramo stcok rstante o nuevo stock en el campo 
                     a=true; 
                     
                    }
                        else{
                            JOptionPane.showMessageDialog(null,"ERROR actualizar stock"); //si el stock actual no cumple   
                            a =false; // con la condicion ...la variable boobleana cambia a false .. 
                           return;
                        } 
                        } 
                        
                        // asiganmos el nuevo stock restante en el alamacen
                      
                    } 
                  
      }
      
      if(a){
      //SE BUSCA LA TARJETA PARA VERIFICAR EL MONTO
            int tar=Integer.parseInt(txttar.getText()); // convetimos a nmerico 
               for (cliente c : listac){ // recorremos con un for el array lista c
                    if(c.getTarjeta()==tar){ // buscamos ..comparando el numero de trjeta qu estan regitrad en el array listc
                        if(c.getMonto()>total){ // si el monto es mayor al totoal a pagar 
                        // obtenemos el monto de la tarjeta y le restamos el total 
                        double saldo1= c.getMonto()-total;
                        c.setMonto(saldo1); // asignamos el nuevo monto restante de la tarjeta
                        
                        
                        txtsal.setText(String.valueOf(saldo1)); // mostramos en el campo el saldo de la tarjeta
                        a=true;
                        
                        } 
                        
                        else{
                            JOptionPane.showMessageDialog(null,"ERROR SALDO NO SUFICIENTE"); // entrra al if si el  total es mayor al saldo
                            for (producto p : listap) { // recorremos el arreglo con un for 
                             if(p.getStock()==sf){
                                sf= p.getStock()+can; // restauramos la cantidad que se disminuyo en el stock
                        p.setStock(sf); // asignamos el stock retante
                     txtstock.setText(String.valueOf(sf)); // y lo mostramos en el campostock
                             }
                            }
                            a=false; // la variable booleana obtne valor de false 
                            return ;
                        }
                        //if(saldo1<0){
                          //  JOptionPane.showMessageDialog(null,"SALDO INSUFICIENTE");
                           // saldo1=c.getMonto()+total;
                            //modelo.removeRow(modelo.getRowCount()-1);
                            //return ;
                        //}
                        
               }
                
               }
              
      }
      if(a){ // si variable a tiene valor de  de true  entra al if para poder agregar ala tabla 
    introducirtabla();}
      
}

      
      
      
      
      
      
   
      
public void listarventast(){
      // metodo para registrar en la tabla 
        // Instnciamos un matriz de tipo STRING :filas ( tamaño del arreglo )-columnas(3) 
        String matriz[][]= new String[listast.size()][3];
        for (int i = 0; i < listast.size(); i++) { // se llena la matriz con los campos ingresados en el arreglo
            matriz[i][0]=listast.get(i).getNombre(); // se registra el nombre
            matriz[i][1]=listast.get(i).getPago();// se registra el tipo de pago
            matriz[i][2]=String.valueOf(listast.get(i).getTotal()); // convertimos a cadena los datos enteros 
        }
        
        // SE LLENA LA TABLA PARA MOSTRARLA
        tblst.setModel(new javax.swing.table.DefaultTableModel(
        matriz,
        new String [] {
        "NOMBRE", "PAGO",  "TOTAL"
         }));    
    
    
    
}


public void listarventact(){
      // metodo para registrar en la tabla 
        // Instnciamos un matriz de tipo STRING :filas ( tamaño del arreglo )-columnas(3) 
        String matriz[][]= new String[listact.size()][4];
        for (int i = 0; i < listact.size(); i++) { // se llena la matriz con los campos ingresados en el arreglo
            matriz[i][0]=listact.get(i).getNombre(); // se registra el nombre
            matriz[i][1]=String.valueOf(listact.get(i).getTarjeta());
            matriz[i][2]=listact.get(i).getPago();// se registra el tipo de pago
            matriz[i][3]=String.valueOf(listact.get(i).getTotal()); // convertimos a cadena los datos enteros 
        }
        
        // SE LLENA LA TABLA PARA MOSTRARLA
        tblct.setModel(new javax.swing.table.DefaultTableModel(
        matriz,
        new String [] {
        "NOMBRE","TARJETA", "PAGO",  "TOTAL"
         }));    
    
    
    
}

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cbtipo = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txtnom = new javax.swing.JTextField();
        txtdni = new javax.swing.JTextField();
        txtape = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txttar = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        btncontarjeta = new javax.swing.JButton();
        txtcodc = new javax.swing.JTextField();
        txtnomc = new javax.swing.JTextField();
        txtprec = new javax.swing.JTextField();
        txtcanc = new javax.swing.JTextField();
        txttotal = new javax.swing.JTextField();
        btningresar = new javax.swing.JButton();
        btncalcular = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        txtstock = new javax.swing.JTextField();
        btnsintarjeta = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        txtsal = new javax.swing.JTextField();
        txtpago = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        btntcalculartotal = new javax.swing.JButton();
        btnreiniciar = new javax.swing.JButton();
        btnregistrar = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblventa = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblst = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblct = new javax.swing.JTable();

        jLabel4.setText("jLabel4");

        setClosable(true);
        setIconifiable(true);

        jPanel1.setBackground(new java.awt.Color(153, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "VENTA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N

        jLabel1.setText("NOMBRE");

        jLabel2.setText("APELLIDOS");

        jLabel3.setText("DNI");

        cbtipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Tarjeta", "Efectivo" }));
        cbtipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbtipoActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("TIPO DE PAGO");

        txtnom.setEditable(false);

        txtdni.setEditable(false);

        txtape.setEditable(false);

        jLabel6.setText("TARJETA");

        txttar.setEditable(false);

        jPanel2.setBackground(new java.awt.Color(153, 255, 153));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "COMPRA", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jLabel7.setText("CODIGO");

        jLabel8.setText("NOMBRE");

        jLabel9.setText("PRECIO");

        jLabel10.setText("CANTIDAD");

        jLabel11.setText("TOTAL ");

        btncontarjeta.setText("COMPRA CON TARJETA");
        btncontarjeta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btncontarjeta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncontarjetaActionPerformed(evt);
            }
        });

        txttotal.setEditable(false);
        txttotal.setBackground(new java.awt.Color(255, 255, 153));
        txttotal.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        btningresar.setText("INGRESAR");
        btningresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btningresarActionPerformed(evt);
            }
        });

        btncalcular.setText("CALCULAR");
        btncalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncalcularActionPerformed(evt);
            }
        });

        jLabel13.setText("STOCK");

        btnsintarjeta.setText("COMPRA SIN TARJETA");
        btnsintarjeta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnsintarjeta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsintarjetaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addGap(47, 47, 47)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtnomc, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                            .addComponent(txtcodc)
                            .addComponent(txtprec, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btningresar)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel13)
                        .addGap(20, 20, 20)
                        .addComponent(txtstock, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jLabel11)))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txttotal, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btncalcular, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtcanc, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnsintarjeta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btncontarjeta, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE))
                        .addGap(43, 43, 43))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtcodc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btningresar)
                    .addComponent(jLabel13)
                    .addComponent(txtstock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtnomc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtprec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(txtcanc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btncalcular)
                        .addContainerGap(67, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnsintarjeta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txttotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btncontarjeta))
                        .addGap(23, 23, 23))))
        );

        jLabel12.setText("SALDO");

        txtsal.setEditable(false);

        txtpago.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtpago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpagoActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setText("TOTAL A PAGAR :");

        jLabel15.setText("S/.");

        btntcalculartotal.setText("CALCULAR TOTAL");
        btntcalculartotal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btntcalculartotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntcalculartotalActionPerformed(evt);
            }
        });

        btnreiniciar.setText("REINICIAR");
        btnreiniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnreiniciarActionPerformed(evt);
            }
        });

        btnregistrar.setText("REGISTRAR VENTA");
        btnregistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnregistrarActionPerformed(evt);
            }
        });

        tblventa.setModel(new javax.swing.table.DefaultTableModel(
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
                "NOMBRE", "PAGO", "PRODUCTO", "PRECIO", "CANTIDAD", "TOTAL"
            }
        ));
        jScrollPane1.setViewportView(tblventa);

        jTabbedPane1.addTab("DETALLES DE LA VENTA", jScrollPane1);

        tblst.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "NOMBRE", "PAGO", "TOTAL"
            }
        ));
        jScrollPane2.setViewportView(tblst);

        jTabbedPane1.addTab("VENTAS SIN TARJETA", jScrollPane2);

        tblct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "NOMBRE", "TARJETA", "PAGO", "TOTAL"
            }
        ));
        jScrollPane3.setViewportView(tblct);

        jTabbedPane1.addTab("VENTAS CON TARJETA", jScrollPane3);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnreiniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(btnregistrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btntcalculartotal, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel15)
                        .addGap(18, 18, 18)
                        .addComponent(txtpago, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1)
                            .addComponent(jLabel6)
                            .addComponent(jLabel12))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txttar)
                            .addComponent(txtnom)
                            .addComponent(txtape)
                            .addComponent(txtdni)
                            .addComponent(cbtipo, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtsal, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 778, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(31, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(cbtipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(txtsal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(4, 4, 4)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txttar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtnom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtape, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtdni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtpago, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15)
                    .addComponent(btntcalculartotal)
                    .addComponent(btnreiniciar)
                    .addComponent(btnregistrar))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbtipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbtipoActionPerformed
        
        if( cbtipo.getSelectedIndex()==1){
            this.btnsintarjeta.setEnabled(false); // deshabitimos boton sin tarjeta
            try{
             String star = JOptionPane.showInputDialog("INGRESE TARJETA"); // pedimos ke ingrese numero de tarjeta
            //SI EL CAMPO NO ESTA VACIO BUSCAMOS EN LA LISTA
            int tar=Integer.parseInt(star); // covertims a numerico 
                for (cliente c : listac){ // recorre el array conun for 
                    if(c.getTarjeta()==tar){ // buscamos 
                        // SE MUESTRA LOS CAMPOS
                        txtnom.setText(c.getNombre());
                        txtnom.setEditable(false);// no te permite modifificar el campo ;
                        txtape.setText(c.getApellido());
                        txtape.setEditable(false);
                        //txtcel.setText(String.valueOf(c.getCell()));
                        //txtcel.setEditable(false);
                        txtdni.setText(String.valueOf(c.getDni()));
                        txtdni.setEditable(false);
                        txttar.setText(String.valueOf(c.getTarjeta()));
                        txttar.setEditable(false);
                        txtsal.setText(String.valueOf(c.getMonto()));
                       
                        return;
                    }
                }

            JOptionPane.showMessageDialog(null,"CLIENTE NO ENCONTRADO"); // si no lo encuentra muestra mensaje d eeror

        }

        catch(Exception e){

            JOptionPane.showMessageDialog(null,"ERROR- LA TARJETA DEBE SER NUMERICO"); // mesaje de erorr

        }

        }
        
        
        if(cbtipo.getSelectedIndex()==2){
            this.btncontarjeta.setEnabled(false); // deshabilita el boton con tarjet 
            String nom=JOptionPane.showInputDialog("INGRESE NOMBRE DEL CLIENTE"); // peimos e nombre del cliente 
            txtnom.setText(nom); // se muestra el nombre ingresado en el campo 
            txtnom.setEditable(true); 
            txtape.setEditable(true);
            txtdni.setEditable(true);
            
        }
        
        
    }//GEN-LAST:event_cbtipoActionPerformed

    private void btningresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btningresarActionPerformed

        if (this.txtcodc.getText().equals("")){ // comparamos que el campo de codigo de producto no este vacio
            JOptionPane.showMessageDialog(null,"INGRESE EL CODIGO PARA BUSCAR");
            return;
            
        }
            
        
        
        try{
            this.txttotal.setText("");
            this.txtcanc.setText("");// limpiamos el campo cantidad         
            int codc=Integer.parseInt(txtcodc.getText()); // capturamos el campo de teco de codigo y lo convertimos a entero
                for (producto p : listap){ // recorremos el arryalist listap de clase producto para 
                    if(p.getCodigo()==codc){   // encontrar un codigo que concida con el codigo ingresado
                        // SE MUESTRA LOS CAMPOS
                        txtnomc.setText(p.getNombre());
                        txtnomc.setEditable(false);// no te permite modifificar el campo ;
                        txtprec.setText(String.valueOf(p.getPventa()));
                        txtprec.setEditable(false);
                        txtstock.setText(String.valueOf(p.getStock()));
                        txtstock.setEditable(false);
                        return;
                    }
                }

            JOptionPane.showMessageDialog(null,"PRODUCTO NO ENCONTRADO"); // mensje de erorr si es ke no l ecnotramos 

        }

        catch(Exception e){

            JOptionPane.showMessageDialog(null,"ERROR- EL CODIGO DEBE SER NUMERICO"); // mensaje d error

        }
        
        
        
        
    }//GEN-LAST:event_btningresarActionPerformed

    private void btncalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncalcularActionPerformed
      String spre=txtprec.getText(); //capturamos en una variable los datos que fueron ingresados en los 
      String scan=txtcanc.getText(); // campos de texto
      //VALIDAMOS QUE LOS CAMPOSNO ESTEN VACIOS
      if(spre.equals("")||scan.equals("")){
          JOptionPane.showMessageDialog(null," ERROR- DEBE INGRESAR PRECIO Y CANTIDAD");
          return; // SI ESTA VACIO MUESTRA MENSAJE DE ERROR
      }
      
      try{
      // si es ke no esta vacio ...convertimos los datos a numericos
      double pre=Double.parseDouble(spre);
      int can=Integer.parseInt(scan);
      double total = pre*can;// calculo par halar el totoal a pagar
      txttotal.setText(String.valueOf(total)); // MOSTRAMOS EL VALOR CALCULADO EN ELCAMPO TXTTOTAL
      
      }
      catch(Exception e){
          JOptionPane.showMessageDialog(null," ERROR- LA CANTIDAD DEBE SER NUMERICO");
          return; // MANDA MENSAJE DE ERORR SI SE INGRESO UNA CADENA
          
      }
      
      
      
    }//GEN-LAST:event_btncalcularActionPerformed

    private void btncontarjetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncontarjetaActionPerformed
    if(txttotal.getText().equals("")){ // COMPARAMOS QUE NO ESTE VACIO EL CAMPO
    JOptionPane.showMessageDialog(null,"ERROR-DEBE CALCULAR PRIMERO");
    return;
    }     
    
    calcular();
    //introducirtabla();
    
    
    
    
         //if(stock()==true){
           //   saldo();
         //}      
         
       // stock();
        
      
    }//GEN-LAST:event_btncontarjetaActionPerformed

    private void txtpagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpagoActionPerformed

        
    }//GEN-LAST:event_txtpagoActionPerformed

    private void btntcalculartotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntcalculartotalActionPerformed
      
        double sumatoria ; // DECLARAMOS UNA VARIAVLE PARA PODER SUMAR
        double sumat=0; //  INIZIALIZAMOS VARIABLE
        int totalrow=this.tblventa.getRowCount(); // DECLARAMOS VARIABLE QUE OBTIENE EL TOTAL DE FILAS
        totalrow-=1;  // DISMINUIMOS EN UNO EL CONTADOR DE FILAS
        for (int i = 0; i <=totalrow; i++) { // HACEMOS UN FOR PARA SUMAR LAS FILAS
            sumatoria=Double.parseDouble(String.valueOf(tblventa.getValueAt(i, 5))); // SE SUMA  FILA Y COLUMNA 5 QUE SELECIONAMOS Y LO GUARDAMOS EN LA VARIANLE SUMATORIA
            sumat+=sumatoria; // HACEMOS FILAS ITERATIVAS PARA QUE LA VARIABLE SUMAT AUMENTE 
        }
        this.txtpago.setText(String.valueOf(sumat));// IMMMPRIMIMOS EL VALOR DE LA SUMA 
    }//GEN-LAST:event_btntcalculartotalActionPerformed

    private void btnsintarjetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsintarjetaActionPerformed
        if(txttotal.getText().equals("")){  // VALIDMOS QUE EL CAMPO NO ESTE VACIO
        JOptionPane.showMessageDialog(null,"ERROR-DEBE CALCULAR PRIMERO");
         return;
       }      
        stock();
         //introducirtabla();
            
       
    }//GEN-LAST:event_btnsintarjetaActionPerformed

    private void btnreiniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnreiniciarActionPerformed
        
        limpiar(); // LIMPIAMOS CAMPOS 
    }//GEN-LAST:event_btnreiniciarActionPerformed

    private void btnregistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnregistrarActionPerformed
  
         if(this.cbtipo.getSelectedIndex()==1){ // SI SELECIONA LA CASILLA TARJETA EN EL COMOBOX  HACER 
       //INSTANCIAMOS OBJETO DE LA CLASE VENTA CONTARJETA
      ventacontarjeta vc= new ventacontarjeta(txtnom.getText(),Integer.parseInt(txttar.getText()),String.valueOf(cbtipo.getSelectedItem()),Double.parseDouble(txtpago.getText()));
      listact.add(vc); // AÑADIMOS EL VALOR AL ARREGLO
      listarventact();// MOSTRAMOS EN LA TABLA  EN LA TABLA 
      JOptionPane.showMessageDialog(null,"VENTA REGISTRADA"); // MENSAJE DE CONFIRMCION
      limpiar(); // LIMPIAMOS CAMPOS
      return;
      
      
  }
        
        
        if (this.cbtipo.getSelectedIndex()==2){
      
      //INSTANCIAMOS OBJETO DE LA CLASE  VENTASINTRJETA VS 
      ventasintarjeta vs= new ventasintarjeta(txtnom.getText(),String.valueOf(cbtipo.getSelectedItem()),Double.parseDouble(txtpago.getText()));
      listast.add(vs); // añadimos al array list
      listarventast(); // listamos los valores ala tabla
      JOptionPane.showMessageDialog(null,"VENTA REGISTRADA"); // MESANJE DE CONFIRMCION
      limpiar();
      return;
  }   
  
 
         
        
        
    }//GEN-LAST:event_btnregistrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncalcular;
    private javax.swing.JButton btncontarjeta;
    private javax.swing.JButton btningresar;
    private javax.swing.JButton btnregistrar;
    private javax.swing.JButton btnreiniciar;
    private javax.swing.JButton btnsintarjeta;
    private javax.swing.JButton btntcalculartotal;
    private javax.swing.JComboBox<String> cbtipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tblct;
    private javax.swing.JTable tblst;
    private javax.swing.JTable tblventa;
    private javax.swing.JTextField txtape;
    private javax.swing.JTextField txtcanc;
    private javax.swing.JTextField txtcodc;
    private javax.swing.JTextField txtdni;
    private javax.swing.JTextField txtnom;
    private javax.swing.JTextField txtnomc;
    private javax.swing.JTextField txtpago;
    private javax.swing.JTextField txtprec;
    private javax.swing.JTextField txtsal;
    private javax.swing.JTextField txtstock;
    private javax.swing.JTextField txttar;
    private javax.swing.JTextField txttotal;
    // End of variables declaration//GEN-END:variables
}