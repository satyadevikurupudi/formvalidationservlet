package sam;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/getbyemail")
public class satya extends HttpServlet{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
  String email = req.getParameter("email");
  try {
    PrintWriter pw = resp.getWriter();
    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/student","root","Satya@22551A4261");
    String sql = "select * from login where email = ?";
    PreparedStatement pmst = conn.prepareStatement(sql);
    pmst.setString(1,email);
    ResultSet rs = pmst.executeQuery();
    while(rs.next()) {
      pw.println("id: "+rs.getInt("id"));
      pw.println("name: "+rs.getString("name"));
      pw.println("email: "+rs.getString("email"));
      pw.println("password: "+rs.getString("passsword"));
    }
  } catch (Exception e) {
    e.printStackTrace();
  }
  
}
}