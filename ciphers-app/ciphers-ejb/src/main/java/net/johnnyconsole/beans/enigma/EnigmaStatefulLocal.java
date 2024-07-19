package net.johnnyconsole.beans.enigma;

import javax.ejb.Local;

import net.johnnyconsole.algorithms.enigma.Reflector;
import net.johnnyconsole.algorithms.enigma.Rotor;

@Local
public interface EnigmaStatefulLocal {

	void setRotors(Rotor left, Rotor middle, Rotor right);
	void setReflector(Reflector reflector);
	void setPlugboardPairs(String... pairs);
	void initialize();
	
}
