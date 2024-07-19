package net.johnnyconsole.beans.enigma;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;

import net.johnnyconsole.algorithms.enigma.Enigma;
import net.johnnyconsole.algorithms.enigma.Plugboard;
import net.johnnyconsole.algorithms.enigma.Reflector;
import net.johnnyconsole.algorithms.enigma.Rotor;


@Singleton
@LocalBean
public class EnigmaSingleton implements EnigmaSingletonLocal, EnigmaSingletonRemote {

	Enigma enigma;

	@Override
	public String encipher(String string) {
		return enigma.encipher(string);
		
	}

	@Override
	public void initialize(Plugboard plugboard, Rotor left, Rotor middle, Rotor right, Reflector reflector) {
		enigma = new Enigma(plugboard, left, middle, right, reflector);
	}

	@Override
	public void saveConfiguration(String path) {
		try(ObjectOutputStream out = new ObjectOutputStream(Files.newOutputStream(Paths.get(path)))) {
			out.writeObject(enigma);
		} catch(IOException ex) {
			System.err.println("Error: " + ex.getMessage());
		}
	}

	@Override
	public void loadConfiguration(String path) {
		try(ObjectInputStream in = new ObjectInputStream(Files.newInputStream(Paths.get(path)))) {
			enigma = (Enigma)(in.readObject());
		} catch(IOException | ClassNotFoundException ex) {
			System.err.println("Error: " + ex.getMessage());
		}
	}

	@Override
	public void setRotorRingPositions(String positions) {
		enigma.setRingPositions(positions);
		
	}

	@Override
	public void setRotorPositions(String positions) {
		enigma.setRotorPositions(positions);
		
	}
}
