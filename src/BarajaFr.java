/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.Rectangle;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Andres Tascon
 */
public class BarajaFr {
    
    ArrayList <ArrayList<Carta>> brj = new ArrayList <ArrayList<Carta>>();
    ArrayList <Carta> mazo;
    ArrayList <Carta> pila1;
    ArrayList <Carta> pila2;
    ArrayList <Carta> pila3;
    ArrayList <Carta> pila4;
    ArrayList <Carta> pila5;
    ArrayList <Carta> pila6;
    ArrayList <Carta> pila7;
    public ArrayList<Boolean> cambioMazo = new ArrayList <Boolean>(); //Para boton deshacer
    public ArrayList<Boolean> cambioBocaAbajo = new ArrayList <Boolean>(); //Para boton deshacer
    public ArrayList<JPanel> panelAntiguo = new ArrayList <JPanel>(); //Para boton deshacer
    public ArrayList<JPanel> panelActual = new ArrayList <JPanel>(); //Para boton deshacer
    public ArrayList<Integer> movimientos = new ArrayList <Integer>(); //Para boton deshacer
    public JLabel[] labelsToMove;
    public JLabel lbl; 
    public int count = 0;
    Carta[] baraja = new Carta[52];
    String[] cartas = "AC 2C 3C 4C 5C 6C 7C 8C 9C TC JC QC KC AD 2D 3D 4D 5D 6D 7D 8D TD 9D JD QD KD AH 2H 3H 4H 5H 6H 7H 8H 9H KH 6S QH TH AS 2S 3S 4S 5S JH 7S 8S 9S TS JS QS KS".split(" ");
    
    public BarajaFr() throws IOException{
        barajar();
        for(int i = 0; i<cartas.length; i++){
            Carta carta = new Carta(cartas[i], "Fr"); 
            
            JLabel label = carta.getJLabel(); //Inicializacion y seteo de la label para la carta boca arriba.
            label.setName(carta.getName());
            label.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mousePressed(java.awt.event.MouseEvent evt) {
                    jLabelPressed(evt);    
                }
            });
            carta.setLabel(label);
            
