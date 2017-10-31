package hb.web.ui;

import java.io.IOException;
import java.security.Principal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import com.ibm.ws.security.authentication.principals.WSPrincipal;

@WebServlet(name="HBServlet", loadOnStartup=1, urlPatterns= {"/test/*"})
public class HBServlet extends javax.servlet.http.HttpServlet
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6113278719254186970L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
	
		Principal user=req.getUserPrincipal();
		
		System.out.println("USER: "+user.toString()+"-"+user.getClass().getName());

		
	}

}
