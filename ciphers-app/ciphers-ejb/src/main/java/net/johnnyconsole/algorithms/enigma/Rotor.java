package net.johnnyconsole.algorithms.enigma;

import java.io.Serializable;

public class Rotor implements Serializable {

	private static final long serialVersionUID = 1L;
	private final char[] left = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
	private final char[] right;
	private char notch;
	
	public static final Rotor I = new Rotor("EKMFLGDQVZNTOWYHXUSPAIBRCJ", 'Q'),
							  II = new Rotor("AJDKSIRUXBLHWTMCQGZNPYFVOE", 'E'),
							  III = new Rotor("BDFHJLCPRTXVZNYEIWGAKMUSQO", 'V'),
							  IV = new Rotor("ESOVPZJAYQUIRHXLNFTGKDCMWB", 'J'),
							  V = new Rotor("VZBRGITYUPSDNHLXAWMJQOFECK", 'Z');
	
	public Rotor(String wiring, char notch) {
		right = wiring.toCharArray();
		this.notch = notch;
	}
	
	protected void rotate() {
		char l = left[0], r = right[0];
		
		for(int i = 0; i < left.length - 1; i++) {
			left[i] = left[i + 1];
			right[i] = right[i + 1];
		}
		left[left.length - 1] = l;
		right[right.length - 1] = r;
	}
	
	private void reverseRotate(int n) {
		while(n-- > 0) {
			char l = left[25], r = right[25];
			
			for(int i = left.length - 1; i > 0; i--) {
				left[i] = left[i - 1];
				right[i] = right[i - 1];
			}
			left[0] = l;
			right[0] = r;
		}
	}
	
	protected boolean isOnNotch() {
		return left[0] == notch;
	}
	
	public void rotateTo(char letter) {
		for(int i = 0; i < letter - 'A'; i++) {
			rotate();
		}
	}
	
	public int forward(int signal) {
		return find(left, right[signal]);
	}
	
	public int reverse(int signal) {
		return find(right, left[signal]);
	}
	
	protected void setRingPosition(char position) {
		int n = position - 'A', nNotch = notch - 'A';
		reverseRotate(n);
		notch = (char)(Math.abs((nNotch - n) % 26) + 'A');
		
	}
	
	private int find(char[] array, char key) {
		for(int i = 0; i < array.length; i++) {
			if(array[i] == key) return i;
		}
		return -1;
	}
	
}
