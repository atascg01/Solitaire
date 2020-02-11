/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Andres Tascon
 */
public class BarajaSp {
    
    Carta[] baraja = new Carta[40];
    String[] cartas = ("AO 2O 3O 4O 5O 6O 7O SO CO RO AB 2B 3B 4B 5B 6B 7B SB CB RB AE 2E 3E 4E 5E 6E 7E SE CE RE AC 2C 3C 4C 5C 6C 7C SC CC RC").split(" ");
    
    public BarajaSp() throws IOException{
        barajar();
        for(int i = 0; i<cartas.length; i++){
            Carta carta = new Carta(cartas[i], "Sp");
            JLabel label = carta.getJLabel();
            label.setName(carta.getName());
            baraja[i] = carta;
        }
    }
    
    public Carta[] getBaraja(){
        return baraja;
    }
    
        //TODO Baraja aleatoriamente las 40 cartas.
    public void barajar(){
        for(int i = 0; i<cartas.length; i++){
            int random = (int) (Math.random() *39);
            String tmp = cartas[random];
            cartas[random] = cartas[i];
            cartas[i] = tmp;
        }
    }
}
