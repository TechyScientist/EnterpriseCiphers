package net.johnnyconsole.servlets.enigma;

import static net.johnnyconsole.algorithms.enigma.Reflector.*;
import static net.johnnyconsole.algorithms.enigma.Rotor.*;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.johnnyconsole.algorithms.enigma.Reflector;
import net.johnnyconsole.algorithms.enigma.Rotor;
import net.johnnyconsole.beans.enigma.EnigmaSingletonRemote;
import net.johnnyconsole.beans.enigma.EnigmaStatefulRemote;

@WebServlet("/enigma/initialize")
public class InitializeEnigmaServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@EJB
	private EnigmaSingletonRemote singleton;
	
	@EJB
	private EnigmaStatefulRemote stateful;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
       
        try(PrintWriter out = response.getWriter()) {
        	String sLeft = request.getParameter("rotor-left"), sMiddle = request.getParameter("rotor-middle"), sRight = request.getParameter("rotor-right");
        	String sReflector = request.getParameter("reflector");
        	String[] pairs = new String[10];
        	for(int i = 0; i < 10; i++) {
        		pairs[i] = request.getParameter("plugboard" + (i + 1)).toUpperCase();
        	}
        	String sLeftR = request.getParameter("ring-left"), sMiddleR = request.getParameter("ring-middle"), sRightR = request.getParameter("ring-right");
        	String sLeftP = request.getParameter("position-left"), sMiddleP = request.getParameter("position-middle"), sRightP = request.getParameter("position-right");
        	
        	Rotor left = getRotorObject(sLeft), middle = getRotorObject(sMiddle), right = getRotorObject(sRight);
        	Reflector reflector = getReflectorObject(sReflector);
        	
        	stateful.setRotors(left, middle, right);
        	stateful.setReflector(reflector);
        	stateful.setPlugboardPairs(pairs);
        	stateful.initialize();
        	singleton.setRotorRingPositions(sLeftR + sMiddleR + sRightR);
        	singleton.setRotorPositions(sLeftP + sMiddleP + sRightP);
        	singleton.saveConfiguration(request.getParameter("path"));
        	
        	out.println("<b>Enigma Initialized.</b> You will be redirected to the home page in 3 seconds.");
        	response.setHeader("Refresh", "3; URL=../../ciphers/enigma.html");
            
        } catch (Exception ex) {
            throw new ServletException(ex);
        }
	}
	
	private Rotor getRotorObject(String s) {
		switch(s) {
			case "I": return I;
			case "II": return II;
			case "III": return III;
			case "IV": return IV;
			case "V": return V;
			default: throw new IllegalArgumentException("Invalid Rotor: " + s);
		}
	}
	
	private Reflector getReflectorObject(String s) {
		switch(s) {
			case "A": return A;
			case "B": return B;
			case "C": return C;
			default: throw new IllegalArgumentException("Invalid Reflector: " + s);
		}
	}

}	
