/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

import static bank.Atm.inputmode;

/**
 *
 * @author n
 */
public class Deposit {
    Screeen s;
    public void deposit(){
        inputmode="deposit";
        s=new Screeen();
        s.display();
    
    }
}
