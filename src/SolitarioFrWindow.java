/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

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
public class SolitarioFrWindow extends javax.swing.JFrame {

    BarajaFr bfr;
    private static int width = 122;
    private static int height = 150;
    JLabel lblChange;
    JPanel panelChange; //Para el boton de deshacer.
    JLabel labelChange; //Para el boton de deshacer.
    int count = 0;
    File archivo;
    ArrayList <ArrayList<Carta>> baraja;
    ArrayList <Carta> mazo;
    ArrayList <Carta> pila1;
    ArrayList <Carta> pila2;
    ArrayList <Carta> pila3;
    ArrayList <Carta> pila4;
    ArrayList <Carta> pila5;
    ArrayList <Carta> pila6;
    ArrayList <Carta> pila7;
    ArrayList <Boolean> cambioMazo2 = new ArrayList <Boolean>();
    ArrayList <Boolean> cambioBocaAbajo2 = new ArrayList <Boolean>();
    ArrayList <JPanel> panelActual2 = new ArrayList <JPanel>();
    ArrayList <JPanel> panelAntiguo2 = new ArrayList <JPanel>();
    ArrayList <Integer> movimientos2 = new ArrayList <Integer>();
    /**
     * Creates new form SolitarioFrWindow
     */
    public SolitarioFrWindow() throws IOException {
        bfr = new BarajaFr();
        baraja = bfr.getBaraja();
        initComponents(); 
        width = 122;
        height = 150;
        iniciarPanel();
        setTitle("Solitario Frances Clasico");
        setResizable(false);
        setLocationRelativeTo(null);
    }

    private void iniciarPanel(){
        
        jPanelMazo8.setName("jPanelMazo8");
        jPanel2.setName("jPanel2");
        jPanel3.setName("jPanel3");
        jPanel4.setName("jPanel4");
        jPanel5.setName("jPanel5");
        
        jPanelMazo1.setLayout(null);
        jPanelMazo2.setLayout(null);
        jPanelMazo3.setLayout(null);
        jPanelMazo4.setLayout(null);
        jPanelMazo5.setLayout(null);
        jPanelMazo6.setLayout(null);
        jPanelMazo7.setLayout(null);
        
        for(int i = 0; i<baraja.size(); i++){
            for(int j = 0; j<baraja.get(i).size(); j++){
                switch(i){
                    case 0:
                        if(jPanelMazo1.getComponentCount() == 0){
                            baraja.get(i).get(baraja.get(i).size()-j-1).getJLabel().setBounds(0, 0, 122, 150);
                            this.jPanelMazo1.add(baraja.get(i).get(baraja.get(i).size()-j-1).getJLabel());
                        }
                    break;
                    case 1:
                        if(jPanelMazo2.getComponentCount() == 0){
                            baraja.get(i).get(baraja.get(i).size()-j-1).getJLabelDown().setBounds(0, 0, 122, 150);
                            this.jPanelMazo2.add(baraja.get(i).get(baraja.get(i).size()-j-1).getJLabelDown());
                        }
                        else{
                            if(jPanelMazo2.getComponentCount() == baraja.get(i).size()-1){
                                baraja.get(i).get(baraja.get(i).size()-j-1).getJLabel().setBounds(jPanelMazo2.getComponent(j-1).getX(), jPanelMazo2.getComponent(j-1).getY()+12, width, height);
                                baraja.get(i).get(baraja.get(i).size()-j-1).getJLabel().setVisible(true);
                                this.jPanelMazo2.add(baraja.get(i).get(baraja.get(i).size()-j-1).getJLabel());
                            }else{
                                baraja.get(i).get(baraja.get(i).size()-j-1).getJLabelDown().setBounds(jPanelMazo2.getComponent(j-1).getX(), jPanelMazo2.getComponent(j-1).getY()+12, width, height);
                                baraja.get(i).get(baraja.get(i).size()-j-1).getJLabel().setVisible(true);
                                this.jPanelMazo2.add(baraja.get(i).get(baraja.get(i).size()-j-1).getJLabelDown());  
                            }
                        }
                    break;
                    case 2:
                        if(jPanelMazo3.getComponentCount() == 0){
                            baraja.get(i).get(baraja.get(i).size()-j-1).getJLabelDown().setBounds(0, 0, 122, 150);
                            this.jPanelMazo3.add(baraja.get(i).get(baraja.get(i).size()-j-1).getJLabelDown());
                        }
                        else{
                            if(jPanelMazo3.getComponentCount() == baraja.get(i).size()-1){
                                baraja.get(i).get(baraja.get(i).size()-j-1).getJLabel().setBounds(jPanelMazo3.getComponent(j-1).getX(), jPanelMazo3.getComponent(j-1).getY()+12, width, height);
                                baraja.get(i).get(baraja.get(i).size()-j-1).getJLabel().setVisible(true);
                                this.jPanelMazo3.add(baraja.get(i).get(baraja.get(i).size()-j-1).getJLabel());
                            }else{
                                baraja.get(i).get(baraja.get(i).size()-j-1).getJLabelDown().setBounds(jPanelMazo3.getComponent(j-1).getX(), jPanelMazo3.getComponent(j-1).getY()+12, width, height);
                                baraja.get(i).get(baraja.get(i).size()-j-1).getJLabel().setVisible(true);
                                this.jPanelMazo3.add(baraja.get(i).get(baraja.get(i).size()-j-1).getJLabelDown());  
                            }
                        }
                    break;
                    case 3:
                        if(jPanelMazo4.getComponentCount() == 0){
                            baraja.get(i).get(baraja.get(i).size()-j-1).getJLabelDown().setBounds(0, 0, 122, 150);
                            this.jPanelMazo4.add(baraja.get(i).get(baraja.get(i).size()-j-1).getJLabelDown());
                        }
                        else{
                            if(jPanelMazo4.getComponentCount() == baraja.get(i).size()-1){
                                baraja.get(i).get(baraja.get(i).size()-j-1).getJLabel().setBounds(jPanelMazo4.getComponent(j-1).getX(), jPanelMazo4.getComponent(j-1).getY()+12, width, height);
                                baraja.get(i).get(baraja.get(i).size()-j-1).getJLabel().setVisible(true);
                                this.jPanelMazo4.add(baraja.get(i).get(baraja.get(i).size()-j-1).getJLabel());
                            }else{
                                baraja.get(i).get(baraja.get(i).size()-j-1).getJLabelDown().setBounds(jPanelMazo4.getComponent(j-1).getX(), jPanelMazo4.getComponent(j-1).getY()+12, width, height);
                                baraja.get(i).get(baraja.get(i).size()-j-1).getJLabel().setVisible(true);
                                this.jPanelMazo4.add(baraja.get(i).get(baraja.get(i).size()-j-1).getJLabelDown());  
                            }
                        }
                    break;
                    case 4:
                        if(jPanelMazo5.getComponentCount() == 0){
                            baraja.get(i).get(baraja.get(i).size()-j-1).getJLabelDown().setBounds(0, 0, 122, 150);
                            this.jPanelMazo5.add(baraja.get(i).get(baraja.get(i).size()-j-1).getJLabelDown());
                        }
                        else{
                            if(jPanelMazo5.getComponentCount() == baraja.get(i).size()-1){
                                baraja.get(i).get(baraja.get(i).size()-j-1).getJLabel().setBounds(jPanelMazo5.getComponent(j-1).getX(), jPanelMazo5.getComponent(j-1).getY()+12, width, height);
                                baraja.get(i).get(baraja.get(i).size()-j-1).getJLabel().setVisible(true);
                                this.jPanelMazo5.add(baraja.get(i).get(baraja.get(i).size()-j-1).getJLabel());
                            }else{
                                baraja.get(i).get(baraja.get(i).size()-j-1).getJLabelDown().setBounds(jPanelMazo5.getComponent(j-1).getX(), jPanelMazo5.getComponent(j-1).getY()+12, width, height);
                                baraja.get(i).get(baraja.get(i).size()-j-1).getJLabel().setVisible(true);
                                this.jPanelMazo5.add(baraja.get(i).get(baraja.get(i).size()-j-1).getJLabelDown());  
                            }
                        }
                    break;
                    case 5:
                        if(jPanelMazo6.getComponentCount() == 0){
                            baraja.get(i).get(baraja.get(i).size()-j-1).getJLabelDown().setBounds(0, 0, 122, 150);
                            this.jPanelMazo6.add(baraja.get(i).get(baraja.get(i).size()-j-1).getJLabelDown());
                        }
                        else{
                            if(jPanelMazo6.getComponentCount() == baraja.get(i).size()-1){
                                baraja.get(i).get(baraja.get(i).size()-j-1).getJLabel().setBounds(jPanelMazo6.getComponent(j-1).getX(), jPanelMazo6.getComponent(j-1).getY()+12, width, height);
                                baraja.get(i).get(baraja.get(i).size()-j-1).getJLabel().setVisible(true);
                                this.jPanelMazo6.add(baraja.get(i).get(baraja.get(i).size()-j-1).getJLabel());
                            }else{
                                baraja.get(i).get(baraja.get(i).size()-j-1).getJLabelDown().setBounds(jPanelMazo6.getComponent(j-1).getX(), jPanelMazo6.getComponent(j-1).getY()+12, width, height);
                                baraja.get(i).get(baraja.get(i).size()-j-1).getJLabel().setVisible(true);
                                this.jPanelMazo6.add(baraja.get(i).get(baraja.get(i).size()-j-1).getJLabelDown());  
                            }
                        }
                    break;
                    case 6:
                        if(jPanelMazo7.getComponentCount() == 0){
                            baraja.get(i).get(baraja.get(i).size()-j-1).getJLabelDown().setBounds(0, 0, 122, 150);
                            this.jPanelMazo7.add(baraja.get(i).get(baraja.get(i).size()-j-1).getJLabelDown());
                        }
                        else{
                            if(jPanelMazo7.getComponentCount() == baraja.get(i).size()-1){
                                baraja.get(i).get(baraja.get(i).size()-j-1).getJLabel().setBounds(jPanelMazo7.getComponent(j-1).getX(), jPanelMazo7.getComponent(j-1).getY()+12, width, height);
                                baraja.get(i).get(baraja.get(i).size()-j-1).getJLabel().setVisible(true);
                                this.jPanelMazo7.add(baraja.get(i).get(baraja.get(i).size()-j-1).getJLabel());
                            }else{
                                baraja.get(i).get(baraja.get(i).size()-j-1).getJLabelDown().setBounds(jPanelMazo7.getComponent(j-1).getX(), jPanelMazo7.getComponent(j-1).getY()+12, width, height);
                                baraja.get(i).get(baraja.get(i).size()-j-1).getJLabel().setVisible(true);
                                this.jPanelMazo7.add(baraja.get(i).get(baraja.get(i).size()-j-1).getJLabelDown());  
                            }
                        }
                    break;
                    case 7:
                            baraja.get(i).get(baraja.get(i).size()-j-1).getJLabelDown().setBounds(0, 0, 122, 150);
                            this.jPanelMazo.add(baraja.get(i).get(baraja.get(i).size()-j-1).getJLabelDown());
                    break;
                }
            }
        }
        
        orderZComponentReverse(jPanelMazo1);
        orderZComponentReverse(jPanelMazo2);
        orderZComponentReverse(jPanelMazo3);
        orderZComponentReverse(jPanelMazo4);
        orderZComponentReverse(jPanelMazo5);
        orderZComponentReverse(jPanelMazo6);
        orderZComponentReverse(jPanelMazo7);
    }

