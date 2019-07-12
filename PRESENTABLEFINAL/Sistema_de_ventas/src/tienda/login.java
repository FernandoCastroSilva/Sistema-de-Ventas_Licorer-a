package tienda;

import javax.swing.JOptionPane; 


public class login extends javax.swing.JFrame {

    public login() { 
        initComponents();
        this.setLocationRelativeTo(null); // metodo para centrar ventana
        this.setTitle("REGISTRARSE"); // metodo para poner titulo
        this.setResizable(false); // metodo  booleano que no te permite maximizar 
    }

    public void iniciar() { // creamos un metodo de inicio 
        String user = txtusuario.getText(); //variables que obtenmos de los campos
        String pass = txtpas.getText();     // y lo declaramos con una variable que utilizaremos para comparar
                                            
                                                
        if (user.isEmpty() || pass.isEmpty()) { // condicional  para verificar que los dos campos han sido llenado
            JOptionPane.showMessageDialog(null, " DEBE INGRESAR LOS DOS CAMPOS "); 
            return;
        }

        if (user.equalsIgnoreCase("GRUPO 1") && pass.equalsIgnoreCase("GRUPO 1")) { 
            menu m = new menu(); 
            m.setVisible(true); 
            dispose(); // cerramos ventana

        } else {
            JOptionPane.showMessageDialog(null, "USUARIO INCORRECTO", "ACCESO DENEGADO", 2); // sino son correctos
            return; // sale mensaje de error
        }

    }

    
  
    private void initComponents() {

        logoacceso = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btningresar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtusuario = new javax.swing.JTextField();
        txtpas = new javax.swing.JPasswordField();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

       

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("USUARIO");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("CONTRASEÑA");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, -1));

        btningresar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btningresar.setForeground(new java.awt.Color(0, 51, 255));
        btningresar.setText("INGRESAR");
        btningresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btningresarActionPerformed(evt);
            }
        });
        getContentPane().add(btningresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 250, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 2, 36)); // NOI18N
        jLabel3.setText("ACCESO");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, 150, -1));

        txtusuario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(txtusuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, 160, -1));

        txtpas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpasActionPerformed(evt);
            }
        });
        getContentPane().add(txtpas, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, 160, 30));


        pack();
    }

    private void txtpasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpasActionPerformed
        iniciar(); 
    }

    private void btningresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btningresarActionPerformed
        iniciar(); // asignamos el metodo iniciar al boton INGRESAR
    }
    
    public static void main(String args[]) {
  
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
     
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
            }
        });
    }

    
    private javax.swing.JButton btningresar;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel logoacceso;
    private javax.swing.JPasswordField txtpas;
    private javax.swing.JTextField txtusuario;
    
}
