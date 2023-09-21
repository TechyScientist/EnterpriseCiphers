package net.johnnyconsole.beans.enigma;

import javax.ejb.Local;

import net.johnnyconsole.algorithms.enigma.Plugboard;
import net.johnnyconsole.algorithms.enigma.Reflector;
import net.johnnyconsole.algorithms.enigma.Rotor;

@Local
public interface EnigmaSingletonLocal {
	
	public void initialize(Plugboard plugboard, Rotor left, Rotor middle, Rotor right, Reflector reflector);
	public String encipher(String message);
	public void setRotorRingPositions(String positions);
	public void setRotorPositions(String positions);
	public void saveConfiguration(String path);
	public void loadConfiguration(String path);

}