    // Reorder the Component Z Order of the JPanel component array
    private void orderZComponentReverse(JPanel jpanel){
        for(int i = 0; i<jpanel.getComponentCount(); i++){
            jpanel.setComponentZOrder(jpanel.getComponent(i), 0);
        }
    }
    
    public Carta getCarta(String name){
        for(int i = 0; i<baraja.size(); i++){
            for(int j = 0; j<baraja.get(i).size(); j++){
                if(baraja.get(i).get(j).getName().equals(name)){
                    return baraja.get(i).get(j);
                }
            }
        }
        return null;
    }
    
    public static int getWidths(){
        return width;
    }

    public static int getHeigth(){
        return height;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanelMazo = new javax.swing.JPanel();
        jPanelMazo8 = new javax.swing.JPanel();
        jPanelMazo1 = new javax.swing.JPanel();
        jPanelMazo2 = new javax.swing.JPanel();
        jPanelMazo3 = new javax.swing.JPanel();
        jPanelMazo4 = new javax.swing.JPanel();
        jPanelMazo5 = new javax.swing.JPanel();
        jPanelMazo6 = new javax.swing.JPanel();
        jPanelMazo7 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
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
        jMenuItem8.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		jMenuItem8ActionPerformed(arg0);
        	}
        });
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
        setMaximumSize(new java.awt.Dimension(1008, 850));

        jPanel1.setBackground(new java.awt.Color(0, 102, 0));

        jPanelMazo.setBackground(new java.awt.Color(0, 102, 0));
        jPanelMazo.setName("jPanelMazo"); // NOI18N
        jPanelMazo.setPreferredSize(new java.awt.Dimension(122, 150));
        jPanelMazo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanelMazoMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanelMazoLayout = new javax.swing.GroupLayout(jPanelMazo);
        jPanelMazo.setLayout(jPanelMazoLayout);
        jPanelMazoLayout.setHorizontalGroup(
            jPanelMazoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanelMazoLayout.setVerticalGroup(
            jPanelMazoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanelMazo8.setBackground(new java.awt.Color(0, 102, 0));
        jPanelMazo8.setName("jPanelMazo"); // NOI18N
        jPanelMazo8.setPreferredSize(new java.awt.Dimension(122, 255));
        jPanelMazo8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanelMazo8MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanelMazo8Layout = new javax.swing.GroupLayout(jPanelMazo8);
        jPanelMazo8.setLayout(jPanelMazo8Layout);
        jPanelMazo8Layout.setHorizontalGroup(
            jPanelMazo8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanelMazo8Layout.setVerticalGroup(
            jPanelMazo8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 165, Short.MAX_VALUE)
        );

        jPanelMazo1.setBackground(new java.awt.Color(0, 102, 0));
        jPanelMazo1.setName("jPanelMazo"); // NOI18N
        jPanelMazo1.setPreferredSize(new java.awt.Dimension(122, 200));
        jPanelMazo1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanelMazo1MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanelMazo1Layout = new javax.swing.GroupLayout(jPanelMazo1);
        jPanelMazo1.setLayout(jPanelMazo1Layout);
        jPanelMazo1Layout.setHorizontalGroup(
            jPanelMazo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 122, Short.MAX_VALUE)
        );
        jPanelMazo1Layout.setVerticalGroup(
            jPanelMazo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanelMazo2.setBackground(new java.awt.Color(0, 102, 0));
        jPanelMazo2.setName("jPanelMazo"); // NOI18N
        jPanelMazo2.setPreferredSize(new java.awt.Dimension(122, 200));
        jPanelMazo2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanelMazo2MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanelMazo2Layout = new javax.swing.GroupLayout(jPanelMazo2);
        jPanelMazo2.setLayout(jPanelMazo2Layout);
        jPanelMazo2Layout.setHorizontalGroup(
            jPanelMazo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 122, Short.MAX_VALUE)
        );
        jPanelMazo2Layout.setVerticalGroup(
            jPanelMazo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanelMazo3.setBackground(new java.awt.Color(0, 102, 0));
        jPanelMazo3.setName("jPanelMazo"); // NOI18N
        jPanelMazo3.setPreferredSize(new java.awt.Dimension(122, 200));
        jPanelMazo3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanelMazo3MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanelMazo3Layout = new javax.swing.GroupLayout(jPanelMazo3);
        jPanelMazo3.setLayout(jPanelMazo3Layout);
        jPanelMazo3Layout.setHorizontalGroup(
            jPanelMazo3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 122, Short.MAX_VALUE)
        );
        jPanelMazo3Layout.setVerticalGroup(
            jPanelMazo3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanelMazo4.setBackground(new java.awt.Color(0, 102, 0));
        jPanelMazo4.setName("jPanelMazo"); // NOI18N
        jPanelMazo4.setPreferredSize(new java.awt.Dimension(122, 200));
        jPanelMazo4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanelMazo4MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanelMazo4Layout = new javax.swing.GroupLayout(jPanelMazo4);
        jPanelMazo4.setLayout(jPanelMazo4Layout);
        jPanelMazo4Layout.setHorizontalGroup(
            jPanelMazo4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 122, Short.MAX_VALUE)
        );
        jPanelMazo4Layout.setVerticalGroup(
            jPanelMazo4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanelMazo5.setBackground(new java.awt.Color(0, 102, 0));
        jPanelMazo5.setName("jPanelMazo"); // NOI18N
        jPanelMazo5.setPreferredSize(new java.awt.Dimension(122, 200));
        jPanelMazo5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanelMazo5MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanelMazo5Layout = new javax.swing.GroupLayout(jPanelMazo5);
        jPanelMazo5.setLayout(jPanelMazo5Layout);
        jPanelMazo5Layout.setHorizontalGroup(
            jPanelMazo5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 122, Short.MAX_VALUE)
        );
        jPanelMazo5Layout.setVerticalGroup(
            jPanelMazo5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanelMazo6.setBackground(new java.awt.Color(0, 102, 0));
        jPanelMazo6.setName("jPanelMazo"); // NOI18N
        jPanelMazo6.setPreferredSize(new java.awt.Dimension(122, 200));
        jPanelMazo6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanelMazo6MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanelMazo6Layout = new javax.swing.GroupLayout(jPanelMazo6);
        jPanelMazo6.setLayout(jPanelMazo6Layout);
        jPanelMazo6Layout.setHorizontalGroup(
            jPanelMazo6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 122, Short.MAX_VALUE)
        );
        jPanelMazo6Layout.setVerticalGroup(
            jPanelMazo6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );

        jPanelMazo7.setBackground(new java.awt.Color(0, 102, 0));
        jPanelMazo7.setName("jPanelMazo"); // NOI18N
        jPanelMazo7.setPreferredSize(new java.awt.Dimension(122, 200));
        jPanelMazo7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanelMazo7MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanelMazo7Layout = new javax.swing.GroupLayout(jPanelMazo7);
        jPanelMazo7.setLayout(jPanelMazo7Layout);
        jPanelMazo7Layout.setHorizontalGroup(
            jPanelMazo7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 122, Short.MAX_VALUE)
        );
        jPanelMazo7Layout.setVerticalGroup(
            jPanelMazo7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(0, 102, 0));
        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 191, 255)));
        jPanel2.setPreferredSize(new java.awt.Dimension(122, 144));
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel2MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 120, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 143, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(0, 102, 0));
        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 191, 255)));
        jPanel3.setPreferredSize(new java.awt.Dimension(122, 144));
        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel3MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 120, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 143, Short.MAX_VALUE)
        );

        jPanel4.setBackground(new java.awt.Color(0, 102, 0));
        jPanel4.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 191, 255)));
        jPanel4.setPreferredSize(new java.awt.Dimension(122, 144));
        jPanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel4MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 120, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 143, Short.MAX_VALUE)
        );

        jPanel5.setBackground(new java.awt.Color(0, 102, 0));
        jPanel5.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 191, 255)));
        jPanel5.setPreferredSize(new java.awt.Dimension(122, 144));
        jPanel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel5MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 120, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 143, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(47, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanelMazo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelMazo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanelMazo8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelMazo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanelMazo3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanelMazo4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanelMazo5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanelMazo6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanelMazo7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(47, 47, 47))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanelMazo, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                    .addComponent(jPanelMazo8, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanelMazo6, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
                        .addComponent(jPanelMazo5, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
                        .addComponent(jPanelMazo3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
                        .addComponent(jPanelMazo2, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
                        .addComponent(jPanelMazo4, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
                        .addComponent(jPanelMazo1, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE))
                    .addComponent(jPanelMazo7, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
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
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
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
        jMenuItem6.setPreferredSize(new java.awt.Dimension(117, 30));
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem6);

        jMenuItem7.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jMenuItem7.setText("Hacer");
        jMenuItem7.setPreferredSize(new java.awt.Dimension(117, 30));
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
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
            if(MainWindow.archivoEstadisticas!=null) {
            	MainWindow.intentosRealizadoClasico++;
            	if(MainWindow.archivoEstadisticas!=null) {
            		BufferedWriter bw = new BufferedWriter(new FileWriter(MainWindow.archivoEstadisticas));
                    bw.write("Solitario saltos"+System.getProperty("line.separator")+MainWindow.intentosRealizadoSaltos+System.getProperty("line.separator")+MainWindow.intentosExitoSaltos+System.getProperty("line.separator"));
                    bw.write("Solitario clasico"+System.getProperty("line.separator")+MainWindow.intentosRealizadoClasico+System.getProperty("line.separator")+MainWindow.intentosExitoClasico);
                    bw.close();
            	}
                
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
            if(MainWindow.archivoEstadisticas!=null) {
            	BufferedWriter bw = new BufferedWriter(new FileWriter(MainWindow.archivoEstadisticas));
                bw.write("Solitario saltos"+System.getProperty("line.separator")+MainWindow.intentosRealizadoSaltos+System.getProperty("line.separator")+MainWindow.intentosExitoSaltos+System.getProperty("line.separator"));
                bw.write("Solitario clasico"+System.getProperty("line.separator")+MainWindow.intentosRealizadoClasico+System.getProperty("line.separator")+MainWindow.intentosExitoClasico);
                bw.close();
            }
            
        }      
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
        if(JOptionPane.OK_OPTION == JOptionPane.showConfirmDialog(this,"¿Quieres guardar antes de salir?","Guardar",JOptionPane.YES_NO_OPTION)){
            jMenuItem4ActionPerformed(evt);
        }
        System.exit(0);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "Para crear un nuevo solitario puede elegir entre utilizar los botones de Solitario saltos o Solitario clasico y el Menu Archivo -> Nuevo. A continuacion saltara un mensaje para elegir el tipo de solitario que desea crear.\nAntes de empezar a jugar, por cada sesion se le pedira que cree o elija un archivo para guardar las estadisticas, que mas tarde podra consultar en el menu Historial -> Estadisticas. Tambien podra elegir o crear un fichero de estadisticas nuevo una vez creada la sesion mediante el menu Historial -> Fichero de estadisticas\nNota: El solitario clasico tarda unos segundos por el cargado de imagenes");
    }//GEN-LAST:event_jMenu2MouseClicked

    private void jPanelMazoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelMazoMousePressed
         // TODO add your handling code here:
         JPanel jpanel = (JPanel) evt.getSource();
         if(jpanel.getComponentCount()!=0){
            JLabel lbl = (JLabel) jpanel.getComponent(0);
            bfr.panelAntiguo.add(jpanel);
            bfr.panelActual.add(jPanelMazo8);
            bfr.cambioMazo.add(true);
            bfr.cambioBocaAbajo.add(false);
            bfr.movimientos.add(1);
            jpanel.remove(0);
            jpanel.revalidate();
            jpanel.repaint();
            lbl.setBounds(0, 0, 122, 150);
            jPanelMazo8.add(lbl,0);
            changeDownToUp(jPanelMazo8, lbl);
            jPanelMazo8.revalidate();
            jPanelMazo8.repaint();            
         }
    }//GEN-LAST:event_jPanelMazoMousePressed

    private void jPanelMazo8MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelMazo8MousePressed
         // TODO add your handling code here:
        if(jPanelMazo8.getComponentCount() != 0){
          if(count%2 == 0){
              cambiarCartaTop(evt.getSource()); 
          }else{
              ponerCarta(jPanelMazo8);
              esFinalizado();
          }
          count++;  
        }
    }//GEN-LAST:event_jPanelMazo8MousePressed

    private void jPanelMazo1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelMazo1MousePressed
        // TODO add your handling code here:
        JPanel jpanel = (JPanel) evt.getSource();
        if(jpanel.getComponentCount() == 0){
            cambiarCartaAMazoVacio(jpanel);
            esFinalizado();
        }
    }//GEN-LAST:event_jPanelMazo1MousePressed

    private void jPanelMazo2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelMazo2MousePressed
        // TODO add your handling code here:
        JPanel jpanel = (JPanel) evt.getSource();
        if(jpanel.getComponentCount() == 0){
            cambiarCartaAMazoVacio(jpanel);
            esFinalizado();
        }
    }//GEN-LAST:event_jPanelMazo2MousePressed

    private void jPanelMazo3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelMazo3MousePressed
        // TODO add your handling code here:
        JPanel jpanel = (JPanel) evt.getSource();
        if(jpanel.getComponentCount() == 0){
            cambiarCartaAMazoVacio(jpanel);
            esFinalizado();
        }
    }//GEN-LAST:event_jPanelMazo3MousePressed

    private void jPanelMazo4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelMazo4MousePressed
        // TODO add your handling code here:
        JPanel jpanel = (JPanel) evt.getSource();
        if(jpanel.getComponentCount() == 0){
            cambiarCartaAMazoVacio(jpanel);
            esFinalizado();
        }
    }//GEN-LAST:event_jPanelMazo4MousePressed

    private void jPanelMazo5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelMazo5MousePressed
        // TODO add your handling code here:
        JPanel jpanel = (JPanel) evt.getSource();
        if(jpanel.getComponentCount() == 0){
            cambiarCartaAMazoVacio(jpanel);
            esFinalizado();
        }
    }//GEN-LAST:event_jPanelMazo5MousePressed

    private void jPanelMazo6MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelMazo6MousePressed
        // TODO add your handling code here:
        JPanel jpanel = (JPanel) evt.getSource();
        if(jpanel.getComponentCount() == 0){
            cambiarCartaAMazoVacio(jpanel);
            esFinalizado();
        }
    }//GEN-LAST:event_jPanelMazo6MousePressed

    private void jPanelMazo7MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelMazo7MousePressed
        // TODO add your handling code here:
        JPanel jpanel = (JPanel) evt.getSource();
        if(jpanel.getComponentCount() == 0){
            cambiarCartaAMazoVacio(jpanel);
            esFinalizado();
        }
    }//GEN-LAST:event_jPanelMazo7MousePressed

    private void jPanel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MousePressed
        // TODO add your handling code here:
        if(bfr.count % 2 == 1){
            cambiarCartaAMazoArriba((JPanel) evt.getSource());
            esFinalizado();
        }  
    }//GEN-LAST:event_jPanel2MousePressed

    private void jPanel3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MousePressed
        // TODO add your handling code here:
        if(bfr.count % 2 == 1){
            cambiarCartaAMazoArriba((JPanel) evt.getSource());
            esFinalizado();
        }
    }//GEN-LAST:event_jPanel3MousePressed

    private void jPanel4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MousePressed
        // TODO add your handling code here:
        if(bfr.count % 2 == 1){
            cambiarCartaAMazoArriba((JPanel) evt.getSource());
            esFinalizado();
        }       
    }//GEN-LAST:event_jPanel4MousePressed

    private void jPanel5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MousePressed
        // TODO add your handling code here:
        if(bfr.count % 2 == 1){
            cambiarCartaAMazoArriba((JPanel) evt.getSource());
            esFinalizado();
        }
        
    }//GEN-LAST:event_jPanel5MousePressed

    private void esFinalizado(){
    	if(jPanel2.getComponentCount() == 13 && jPanel3.getComponentCount() == 13 && jPanel4.getComponentCount() == 13 && jPanel5.getComponentCount() == 13) {
    		MainWindow.intentosExitoClasico++; //Sumamos uno al contador de exito
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
    
    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        // TODO add your handling code here:
        if(bfr.panelActual.size() > 0 & bfr.panelAntiguo.size() > 0){
            JPanel panelAntiguo = bfr.panelAntiguo.get(bfr.panelAntiguo.size()-1);
            JPanel panelActual = bfr.panelActual.get(bfr.panelActual.size()-1);
            for(int i = bfr.movimientos.get(bfr.movimientos.size()-1)-1;  i>=0; i--){
                if(bfr.cambioMazo.get(bfr.cambioMazo.size()-1)){
                    changeUpToDown(panelActual, (JLabel) panelActual.getComponent(0));
                }
                else if(i == bfr.movimientos.get(bfr.movimientos.size()-1)-1 && bfr.cambioBocaAbajo.get(bfr.movimientos.size()-1)){
                    changeUpToDown(panelAntiguo, (JLabel) panelAntiguo.getComponent(0));
                    panelActual.getComponent(i).setBounds(panelAntiguo.getComponent(0).getX(), panelAntiguo.getComponent(0).getY()+12, panelAntiguo.getComponent(0).getWidth(), panelAntiguo.getComponent(0).getHeight());
                }else{
                    if(panelAntiguo.getComponentCount() == 0){
                        panelActual.getComponent(i).setBounds(0, 0, width, height);     
                    }else{
                        panelActual.getComponent(i).setBounds(panelAntiguo.getComponent(0).getX(), panelAntiguo.getComponent(0).getY()+30, panelAntiguo.getComponent(0).getWidth(), panelAntiguo.getComponent(0).getHeight());                           
                    }
                }
                panelAntiguo.add(panelActual.getComponent(i),0);
                if(panelAntiguo.getName() == "jPanelMazo8"){
                    panelAntiguo.getComponent(i).setBounds(0, 0, panelAntiguo.getComponent(0).getWidth(), panelAntiguo.getComponent(0).getHeight());                        
                }
            }
            panelAntiguo.revalidate();
            panelAntiguo.repaint();
            panelActual.revalidate();
            panelActual.repaint();
            
            cambioMazo2.add(bfr.cambioMazo.get(bfr.cambioMazo.size()-1)); //Anyadir para el boton Hacer
            cambioBocaAbajo2.add(bfr.cambioBocaAbajo.get(bfr.cambioBocaAbajo.size()-1));
            panelActual2.add(bfr.panelActual.get(bfr.panelActual.size()-1));
            panelAntiguo2.add(bfr.panelAntiguo.get(bfr.panelAntiguo.size()-1));
            movimientos2.add(bfr.movimientos.get(bfr.movimientos.size()-1));
            
            bfr.cambioMazo.remove(bfr.cambioMazo.size()-1);
            bfr.cambioBocaAbajo.remove(bfr.cambioBocaAbajo.size()-1);
            bfr.panelActual.remove(bfr.panelActual.size()-1);
            bfr.panelAntiguo.remove(bfr.panelAntiguo.size()-1);
            bfr.movimientos.remove(bfr.movimientos.size()-1);
        }
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenu3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu3MousePressed
        // TODO add your handling code here:
        if(bfr.panelActual.size()<1){
            jMenuItem6.setEnabled(false);
        }else{
            jMenuItem6.setEnabled(true);
        }
        if(panelActual2.size()<1){
            jMenuItem7.setEnabled(false);
        }else{
            jMenuItem7.setEnabled(true);
        }
    }//GEN-LAST:event_jMenu3MousePressed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        // TODO add your handling code here:
        if(panelActual2.size() > 0 && panelAntiguo2.size() > 0){
            JPanel panelActual = panelAntiguo2.get(panelAntiguo2.size()-1);
            JPanel panelAntiguo = panelActual2.get(panelActual2.size()-1);
            for(int i = movimientos2.get(movimientos2.size()-1)-1;  i>=0; i--){
                if(cambioMazo2.get(cambioMazo2.size()-1)){
                    changeDownToUp(panelActual, (JLabel) panelActual.getComponent(0));
                }
                else if(i == movimientos2.get(movimientos2.size()-1)-1 && cambioBocaAbajo2.get(movimientos2.size()-1)){
                    panelActual.getComponent(i).setBounds(panelAntiguo.getComponent(0).getX(), panelAntiguo.getComponent(0).getY()+30, panelAntiguo.getComponent(0).getWidth(), panelAntiguo.getComponent(0).getHeight());
                }else{
                    if(panelAntiguo.getComponentCount() == 0){
                        panelActual.getComponent(i).setBounds(0, 0, width, height);     
                    }else{
                        panelActual.getComponent(i).setBounds(panelAntiguo.getComponent(0).getX(), panelAntiguo.getComponent(0).getY()+30, panelAntiguo.getComponent(0).getWidth(), panelAntiguo.getComponent(0).getHeight());                           
                    }
                }
                panelAntiguo.add(panelActual.getComponent(i),0);
                if(panelAntiguo.getName() == "jPanelMazo8"){
                    panelAntiguo.getComponent(i).setBounds(0, 0, panelAntiguo.getComponent(0).getWidth(), panelAntiguo.getComponent(0).getHeight());                        
                }else if(i == 0 && cambioBocaAbajo2.get(movimientos2.size()-1)){
                    changeDownToUp(panelActual, (JLabel) panelActual.getComponent(0));

                }
            }
            panelAntiguo.revalidate();
            panelAntiguo.repaint();
            panelActual.revalidate();
            panelActual.repaint();
            
            bfr.cambioMazo.add(cambioMazo2.get(cambioMazo2.size()-1)); //Anyadir para el boton Deshacer
            bfr.cambioBocaAbajo.add(cambioBocaAbajo2.get(cambioBocaAbajo2.size()-1));
            bfr.panelActual.add(panelActual2.get(panelActual2.size()-1));
            bfr.panelAntiguo.add(panelAntiguo2.get(panelAntiguo2.size()-1));
            bfr.movimientos.add(movimientos2.get(movimientos2.size()-1));
            
            cambioMazo2.remove(cambioMazo2.size()-1);
            cambioBocaAbajo2.remove(cambioBocaAbajo2.size()-1);
            panelActual2.remove(panelActual2.size()-1);
            panelAntiguo2.remove(panelAntiguo2.size()-1);
            movimientos2.remove(movimientos2.size()-1);
        }
    }//GEN-LAST:event_jMenuItem7ActionPerformed
    
    //Funcion que se encarga de guardar la informacion ordenada de los 4 paneles de arriba del solitario
    private void fillWriter4MazosArriba(JPanel jpanel, JPanel jpanel2, JPanel jpanel3, JPanel jpanel4, BufferedWriter bw) throws IOException{
        JPanel jpanelPrimero = new JPanel(); //Orden en el que se van a escribir los jpanel.
        JPanel jpanelSegundo = new JPanel();
        JPanel jpanelTercero = new JPanel();
        JPanel jpanelCuarto = new JPanel();
        JPanel[] jpaneles = new JPanel[4]; //Array de los jpanel para trabajar mas comodamente
        jpaneles[0] = jpanel;
        jpaneles[1] = jpanel2;
        jpaneles[2] = jpanel3;
        jpaneles[3] = jpanel4;
        
        for(int i = 0; i<jpaneles.length; i++){ //Bucle para saber que panel hemos de sacar la informacion para el archivo primero.
            if(jpaneles[i].getComponentCount()!=0){
                if(getCarta(jpaneles[i].getComponent(0).getName()).getPalo() == 'C'){ //Si el palo de la primera carta es C = Clubs
                    jpanelPrimero = jpaneles[i];
                }else if(getCarta(jpaneles[i].getComponent(0).getName()).getPalo() == 'D'){
                    jpanelSegundo = jpaneles[i];
                }else if(getCarta(jpaneles[i].getComponent(0).getName()).getPalo() == 'H'){
                    jpanelTercero = jpaneles[i];
                }else{
                    jpanelCuarto = jpaneles[i];
                }
            }
        }
        
        fillWriter1Panel(jpanelPrimero, bw);
        fillWriter1Panel(jpanelSegundo, bw);
        fillWriter1Panel(jpanelTercero, bw);
        fillWriter1Panel(jpanelCuarto, bw);

    }
    
    //Funcion utilizada para escribir la informacion de un mazo con cartas boca arriba.
    private void fillWriter1Panel(JPanel jpanel, BufferedWriter bw) throws IOException{
        for(int i = jpanel.getComponentCount()-1; i>=0 ; i--){
            bw.write(jpanel.getComponent(i).getName()+" ");
        }
        bw.write(System.getProperty("line.separator"));
    }
    
    //Funcion que rellena el archivo de texto con las lineas de las 7 pilas.
    private void fillWriter7Mazos(BufferedWriter bw) throws IOException{
        fillWriter7MazosAyuda(jPanelMazo1, bw);
        fillWriter7MazosAyuda(jPanelMazo2, bw);
        fillWriter7MazosAyuda(jPanelMazo3, bw);
        fillWriter7MazosAyuda(jPanelMazo4, bw);
        fillWriter7MazosAyuda(jPanelMazo5, bw);
        fillWriter7MazosAyuda(jPanelMazo6, bw);
        fillWriter7MazosAyuda(jPanelMazo7, bw);
    }

    //Funcion que rellena el archivo con la linea de informacion del jpanel pasado como parametro.
    private void fillWriter7MazosAyuda(JPanel jpanel, BufferedWriter bw) throws IOException{
        int count = 0;
        if(jpanel.getComponentCount() == 0){ //Si el monton no contiene ninguna carta boca arriba ni boca abajo
            bw.write("*");
        }
        for(int i = jpanel.getComponentCount()-1; i>=0; i--){
            if(jpanel.getComponent(i).getName().length()!=2){ //Si la carta esta boca abajo
                bw.write(jpanel.getComponent(i).getName().substring(0,2)+" ");
            }else{ //La carta esta boca arriba
                if(count == 0){ //Si es la primera carta boca arriba
                    bw.write("* "); //Asterisco que indica que acaban las cartas boca abajo
                    bw.write(jpanel.getComponent(i).getName()+" ");
                    count++;
                }else{ //No es la primera carta boca arriba
                    bw.write(jpanel.getComponent(i).getName()+" ");
                }
            }
        }
        bw.write(System.getProperty("line.separator"));
    }
    
    //Funcion que rellena el archivo de texto con las primeras dos lineas
    private void fillWriterFirst2(BufferedWriter bw) throws IOException{
        bw.write("Solitario clásico"+System.getProperty("line.separator"));
        
        for(int i = jPanelMazo.getComponentCount()-1; i>=0; i--){ //Cartas del mazo sin extraer boca abajo.
            bw.write(jPanelMazo.getComponent(i).getName().substring(0,2)+" ");
        }
        bw.write(System.getProperty("line.separator")); // \n
        for(int i = jPanelMazo8.getComponentCount()-1; i>=0; i--){ //Cartas extraidas del mazo boca arriba.
            bw.write(jPanelMazo8.getComponent(i).getName()+" ");
        }
        bw.write(System.getProperty("line.separator")); // \n
    }
    
    //Funcion que se encarga de guardar la informacion del solitario en un fichero
    private void fillWriter(BufferedWriter bw) throws IOException{
        fillWriterFirst2(bw);
        fillWriter7Mazos(bw);
        fillWriter4MazosArriba(jPanel2, jPanel3, jPanel4, jPanel5, bw);
    }
    
    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        JFileChooser jfc = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de texto .txt", "txt");
        jfc.setFileFilter(filter);
        int returnValue = jfc.showDialog(null, "Salvar como"); 
        if(returnValue==JFileChooser.APPROVE_OPTION){ 
            try{
                archivo = jfc.getSelectedFile();
                String filePaths = archivo.getAbsolutePath();
                if(!filePaths.endsWith(".txt")) {
                    archivo = new File(filePaths + ".txt");
                }
                BufferedWriter bw;                
                if(new File(archivo.getAbsolutePath()).exists()){ //El archivo ya existia
                    if(JOptionPane.OK_OPTION == JOptionPane.showConfirmDialog(this,"El fichero existe,deseas reemplazarlo?","Guardar como",JOptionPane.YES_NO_OPTION)){ //Se remplaza el archivo si presiona si.
                        archivo = new File(archivo.getAbsolutePath());
                        String filePath = archivo.getAbsolutePath();
                        if(!filePath.endsWith(".txt")) {
                            archivo = new File(filePath + ".txt");
                        }
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

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) { //Boton resolver 
    	esFinalizado(); //Comprobar si se ha ganado
    	JPanel[] paneles = {jPanel2, jPanel3, jPanel4, jPanel5, jPanelMazo1, jPanelMazo2, jPanelMazo3, jPanelMazo4, jPanelMazo5, jPanelMazo6, jPanelMazo7, jPanelMazo8}; //Paneles a comprobar por orden
    	for(int i = 4; i<paneles.length; i++) {
    		for(int j = paneles[i].getComponentCount()-1; j>=0; j--) {
    			if(paneles[i].getComponentCount() > 0) {
    				JLabel lbl = (JLabel) paneles[i].getComponent(j);
    				if(lbl.getName().length() == 2) { //Si la carta no esta boca abajo
    					for(int k = 0; k<paneles.length-1; k++) {
            				if(paneles[k].getComponentCount() > 0) {
            					JLabel lbl2 = (JLabel) paneles[k].getComponent(0);
            					if(k<=3) {
            						if(getCarta(lbl.getName()).esMovibleMazoArriba(getCarta(lbl2.getName()))){ //Comprobar primero si se puede mover arriba
                						paneles[k].add(lbl,0);
                						i = 3;
                						k = paneles.length-1;
                						j = -1; 
                						if(paneles[i].getComponentCount() > 0) { //Si hay que poner boca arriba una carta que ha quedado boca abajo
                    						if(paneles[i].getComponent(0).getName().length() != 2) {
                        						JLabel labl = getCarta(paneles[i].getComponent(0).getName().substring(0,2)).getJLabel();
                        						paneles[i].remove(0);
                        						paneles[i].add(labl, 0);
                        						
                        					}
                    					}
                					}
            					}           					
            					else if(getCarta(lbl2.getName()).esMovibleFr(getCarta(lbl.getName()))) { //Si la carta se puede mover a algun panel
                					int pos = paneles[i].getComponentZOrder(lbl);
                					for(int l = pos; l>=0; l--) {
                						paneles[k].add(paneles[i].getComponent(l),0); //Anyadimos la o las labels al panel nuevo
                					}
                					if(paneles[i].getComponentCount() > 0) { //Si hay que poner boca arriba una carta que ha quedado boca abajo
                						if(paneles[i].getComponent(0).getName().length() != 2) {
                    						JLabel labl = getCarta(paneles[i].getComponent(0).getName().substring(0,2)).getJLabel();
                    						paneles[i].remove(0);
                    						paneles[i].add(labl, 0);
                    						
                    					}
                					}
                					
                					i = 3; //Si se mueve una carta/s se vuelve a mirar de 0
                					k = paneles.length-1;
                					j = -1;
                				}
            				}else {
            					if(getCarta(lbl.getName()).getNumero() == 'A' && k<=3 && paneles[k].getComponentCount() == 0) { //Si el panel de arriba esta vacio y es un as a mover
            						paneles[k].add(lbl, 0);
            						if(paneles[i].getComponentCount() > 0) { //Si hay que poner boca arriba una carta que ha quedado boca abajo
                						if(paneles[i].getComponent(0).getName().length() != 2) {
                    						JLabel labl = getCarta(paneles[i].getComponent(0).getName().substring(0,2)).getJLabel();
                    						paneles[i].remove(0);
                    						paneles[i].add(labl,0);
                    						
                    					}
                					}
            						i = 3;
            						k = paneles.length-1;
            						j = -1;
            					}
            				}
            				
            			}
    				}
        			
    			}
    		}
    		if(i == paneles.length-1 && paneles[i].getComponentCount() == 0) {
				if(jPanelMazo.getComponentCount()>0) { //Si hay cartas en el mazo
					jPanelMazo8.add(jPanelMazo.getComponent(0), 0); //Anyadimos una carta del mazo
					i = 3; //Volvemos a comprobar
    				JLabel labl = getCarta(jPanelMazo8.getComponent(0).getName().substring(0,2)).getJLabel();
    				jPanelMazo8.remove(0);
    				jPanelMazo8.add(labl, 0);   						
				}
			}
    	} //En este punto ya no se puede mover ninguna otra carta
    	for(int i = 0; i<paneles.length; i++) {
    		paneles[i].revalidate();
    		paneles[i].repaint();
    	}
    	System.out.println("");
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

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
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
                jPanelMazo.removeAll();
                jPanelMazo1.removeAll();
                jPanelMazo2.removeAll();
                jPanelMazo3.removeAll();
                jPanelMazo4.removeAll();
                jPanelMazo5.removeAll();
                jPanelMazo6.removeAll();
                jPanelMazo7.removeAll();
                jPanelMazo8.removeAll();
                jPanel2.removeAll();
                jPanel3.removeAll();
                jPanel4.removeAll();
                jPanel5.removeAll();
        
                String text2 = text.toString();
                String[] txt = text2.split("\n");
                if(txt[0].contains("Solitario clásico")){
                    String[] lines = txt[1].split(" ");

                    for(int i = 0; i<lines.length; i++){
                        JLabel lbl = getCarta(lines[i]).getJLabelDown();
                        jPanelMazo.add(lbl,0);
                        lbl.setBounds(0, 0, width, height);
                    }
                    jPanelMazo.revalidate();
                    jPanelMazo.repaint();

                    lines = txt[2].split(" ");
                    if(lines[0].length()>1){
                       for(int i = 0; i<lines.length; i++){
                            JLabel lbl = getCarta(lines[i]).getJLabel();
                            jPanelMazo8.add(lbl,0);
                            lbl.setBounds(0, 0, width, height);
                        } 
                    }
                    jPanelMazo8.revalidate();
                    jPanelMazo8.repaint();

                    funcAbrir2(jPanelMazo1, txt, 3);
                    funcAbrir2(jPanelMazo2, txt, 4);
                    funcAbrir2(jPanelMazo3, txt, 5);
                    funcAbrir2(jPanelMazo4, txt, 6);
                    funcAbrir2(jPanelMazo5, txt, 7);
                    funcAbrir2(jPanelMazo6, txt, 8);
                    funcAbrir2(jPanelMazo7, txt, 9);

                    if(txt.length>10){
                        funcAbrir3(jPanel2, txt, 10);
                    }if(txt.length>11){
                        funcAbrir3(jPanel3, txt, 11);
                    }if(txt.length>12){
                        funcAbrir3(jPanel4, txt, 12);
                    }if(txt.length>13){
                        funcAbrir3(jPanel5, txt, 13);
                    }      
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(SolitarioFrWindow.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(SolitarioFrWindow.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }//GEN-LAST:event_jMenuItem2ActionPerformed
    
    private void funcAbrir3(JPanel jpanel, String[] txt, int linea){
        if(txt[linea].length()>1){
            String[] line = txt[linea].split(" ");
            for(int i = 0; i<line.length; i++){
                JLabel lbl = getCarta(line[i]).getJLabel();
                lbl.setBounds(0, 0, width, height);
                jpanel.add(lbl, 0);
            }
            jpanel.validate();
            jpanel.repaint();
        }
    }
    
    //Funcion para poner las cartas de las 7 pilas de abajo
    private void funcAbrir2(JPanel jpanel, String[] txt, int linea){
        if(txt[linea].length()>3){
            String lineBocaAbajo = txt[linea].substring(0, txt[linea].indexOf("*"));
            String lineBocaArriba = txt[linea].substring(txt[linea].indexOf("*")+2, txt[linea].length());
            funcAbrir(lineBocaAbajo, lineBocaArriba, jpanel);
        }
    }
    
    //Funcion para poner las cartas de las 7 pilas de abajo
    private void funcAbrir(String line, String line2, JPanel jpanel){
        String[] txt = line.split(" ");
        String[] txt2 = line2.split((" "));
        if(txt[0].length()!=0){
           for(int i = 0; i<txt.length; i++){
                if(jpanel.getComponentCount() == 0){ //Si es la primera carta a colocar boca abajo
                    JLabel lbl = getCarta(txt[i]).getJLabelDown();
                    lbl.setBounds(0, 0, width, height);
                    jpanel.add(lbl, 0);
                }else{
                    JLabel lbl = getCarta(txt[i]).getJLabelDown();
                    lbl.setBounds(jpanel.getComponent(0).getX(), jpanel.getComponent(0).getY()+12, width, height);
                    jpanel.add(lbl,0);
                }            
            }
        }
        
        for(int i = 0; i<txt2.length; i++){
            if(jpanel.getComponentCount() == 0 && txt[0].length() == 0){ //Si no habia cartas boca abajo y es la primera a colocar boca arriba.
                JLabel lbl = getCarta(txt2[i]).getJLabel();
                lbl.setBounds(0, 0, width, height);
                jpanel.add(lbl, 0);
            }else{
                if(i == 0){
                    JLabel lbl = getCarta(txt2[i]).getJLabel();
                    lbl.setBounds(jpanel.getComponent(0).getX(), jpanel.getComponent(0).getY()+12, width, height);
                    jpanel.add(lbl, 0);                     
                }else{
                    JLabel lbl = getCarta(txt2[i]).getJLabel();
                    lbl.setBounds(jpanel.getComponent(0).getX(), jpanel.getComponent(0).getY()+30, width, height);
                    jpanel.add(lbl, 0);                   
                }
                
            }
            
        }
        jpanel.revalidate();
        jpanel.repaint();
    }
    //Cambiar una carta al mazo de arriba
    private void cambiarCartaAMazoArriba(JPanel jpanel){
        if(bfr.labelsToMove.length == 1){ //Si la carta a mover es 1 carta solo.
            JPanel jp2 = (JPanel) bfr.labelsToMove[0].getParent();
            if(jpanel.getComponentCount() == 0){
                if(getCarta(bfr.labelsToMove[0].getName()).getNumero() == 'A'){ // Si dicha carta a mover es un As 
                    bfr.cambioMazo.add(false);
                    bfr.panelActual.add(jpanel);
                    bfr.panelAntiguo.add((JPanel) bfr.labelsToMove[0].getParent());
                    bfr.movimientos.add(bfr.labelsToMove.length);
                    bfr.labelsToMove[0].setBounds(0, 0, width, height); //Seteamos la posicion en 0,0
                    cambiarAlMazoArribaAyuda(jpanel, jp2);
                }
            }else{ // Si ya hay mas de una label en el panel
                if(getCarta(bfr.labelsToMove[0].getName()).esMovibleMazoArriba(getCarta(jpanel.getComponent(0).getName()))){ //Si se puede mover al mazo de arriba
                    bfr.cambioMazo.add(false);
                    bfr.panelActual.add(jpanel);
                    bfr.panelAntiguo.add((JPanel) bfr.labelsToMove[0].getParent());
                    bfr.movimientos.add(bfr.labelsToMove.length);
                    bfr.labelsToMove[0].setBounds(jpanel.getComponent(0).getX(), jpanel.getComponent(0).getY(), width, height);
                    cambiarAlMazoArribaAyuda(jpanel, jp2);
                } 
            }
        }    
    }
    
    private void cambiarAlMazoArribaAyuda(JPanel jpanel, JPanel jp2){
        JLabel lbl = (JLabel) jp2.getComponent(0);
        jpanel.add(bfr.labelsToMove[0]);
        jpanel.setComponentZOrder(bfr.labelsToMove[0], 0);
        jp2.remove(bfr.labelsToMove[0]);
        bfr.count++;
        if(jp2.getComponentCount()>0){
            if(jp2.getComponent(0).getName().length() != 2){ //Si al acabar de mover, se queda una carta boca abajo, se pone boca arriba
                changeDownToUp(jp2, (JLabel) jp2.getComponent(0));
                bfr.cambioBocaAbajo.add(true);
            }else{
                bfr.cambioBocaAbajo.add(false);
            }
        }else{
            bfr.cambioBocaAbajo.add(false);        
        }
        lbl.setBorder(null);
        jp2.revalidate();
        jp2.repaint();
        jpanel.revalidate();
        jpanel.repaint();
    }
    
    private void cambiarCartaAMazoVacio(JPanel jpanel){
        JPanel jp2 = (JPanel) bfr.lbl.getParent();
        if(getCarta(bfr.labelsToMove[bfr.labelsToMove.length-1].getName()).getNumero() == 'K'){ // Si la carta a mover es un rey, se puede mover a monton vacio.
            bfr.lbl.setBorder(null);
            bfr.panelActual.add(jpanel);
            bfr.panelAntiguo.add(jp2);
            bfr.movimientos.add(bfr.labelsToMove.length);
            bfr.cambioMazo.add(false);
            for(int i = bfr.labelsToMove.length-1;  i>=0; i--){
                if(jpanel.getComponentCount() == 0){
                    bfr.labelsToMove[i].setBounds(0, 0, width, height);
                }else{
                    bfr.labelsToMove[i].setBounds(jpanel.getComponent(0).getX(), jpanel.getComponent(0).getY()+30, jpanel.getComponent(0).getWidth(), jpanel.getComponent(0).getHeight());
                }
                jpanel.add(bfr.labelsToMove[i],0);
                jp2.remove(bfr.labelsToMove[i]);
            }
            if(jp2.getComponentCount()>0){
                if(jp2.getComponent(0).getName().length() != 2){ //Si al acabar de mover, se queda una carta boca abajo, se pone boca arriba
                    changeDownToUp(jp2, (JLabel) jp2.getComponent(0));
                    bfr.cambioBocaAbajo.add(true);
                }else{
                    bfr.cambioBocaAbajo.add(false);
                }    
            }else{
                bfr.cambioBocaAbajo.add(false);
            }
            jp2.revalidate();
            jp2.repaint();
            jpanel.revalidate();
            jpanel.repaint();
            bfr.count++;
        }
        
    }
    private void cambiarCartaTop(Object jp){
        JPanel jpanel = (JPanel) jp;
        if(jpanel.getComponents().length>0){
            lblChange = (JLabel) jpanel.getComponents()[0];
            panelChange = (JPanel) lblChange.getParent();
            jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 0, 0)));
            jpanel.revalidate();
            jpanel.repaint(); 
        }
    }
    
    //Cambia carta boca abajo por la misma carta boca arriba
    private void changeDownToUp(JPanel jpanel, JLabel label){
        String name = label.getName().substring(0,2); //Obtenemos el nombre de la carta que esta boca abajo.
        JLabel lbl = getCarta(name).getJLabel(); //Creamos una label boca arriba con la carta previamente seleccionada.
        if(jpanel.getComponentCount() == 0){
            lbl.setBounds(0, 0, 122, 150);
        }else{
            lbl.setBounds(jpanel.getComponent(0).getBounds());
        }
        jpanel.remove(0); //Eliminamos la carta boca abajo.
        jpanel.add(lbl, 0); //Anyadimos la carta nueva
        jpanel.revalidate();
        jpanel.repaint();            
    }
    
    private void changeUpToDown(JPanel jpanel, JLabel label){
        String name = label.getName().substring(0,2); //Obtenemos el nombre de la carta que esta boca arriba.
        JLabel lbl = getCarta(name).getJLabelDown(); //Creamos una label boca abajo con la carta previamente seleccionada.
        if(jpanel.getComponentCount() == 0){
            lbl.setBounds(0, 0, 122, 150);
        }else{
            lbl.setBounds(jpanel.getComponent(0).getBounds());
        }
        jpanel.remove(0); //Eliminamos la carta boca arriba.
        jpanel.add(lbl, 0); //Anyadimos la carta nueva
        jpanel.revalidate();
        jpanel.repaint();            
    }
    
    private void ponerCarta(JPanel jpanel){
        JPanel jp2 = (JPanel) lblChange.getParent();
        lblChange.setBorder(null);
        jp2.remove(lblChange);
        
        //Cambiar carta boca abajo por la misma carta boca arriba
        if(jp2.getComponentCount()!=0){
            changeDownToUp(jp2, (JLabel) jp2.getComponent(0));
            
            jp2.getComponent(0).setBounds(WIDTH, WIDTH, getWidths(), (int) (getHeigth()/0.5));  
        }
        
        lblChange.setBounds(jpanel.getComponent(0).getX(), jpanel.getComponent(0).getY()+30, jpanel.getComponent(0).getWidth(), jpanel.getComponent(0).getHeight());
        jpanel.add(lblChange, 0); //Mover arriba las cartas
        jpanel.revalidate();
        jpanel.repaint();
        
    }

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
            java.util.logging.Logger.getLogger(SolitarioFrWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SolitarioFrWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SolitarioFrWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SolitarioFrWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new SolitarioFrWindow().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(SolitarioFrWindow.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
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
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanelMazo;
    private javax.swing.JPanel jPanelMazo1;
    private javax.swing.JPanel jPanelMazo2;
    private javax.swing.JPanel jPanelMazo3;
    private javax.swing.JPanel jPanelMazo4;
    private javax.swing.JPanel jPanelMazo5;
    private javax.swing.JPanel jPanelMazo6;
    private javax.swing.JPanel jPanelMazo7;
    private javax.swing.JPanel jPanelMazo8;
    // End of variables declaration//GEN-END:variables
}
