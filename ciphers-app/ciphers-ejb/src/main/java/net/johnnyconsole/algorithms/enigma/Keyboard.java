package net.johnnyconsole.algorithms.enigma;

public class Keyboard {

	public int forward(char letter) {
		return letter - 'A';
	}
	
	public char backward(int signal) {
		return (char)(signal + 'A');
	}
	
}
