/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

import static bank.Atm.accountno;
import static bank.Atm.inputmode;
import static bank.Atm.isloggedin;
import static bank.Atm.language;
import static bank.Atm.pin;
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
public class BalanceEnquiry {
   public void enquiry(){
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
            int account= rs.getInt("account_no");
            int cash= rs.getInt("cash");
            String nam1= rs.getString("firstname");
            String nam2= rs.getString("lastname");
            String nam3= nam1+" "+nam2;
            inputmode="balance";
            if (language=="english"){
            txtDisplay.setText("Dear "+nam3+"\nAccount no:"+account+"\n your balance is ksh. "+cash);
    
            }
            if (language=="kiswahili"){
            txtDisplay.setText("Jambo "+nam3+"\nAccount no:"+account+"\n salio lako ni ksh. "+cash);
            
            }
                
                
           } 
        }catch(SQLException e){
        e.printStackTrace();
        }
        
   
   } 
}
