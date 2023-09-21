package net.johnnyconsole.algorithms.enigma;

import java.io.Serializable;

public class Reflector implements Serializable {

	private static final long serialVersionUID = 1L;
	private final char[] left = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
	private final char[] right;
	
	public static final Reflector A = new Reflector("EJMZALYXVBWFCRQUONTSPIKHGD"),
								  B = new Reflector("YRUHQSLDPXNGOKMIEBFZCWVJAT"),
								  C = new Reflector("FVPJIAOYEDRZXWGCTKUQSBNMHL");
	
	public Reflector(String wiring) {
		right = wiring.toCharArray();
	}
	
	public int reflect(int signal) {
		return find(left, right[signal]);
	}
	
	private int find(char[] array, char key) {
		for(int i = 0; i < array.length; i++) {
			if(array[i] == key) return i;
		}
		return -1;
	}
	
}
