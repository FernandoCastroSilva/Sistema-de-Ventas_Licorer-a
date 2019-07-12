
package tienda;


public class menu extends javax.swing.JFrame {

    
    public menu() {
        initComponents();
        this.setTitle("MENU PRINCIPAL"); // le damos titulo 
        this.setLocationRelativeTo(null); // centramos ventana
        this.setResizable(true); // damos valor de verdad al boton maximizar 
        setExtendedState(menu.MAXIMIZED_BOTH);// metodo que extiende toda la pantalla
        
    }

    
   
    
    private void initComponents() {

        escritorio = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mcliente = new javax.swing.JMenuItem();
        msalir = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        mventa = new javax.swing.JMenuItem();
        malmacen = new javax.swing.JMenu();
        mproductos = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(escritorio, new org.netbeans.lib.awtextra.AbsoluteConstraints(-209, -30, 1520, 970));

        jMenu1.setText("Archivo");

        mcliente.setText("Cliente");
        mcliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mclienteActionPerformed(evt);
            }
        });
        jMenu1.add(mcliente);

        msalir.setText("Salir");
        msalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                msalirActionPerformed(evt);
            }
        });
        jMenu1.add(msalir);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Venta");

        mventa.setText("Nueva Venta");
        mventa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mventaActionPerformed(evt);
            }
        });
        jMenu2.add(mventa);

        jMenuBar1.add(jMenu2);

        malmacen.setText("Almacen");

        mproductos.setText("Productos");
        mproductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mproductosActionPerformed(evt);
            }
        });
        malmacen.add(mproductos);

        jMenuBar1.add(malmacen);

        setJMenuBar(jMenuBar1);

        pack();
    }

    private void msalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_msalirActionPerformed
        System.exit(0); // sale del sistema 
    }
    private void mclienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mclienteActionPerformed
        clientemenu c = new clientemenu (); // instanciamos ventana clientemenu
        escritorio.add(c); // lo añadimos al panel de escritorio 
        c.setVisible(true); // la hacemos visible
        
    }

    private void mventaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mventaActionPerformed
        venta v = new venta();  // instanciamos ventana venta 
        escritorio.add(v);   //  lo añadimos al panel de escritorio
        v.setVisible(true); // la hacemos visible 
    }

    private void mproductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mproductosActionPerformed
        almacen a = new almacen(); // instanciamos  ventana almacen
        escritorio.add(a); // lo añadimos  al panel de escritorio 
        a.setVisible(true); // la hacemos visible
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
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
     
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                
                menu m=new menu();
                m.setExtendedState(MAXIMIZED_BOTH);
                m.setVisible(true);
            }
        });
    }

    
    private javax.swing.JDesktopPane escritorio;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu malmacen;
    private javax.swing.JMenuItem mcliente;
    private javax.swing.JMenuItem mproductos;
    private javax.swing.JMenuItem msalir;
    private javax.swing.JMenuItem mventa;
   
}
