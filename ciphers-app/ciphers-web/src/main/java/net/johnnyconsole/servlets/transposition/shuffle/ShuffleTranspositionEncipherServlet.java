package net.johnnyconsole.servlets.transposition.shuffle;

import net.johnnyconsole.beans.transposition.shuffle.ShuffleTranspositionSingleton;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/transposition/shuffle/encipher")
public class ShuffleTranspositionEncipherServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@EJB
	private ShuffleTranspositionSingleton singleton;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
       
        try(PrintWriter out = response.getWriter()) { 
        	String plaintext = request.getParameter("plaintext");
			int key = Integer.parseInt(request.getParameter("shuffle"));

        	out.println("<b>Plain Text:</b> " + plaintext.replace(" ", "") + "<br/>");
        	out.println("<b>Cipher Text:</b> " + singleton.encipher(plaintext, key));
        	out.println("<br/><a href=\"../../ciphers/ohavers.html\">Return to Home</a>");
            
        } catch (Exception ex) {
            throw new ServletException(ex);
        }
	}
}	
