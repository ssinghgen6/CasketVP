package BeanDAOFile;

import java.text.*;
import java.util.*;
import java.sql.*;

import DBConnection.ConnectionManager;

public class UserDAO {
	static Connection con = null;
	static ResultSet rs = null;

	public static UserBean login(UserBean bean) {

		// preparing some objects for connection
		Statement stmt = null;

		String name = bean.getName();
		String pass = bean.getPass();

	
		
	      String searchQuery =
              "select * from userreg where name='"
                       + name
                       + "' AND pass='"
                       + pass
                       + "'";

		// "System.out.println" prints in the console; Normally used to trace
		// the process
		System.out.println("Your user name is " + name);
		System.out.println("Your password is " + pass);
		System.out.println("Query: " + searchQuery);

		try {
			// connect to DB
			con = ConnectionManager.getConnection();
			System.out.println("hahahahaha");
			stmt = con.createStatement();
			System.out.println("xyz");
			rs = stmt.executeQuery(searchQuery);

			
			boolean more = rs.next();

			// if user does not exist set the isValid variable to false
			if (!more) {
				System.out.println("Sorry");
				bean.setValid(false);
			}

			// if user exists set the isValid variable to true
			else if (more) {
				String email = rs.getString("email");

				System.out.println("Welcome " + name);

				bean.setValid(true);
			} else {
				System.out.println("inside else");
			}

		}

		catch (Exception ex) {
			System.out.println("Log In failed: An Exception has occurred! "
					+ ex);
		}

		// some exception handling
		finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
				}
				rs = null;
			}

			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {
				}
				stmt = null;
			}

			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
				}

				con = null;
			}
		}

		return bean;

	}
}