/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itime.vduraka.classes;

import java.util.Scanner;

/**
 *
 * @author Andrei_Fofilov
 */
public class Game {

    private Card trump;
    private final Player[] team;
    private Player playerLeadId;
    private Player playerDefId;
    //private int stepNr = 0;
    private CardPack deck = new CardPack();
    private Table table = new Table();
    Scanner in = new Scanner(System.in);
    private Card cardLead;
    private Card cardCover;

    public Game(int playersQty) {
        this.team = new Player[playersQty];

    }

    public void StartGame() {

        deck.mixCardPack(300);

        for (int i = 0; i < team.length; i++) {
            System.out.println("Enter player" + (i + 1) + " name:");
            team[i] = new Player(i, in.nextLine());
            for (int y = 0; y < 6; y++) {
                team[i].getPlayersCards().add(deck.getPack().get(0));
                deck.getPack().remove(0);
            }

            System.out.println("Player" + (i + 1) + "-" + team[i].getPlayerName() + " with id-" + team[i].getPlayerId() + " ");
            System.out.println("Player" + (i + 1) + "-" + team[i].getPlayerName() + " cards are:");
            for (int z = 0; z < team[i].getPlayersCards().size(); z++) {
                System.out.println(team[i].getPlayersCards().get(z).getWeightName() + "/" + team[i].getPlayersCards().get(z).getSuitName());
            }
        }
        this.trump = deck.getPack().get(0);
        deck.getPack().add(trump);
        deck.getPack().remove(0);
        System.out.println("trump is-" + this.trump.getSuitName());
        
    }

    public void firstStep() {
        
        int minTrumpWeight = 21; //hwo have trump with smallest weight
        for (int i = 0; i < this.team.length; i++) {
            for (int y = 0; y < team[i].getPlayersCards().size(); y++) {
                if (team[i].getPlayersCards().get(y).getSuit() == this.trump.getSuit()) {
                    if (minTrumpWeight > team[i].getPlayersCards().get(y).getWeight()) {
                        minTrumpWeight = team[i].getPlayersCards().get(y).getWeight();
                        playerLeadId = team[i]; // he will lead first
                        if (i != team.length - 1) {
                            playerDefId = team[i + 1];
                        } else {
                            playerDefId = team[0];
                        }
                    }
                }
            }
        }
    }

    public void step() {
        this.lead();
        this.defend();
        
        
       
     
    }

    private boolean Check(Card cardLead, Card cardCover) {

        if (cardLead.getSuit() == cardCover.getSuit() && cardLead.getSuit() != this.trump.getSuit() && cardLead.getWeight() < cardCover.getWeight()) {
            return true;
        } else if (cardLead.getSuit() != this.trump.getSuit() && cardCover.getSuit() == this.trump.getSuit()) {
            return true;
        } else if (cardLead.getSuit() == this.trump.getSuit() && cardCover.getSuit() == this.trump.getSuit()) {
            if (cardLead.getWeight() < cardCover.getWeight()) {
                return true;
            }
        }
        return false;

    }
    
    private void lead(){
        System.out.println(this.playerLeadId.getPlayerName() + " lead to " + this.playerDefId.getPlayerName() + " and choose cards number");
        this.playerLeadId.showPlayersCard();
        int input = this.in.nextInt();
        if (input<this.playerLeadId.getPlayersCards().size()){
            this.cardLead = this.playerLeadId.getPlayersCards().get(input);
            this.playerLeadId.getPlayersCards().remove(this.cardLead);
            this.table.cardToTable(this.cardLead);
            this.table.showCardsInTable();
        }
        else this.lead();
        
    }
    
    
    private void defend(){
        System.out.println(this.playerDefId.getPlayerName() + " Choose card to cover or take cards: ");
        this.playerDefId.showPlayersCard();
        System.out.println(" 33 - Take cards ");
        int input = in.nextInt();
        if (input == 33) { // Player take cards
            for (int i = 0; i < this.table.getTableCards().size(); i++) {
                this.playerDefId.getPlayersCards().add(this.table.getTableCards().get(i));
            }
            this.playerDefId.showPlayersCard();
            this.table.cleanTable();
            
        } else {
            cardCover = this.playerDefId.getPlayersCards().get(input);
            if (this.Check(this.cardLead, cardCover)==true) {
                this.table.cardToTable(cardCover);
                this.table.showCardsInTable();
            } else {
                System.out.println("Your card is wrong!");
                this.defend();
            }
        }
        
        int toadd = this.moreLeads();
        if (toadd!=333) {
            this.playerLeadId = this.team[toadd];
            this.step();
        }else{
            this.allBitted();
        }
        
        
            
        
    }
    
    private int moreLeads(){ //Who want to lead more cards
        if (this.playerDefId.getPlayersCards().isEmpty()) { // no more leads
           
           return 333;
        }
        System.out.println(" Who give more?");
       
        for (int i = 0; i<this.team.length; i++){
          if (i!=playerDefId.getPlayerId()){
              System.out.println(i+".-"+this.team[i].getPlayerName());
          }  
        }
        System.out.println("333 - Pass");
        int input = this.in.nextInt();
        return input;
     }
    
    private void allBitted(){
        this.table.cleanTable();
        System.out.println("Card is covered!");
    }

}
