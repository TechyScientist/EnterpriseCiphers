package net.johnnyconsole.algorithms.enigma;

public class Rotor {

	private final char[] left = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
	private final char[] right;
	private final char notch;
	
	public static final Rotor I = new Rotor("EKMFLGDQVZNTOWYHXUSPAIBRCJ", 'Q'),
							  II = new Rotor("AJDKSIRUXBLHWTMCQGZNPYFVOE", 'E'),
							  III = new Rotor("BDFHJLCPRTXVZNYEIWGAKMUSQO", 'V'),
							  IV = new Rotor("ESOVPZJAYQUIRHXLNFTGKDCMWB", 'J'),
							  V = new Rotor("VZBRGITYUPSDNHLXAWMJQOFECK", 'Z');
	
	public Rotor(String wiring, char notch) {
		right = wiring.toCharArray();
		//TODO: Implement Notch and Ring Settings for Rotors
		this.notch = notch;
	}
	
	private void rotate() {
		//TODO: Implement Rotation Functionality for Rotors
	}
	
	public int forward(int signal) {
		return find(left, right[signal]);
	}
	
	public int reverse(int signal) {
		return find(right, left[signal]);
	}
	
	private int find(char[] array, char key) {
		for(int i = 0; i < array.length; i++) {
			if(array[i] == key) return i;
		}
		return -1;
	}
	
}
