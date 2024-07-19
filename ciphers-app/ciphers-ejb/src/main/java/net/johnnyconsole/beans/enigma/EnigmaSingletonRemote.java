package net.johnnyconsole.beans.enigma;

import javax.ejb.Remote;

import net.johnnyconsole.algorithms.enigma.Plugboard;
import net.johnnyconsole.algorithms.enigma.Reflector;
import net.johnnyconsole.algorithms.enigma.Rotor;

@Remote
public interface EnigmaSingletonRemote {
	
	void initialize(Plugboard plugboard, Rotor left, Rotor middle, Rotor right, Reflector reflector);
	String encipher(String message);
	void setRotorRingPositions(String positions);
	void setRotorPositions(String positions);
	void saveConfiguration(String path);
	void loadConfiguration(String path);
	
}
