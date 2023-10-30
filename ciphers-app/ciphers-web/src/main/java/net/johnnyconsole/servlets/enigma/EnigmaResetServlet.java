package net.johnnyconsole.servlets.enigma;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.johnnyconsole.beans.enigma.EnigmaSingletonRemote;

@WebServlet("/enigma/reset")
public class EnigmaResetServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@EJB
	private EnigmaSingletonRemote singleton;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
       
        try(PrintWriter out = response.getWriter()) { 
        	String path = request.getParameter("path");
        	singleton.loadConfiguration(path);
        	out.println("<b>Configuration Loaded</b> from <i>" + path + "</i>. You will be redirected to the home page in 3 seconds.");
        	response.setHeader("Refresh", "3; URL=/ciphers/enigma.html");
            
        } catch (Exception ex) {
            throw new ServletException(ex);
        }
	}
}	
