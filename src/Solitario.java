/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;

/**
 *
 * @author andre
 */
public class Solitario{
    
    //Metodo que comprueba el arrayList de cartas para ver si hay alguna duplicada
    public static boolean cartaDuplicada(ArrayList<ArrayList<Carta>> cartas){
        for(int i = 0; i<cartas.size(); i++){
            for(int j = i+1; j<cartas.size(); j++){
                if(cartas.get(i).get(0).mismaCarta(cartas.get(j).get(0))){
                    return true;
                }
            }
        }
        return false;
    }
        
    /**
     * @param cartas ArrayList de cartas
     * @param pos Posicion de la carta a mover
     * @param numero 1 o 3 = Mover 1 o 3 posiciones a la izqda.
     * @return true si se puede mover la carta
     */
    
    //Metodo que comprueba si una carta del arrayList se puede mover 1 o 3 pilas a la izquierda.
    public static boolean moverCarta(ArrayList<ArrayList<Carta>> cartas, int pos, int numero){
        //Comprobamos que la posicion este en el rango del arraylist.
        if(pos<cartas.size()){
            //Dependiendo de la variable numero (1 o 3) comprueba si se puede cambiar a la pila de 1 o 3 pilas a la izqda.
            if(pos >= numero && cartas.get(pos).get(cartas.get(pos).size()-1).esMovible(cartas.get(pos-numero).get(cartas.get(pos-numero).size()-1))){
                cartas.get(pos-numero).add(cartas.get(pos).get(cartas.get(pos).size()-1)); //Anyadir la carta a la pila
                cartas.get(pos).remove(cartas.get(pos).size()-1); //Eliminar la carta de la pila
                if(cartas.get(pos).isEmpty()){
                    cartas.remove(pos);
                }
                return true;
            }
        }
        return false;
    }
    
    //Metodo para llamar al metodo recursivo con los valores deseados, imprime la salida.
    public ArrayList<ArrayList<Carta>> recorreArray(ArrayList <ArrayList<Carta>> cartas){
        //Llamamos al metodo con el arraylist, la posicion en la que queremos que empiece (1), y el booleano a true
        recorreArrayRec(cartas, 1, true);
        //Si ha quedado 1 pila.  
        return cartas;
    }
    
    public String getSolucionString(ArrayList <ArrayList<Carta>> cartas){
        if(cartas.size()==1){
            return "Ha quedado "+cartas.size()+" pila: "+cartas.get(0).size();
        }
        //Si ha quedado mas de 1 pila.
        else{
            StringBuilder output = new StringBuilder("");
            output.append("Han quedado "+cartas.size()+" pilas:");
            for(int i = 0; i<cartas.size(); i++){
                output.append(" "+cartas.get(i).size());
            }
            return output.toString();
        } 
    }
    //Metodo recursivo que va recorriendo el ArrayList en busca de movimientos posibles.
    private static void recorreArrayRec(ArrayList<ArrayList <Carta>> cartas, int pos, boolean hayMovimiento){
        if(hayMovimiento){
            //Si se ha llegado al final de la baraja y no se pueden hacer mas movimientos.
            if(pos == cartas.size()-1){
                //movs = Si hay movimientos posibles en el array de cartas
                boolean movs = false;
                //Comprobamos que no haya movimientos posibles 
                for(int i = 0; i<cartas.size(); i++){
                    if(moverCarta(cartas, i , 1) || moverCarta(cartas, i, 3)){
                        movs = true;
                    }
                }
                //Si hay movimientos posibles volvemos a llamar al metodo
                if(movs){
                    recorreArrayRec(cartas, 1, hayMovimiento);
                }
                //Si no hay movimientos posibles, llamamos al metodo con la condicion a false para que salga.
                else{
                    recorreArrayRec(cartas, 1, false);
                }
            }
            else{
                //Si la carta se puede mover a la pila de 3 pos a la izqda
                if(moverCarta(cartas, pos, 3)){
                    recorreArrayRec(cartas, 1, hayMovimiento);
                }
                //Si la carta se puede mover a la pila de la izqda
                else if(moverCarta(cartas, pos, 1)){
                    recorreArrayRec(cartas, 1, hayMovimiento);
                } 
                //Si no se puede mover a ningun lado, se pasa a la siguiente carta
                else{
                    if(pos<cartas.size()-1){
                        recorreArrayRec(cartas, pos+1, hayMovimiento);
                    }
                }
            }
        }
    }
    
}
