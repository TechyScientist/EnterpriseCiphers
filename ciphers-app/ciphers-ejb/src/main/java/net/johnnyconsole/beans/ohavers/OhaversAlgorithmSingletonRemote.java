package net.johnnyconsole.beans.ohavers;

import javax.ejb.Remote;

@Remote
public interface OhaversAlgorithmSingletonRemote {
	
	String encipher(String message);
}
