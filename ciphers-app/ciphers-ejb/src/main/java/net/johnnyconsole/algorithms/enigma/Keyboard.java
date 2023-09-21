package net.johnnyconsole.algorithms.enigma;

import java.io.Serializable;

public class Keyboard implements Serializable {

	private static final long serialVersionUID = 1L;

	public int forward(char letter) {
		return letter - 'A';
	}
	
	public char reverse(int signal) {
		return (char)(signal + 'A');
	}
	
}
