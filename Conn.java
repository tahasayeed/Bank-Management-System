package bank.management;
import java.sql.*;
public class Conn {
    Connection c;
    Statement s;
    public Conn(){

        try{
           c= DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","Taha@12345");
           s = c.createStatement();
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
