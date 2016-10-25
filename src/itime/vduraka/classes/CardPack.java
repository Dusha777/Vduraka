/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itime.vduraka.classes;

import itime.vduraka.interfaces.ICardPack;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Andrei_Fofilov
 */
public class CardPack implements ICardPack {

    //private Card[] pack = new Card[36];
    private ArrayList<Card> pack = new ArrayList<Card>();
    public CardPack() {
        int counter = 0;
        for (int i = 0; i < 4; i++) {

            for (int y = 0; y < 9; y++) {
                this.pack.add(new Card()); //= new Card();
                this.pack.get(counter).setSuit(i);
                this.pack.get(counter).setWeight(y);
                //System.out.println(counter+ "---------" + pack[counter].getWeightName() + "/" + pack[counter].getSuitName());
                counter++;

            }

        }

    }

    @Override
    public void mixCardPack(int precision) {
        for (int i = 0; i < precision; i++) {
            Random mixRand = new Random();
            int cardToChange = mixRand.nextInt(36);
            Card buffer = new Card();
            buffer = this.pack.get(cardToChange);
            this.pack.set(cardToChange, this.pack.get(0));
            this.pack.set(0, buffer);

        }
        showCards();

    }
    
    public void showCards() {
        System.out.println("Cards pack:");
        for (int i = 0; i < this.pack.size(); i++) {
            System.out.println(i + "---------" + pack.get(i).getWeightName() + "/" + pack.get(i).getSuitName());
        }
    }

    @Override
    public void dealCards() {
        
    }

    @Override
    public void addCards() {
    }

    public ArrayList<Card> getPack() {
        return pack;
    }

   /* public Card[] getPack() {
        return pack;
    }*/

    @Override
    public void addPlayOffCards() {
    }

}
