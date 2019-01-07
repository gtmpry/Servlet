import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
public class demo extends HttpServlet
{
	public PrintWriter out1;
	public void service(HttpServletRequest req,HttpServletResponse res)
	{
		try
		{
			res.setContentType("text/html");
			out1=res.getWriter();
			out1.print("Gautam");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}