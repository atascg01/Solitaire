/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 *
 * @author Andres Tascon
 */
public class SolitarioSpWindow extends javax.swing.JFrame {

    /**
     * Creates new form SolitarioSp
     */
    
    ArrayList<Boolean> eliminado = new ArrayList <Boolean>();//boton deshacer
    ArrayList<JPanel> jpanelEliminado = new ArrayList <JPanel>();
    ArrayList<JPanel> jpanelActual = new ArrayList <JPanel>();
    ArrayList<Integer> posJPanel = new ArrayList <Integer>();
    ArrayList<Boolean> mazo = new ArrayList <Boolean>();
    int counter = 0;
    ArrayList<Boolean> eliminado2 = new ArrayList <Boolean>(); //boton hacer
    ArrayList<JPanel> jpanelEliminado2 = new ArrayList <JPanel>();
    ArrayList<JPanel> jpanelActual2 = new ArrayList <JPanel>();
    ArrayList<Integer> posJPanel2 = new ArrayList <Integer>();
    ArrayList<Boolean> mazo2 = new ArrayList <Boolean>();
    JLabel lbl;
    int count = 0; 
    BarajaSp bsp;
    Carta[] baraja;
    File archivo;
    
    public SolitarioSpWindow() throws IOException {
        initComponents();
        Dimension DimMax = Toolkit.getDefaultToolkit().getScreenSize();
        setMinimumSize(DimMax);
        setTitle("Solitario Saltos");
        bsp = new BarajaSp();
        baraja = bsp.getBaraja();
        this.jPanel1.setLayout(new GridLayout(0, 10));  
        this.jPanel1.setBackground(new Color(0,102,0));
        jLabel1.setIcon(new ImageIcon(new ImageIcon(MainWindow.class.getResource("/PNG/Fr/red_back.png")).getImage().getScaledInstance(122, 150, Image.SCALE_SMOOTH)));       
        this.jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mousePressed(java.awt.event.MouseEvent evt) {
                    jMazoPressed(evt);    
                }
        });
        jPanel1.revalidate();
        jPanel1.repaint();
        
    }

    private void jMazoPressed(java.awt.event.MouseEvent evt){
        int counter = 0;
            for(int i = 0; i<jPanel1.getComponentCount(); i++){
                JPanel jp = (JPanel) jPanel1.getComponent(i);
                for(int j = 0; j<jp.getComponentCount(); j++){
                    counter++;
                }
        }
        if(counter<40){
            JPanel jpanel = new JPanel();
            jpanel.setLayout(null);
            jpanel.setBackground(new Color(0,102,0));
            jpanel.addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mousePressed(java.awt.event.MouseEvent evt) {
                        jPanelPressed(evt);    
                    }
            });
            JLabel label = baraja[counter].getJLabel();
            label.setBounds(0,0,122,150);
            jpanel.add(label);
            this.eliminado.add(false);
            this.jpanelActual.add(jpanel);
            this.jpanelEliminado.add(jPanel2);
            this.posJPanel.add(jPanel1.getComponentZOrder(jpanel));
            this.mazo.add(true);
            jpanel.revalidate();
            jpanel.repaint();
            counter++;
            jPanel1.add(jpanel);
            jPanel1.revalidate();
            jPanel1.repaint();
        }if(counter == 40){
            jPanel2.getComponent(0).setVisible(false);
        }
           
    }
    
    private void jPanelPressed(java.awt.event.MouseEvent evt){
        if(count % 2 == 0){
            seleccionar((JPanel) evt.getSource());
            count++;
        }else{
            mover((JPanel) evt.getSource());
            count++;
            if(jPanel1.getComponentCount() == 1) { //Tras mover, comprobamos si se ha terminado
            	JPanel jpanel = (JPanel) jPanel1.getComponent(0);
                if(jpanel.getComponentCount() == 40) {
                	JOptionPane.showMessageDialog(null, "¡Enhorabuena, has ganado!");
                	MainWindow.intentosExitoSaltos++;
                	BufferedWriter bw;
        			try {
        				if(MainWindow.archivoEstadisticas!=null) {
        					bw = new BufferedWriter(new FileWriter(MainWindow.archivoEstadisticas));
            				bw.write("Solitario saltos"+System.getProperty("line.separator")+MainWindow.intentosRealizadoSaltos+System.getProperty("line.separator")+MainWindow.intentosExitoSaltos+System.getProperty("line.separator"));
            	            bw.write("Solitario clasico"+System.getProperty("line.separator")+MainWindow.intentosRealizadoClasico+System.getProperty("line.separator")+MainWindow.intentosExitoClasico);
            	            bw.close();
        				}
        				
        			} catch (IOException e) {
        				// TODO Auto-generated catch block
        				e.printStackTrace();
        			}
                }
            }
        }
    }
    
    public void seleccionar(JPanel jpanel){
        lbl = (JLabel) jpanel.getComponent(0);
        lbl.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 0, 0)));
        jpanel.revalidate();
        jpanel.repaint();         
    }
    
    public void mover(JPanel jpanel){
        JPanel jp2 = (JPanel) lbl.getParent();
        lbl.setBorder(null);
        if((jPanel1.getComponentZOrder(jp2)-jPanel1.getComponentZOrder(jpanel) == 1) || (jPanel1.getComponentZOrder(jp2)-jPanel1.getComponentZOrder(jpanel) == 3)){//Si el monton es 1 o 3 uds izqda
            
            posJPanel.add(jPanel1.getComponentZOrder(jp2)); //Para el boton deshacer
            jpanelActual.add(jpanel);
            jpanelEliminado.add(jp2);
            mazo.add(false);
            
            Carta carta = getCarta(jpanel.getComponent(0).getName());
            Carta carta1 = getCarta(jp2.getComponent(0).getName());
            if(carta.mismoNumero(carta1) || carta.mismoPalo(carta1)){ //Si la carta tiene el mismo palo o numero que la otra carta, se puede mover
                lbl.setBounds(jpanel.getComponent(0).getX(), jpanel.getComponent(0).getY()+15, 122, 150); //seteo la carta 
                jpanel.add(lbl, 0);
                if(jp2.getComponentCount() == 0){
                    jPanel1.remove(jp2);
                    eliminado.add(true);
                }else{
                    eliminado.add(false);
                }
                jp2.revalidate();
                jp2.repaint();
                jpanel.revalidate();
                jpanel.repaint();   
                jPanel1.revalidate();
                jPanel1.repaint();
            }
            
        }
    }
    
    public Carta getCarta(String name){
        for(int i = 0; i<baraja.length; i++){
            if(baraja[i].getName().equals(name)){
                return baraja[i];
            }
        }
        return null;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
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
        	public void actionPerformed(ActionEvent e) {
            	JOptionPane.showMessageDialog(null, "Solitario saltos"+System.getProperty("line.separator")+MainWindow.intentosRealizadoSaltos+" intentos realizados"+System.getProperty("line.separator")+MainWindow.intentosExitoSaltos+" intentos con exito"+System.getProperty("line.separator")+"Solitario clasico"+System.getProperty("line.separator")+MainWindow.intentosRealizadoClasico+" intentos realizados"+System.getProperty("line.separator")+MainWindow.intentosExitoClasico+" intentos con exito");
        	}
        });
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem10.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		try {
					ficheroEstadisticas();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        	}
        });
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(0, 102, 0));

        jPanel1.setBackground(new java.awt.Color(0, 102, 0));
        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

        jPanel2.setBackground(new java.awt.Color(0, 102, 0));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(682, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                .addContainerGap(682, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE))
        );

        jMenu1.setText("Archivo");
        jMenu1.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N

        jMenuItem1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jMenuItem1.setText("Nuevo");
        jMenuItem1.setPreferredSize(new java.awt.Dimension(130, 30));
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                	dispose();
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
        jMenuItem2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItem2MousePressed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jMenuItem3.setText("Salvar");
        jMenuItem3.setPreferredSize(new java.awt.Dimension(130, 30));
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem4.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jMenuItem4.setText("Salvar como");
        jMenuItem4.setPreferredSize(new java.awt.Dimension(130, 30));
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
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
        jMenu3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenu3MousePressed(evt);
            }
        });

        jMenuItem6.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jMenuItem6.setText("Deshacer");
        jMenuItem6.setPreferredSize(new java.awt.Dimension(130, 30));
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem6);

        jMenuItem7.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jMenuItem7.setText("Hacer");
        jMenuItem7.setPreferredSize(new java.awt.Dimension(130, 30));
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem7);

        jMenuItem8.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jMenuItem8.setText("Resolver");
        jMenuItem8.setPreferredSize(new java.awt.Dimension(130, 30));
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
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
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Funcion para crear o fijar el fichero de estadisticas
    private void ficheroEstadisticas() throws IOException {
    	String[] options = {"Elegir un fichero ya creado.", "Crear un fichero nuevo."};
        int pos = JOptionPane.showOptionDialog(null, "Selecciona o crea un archivo de estadisticas para esta sesion.","Estadisticas", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
        if(pos == 0) { //Seleccionar fichero ya creado
        	JFileChooser jfc = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de texto .txt", "txt");
            jfc.setFileFilter(filter);
            int returnValue = jfc.showDialog(null, "Elegir fichero");
            if(returnValue==JFileChooser.APPROVE_OPTION){ 
            	MainWindow.archivoEstadisticas = jfc.getSelectedFile();
            }
            MainWindow.counterNuevo++;
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
        }else if(pos == 1){
        	MainWindow.intentosExitoClasico = 0;
        	MainWindow.intentosExitoSaltos = 0;
        	MainWindow.intentosRealizadoClasico = 0;
        	MainWindow.intentosRealizadoSaltos = 0;
        	JFileChooser jfc = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de texto .txt", "txt");
            jfc.setFileFilter(filter);
            int returnValue = jfc.showDialog(null, "Crear fichero");
            if(returnValue==JFileChooser.APPROVE_OPTION) {
            	try{                    	
                    MainWindow.archivoEstadisticas = jfc.getSelectedFile();
                    String filePaths = MainWindow.archivoEstadisticas.getAbsolutePath();
                    if(!filePaths.endsWith(".txt")) {
                    	MainWindow.archivoEstadisticas = new File(filePaths + ".txt");
                    }
                    BufferedWriter bw;                
                    if(new File(MainWindow.archivoEstadisticas.getAbsolutePath()).exists()){ //El archivo ya existia
                        if(JOptionPane.OK_OPTION == JOptionPane.showConfirmDialog(this,"El fichero existe,deseas reemplazarlo?","Guardar como",JOptionPane.YES_NO_OPTION)){ //Se remplaza el archivo si presiona si.
                        	MainWindow.archivoEstadisticas = new File(MainWindow.archivoEstadisticas.getAbsolutePath());
                            String filePath = MainWindow.archivoEstadisticas.getAbsolutePath();
                            if(!filePath.endsWith(".txt")) {
                            	MainWindow.archivoEstadisticas = new File(filePath + ".txt");
                            }
                            bw = new BufferedWriter(new FileWriter(MainWindow.archivoEstadisticas));
                            bw.write("Solitario saltos"+System.getProperty("line.separator")+MainWindow.intentosRealizadoSaltos+System.getProperty("line.separator")+MainWindow.intentosExitoSaltos+System.getProperty("line.separator"));
                            bw.write("Solitario clasico"+System.getProperty("line.separator")+MainWindow.intentosRealizadoClasico+System.getProperty("line.separator")+MainWindow.intentosRealizadoClasico);
                            bw.close();
                            MainWindow.counterNuevo++;
                        }
                    }else{ //El archivo no existe, se crea y se guarda la info en el
                        try { 
                            bw = new BufferedWriter(new FileWriter(MainWindow.archivoEstadisticas));
                            bw.write("Solitario saltos"+System.getProperty("line.separator")+MainWindow.intentosRealizadoSaltos+System.getProperty("line.separator")+MainWindow.intentosExitoSaltos+System.getProperty("line.separator"));
                            bw.write("Solitario clasico"+System.getProperty("line.separator")+MainWindow.intentosRealizadoClasico+System.getProperty("line.separator")+MainWindow.intentosExitoClasico);
                            bw.close();
                            MainWindow.counterNuevo++;
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
    
    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) throws IOException {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
    	if(MainWindow.counterNuevo == 0) {
    		ficheroEstadisticas();
    	}
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
            MainWindow.intentosRealizadoClasico++;
            BufferedWriter bw;
			try {
				if(MainWindow.archivoEstadisticas!=null) {
					bw = new BufferedWriter(new FileWriter(MainWindow.archivoEstadisticas));
					bw.write("Solitario saltos"+System.getProperty("line.separator")+MainWindow.intentosRealizadoSaltos+System.getProperty("line.separator")+MainWindow.intentosExitoSaltos+System.getProperty("line.separator"));
		            bw.write("Solitario clasico"+System.getProperty("line.separator")+MainWindow.intentosRealizadoClasico+System.getProperty("line.separator")+MainWindow.intentosExitoClasico);
		            bw.close();
				}				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
            MainWindow.intentosRealizadoSaltos++;
            BufferedWriter bw;
			try {
				if(MainWindow.archivoEstadisticas!=null) {
					bw = new BufferedWriter(new FileWriter(MainWindow.archivoEstadisticas));
					bw.write("Solitario saltos"+System.getProperty("line.separator")+MainWindow.intentosRealizadoSaltos+System.getProperty("line.separator")+MainWindow.intentosExitoSaltos+System.getProperty("line.separator"));
		            bw.write("Solitario clasico"+System.getProperty("line.separator")+MainWindow.intentosRealizadoClasico+System.getProperty("line.separator")+MainWindow.intentosExitoClasico);
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "Para crear un nuevo solitario puede elegir entre utilizar los botones de Solitario saltos o Solitario clasico y el Menu Archivo -> Nuevo. A continuacion saltara un mensaje para elegir el tipo de solitario que desea crear.\nAntes de empezar a jugar, por cada sesion se le pedira que cree o elija un archivo para guardar las estadisticas, que mas tarde podra consultar en el menu Historial -> Estadisticas. Tambien podra elegir o crear un fichero de estadisticas nuevo una vez creada la sesion mediante el menu Historial -> Fichero de estadisticas\nNota: El solitario clasico tarda unos segundos por el cargado de imagenes");
    }//GEN-LAST:event_jMenu2MouseClicked

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        // TODO add your handling code here:
        if(mazo.get(mazo.size()-1)){//Si era una carta del mazo
            if(jPanel2.getComponent(0).isVisible()){ //Si la label es visible
                jPanel1.remove(jPanel1.getComponentCount()-1);
            }else{
                jPanel2.getComponent(0).setVisible(true);
                jPanel1.remove(jPanel1.getComponent(jPanel1.getComponentCount()-1));
            }
        }else{
            if(eliminado.get(eliminado.size()-1)){ //Si se habia eliminado un panel
                JLabel lblToMove = (JLabel) jpanelActual.get(jpanelActual.size()-1).getComponent(0); //Componente 0 del panel actual es la label que queremos deshacer
                lblToMove.setBounds(0, 0, 122, 150);
                JPanel panelAntiguo = jpanelEliminado.get(jpanelEliminado.size()-1);
                panelAntiguo.add(lblToMove,0);
                jPanel1.add(panelAntiguo, posJPanel.get(posJPanel.size()-1)); //Anyadimos el panel eliminado en la posicion en la que estaba 
                jPanel1.setComponentZOrder(panelAntiguo, posJPanel.get(posJPanel.size()-1)); //Reordenamos por si no se ha puesto en la posicion correcta                     
            }else{
                JLabel lblToMove = (JLabel) jpanelActual.get(jpanelActual.size()-1).getComponent(0); //Componente 0 del panel actual es la label que queremos deshacer
                JPanel panelAntiguo = jpanelEliminado.get(jpanelEliminado.size()-1);
                lblToMove.setBounds(panelAntiguo.getComponent(0).getX(), panelAntiguo.getComponent(0).getY()+15, 122, 150);  
                panelAntiguo.add(lblToMove, 0);
            }
        }
        
        jPanel1.revalidate();
        jPanel1.repaint();
        if(this.counter == 3){
            System.out.println("");
        }
        eliminado2.add(eliminado.get(eliminado.size()-1)); //anyadimos a los arraylist para el boton hacer
        jpanelEliminado2.add(jpanelEliminado.get(jpanelEliminado.size()-1));
        jpanelActual2.add(jpanelActual.get(jpanelActual.size()-1));
        posJPanel2.add(posJPanel.get(posJPanel.size()-1));
        mazo2.add(mazo.get(mazo.size()-1));
        
        eliminado.remove(eliminado.size()-1); //Eliminamos de la cola de deshacer
        jpanelEliminado.remove(jpanelEliminado.size()-1);
        jpanelActual.remove(jpanelActual.size()-1);
        posJPanel.remove(posJPanel.size()-1);
        mazo.remove(mazo.size()-1);
        this.counter++;
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        // TODO add your handling code here:
        if(mazo2.get(mazo2.size()-1)){ //Si se habia deshecho del mazo
            jMazoPressed(null);
        }else{
            JPanel jpanelAntiguo = jpanelActual2.get(jpanelActual2.size()-1);
            JPanel jpanelAct = jpanelEliminado2.get(jpanelEliminado2.size()-1);
            if(eliminado2.get(eliminado2.size()-1)){ //Si se habia eliminado un panel
                JLabel lblToMove = (JLabel) jpanelAct.getComponent(0); //Componente 0 del panel actual es la label que queremos deshacer
                lblToMove.setBounds(jpanelAntiguo.getComponent(0).getX(), jpanelAntiguo.getComponent(0).getY()+15, 122, 150);
                jpanelAntiguo.add(lblToMove,0);      
                jPanel1.remove(jpanelAct);
            }else{
                JLabel lblToMove = (JLabel) jpanelAct.getComponent(0); //Componente 0 del panel actual es la label que queremos deshacer
                lblToMove.setBounds(jpanelAntiguo.getComponent(0).getX(), jpanelAntiguo.getComponent(0).getY()+15, 122, 150);  
                jpanelAntiguo.add(lblToMove, 0);
            }
            eliminado.add(eliminado2.get(eliminado2.size()-1));
            jpanelEliminado.add(jpanelEliminado2.get(jpanelEliminado2.size()-1));
            jpanelActual.add(jpanelActual2.get(jpanelActual2.size()-1));
            posJPanel.add(posJPanel2.get(posJPanel2.size()-1));
            mazo.add(mazo2.get(mazo2.size()-1));
        }
        
        jPanel1.revalidate();
        jPanel1.repaint();
        
        eliminado2.remove(eliminado2.size()-1);
        jpanelEliminado2.remove(jpanelEliminado2.size()-1);
        jpanelActual2.remove(jpanelActual2.size()-1);
        posJPanel2.remove(posJPanel2.size()-1);
        mazo2.remove(mazo2.size()-1);
        this.counter++;
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenu3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu3MousePressed
        // TODO add your handling code here:
        if(eliminado.size() == 0){
            jMenuItem6.setEnabled(false);
        }else{
            jMenuItem6.setEnabled(true);
        }
        
        if(eliminado2.size() == 0){
            jMenuItem7.setEnabled(false);
        }else{
            jMenuItem7.setEnabled(true);
        }
    }//GEN-LAST:event_jMenu3MousePressed

    private void jMenuItem2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem2MousePressed
        // TODO add your handling code here:
        JFileChooser jfc = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de texto .txt", "txt");
        jfc.setFileFilter(filter);
        int returnValue = jfc.showDialog(null, "Abrir");
        StringBuilder text = new StringBuilder("");
        if(returnValue==JFileChooser.APPROVE_OPTION){ 
            archivo = jfc.getSelectedFile();
            try {
                BufferedReader br = new BufferedReader(new FileReader(archivo));
                String line;
                while((line = br.readLine()) != null){
                    text.append(line+"\n");
                }
                br.close();
                jPanel1.removeAll();
                String text2 = text.toString();
                String[] txt = text2.split("\n");
                if(txt[0].contains("Solitario saltos")){
                    Carta[] baraja2 = new Carta[40];
                    String[] line2 = txt[1].split(" ");
                    int c = 0;
                    if(line2[0].length() != 0){
                        c = line2.length; //Cartas en el mazo
                    }else{
                        
                    }                           
                    int counter1 = baraja2.length-1;
                    ArrayList <Integer> counterPilas = new ArrayList <Integer>();
                    for(int i = 0; i<line2.length; i++){
                        baraja2[counter1] = getCarta(line2[i]);
                        counter1--;
                    }
                    int counter2 = baraja2.length-c-1;
                    for(int i = 2; i<txt.length; i++){
                        String[] lin = txt[i].split(" ");
                        for(int j = lin.length-1; j>=0; j--){
                            if(j == 0){
                                counterPilas.add(lin.length);
                            }
                            baraja2[counter2] = getCarta(lin[j]);
                            counter2--;
                        }
                    }
                    this.baraja = baraja2;
                    int counter3 = 0;
                    int counterCartas = 0;
                    for(int i = counterPilas.size()-1; i>=0 ; i--){
                        if(counterPilas.get(i) == 1){ //La pila solo tiene una carta
                            JPanel jpanel = new JPanel();
                            jpanel.setLayout(null);
                            jpanel.setBackground(new Color(0,102,0));
                            jpanel.addMouseListener(new java.awt.event.MouseAdapter() {
                                    public void mousePressed(java.awt.event.MouseEvent evt) {
                                        jPanelPressed(evt);    
                                    }
                            });
                            JLabel label = baraja[counter3].getJLabel();
                            label.setBounds(0,0,122,150);
                            jpanel.add(label);
                            jPanel1.add(jpanel,0);
                            counter3++;
                        }else{ //La pila tiene mas de una carta
                            JPanel jpanel = new JPanel();
                            jpanel.setLayout(null);
                            jpanel.setBackground(new Color(0,102,0));
                            jpanel.addMouseListener(new java.awt.event.MouseAdapter() {
                                    public void mousePressed(java.awt.event.MouseEvent evt) {
                                        jPanelPressed(evt);    
                                    }
                            });
                            for(int j = 0; j<counterPilas.get(i); j++){
                                if(j == 0){                                    
                                    JLabel label = baraja[counter3].getJLabel();
                                    label.setBounds(0,0,122,150);
                                    jpanel.add(label,0);
                                    counter3++;
                                }else{
                                    JLabel label = baraja[counter3].getJLabel();
                                    label.setBounds(jpanel.getComponent(0).getX(),jpanel.getComponent(0).getY()+14,122,150);
                                    jpanel.add(label,0);
                                    counter3++;
                                }
                            }
                            jPanel1.add(jpanel,0);
                        }
                    }
                    for(int i = 0; i<jPanel1.getComponentCount(); i++){
                        JPanel jp = (JPanel) jPanel1.getComponent(i);
                        for(int j = 0; j<jp.getComponentCount(); j++){
                            counterCartas++;
                        }
                    }
                    if(counterCartas == 40){
                        jPanel2.getComponent(0).setVisible(false);
                    }else{
                        jPanel2.getComponent(0).setVisible(true);
                    }
                    jPanel1.repaint();
                    jPanel1.revalidate();
                    System.out.println("");  
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(SolitarioFrWindow.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(SolitarioFrWindow.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        
            
        }
    }//GEN-LAST:event_jMenuItem2MousePressed

    
    private void fillWriter(BufferedWriter bw) throws IOException{
        bw.write("Solitario saltos"+System.getProperty("line.separator"));
        int counter = 0;
            for(int i = 0; i<jPanel1.getComponentCount(); i++){
                JPanel jp = (JPanel) jPanel1.getComponent(i);
                for(int j = 0; j<jp.getComponentCount(); j++){
                    counter++;
                }
        }
        for(int i = baraja.length-1; i>=counter; i--){
            bw.write(baraja[i].getName()+" ");
        }
        bw.write(System.getProperty("line.separator"));
        for(int i = 0; i<jPanel1.getComponentCount(); i++){ //Escribe las cartas de las pilas
            JPanel jpanel = (JPanel) jPanel1.getComponent(i);
            for(int j = jpanel.getComponentCount()-1 ; j>=0; j--){
                bw.write(getCarta(jpanel.getComponent(j).getName()).getName()+" ");
            }
            bw.write(System.getProperty("line.separator"));
        }
    }
    
    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        if(archivo == null){
            jMenuItem4ActionPerformed(evt);
        }else{
            try {
                BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));
                fillWriter(bw);
                bw.close();
            } catch (IOException ex) {
                Logger.getLogger(SolitarioFrWindow.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        JFileChooser jfc = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de texto .txt", "txt");
        jfc.setFileFilter(filter);
        int returnValue = jfc.showDialog(null, "Salvar como"); 
        if(returnValue==JFileChooser.APPROVE_OPTION){ 
            try{
                archivo = jfc.getSelectedFile();
                String filePath = archivo.getAbsolutePath();
                if(!filePath.endsWith(".txt")) {
                    archivo = new File(filePath + ".txt");
                }
                BufferedWriter bw;                
                if(new File(archivo.getAbsolutePath()).exists()){ //El archivo ya existia
                    if(JOptionPane.OK_OPTION == JOptionPane.showConfirmDialog(this,"El fichero existe,deseas reemplazarlo?","Guardar como",JOptionPane.YES_NO_OPTION)){ //Se remplaza el archivo si presiona si.
                        archivo = new File(archivo.getAbsolutePath());
                        bw = new BufferedWriter(new FileWriter(archivo));
                        fillWriter(bw);
                        bw.close();
                    }
                }else{ //El archivo no existe, se crea y se guarda la info en el
                    try { 
                        bw = new BufferedWriter(new FileWriter(archivo));
                        fillWriter(bw);
                        bw.close();
                    } catch (IOException ex) {
                        Logger.getLogger(SolitarioFrWindow.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } 
            }catch (Exception ex){ 
                ex.printStackTrace(); 
            } 
        }
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        // TODO add your handling code here:
        ArrayList<ArrayList<Carta>> cartas = new ArrayList<ArrayList<Carta>>();
        for(int i = 0; i<jPanel1.getComponentCount(); i++){ //Obtengo la cantidad de pilas y cartas en cada pila
            JPanel jpanel = (JPanel) jPanel1.getComponent(i);
            ArrayList<Carta> pila = new ArrayList<Carta>();
            for(int j = jpanel.getComponentCount()-1; j>=0; j--){
                pila.add(getCarta(jpanel.getComponent(j).getName()));
            }
            cartas.add(pila);
        } //Rellenadas todas las cartas de las pilas, faltan las del mazo que hay que anyadir al final del arraylist
        int counter = 0; //Contador de cartas en las pilas
            for(int i = 0; i<jPanel1.getComponentCount(); i++){
                JPanel jp = (JPanel) jPanel1.getComponent(i);
                for(int j = 0; j<jp.getComponentCount(); j++){
                    counter++;
                }
        }
        for(int i = baraja.length-1; i>=counter; i--){ //Bucle para sacar las cartas del mazo
            ArrayList<Carta> mazo = new ArrayList<Carta>();
            mazo.add(baraja[i]);
            cartas.add(mazo);
        }
        
        ArrayList<ArrayList<Carta>> solucion = new ArrayList<ArrayList<Carta>>(); //ArrayList para la solucion
        Solitario solitario = new Solitario();
        solucion = solitario.recorreArray(cartas); //Obtenemos la solucion.
        if(jPanel2.getComponent(0).isVisible()){
            jPanel2.getComponent(0).setVisible(false); //Ocultamos el mazo si fuera necesario
        }
        jPanel1.removeAll();
        for(int i = 0; i<solucion.size(); i++){
            JPanel jpanel = new JPanel();
            jpanel.setLayout(null);
            jpanel.setBackground(new Color(0,102,0));
            jpanel.addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mousePressed(java.awt.event.MouseEvent evt) {
                        jPanelPressed(evt);    
                    }
            });
            for(int j = 0; j<solucion.get(i).size(); j++){
                JLabel label = solucion.get(i).get(j).getJLabel();
                if(j == 0){                    
                    label.setBounds(0, 0, 122, 150);
                }else{
                    label.setBounds(jpanel.getComponent(0).getX(), jpanel.getComponent(0).getY()+14, 122, 150);
                }
                jpanel.add(label, 0);               
            }
            jPanel1.add(jpanel);
        }
        jPanel1.revalidate();
        jPanel1.repaint();
        JOptionPane.showMessageDialog(this, solitario.getSolucionString(solucion));
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(SolitarioSpWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SolitarioSpWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SolitarioSpWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SolitarioSpWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new SolitarioSpWindow().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(SolitarioSpWindow.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}
