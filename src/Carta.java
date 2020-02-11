/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Image;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import sun.reflect.ReflectionFactory.GetReflectionFactoryAction;

/**
 *
 * @author andre
 */
public final class Carta{

    private char numero;
    private char palo;
    String tipo = "";
    private JLabel label;
    private JLabel labeldown;
    public Carta(String carta, String tipo) throws FileNotFoundException, IOException{
        if(tipo == "Fr"){
            this.numero = carta.charAt(0);
            this.palo = carta.charAt(1);
            label = new JLabel();
            labeldown = new JLabel();
            label.setIcon(new ImageIcon(new ImageIcon(MainWindow.class.getResource("/PNG/Fr/"+numero+palo+".png")).getImage().getScaledInstance(122, 150, Image.SCALE_SMOOTH)));
            labeldown.setIcon(new ImageIcon(new ImageIcon(MainWindow.class.getResource("/PNG/Fr/blue_back.png")).getImage().getScaledInstance(122, 150, Image.SCALE_SMOOTH)));
            if(!esCorrecto()){
                System.out.println("Carta con numero: "+numero+ " y palo: "+palo+" creada incorrectamente.");
                System.exit(0);
            } 
        }else if(tipo == "Sp"){
            this.numero = carta.charAt(0);
            this.palo = carta.charAt(1);
            label = new JLabel();
            label.setIcon(new ImageIcon(new ImageIcon(MainWindow.class.getResource("/PNG/Sp/"+numero+palo+".jpg")).getImage().getScaledInstance(122, 150, Image.SCALE_SMOOTH)));
                    
        }
        
    }
    
    //return true si el palo de la carta es S=Spades o C=Clubs, es decir negro
    public boolean isBlack(){
        if(this.palo == 'S' || this.palo == 'C'){
            return true;
        }
        return false;
    }
    
    //return true si el palo de la carta es H=Hearts o D=Diamonds, es decir rojo
    public boolean isRed(){
        if(this.palo == 'H' || this.palo == 'D'){
            return true;
        }
        return false;
    }
    
    //return true si el numero de la carta es una unidad menos que la comparada.
    public boolean esNumeroMovible(Carta carta){
        if((this.numero == 'J' && carta.numero == 'T') || carta.numero == '9' && this.numero == 'T'){
            return true;
        }if(this.numero == 'Q' && carta.numero == 'J'){
            return true;
        }if(this.numero == 'K' && carta.numero == 'Q'){
            return true;
        }if(this.numero == '2' && carta.numero == 'A'){
            return true;
        }if(this.numero == 'K' || this.numero == 'Q' || this.numero == 'J' || this.numero == 'T'){ //Problemas restando K - J
            return false;
        }if(this.numero-carta.numero==1){
            return true;
        }
        return false;
    }
    
    public boolean esMovibleMazoArriba(Carta carta){
        if((this.getPalo() == carta.getPalo()) && this.esNumeroMovible(carta)){
            return true;
        }
        return false;
    }
    
    //return true si una carta se puede mover a otra en el solitario frances
    public boolean esMovibleFr(Carta carta){
        if(((isBlack() && carta.isRed()) && esNumeroMovible(carta)) || ((isRed() && carta.isBlack()) && esNumeroMovible(carta))){
            return true;
        }
        return false;
    }
    
    public boolean esMovible(Carta carta){
        return mismoPalo(carta) || mismoNumero(carta);
    }

    public boolean mismaCarta(Carta carta){
        return mismoPalo(carta) && mismoNumero(carta);
    }
    
    public boolean mismoPalo(Carta carta){
        return this.palo == carta.palo;
    }
    
    public boolean mismoNumero(Carta carta){
        return this.numero == carta.numero;
    }
    
    public void setCarta(char numero, char palo){
        this.numero = numero;
        this.palo = palo;
    }
    
    public void setLabel(JLabel label){
        this.label = label;
    }
    
    public void setLabelDown(JLabel label){
        this.labeldown = label;
    }
    
    public JLabel getJLabel(){
        return this.label;
    }
    
    public JLabel getJLabelDown(){
        return this.labeldown;
    }
    
    public char getPalo() {
        return palo;
    }

    public char getNumero() {
        return numero;
    }
    
    public String getName(){
        StringBuilder sb = new StringBuilder();
        sb.append(numero);
        sb.append(palo);
        return sb.toString();
    }
    

    
    @Override
    public String toString(){
        System.out.println(this.numero+" de "+this.palo);
        return this.numero+" de "+this.palo;
    }
    
    public boolean esCorrecto(){
        boolean num = false;
        boolean pal = false;
        if(numero == '2' || numero == '3' || numero == '4' || numero == '5' || numero == '6' || numero == '7' || numero == '8' || numero == '9' || numero == 'A' || numero == 'T' || numero == 'J' || numero == 'Q' || numero == 'K'){
            num = true;
        }
        if( palo=='C' || palo== 'D' || palo== 'H' || palo== 'S' ){
            pal = true;
        }
        return num && pal;
    }
}
