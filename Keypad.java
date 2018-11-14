/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

import static bank.Atm.input;
import static bank.Atm.inputmode;
import static bank.Atm.language;
import static bank.Atm.accountno;
import static bank.Atm.amount;
import static bank.Atm.input;
import static bank.Screeen.message;
import static bank.Atm.pin;
import static bank.Atm.txtDisplay;
/**
 *
 * @author n
 */
public class Keypad {
    Screeen s;
    Withdraw w;
    Deposit d;
    BalanceEnquiry b;
public void add(String n){
s=new Screeen();
s.add(n);

}
     public void action(){
    if(inputmode=="language"){
        
        inputmode="kiswahili";
        s=new Screeen();
        s.display();
    }
    else if(inputmode=="kiswahili"){
        inputmode="withdraw";
        language="kiswahili";
        s=new Screeen();
        s.display();
    
    }
    else if(inputmode=="english"){
        inputmode="withdraw";
        language="english";
        s=new Screeen();
        s.display();
    
    }
}
     public void checkMode(){
    if(inputmode=="account"){
       
        if(input==""){
            inputmode="account";
            s=new Screeen();
            s.display();
        
        }
    if(input!=""){
        inputmode="pin";
        accountno=Integer.parseInt(input);
        s= new Screeen();
        s.display();
       }
    }
    else if(inputmode=="pin"){
     if(input!=""){
        inputmode="language";
        pin=Integer.parseInt(input);
        Account a= new Account();
        a.login();
     }
        if(input==""){
            inputmode="pin";
            s=new Screeen();
            s.display();
        
        }
    
    }
    else if(inputmode=="withdraw"){
        amount=Integer.parseInt(input);
        w= new Withdraw();
        w.withdraw();
    }
    
    else if(inputmode=="err"){
        if (language=="kiswahili"){
        inputmode="withdraw";
        language="kiswahili";
        s=new Screeen();
        s.display();
        }
        else if(language=="english"){
        inputmode="withdraw";
        language="english";
        s=new Screeen();
        s.display();
    
    }
    }
    

}
     public void actionB(){
    if(inputmode=="language"){
        
       inputmode="english";
       s= new Screeen();
       s.display();
    }
    else if(inputmode=="english"){
        
       inputmode="deposit";
       language="english";
       s= new Screeen();
       s.display();
       d= new Deposit();
       d.deposit();
    }
    else if(inputmode=="kiswahili"){
        
       inputmode="deposit";
       language="kiswahili";
       d= new Deposit();
       d.deposit();
    }
    
    
}
     public void actionc(){
     if(inputmode=="english"){
        
       inputmode="enquiry";
       language="english";
       b= new BalanceEnquiry();
       b.enquiry();
    }
    else if(inputmode=="kiswahili"){
        
       inputmode="enquiry";
       language="kiswahili";
       b= new BalanceEnquiry();
       b.enquiry();
    }
     
     }
     
     public void back(){
     if(inputmode=="withdraw"){
     inputmode="language";
     s=new Screeen();
     s.display();
     
     }
     if(inputmode=="deposit"){
     inputmode="language";
     s=new Screeen();
     s.display();
     
     }
     if(inputmode=="balance"){
     inputmode="language";
     s=new Screeen();
     s.display();
     
     }
     if(inputmode=="pin"){
     inputmode="account";
     s=new Screeen();
     s.display();
     
     }
     
     }
     public void delete(){
         if(input!=""){
            
     input=input.substring(0,input.length()-1);
            
     txtDisplay.setText(message+input);
         }
         else if(input==""){
         
         }
     }
}
