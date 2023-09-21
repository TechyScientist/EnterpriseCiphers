package net.johnnyconsole.beans.enigma;

import javax.ejb.Remote;

import net.johnnyconsole.algorithms.enigma.Reflector;
import net.johnnyconsole.algorithms.enigma.Rotor;

@Remote
public interface EnigmaStatefulRemote {

	public void setRotors(Rotor left, Rotor middle, Rotor right);
	public void setReflector(Reflector reflector);
	public void setPlugboardPairs(String... pairs);
	public void initialize();
	
}
