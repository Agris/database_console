
package database_console;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class DBConnect {

  
    public static void main(String[] args) {
    try {
       
    String host = "jdbc:derby://localhost:1527/DF";
    String uName = "dfadmin";
    String uPass = "dfadmin";
    Connection con = DriverManager.getConnection(host, uName, uPass);
      
    Statement stmt = con.createStatement( );
    String SQL = "select * from DFADMIN.PAMATS";
    ResultSet rs = stmt.executeQuery(SQL);
    
    while (rs.next( )){
    int id_col = rs.getInt("ID");
    String item = rs.getString("ITEM");
    String price = rs.getString("PRICE");
    String quan = rs.getString("QUANTITY");
    String dat = rs.getString("DATUMS");

    String p = id_col + " " + item + " " + price + " " + quan + " " + dat;
    System.out.println(p);
    }
    }
    catch (SQLException err){
        System.out.println(err.getMessage());
    }
    }
}
