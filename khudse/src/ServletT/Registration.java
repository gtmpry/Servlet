package ServletT;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Registration
 */
@WebServlet("/Registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PrintWriter out;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registration() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		out=response.getWriter();
		String a=request.getParameter("fname");
		String b=request.getParameter("lname");
		String c=request.getParameter("email");
		String d=request.getParameter("password");
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","priya","Gautam");
			PreparedStatement ps=con.prepareStatement("insert into Login values(?,?,?,?)");
			ps.setString(1, c);
			ps.setString(2, d);
			ps.setString(3, a);
			ps.setString(4, b);
			
			ps.executeUpdate();
			out.write("Success");
		}catch(Exception e)
		{
			System.out.println(e);
		}
		
	}

	

}
