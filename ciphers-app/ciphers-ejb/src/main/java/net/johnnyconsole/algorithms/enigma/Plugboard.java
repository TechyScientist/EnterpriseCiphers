package net.johnnyconsole.algorithms.enigma;

import java.io.Serializable;

public class Plugboard implements Serializable {

	private static final long serialVersionUID = 1L;
	private final char[] left = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
	private final char[] right = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
	
	public Plugboard(String... pairs) {
		for(String pair : pairs) {
			int a = pair.charAt(0) - 'A', b = pair.charAt(1) - 'A';
			char t = left[a];
			left[a] = left[b];
			left[b] = t;
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
