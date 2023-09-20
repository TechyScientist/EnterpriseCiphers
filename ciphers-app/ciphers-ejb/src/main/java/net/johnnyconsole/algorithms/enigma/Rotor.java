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
		char l = left[0], r = right[0];
		
		for(int i = 0; i < left.length - 1; i++) {
			left[i] = left[i + 1];
			right[i] = right[i + 1];
		}
		left[left.length - 1] = l;
		right[right.length - 1] = r;
	}
	
	public void rotateTo(char letter) {
		while(right[0] != letter) {
			rotate();
		}
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
