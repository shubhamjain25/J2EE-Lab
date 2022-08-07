import java.io.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class ITDetails extends HttpServlet {
    
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
    
        PrintWriter out = response.getWriter();
//        out.println("<h1>Inside servlet</h1>");
        
        String name = request.getParameter("name");
        String gender = request.getParameter("gender");
        String salary = request.getParameter("salary");
        String deduction = request.getParameter("deduction");
        
        String finalMessage = "\n"+"Hey! "+name+" "+gender+" "+salary+" "+deduction+"\n";
                
        File file = new File("/temp1.txt");
        file.createNewFile();
        
        FileOutputStream fout = new FileOutputStream(file, true);
        fout.write(finalMessage.getBytes());
        fout.close();
        out.println("<h3>"+finalMessage+"</h3>");
        
    }
    
}