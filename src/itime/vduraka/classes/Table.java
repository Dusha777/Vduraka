/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itime.vduraka.classes;

import java.util.ArrayList;

/**
 *
 * @author Andrei_Fofilov
 */
public class Table {
    private ArrayList<Card> tableCards = new ArrayList<Card>();
    
    public Table() {
    }
    public void cardToTable(Card card){
       this.tableCards.add(card);
    }
    public void cleanTable(){
       for (int i = 0; i<this.tableCards.size(); i++){
           this.tableCards.remove(i);
       }
    }

    public ArrayList<Card> getTableCards() {
        return tableCards;
    }
    public void showCardsInTable(){
        System.out.println("On the table now:");
        for (int i = 0; i< this.tableCards.size();i++ ){
            System.out.print("  "+this.tableCards.get(i).getWeightName()+"/"+this.tableCards.get(i).getSuitName());
        }
        System.out.println(" ");
    }
}
