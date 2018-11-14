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
import static bank.Atm.accountno;
import static bank.Atm.amount;
import static bank.Atm.btnEnter;
import static bank.Atm.btndelete;
import static bank.Atm.input;
import static bank.Atm.inputmode;
import static bank.Atm.isloggedin;
import static bank.Atm.language;
import static bank.Atm.pin;
import static bank.Atm.txt1;
import static bank.Atm.txt2;
import static bank.Atm.txtDisplay;
import static bank.Screeen.message;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author n
 */
public class Withdraw {
    Screeen s;
 public void withdraw(){
    if (amount<=40000){
try{
            Connection con;
            ResultSet rs;
            String url="jdbc:mysql://localhost:3306/atm?zeroDateTimeBehavior=convertToNull";
            String user="root";
            String pass="";
            String query="SELECT * FROM customers  where account_no=? and pin=?";
            con=DriverManager.getConnection(url, user, pass);
            PreparedStatement pst= con.prepareStatement(query) ;
           pst.setInt(1, accountno);
           pst.setInt(2, pin);
            rs=pst.executeQuery();
           while(rs.next()){
            int cash= rs.getInt("cash");
            if(amount<=cash){
            cash=cash-amount;
           String quer="update customers set cash=? where account_no=?";
           PreparedStatement ps= con.prepareStatement(quer);
             ps.setInt(1, cash);
            ps.setInt(2, accountno);
            ps.execute();
            if(language=="english"){
               message="Thank You For Banking With Us!!!\nYou have withdrawn\nAmount: ksh."+amount+"\nYour remaining balance is:\nKsh. "+cash;
            txtDisplay.setText(message);
            input="0";
            amount=Integer.parseInt(input);
            }
            if(language=="kiswahili"){
            message="Asanti kwa kubenki nasi!!!\nUmetoa\nHela: ksh."+amount+"\nSalio lako ni:\nKsh. "+cash;
            txtDisplay.setText(message);
            input="0";
            amount=Integer.parseInt(input);
            }
            txt1.setText("Collect your Ksh."+amount +" HERE!");
            txt2.setText("collect your card!!");
            
            
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
        btnEnter.setEnabled(false);
            }else if(amount>cash){
                if(language=="english"){
                    message="Sorry you have insufficient balance in your account";
            txtDisplay.setText(message);
            
                }
                if(language=="kiswahili"){
                    message="Samahani huna salio ya kutosha kuendeleza shughuli hii";
                txtDisplay.setText(message);
                
                }
            }
           } 
        }catch(SQLException e){
        e.printStackTrace();
        }catch(Exception e){
        e.printStackTrace();
        }

}
    else if(amount>40000){
        if (language=="english"){
            message="Sorry you cannot withdraw more than 40,000 according to law\n\nPress Enter to continue";
    txtDisplay.setText(message);
        inputmode="err";
        
    }
    if(language=="kiswahili"){
        message="Samahani huezi kutoa zaidi ya 40,000 kulingana na sheria\n\nFinya Enter ili kuendelea";
    txtDisplay.setText(message);
    inputmode="err";
    
    
    }
    }
 }
}

