/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

import static bank.Atm.btn0;
import static bank.Atm.btn1;
import static bank.Atm.btn2;
import static bank.Atm.btn3;
import static bank.Atm.btn4;
import static bank.Atm.btn5;
import static bank.Atm.btn6;
import static bank.Atm.btn7;
import static bank.Atm.btn8;
import static bank.Atm.btn9;
import static bank.Atm.btnc;
import static bank.Atm.btnd;
import static bank.Atm.btndelete;
import static bank.Atm.btne;
import static bank.Atm.btnf;
import static bank.Atm.input;
import static bank.Atm.inputmode;
import static bank.Atm.language;
import static bank.Atm.lbl;

import static bank.Atm.txtDisplay;

/**
 *
 * @author n
 */
public class Screeen {
    public static String message="";
    String out="";
    public void display(){
    if (inputmode=="language"){
        message="choose language\nA. Kiswahili \nB. English";
        txtDisplay.setText(message);
        btnc.setVisible(false);
        btnd.setVisible(false);
        btne.setVisible(false);
        btnf.setVisible(false);
        btn1.setEnabled(false);
        btn2.setEnabled(false);
        btn3.setEnabled(false);
        btn4.setEnabled(false);
        btn5.setEnabled(false);
        btn6.setEnabled(false);
        btn7.setEnabled(false);
        btn8.setEnabled(false);
        btn9.setEnabled(false);
        btn0.setEnabled(false);
        btndelete.setEnabled(false);
    }
    else if (inputmode=="pin"){
        input="";
        message="enter pin \n>";
        txtDisplay.setText(message);
        lbl.setVisible(false);
        
    }
    else if(inputmode=="kiswahili"){
        message="A. Toa \nB. Weka \nC. Kuangalia Salio ";
        txtDisplay.setText(message);
        btnc.setVisible(true);
        btnd.setVisible(true);
        btne.setVisible(true);
        btnf.setVisible(true);
         btn1.setEnabled(false);
        btn2.setEnabled(false);
        btn3.setEnabled(false);
        btn4.setEnabled(false);
        btn5.setEnabled(false);
        btn6.setEnabled(false);
        btn7.setEnabled(false);
        btn8.setEnabled(false);
        btn9.setEnabled(false);
        btn0.setEnabled(false);
        btndelete.setEnabled(false);
    
    }
    else if(inputmode=="english"){
        message="A. Withdraw \nB. Deposit \nC. Balance Enquiry ";
        txtDisplay.setText(message);
        btnc.setVisible(true);
        btnd.setVisible(true);
        btne.setVisible(true);
        btnf.setVisible(true);
         btn1.setEnabled(false);
        btn2.setEnabled(false);
        btn3.setEnabled(false);
        btn4.setEnabled(false);
        btn5.setEnabled(false);
        btn6.setEnabled(false);
        btn7.setEnabled(false);
        btn8.setEnabled(false);
        btn9.setEnabled(false);
        btn0.setEnabled(false);
        btndelete.setEnabled(false);
    
    }
    else if(inputmode=="withdraw"){
        if (language=="english"){
            input="";
            message="Insert amount to withdraw \n> ";
        txtDisplay.setText(message);
         btn1.setEnabled(true);
        btn2.setEnabled(true);
        btn3.setEnabled(true);
        btn4.setEnabled(true);
        btn5.setEnabled(true);
        btn6.setEnabled(true);
        btn7.setEnabled(true);
        btn8.setEnabled(true);
        btn9.setEnabled(true);
        btn0.setEnabled(true);
        btndelete.setEnabled(true);
        }
        if(language=="kiswahili"){
            input="";
            message="Weka kiasi cha pesa ya kutoa \n> ";
        txtDisplay.setText(message);
         btn1.setEnabled(true);
        btn2.setEnabled(true);
        btn3.setEnabled(true);
        btn4.setEnabled(true);
        btn5.setEnabled(true);
        btn6.setEnabled(true);
        btn7.setEnabled(true);
        btn8.setEnabled(true);
        btn9.setEnabled(true);
        btn0.setEnabled(true);
        btndelete.setEnabled(true);
        }
    
    }
    else if(inputmode=="deposit"){
        if (language=="english"){
            input="";
            message="Sorry you cannot Deposit at the moment \n Visit our Tellers to deposit or for further info \n ERROR: Deposit slot missing ";
        txtDisplay.setText(message);
         btn1.setEnabled(false);
        btn2.setEnabled(false);
        btn3.setEnabled(false);
        btn4.setEnabled(false);
        btn5.setEnabled(false);
        btn6.setEnabled(false);
        btn7.setEnabled(false);
        btn8.setEnabled(false);
        btn9.setEnabled(false);
        btn0.setEnabled(false);
        btndelete.setEnabled(false);
        }
        if(language=="kiswahili"){
            input="";
            message="Samahani huez kuweka pesa kwa muda huu\n Tembelea wahudumu wetu kuweka pesa au kupata ujumbe zaidi \n ERROR: Deposit slot missing  ";
        txtDisplay.setText(message);
         btn1.setEnabled(false);
        btn2.setEnabled(false);
        btn3.setEnabled(false);
        btn4.setEnabled(false);
        btn5.setEnabled(false);
        btn6.setEnabled(false);
        btn7.setEnabled(false);
        btn8.setEnabled(false);
        btn9.setEnabled(false);
        btn0.setEnabled(false);
        btndelete.setEnabled(false);
        }
    
    }
    
    else if(inputmode=="account"){
        
        message="welcome to Denis Bank Limited \nEnter account number\n>";
        txtDisplay.setText(message);
        btn1.setEnabled(true);
        btn2.setEnabled(true);
        btn3.setEnabled(true);
        btn4.setEnabled(true);
        btn5.setEnabled(true);
        btn6.setEnabled(true);
        btn7.setEnabled(true);
        btn8.setEnabled(true);
        btn9.setEnabled(true);
        btn0.setEnabled(true);
        btndelete.setEnabled(true);
    }


}
    public void add(String n){
input=input+n;
if(inputmode=="pin"){
    for(int i=0;i<input.length();i++){
        out=out+"*";
      txtDisplay.setText(message+out);
    }
        }else{
txtDisplay.setText(message+input);
}
}
}
