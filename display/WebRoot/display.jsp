<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="oracle.jdbc.*" %>
<%





Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;
%>
<h2 align="center"><font><strong>Retrieve data from database in jsp</strong></font></h2>
<table align="center" cellpadding="5" cellspacing="5" border="1">
<tr>

</tr>
<tr bgcolor="#A52A2A">
<td><b>NAME</b></td>
<td><b>Password</b></td>
<td><b>Email</b></td>
<td><b>Address</b></td>
<td><b>PhoneNumber</b></td>
</tr>
<%
try{ 
  Class.forName("oracle.jdbc.driver.OracleDriver");  
      	Connection con=DriverManager.getConnection(  
      	"jdbc:oracle:thin:@pnrtrng23:1521:xe","system","Casket");
statement=con.createStatement();
String sql ="SELECT * FROM USERREG";

resultSet = statement.executeQuery(sql);
while(resultSet.next()){
%>
<tr bgcolor="#DEB887">

<td><%=resultSet.getString("name") %></td>
<td><%=resultSet.getString("pass") %></td>
<td><%=resultSet.getString("email") %></td>
<td><%=resultSet.getString("address") %></td>
<td><%=resultSet.getString("phonenumber") %></td>

</tr>

<% 
}

} catch (Exception e) {
e.printStackTrace();
}
%>
</table>
