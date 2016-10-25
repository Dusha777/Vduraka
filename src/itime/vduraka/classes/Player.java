/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itime.vduraka.classes;

import itime.vduraka.interfaces.IPlayer;
import java.util.ArrayList;

/**
 *
 * @author Andrei_Fofilov
 */
public class Player  {

    private String playerName = "";
    private int playerId;
    private ArrayList<Card> playersCards = new ArrayList <Card>();

    public Player(int playerId, String playerName) {
        this.playerId = playerId;
        this.playerName = playerName;
    }
    
    


    public void addCard(Card card) {
        playersCards.add(card);
    }
    
     public void showPlayersCard() {
        System.out.print(this.playerName+":");
        for (int i = 0; i<playersCards.size(); i++){
           System.out.print("  "+i+"-" + playersCards.get(i).getWeightName() + "/"+playersCards.get(i).getSuitName());
        }
        System.out.println(" ");
    }

    public ArrayList<Card> getPlayersCards() {
        return playersCards;
    }

    

    public String getPlayerName() {
        return playerName;
    }

    public int getPlayerId() {
        return playerId;
    }

   
    public void giveCard(Card card) {
        
    }

}
