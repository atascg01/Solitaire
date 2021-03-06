/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

/**
 *
 * @author Andres Tascon
 */
public class MainWindow extends javax.swing.JFrame {

    /**
     * Creates new form WindowHelp
     */
	public static int intentosRealizadoSaltos = 0;
	public static int intentosExitoSaltos = 0;
	public static int intentosRealizadoClasico = 0;
	public static int intentosExitoClasico = 0;
	public static File archivoEstadisticas;
	public static int counterNuevo = 0;
    public MainWindow() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Solitario");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem(); 
        jMenu4 = new javax.swing.JMenu();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem9.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		jMenuItem9ActionPerformed();
        	}
        });
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem10.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		try {
					botonNuevoFicheroEstadisticas();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        	}
        });
        jMenu2 =  new javax.swing.JMenu();
        jMenu2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
                JOptionPane.showMessageDialog(null, "Para crear un nuevo solitario puede elegir entre utilizar los botones de Solitario saltos o Solitario clasico y el Menu Archivo -> Nuevo. A continuacion saltara un mensaje para elegir el tipo de solitario que desea crear.\nAntes de empezar a jugar, por cada sesion se le pedira que cree o elija un archivo para guardar las estadisticas, que mas tarde podra consultar en el menu Historial -> Estadisticas. Tambien podra elegir o crear un fichero de estadisticas nuevo una vez creada la sesion mediante el menu Historial -> Fichero de estadisticas\nNota: El solitario clasico tarda unos segundos por el cargado de imagenes");
        	}
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 700));

        jPanel1.setBackground(new java.awt.Color(0, 102, 0));

        jLabel2.setFont(new Font("Tahoma", Font.BOLD, 34)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 255, 255));
        jLabel2.setText("Bienvenido al programa de Solitarios");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 255, 255));
        jLabel3.setText("Andres Tascon Gonzalez - Ingenieria Informatica - Universidad de Leon");

        jButton1.setBackground(new java.awt.Color(51, 255, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setText("Solitario Saltos");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					jButton1ActionPerformed(evt);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });

        jButton2.setBackground(new java.awt.Color(51, 255, 255));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton2.setText("Solitario Clasico");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					jButton2ActionPerformed(evt);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 719, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(212, 212, 212)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(384, 384, 384)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(103, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(103, 103, 103))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(140, 140, 140)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(65, 65, 65)))
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 144, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67))
        );

        jMenuBar1.setBackground(new java.awt.Color(0, 0, 0));

        jMenu1.setText("Archivo");
        jMenu1.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N

        jMenuItem1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jMenuItem1.setText("Nuevo");
        jMenuItem1.setPreferredSize(new java.awt.Dimension(130, 30));
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					jMenuItem1ActionPerformed(evt);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jMenuItem2.setText("Cargar");
        jMenuItem2.setPreferredSize(new java.awt.Dimension(130, 30));
        jMenu1.add(jMenuItem2);

        jMenuItem3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jMenuItem3.setText("Salvar");
        jMenuItem3.setPreferredSize(new java.awt.Dimension(130, 30));
        jMenu1.add(jMenuItem3);

        jMenuItem4.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jMenuItem4.setText("Salvar como");
        jMenuItem4.setPreferredSize(new java.awt.Dimension(130, 30));
        jMenu1.add(jMenuItem4);

        jMenuItem5.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jMenuItem5.setText("Salir");
        jMenuItem5.setPreferredSize(new java.awt.Dimension(130, 30));
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);

        jMenuBar1.add(jMenu1);

        jMenu3.setText("Editar");
        jMenu3.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N

        jMenuItem6.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jMenuItem6.setText("Deshacer");
        jMenuItem6.setPreferredSize(new java.awt.Dimension(117, 30));
        jMenu3.add(jMenuItem6);

        jMenuItem7.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jMenuItem7.setText("Hacer");
        jMenuItem7.setPreferredSize(new java.awt.Dimension(117, 30));
        jMenu3.add(jMenuItem7);

        jMenuItem8.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jMenuItem8.setText("Resolver");
        jMenuItem8.setPreferredSize(new java.awt.Dimension(117, 30));
        jMenu3.add(jMenuItem8);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Historial");
        jMenu4.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N

        jMenuItem9.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jMenuItem9.setText("Estadisticas");
        jMenuItem9.setPreferredSize(new java.awt.Dimension(190, 30));
        jMenu4.add(jMenuItem9);

        jMenuItem10.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jMenuItem10.setText("Fichero estadisticas");
        jMenuItem10.setPreferredSize(new java.awt.Dimension(190, 30));
        jMenu4.add(jMenuItem10);

        jMenuBar1.add(jMenu4);

        jMenu2.setText("Ayuda");
        jMenu2.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu2MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

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

    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "Para crear un nuevo solitario puede elegir entre utilizar los botones de Solitario saltos o Solitario clasico y el Menu Archivo -> Nuevo. A continuacion saltara un mensaje para elegir el tipo de solitario que desea crear.\nAntes de empezar a jugar, por cada sesion se le pedira que cree o elija un archivo para guardar las estadisticas, que mas tarde podra consultar en el menu Historial -> Estadisticas. Tambien podra elegir o crear un fichero de estadisticas nuevo una vez creada la sesion mediante el menu Historial -> Fichero de estadisticas\nNota: El solitario clasico tarda unos segundos por el cargado de imagenes");
    }//GEN-LAST:event_jMenu2MouseClicked

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    //Funcion para preguntar por crear o elegir fichero de estadisticas al empezar el juego
    private void botonNuevoFicheroEstadisticas() throws IOException {
    	if(counterNuevo == 0) {
    		String[] options = {"Elegir un fichero ya creado.", "Crear un fichero nuevo."};
            int pos = JOptionPane.showOptionDialog(null, "Selecciona o crea un archivo de estadisticas para esta sesion.","Estadisticas", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
            if(pos == 0) { //Seleccionar fichero ya creado
            	JFileChooser jfc = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de texto .txt", "txt");
                jfc.setFileFilter(filter);
                int returnValue = jfc.showDialog(null, "Elegir fichero");
                if(returnValue==JFileChooser.APPROVE_OPTION){ 
                	archivoEstadisticas = jfc.getSelectedFile();
                }
                this.counterNuevo++;
                if(MainWindow.archivoEstadisticas!=null) {
                	BufferedReader br = new BufferedReader(new FileReader(MainWindow.archivoEstadisticas));
                    String line;
                    StringBuilder text = new StringBuilder("");
                    while((line = br.readLine()) != null){
                        text.append(line+"\n");
                    }
                    br.close();
                    String[]txt = text.toString().split("\n");
                    MainWindow.intentosRealizadoSaltos = Integer.parseInt(txt[1]);
                    MainWindow.intentosExitoSaltos = Integer.parseInt(txt[2]);
                    MainWindow.intentosRealizadoClasico = Integer.parseInt(txt[4]);
                    MainWindow.intentosExitoClasico = Integer.parseInt(txt[5]);
                }
                
                
            }else if(pos == 1){ //Crear fichero
            	JFileChooser jfc = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de texto .txt", "txt");
                jfc.setFileFilter(filter);
                int returnValue = jfc.showDialog(null, "Crear fichero");
                if(returnValue==JFileChooser.APPROVE_OPTION) {
                	try{                    	
                        archivoEstadisticas = jfc.getSelectedFile();
                        String filePaths = archivoEstadisticas.getAbsolutePath();
                        if(!filePaths.endsWith(".txt")) {
                            archivoEstadisticas = new File(filePaths + ".txt");
                        }
                        BufferedWriter bw;                
                        if(new File(archivoEstadisticas.getAbsolutePath()).exists()){ //El archivo ya existia
                            if(JOptionPane.OK_OPTION == JOptionPane.showConfirmDialog(this,"El fichero existe,deseas reemplazarlo?","Guardar como",JOptionPane.YES_NO_OPTION)){ //Se remplaza el archivo si presiona si.
                                archivoEstadisticas = new File(archivoEstadisticas.getAbsolutePath());
                                String filePath = archivoEstadisticas.getAbsolutePath();
                                if(!filePath.endsWith(".txt")) {
                                    archivoEstadisticas = new File(filePath + ".txt");
                                }
                                bw = new BufferedWriter(new FileWriter(archivoEstadisticas));
                                bw.write("Solitario saltos"+System.getProperty("line.separator")+intentosRealizadoSaltos+System.getProperty("line.separator")+intentosExitoSaltos+System.getProperty("line.separator"));
                                bw.write("Solitario clasico"+System.getProperty("line.separator")+intentosRealizadoClasico+System.getProperty("line.separator")+intentosRealizadoClasico);
                                bw.close();
                                this.counterNuevo++;
                            }
                        }else{ //El archivo no existe, se crea y se guarda la info en el
                            try { 
                                bw = new BufferedWriter(new FileWriter(archivoEstadisticas));
                                bw.write("Solitario saltos"+System.getProperty("line.separator")+intentosRealizadoSaltos+System.getProperty("line.separator")+intentosExitoSaltos+System.getProperty("line.separator"));
                                bw.write("Solitario clasico"+System.getProperty("line.separator")+intentosRealizadoClasico+System.getProperty("line.separator")+intentosExitoClasico);
                                bw.close();
                                this.counterNuevo++;
                            } catch (IOException ex) {
                                Logger.getLogger(SolitarioFrWindow.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        } 
	                }catch (Exception ex){ 
	                    ex.printStackTrace(); 
	                }
                }
                	
            }
    	}
    }
    
    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) throws IOException {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
    	botonNuevoFicheroEstadisticas();
        String[] options = {"Solitario clasico", "Solitario de saltos"};
        int pos = JOptionPane.showOptionDialog(null, "Elige el tipo de solitario","Elegir Solitario", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
        if(pos == 0){ //Solitario clasico
            java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new SolitarioFrWindow().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            });
            if(MainWindow.archivoEstadisticas!=null) {
            	MainWindow.intentosRealizadoClasico++;
                BufferedWriter bw = new BufferedWriter(new FileWriter(archivoEstadisticas));
                bw.write("Solitario saltos"+System.getProperty("line.separator")+intentosRealizadoSaltos+System.getProperty("line.separator")+intentosExitoSaltos+System.getProperty("line.separator"));
                bw.write("Solitario clasico"+System.getProperty("line.separator")+intentosRealizadoClasico+System.getProperty("line.separator")+intentosExitoClasico);
                bw.close();
            }
            
        }else if(pos == 1){ //Solitario saltos
            java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new SolitarioSpWindow().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            });
            if(MainWindow.archivoEstadisticas!=null) {
            	MainWindow.intentosRealizadoSaltos++;
                BufferedWriter bw = new BufferedWriter(new FileWriter(archivoEstadisticas));
                bw.write("Solitario saltos"+System.getProperty("line.separator")+intentosRealizadoSaltos+System.getProperty("line.separator")+intentosExitoSaltos+System.getProperty("line.separator"));
                bw.write("Solitario clasico"+System.getProperty("line.separator")+intentosRealizadoClasico+System.getProperty("line.separator")+intentosExitoClasico);
                bw.close();
            	}
            }
            
        	
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) throws IOException {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    	botonNuevoFicheroEstadisticas();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new SolitarioSpWindow().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        if(MainWindow.archivoEstadisticas!=null) {
        	MainWindow.intentosRealizadoSaltos++;
            BufferedWriter bw = new BufferedWriter(new FileWriter(archivoEstadisticas));
            bw.write("Solitario saltos"+System.getProperty("line.separator")+intentosRealizadoSaltos+System.getProperty("line.separator")+intentosExitoSaltos+System.getProperty("line.separator"));
            bw.write("Solitario clasico"+System.getProperty("line.separator")+intentosRealizadoClasico+System.getProperty("line.separator")+intentosExitoClasico);
            bw.close();
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) throws IOException {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    	botonNuevoFicheroEstadisticas();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new SolitarioFrWindow().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        if(MainWindow.archivoEstadisticas!=null) {
        	MainWindow.intentosRealizadoClasico++;
            BufferedWriter bw = new BufferedWriter(new FileWriter(archivoEstadisticas));
            bw.write("Solitario saltos"+System.getProperty("line.separator")+intentosRealizadoSaltos+System.getProperty("line.separator")+intentosExitoSaltos+System.getProperty("line.separator"));
            bw.write("Solitario clasico"+System.getProperty("line.separator")+intentosRealizadoClasico+System.getProperty("line.separator")+intentosExitoClasico);
            bw.close();
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed
    
    public void jMenuItem9ActionPerformed() {
    	JOptionPane.showMessageDialog(null, "Solitario saltos"+System.getProperty("line.separator")+MainWindow.intentosRealizadoSaltos+" intentos realizados"+System.getProperty("line.separator")+MainWindow.intentosExitoSaltos+" intentos con exito"+System.getProperty("line.separator")+"Solitario clasico"+System.getProperty("line.separator")+MainWindow.intentosRealizadoClasico+" intentos realizados"+System.getProperty("line.separator")+MainWindow.intentosExitoClasico+" intentos con exito");
    }
    
    public static void main(String[]args) {
    /**
     * @param args the command line arguments
     */
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
