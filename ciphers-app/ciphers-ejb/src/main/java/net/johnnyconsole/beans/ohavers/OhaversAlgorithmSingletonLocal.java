package net.johnnyconsole.beans.ohavers;

import javax.ejb.Local;

@Local
public interface OhaversAlgorithmSingletonLocal {
	
	String encipher(String message);

}
