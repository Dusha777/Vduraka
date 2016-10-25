/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itime.vduraka.interfaces;

/**
 *
 * @author Andrei_Fofilov
 */
public interface ICardPack {
    
    void mixCardPack(int precision);
    void dealCards();
    void addCards();
    void addPlayOffCards();
    
}
