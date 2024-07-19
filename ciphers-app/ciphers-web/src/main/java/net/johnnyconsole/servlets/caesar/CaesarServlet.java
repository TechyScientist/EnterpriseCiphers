package net.johnnyconsole.servlets.caesar;

import net.johnnyconsole.beans.caesar.CaesarSingleton;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/caesar/encipher")
public class CaesarServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@EJB
	private CaesarSingleton singleton;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
       
        try(PrintWriter out = response.getWriter()) { 
        	String mode = request.getParameter("mode"),
					message = request.getParameter("message").toUpperCase(),
					cipherKey = request.getParameter("key").toUpperCase();

			out.println("<b>Cipher Key:</b> " + cipherKey + "<br/>");
			if(mode.equals("Enciphering")) {
				out.println("<b>Plain Text:</b> " + message + "<br/>");
				out.println("<b>Cipher Text:</b> " + singleton.encipher(message, cipherKey));
			}
			else {
				out.println("<b>Cipher Text:</b> " + message + "<br/>");
				out.println("<b>Plain Text:</b> " + singleton.decipher(message, cipherKey));
			}
        	out.println("<br/><a href=\"/ciphers/caesar.html\">Return to Home</a>");
            
        } catch (Exception ex) {
            throw new ServletException(ex);
        }
	}
}	
