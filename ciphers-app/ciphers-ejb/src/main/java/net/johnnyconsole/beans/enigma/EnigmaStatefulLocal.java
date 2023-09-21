package net.johnnyconsole.beans.enigma;

import javax.ejb.Local;

import net.johnnyconsole.algorithms.enigma.Reflector;
import net.johnnyconsole.algorithms.enigma.Rotor;

@Local
public interface EnigmaStatefulLocal {

	public void setRotors(Rotor left, Rotor middle, Rotor right);
	public void setReflector(Reflector reflector);
	public void setPlugboardPairs(String... pairs);
	public void initialize();
	
}
