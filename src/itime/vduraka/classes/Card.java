/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itime.vduraka.classes;

import itime.vduraka.interfaces.ICard;

/**
 *
 * @author Andrei_Fofilov
 */
public class Card implements ICard {

    private final String[] suitsName = new String[4];
    private final String[] cardsName = new String[9];
    private int weight;
    private int suit;

    public Card() {
        suitsName[0] = "Sp"; // Spade
        suitsName[1] = "Hr"; // Hearts
        suitsName[2] = "Cl"; // Clubs
        suitsName[3] = "Dm"; // Dimonds 
        for (int i = 0; i < 9; i++) {
            if (i < 5) {
                cardsName[i] = Integer.toString(i + 6);
            } else if (i == 5) {
                cardsName[5] = "Jack";
            } else if (i == 6) {
                cardsName[6] = "Queen";
            } else if (i == 7) {
                cardsName[7] = "King";
            } else if (i == 8) {
                cardsName[8] = "Ace";
            }
        }
    }

    @Override
    public int getSuit() {
        return this.suit;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public int getWeight() {
        return this.weight;
    }
  
    public void setSuit(int suit) {
        this.suit = suit;
    }
    public  String getSuitName(){
       return suitsName[this.suit];  
    }
     public  String getWeightName(){
       return cardsName[this.weight];  
    }

}
