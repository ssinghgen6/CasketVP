package DBConnection;

import java.sql.*;
import java.util.*;


public class ConnectionManager {

   static Connection con ;
   static String url;
         
   public static Connection getConnection() throws SQLException
   {
     
      try
      {
    	  
    	  Class.forName("oracle.jdbc.driver.OracleDriver");  
          con = DriverManager.getConnection(  
        	"jdbc:oracle:thin:@pnrtrng23:1521:xe","system","Casket");
    	 
        
      }

      catch(ClassNotFoundException e)
      {
         System.out.println(e);
      }

   return con;
}
}