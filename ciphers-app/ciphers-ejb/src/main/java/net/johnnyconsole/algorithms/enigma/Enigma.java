package net.johnnyconsole.algorithms.enigma;

public class Enigma {

	private final Keyboard keyboard = new Keyboard();
	private final Plugboard plugboard;
	private final Rotor left, middle, right;
	private final Reflector reflector;
	
	public Enigma(Plugboard plugboard, Rotor left, Rotor middle, Rotor right, Reflector reflector) {
		this.plugboard = plugboard;
		this.left = left;
		this.middle = middle;
		this.right = right;
		this.reflector = reflector;
	}
	
	public char encipher(char letter) {
		if(!Character.isAlphabetic(letter)) return letter;
		if(middle.isOnNotch() && right.isOnNotch()) {
			left.rotate();
			middle.rotate();
			right.rotate();
		}
		else if(middle.isOnNotch()) {	//Double Step Anomaly
			left.rotate();
			middle.rotate();
			right.rotate();
		}
		else if(right.isOnNotch()) {
			middle.rotate();
			right.rotate();
		}
		else {
			right.rotate();
		}
		int signal = keyboard.forward(Character.toUpperCase(letter));
		signal = plugboard.forward(signal);
		signal = right.forward(signal);
		signal = middle.forward(signal);
		signal = left.forward(signal);
		signal = reflector.reflect(signal);
		signal = left.reverse(signal);
		signal = middle.reverse(signal);
		signal = right.reverse(signal);
		signal = plugboard.reverse(signal);
		return keyboard.reverse(signal);
		
	}
	
	public String encipher(String string) {
		StringBuilder ciphertext = new StringBuilder();
		for(char c : string.toCharArray()) {
			ciphertext.append(encipher(c));
		}
		
		return ciphertext.toString();
	}
	
	public void setRotorPositions(String positions) {
		left.rotateTo(positions.charAt(0));
		middle.rotateTo(positions.charAt(1));
		right.rotateTo(positions.charAt(2));
	}
	
	public void setRingPositions(String positions) {
		left.setRingPosition(positions.charAt(0));
		middle.setRingPosition(positions.charAt(1));
		right.setRingPosition(positions.charAt(2));
	}
	
}
