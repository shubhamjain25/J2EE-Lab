import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.sql.*;
import java.io.*;

// The header files might vary in your system. Genereally, instead of jakartax they will be javax.
// However, you need not worry as these get created automatically when you create a servlet file in Eclipse.


public class TshirtSale extends HttpServlet{

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        
        // To output things to servlet file in html format
        PrintWriter out = response.getWriter();
        
        out.println("<html>");
        out.println("<body>");
        
        try{
            Connection conn = null;
            
            Class.forName("com.mysql.cj.jdbc.Driver");  
            String url = "jdbc:mysql://localhost:3306/db1?useSSL=false";
            String user = "root";
            String pass = "root";
         
            conn = DriverManager.getConnection(url, user, pass);
            System.out.println("Connection Established");
            
            String[] accessoryList = request.getParameterValues("accessories");
            String tagLine = request.getParameter("tagLine");
            String pocket = request.getParameter("pocket");
            String color = request.getParameter("color");
            String acc="";
            
            for(String a:accessoryList){
                acc+=a+"";
            }
            
            Statement stmt = conn.createStatement();
            
            String rowQuery = "select count(*) from tshirt";
            ResultSet rs1 = stmt.executeQuery(rowQuery);
            rs1.next();
            int count = rs1.getInt(1);
            int oid = count+1;
            
            String insertQuery = "insert into tshirt values("+oid+", '"+tagLine+"', '"+acc+"', '"+color+"', '"+pocket+"')";
            
            stmt.executeUpdate(insertQuery);
            
            out.println("<table>");
            out.println("<tr>");
            out.println("<td>OrderNo:</td>");
            out.println("<td>tagLine</td>");
            out.println("<td>accessoriesTshirt</td>");
            out.println("<td>color</td>");
            out.println("<td>tshirtOption</td>");
            out.println("</tr>");
            
            String getQuery = "select * from tshirt";
            ResultSet rs = stmt.executeQuery(getQuery);
                        
            while(rs.next()){
                
                out.println("<tr>");
                out.print("<td>"+rs.getInt("OrderN")+"</td>");
                out.print("<td>"+rs.getString("tagLineTshirt")+"</td>");
                out.print("<td>"+rs.getString("accessoriesTshirt")+"</td>");
                out.print("<td>"+rs.getString("tcolor")+"</td>");
                out.print("<td>"+rs.getString("tshirtOption")+"</td>");
                out.println("</tr>");
                
            }
            
            out.println("</table>");

        }
        catch(Exception e){
            System.out.println(e);
        }
        
        out.println("<a href=\"\">Go Back</a>");
        out.println("</body>");
        out.println("</html>");
        
    }

}