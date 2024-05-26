package net.johnnyconsole.servlets.bit_shift;

import net.johnnyconsole.beans.bit_shift.BitShiftSingleton;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/bit-shift/encipher")
public class BitShiftServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@EJB
	private BitShiftSingleton singleton;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
       
        try(PrintWriter out = response.getWriter()) { 
        	String mode = request.getParameter("mode"),
					message = request.getParameter("message").toUpperCase();
			int cipherKey = Integer.parseInt(request.getParameter("key").toUpperCase());
			boolean left = true;

			if(mode.equals("left")) {
				out.println("<b>Enciphering</b> Shift: Left<br/>");
				out.println("<b>Deciphering</b> Shift: Right<br/>");
			}
			else {
				left = false;
				out.println("<b>Enciphering</b> Shift: Right<br/>");
				out.println("<b>Deciphering</b> Shift: Left<br/>");
			}
			out.println("<b>Cipher Key:</b> " + cipherKey + "<br/>");
			out.println("<b>Plain Text:</b> " + message + "<br/>");
			out.println("<b>Cipher Text:</b> " + singleton.encipher(message, left, cipherKey));
        	out.println("<br/><a href=\"/ciphers/bit-shift.html\">Return to Home</a>");
            
        } catch (Exception ex) {
            throw new ServletException(ex);
        }
	}
}	
