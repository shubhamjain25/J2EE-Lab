import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
public class tcon extends HttpServlet {
private static final long serialVersionUID = 1L;

public tcon() {
 super();
}
protected void service(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
response.setContentType("text/html");
PrintWriter out=response.getWriter();
String[] Accessories={};
Accessories=request.getParameterValues("access");
String tshirtAccessories="";
String tshirtTagLine=request.getParameter("tagline");
String tshirtOption=request.getParameter("pocket");
String tcolor=request.getParameter("Tshirtcolor");
out.println("<html>");
out.println("<head><title>T-shirt</title></head>");
out.println("<body>");
try {
 Statement stmt;
 Class.forName("com.mysql.jdbc.Driver");
 Connection conn =
DriverManager.getConnection("jdbc:mysql://localhost:3306/db1?useSSL=false", "root", "root");
 if (conn != null) {
 stmt= conn.createStatement();
 String qu;
 if(tshirtAccessories!=null && tshirtTagLine!=null &&
tshirtOption!=null && tcolor!=null){
 for(String option:Accessories){
 tshirtAccessories=tshirtAccessories+option;
 }
 qu="insert into Tshirts values("+null+",'"+tshirtTagLine+"','"+tshirtAccessories+"','"+tcolor+"','"+tshirtOption+"');";
 stmt.executeUpdate(qu);
 }
 qu="select * from Tshirts;";
 ResultSet rs =stmt.executeQuery(qu);
 out.println("<table border=2>");
 out.println("<tr>");
 out.print("<td>OrderNo</td>");
 out.print("<td>T-shirt Accessories</td>");
 out.print("<td>T-shirt tag-line</td>");
 out.print("<td>T-shirt type</td>");
 out.print("<td>T-shirt color</td>");
 out.println("</tr>");
 if(!rs.isBeforeFirst()){
 out.print("<tr>");
out.print("<td>100</td>");
out.print("<td>NULL</td>");
out.print("<td>NULL</td>");
out.print("<td>NULL</td>");
out.print("<td>NULL</td>");
out.print("<td>NULL</td>");
out.println("</tr>");
 }
 while(rs.next()){
 out.println("<tr>");

out.print("<td>"+(Integer.parseInt(rs.getString("OrderNo"))+100)+"</td>");
 out.print("<td>"+rs.getString("tshritAccessories")+"</td>");
 out.print("<td>"+rs.getString("tshritTagLine")+"</td>");
 out.print("<td>"+rs.getString("tcolor")+"</td>");
 out.print("<td>"+rs.getString("tshritOption")+"</td>");
 out.println("</tr>");
 }
 out.println("</table>");
 out.println("<a href=\"tshrit.jsp\">click here</a>");
 out.println("</body></html>");
 }
}
catch (Exception e){
e.printStackTrace();
}
}
}
