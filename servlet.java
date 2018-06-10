import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns = {"/a"})
public class a extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException, InterruptedException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection c;
            c = DriverManager.getConnection("jdbc:mysql://sql7.freemysqlhosting.net/sql7236208", "sql7236208",  "R5kkHabXDs");
            Statement s = c.createStatement();         
            String gname = request.getParameter("gname");
            String name = request.getParameter("name");
            String phone = request.getParameter("phone");
            String pref = request.getParameter("abc");
            String address = request.getParameter("address");
            String school = request.getParameter("school");
            String clas = request.getParameter("class");    
            PreparedStatement ps = c.prepareStatement("insert into student (Guardian_name, Student_name, Mobile, Preference, Address, School, Class)values (?, ?, ?, ?, ?, ?, ?)");      
            ps.setString(1, gname);
            ps.setString(2, name);
            ps.setString(3, phone);
            ps.setString(4, pref);
            ps.setString(5, address);
            ps.setString(6, school);
            ps.setString(7, clas); 
            ps.executeUpdate();    
            response.sendRedirect("thankyou.html");
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(a.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(a.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(a.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(a.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}