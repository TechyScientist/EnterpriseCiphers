package net.johnnyconsole.test.enigma;

import static net.johnnyconsole.algorithms.enigma.Reflector.*;
import static net.johnnyconsole.algorithms.enigma.Rotor.*;

import java.util.Scanner;

import net.johnnyconsole.algorithms.enigma.Enigma;
import net.johnnyconsole.algorithms.enigma.Plugboard;
import net.johnnyconsole.algorithms.enigma.Reflector;
import net.johnnyconsole.algorithms.enigma.Rotor;

public class TestEnigma {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String l, m, r, rf, pairs[] = new String[10], rings, rotors, plaintext, ciphertext;
		
		System.out.print("Select LEFT rotor (I, II, III, IV or V): ");
		l = scanner.nextLine().toUpperCase();
		System.out.print("Select MIDDLE rotor (I, II, III, IV or V): ");
		m = scanner.nextLine().toUpperCase();
		System.out.print("Select RIGHT rotor (I, II, III, IV or V): ");
		r = scanner.nextLine().toUpperCase();
		System.out.print("Select Reflector (A, B, C): ");
		rf = scanner.nextLine().toUpperCase();
		
		for (int i = 0; i < pairs.length; i++) {
			System.out.print("Enter Plugboard Pair " + (i + 1) + "/10 (AB to swap A and B): ");
			pairs[i] = scanner.nextLine().toUpperCase();
		}
		
		System.out.print("Enter Ring Position String (AAA is default): ");
		rings = scanner.nextLine().toUpperCase();
		System.out.print("Enter Rotor Starting Positions (AAA is default): ");
		rotors = scanner.nextLine().toUpperCase();
		System.out.print("Enter Plain Text to Encipher: ");
		plaintext = scanner.nextLine().toUpperCase();
		scanner.close();
		
		Plugboard p = new Plugboard(pairs);
		Rotor r1 = getRotorObject(l), r2 = getRotorObject(m), r3 = getRotorObject(r);
		Reflector ref = getReflectorObject(rf);
		Enigma enigma = new Enigma(p, r1, r2, r3, ref);
		enigma.setRingPositions(rings);
		enigma.setRotorPositions(rotors);
		
		ciphertext = enigma.encipher(plaintext);
		
		System.out.println("Enigma Results:");
		System.out.print("\tPlugboard: ");
		
		for(int i = 0; i < pairs.length; i++) {
			if(i != pairs.length - 1) {
				System.out.println(pairs[i]);
			}
			else {
				System.out.print(pairs[i] + " ");
			}
		}
		System.out.println("\tRotors: " + r1 + "-" + r2 + "-" + r3);
		System.out.println("\tReflector: " + rf);
		System.out.println("\tRing Settings: " + rings);
		System.out.println("\tRotor Positions: " + rotors);
		System.out.println("\tPlain Text: " + plaintext);
		System.out.println("\tEnciphered Text: " + ciphertext);
		
		
	}

	private static Rotor getRotorObject(String s) {
		switch(s) {
			case "I": return I;
			case "II": return II;
			case "III": return III;
			case "IV": return IV;
			case "V": return V;
			default: throw new IllegalArgumentException("Invalid Rotor: " + s);
		}
	}
	
	private static Reflector getReflectorObject(String s) {
		switch(s) {
			case "A": return A;
			case "B": return B;
			case "C": return C;
			default: throw new IllegalArgumentException("Invalid Reflector: " + s);
		}
	}
	
}
