package net.johnnyconsole.servlets.transposition.shuffle;

import net.johnnyconsole.beans.transposition.shuffle.ShuffleTranspositionSingletonLocal;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/transposition/shuffle/decipher")
public class ShuffleTranspositionEncipherServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@EJB
	private ShuffleTranspositionSingletonLocal singleton;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
       
        try(PrintWriter out = response.getWriter()) { 
        	String ciphertext = request.getParameter("ciphertext").toUpperCase().replace(" ", "");
			int key = Integer.parseInt(request.getParameter("shuffle"));

        	out.println("<b>Cipher Text:</b> " + ciphertext + "<br/>");
        	out.println("<b>Plain Text:</b> " + singleton.decipher(ciphertext, key));
        	out.println("<br/><a href=\"../../ciphers/shuffle.html\">Return to Home</a>");
            
        } catch (Exception ex) {
            throw new ServletException(ex);
        }
	}
}	
