package net.johnnyconsole.beans.enigma;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateful;

import net.johnnyconsole.algorithms.enigma.Plugboard;
import net.johnnyconsole.algorithms.enigma.Reflector;
import net.johnnyconsole.algorithms.enigma.Rotor;

@Stateful
@LocalBean
public class EnigmaStateful implements EnigmaStatefulLocal, EnigmaStatefulRemote {

	@EJB
	private EnigmaSingletonLocal singleton;
	
	private Plugboard plugboard;
	private Rotor left, middle, right;
	private Reflector reflector;
	
	@Override
	public void setPlugboardPairs(String... pairs) {
		plugboard = new Plugboard(pairs);
	}
	
	@Override
	public void setRotors(Rotor left, Rotor middle, Rotor right) {
		this.left = left;
		this.middle = middle;
		this.right = right;
	}
	
	@Override
	public void setReflector(Reflector reflector) {
		this.reflector = reflector;
	}
	
	@Override
	public void initialize() {
		singleton.initialize(plugboard, left, middle, right, reflector);
	}
	
}
