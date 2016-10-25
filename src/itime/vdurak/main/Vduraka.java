/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itime.vdurak.main;

import itime.vduraka.classes.CardPack;
import itime.vduraka.classes.Game;
import itime.vduraka.classes.Player;

/**
 *
 * @author user
 */
public class Vduraka {
    //private Player[] team = new Player[2];
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Game myGame = new Game(2); // two players
       myGame.StartGame();
       myGame.firstStep();
       myGame.step();
      
     
      
    }
    
}
