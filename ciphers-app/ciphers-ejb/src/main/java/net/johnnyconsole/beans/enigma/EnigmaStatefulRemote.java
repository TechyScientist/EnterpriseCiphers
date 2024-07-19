package net.johnnyconsole.beans.enigma;

import javax.ejb.Remote;

import net.johnnyconsole.algorithms.enigma.Reflector;
import net.johnnyconsole.algorithms.enigma.Rotor;

@Remote
public interface EnigmaStatefulRemote {

	void setRotors(Rotor left, Rotor middle, Rotor right);
	void setReflector(Reflector reflector);
	void setPlugboardPairs(String... pairs);
	void initialize();
	
}
