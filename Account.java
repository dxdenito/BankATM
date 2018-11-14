/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;
import static bank.Atm.pin;
import static bank.Atm.accountno;
import static bank.Atm.input;
import static bank.Atm.inputmode;
import static bank.Atm.isloggedin;
import static bank.Atm.lbl;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author n
 */
public class Account {
    Screeen s;
    public void login() {
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
           if(rs.next()){
            int account= rs.getInt("account_no");
            int password= rs.getInt("pin");
            isloggedin=true;
            s= new Screeen();
            s.display();
           } else{
           inputmode="account";
           
           s=new Screeen();
           s.display();
           
           lbl.setVisible(true);
           lbl.setText("Wrong Account no or pin please try again!!");
           
           }
        }catch(SQLException e){
        e.printStackTrace();
        }
        
        
    
    }
    
}