            JLabel labeldown = carta.getJLabelDown(); //Inicializacion y seteo de la label para la carta boca abajo.
            labeldown.setName(carta.getName()+"DOWN");
            labeldown.setBounds(new Rectangle(122, 150));
            baraja[i] = carta;
        }
        crearBaraja();
    }
    
    private void crearBaraja() throws IOException{
        Carta[] baraja = this.baraja;
        pila1 = new ArrayList<>();
        this.brj.add(pila1);
        pila2 = new ArrayList<>();
        this.brj.add(pila2);
        pila3 = new ArrayList<>();
        this.brj.add(pila3);
        pila4 = new ArrayList<>();
        this.brj.add(pila4);
        pila5 = new ArrayList<>();
        this.brj.add(pila5);
        pila6 = new ArrayList<>();
        this.brj.add(pila6);
        pila7 = new ArrayList<>();
        this.brj.add(pila7);
        mazo = new ArrayList<>();
        this.brj.add(mazo);
        for(int i = 0; i<baraja.length; i++){
            if(i == 0){
                pila1.add(baraja[i]);
            }
            else if(i>=1 && i<3){
                pila2.add(baraja[i]);
            }
            else if(i>=3 && i<6){
                pila3.add(baraja[i]);
            }
            else if(i>=6 && i<10){
                pila4.add(baraja[i]);
            }
            else if(i>=10 && i<15){
                pila5.add(baraja[i]);
            }
            else if(i>=15 && i<21){
                pila6.add(baraja[i]);
            }
            else if(i>=21 && i<28){
                pila7.add(baraja[i]);
            }
            else if(i>=28){
                mazo.add(baraja[i]);
            }
        }
    }
        
    private void jLabelPressed(java.awt.event.MouseEvent evt){
        if(count % 2 == 0){
            lbl = (JLabel) evt.getSource();
            seleccionar(evt.getSource());
            count++;
        }else{
            mover(evt.getSource());
            count++;
        }
    }
    
    private void seleccionar(Object obj){
        JLabel label = (JLabel) obj;
        JPanel jpanel = (JPanel) label.getParent();
        label.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 0, 0)));
        labelsToMove = new JLabel[jpanel.getComponentZOrder(label)+1];
        for(int i = jpanel.getComponentZOrder(label); i >= 0; i--){
            labelsToMove[i] = (JLabel) jpanel.getComponent(i);
        } 
        jpanel.revalidate();
        jpanel.repaint();
    }
    
    private void mover(Object obj){
        JLabel label = (JLabel) obj;
        Carta carta1 = getCarta(label.getName());
        JPanel jpanel = (JPanel) label.getParent();
        JPanel jp2 = (JPanel) lbl.getParent();
        Carta carta2 = getCarta(labelsToMove[labelsToMove.length-1].getName());
        if(carta1.equals(carta2)){
            lbl.setBorder(null);
        }else{
            if(jpanel.getName() == "jPanel2" || jpanel.getName() == "jPanel3" || jpanel.getName() == "jPanel4" || jpanel.getName() == "jPanel5"){ //Si se quiere mover al mazo de arriba
                if(labelsToMove.length == 1){ //Si la carta a mover es 1 carta solo.
                    if(getCarta(labelsToMove[0].getName()).esMovibleMazoArriba(getCarta(jpanel.getComponent(0).getName()))){ //Si se puede mover al mazo de arriba
                        labelsToMove[0].setBounds(jpanel.getComponent(0).getX(), jpanel.getComponent(0).getY(), 122, 150);
                        panelActual.add(jpanel);
                        panelAntiguo.add(jp2);
                        cambioMazo.add(false);
                        movimientos.add(labelsToMove.length);
                        jpanel.add(labelsToMove[0]);
                        jpanel.setComponentZOrder(labelsToMove[0], 0);
                        jp2.remove(labelsToMove[0]);
                        if(jp2.getComponentCount()>0){
                            if(jp2.getComponent(0).getName().length() != 2){ //Si al acabar de mover, se queda una carta boca abajo, se pone boca arriba
                                changeDownToUp(jp2, (JLabel) jp2.getComponent(0));
                                cambioBocaAbajo.add(true);
                            }else{
                                cambioBocaAbajo.add(false);
                            }
                        }else{
                            cambioBocaAbajo.add(false);
                        }
                        lbl.setBorder(null);
                        jp2.revalidate();
                        jp2.repaint();
                        jpanel.revalidate();
                        jpanel.repaint();
                    }                    
                }
            }else{
                if(label.getParent().equals(jp2.getComponent(0).getParent())){
                    lbl.setBorder(null);
                }else{
                   if(carta1.esMovibleFr(carta2) && label.getParent().getName()!="jPanelMazo8"){
                        lbl.setBorder(null);
                        int pos = jp2.getComponentZOrder(lbl);
                        panelActual.add(jpanel);
                        cambioMazo.add(false);
                        panelAntiguo.add(jp2);
                        movimientos.add(labelsToMove.length);
                        for(int i = 0; i<=pos; i++){
                            jp2.remove(jp2.getComponent(0));
                        }
                        jp2.revalidate();
                        jp2.repaint();
                        if(jp2.getComponentCount()>0){
                            if(jp2.getComponent(0).getName().length() != 2){ //Si al acabar de mover, se queda una carta boca abajo, se pone boca arriba
                                changeDownToUp(jp2, (JLabel) jp2.getComponent(0));
                                cambioBocaAbajo.add(true);
                            }else{
                                cambioBocaAbajo.add(false);
                            } 
                        }else{
                            cambioBocaAbajo.add(false);
                        }
                        for(int i = labelsToMove.length-1;  i>=0; i--){
                            labelsToMove[i].setBounds(jpanel.getComponent(0).getX(), jpanel.getComponent(0).getY()+30, jpanel.getComponent(0).getWidth(), jpanel.getComponent(0).getHeight());
                            jpanel.add(labelsToMove[i],0);
                        }
                        jpanel.revalidate();
                        jpanel.repaint();    
                    }else{
                        lbl.setBorder(null);
                    } 
                }     
            }
            
        }
    }
    
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
    
    public Carta getCarta(String name){
        for(int i = 0; i<brj.size(); i++){
            for(int j = 0; j<brj.get(i).size(); j++){
                if(brj.get(i).get(j).getName().equals(name)){
                    return brj.get(i).get(j);
                }
            }
        }
        return null;
    }
    //TODO Baraja aleatoriamente las 52 cartas.
    public void barajar(){
        for(int i = 0; i<cartas.length; i++){
            int random = (int) (Math.random() *51);
            String tmp = cartas[random];
            cartas[random] = cartas[i];
            cartas[i] = tmp;
        }
    }
    
    
    public ArrayList <ArrayList<Carta>> getBaraja(){
        return brj;
    }
}
