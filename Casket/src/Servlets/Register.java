package Servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class Register extends HttpServlet {
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
	
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String pass = request.getParameter("pass");
        String address = request.getParameter("address");
        String phonenumber = request.getParameter("phonenumber");
        try{
        
        
        
          
        Class.forName("oracle.jdbc.driver.OracleDriver");  
      	Connection con=DriverManager.getConnection(  
      	"jdbc:oracle:thin:@pnrtrng23:1521:xe","system","Casket");

        PreparedStatement ps=con.prepareStatement
                  ("insert into USERREG values(?,?,?,?,?)");

        ps.setString(1, name);
        ps.setString(2, pass);
        ps.setString(3, email);
        ps.setString(4, address);
        ps.setString(5, phonenumber);
        int i=ps.executeUpdate();
        
          if(i>0)
          {
            out.println("You are sucessfully registered");
          }
        
        }
        catch(Exception se)
        {
            se.printStackTrace();
        }
	
      }
  }
