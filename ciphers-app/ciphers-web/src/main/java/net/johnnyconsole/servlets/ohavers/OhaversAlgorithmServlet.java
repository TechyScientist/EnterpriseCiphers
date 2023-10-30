package net.johnnyconsole.servlets.ohavers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.johnnyconsole.beans.ohavers.OhaversAlgorithmSingleton;

@WebServlet("/ohavers/encrypt")
public class OhaversAlgorithmServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@EJB
	private OhaversAlgorithmSingleton singleton;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
       
        try(PrintWriter out = response.getWriter()) { 
        	String message = request.getParameter("message").toUpperCase();
        	out.println("<b>Plain Text:</b> " + message.replace(" ", "_") + "<br/>");
        	out.println("<b>Cipher Text:</b> " + singleton.encipher(message));
        	out.println("<br/><a href=\"/ciphers/ohavers.html\">Return to Home</a>");
            
        } catch (Exception ex) {
            throw new ServletException(ex);
        }
	}
}	
