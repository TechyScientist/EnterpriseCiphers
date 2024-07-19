package net.johnnyconsole.beans.ohavers;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;

@Singleton
@LocalBean
public class OhaversAlgorithmSingleton implements OhaversAlgorithmSingletonLocal, OhaversAlgorithmSingletonRemote {

	private StringBuilder morse = new StringBuilder(), numbers = new StringBuilder();
	
	@Override
	public String encipher(String message) {
		morseify(message);
        numbers = new StringBuilder(numbers).reverse();
        message = demorseify(morse.toString());
        return message;
	}
	
	private void morseify(String message) {
        morse = new StringBuilder();
        numbers = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            String morseCh = morse(message.charAt(i));
            morse.append(morseCh);
            numbers.append(morseCh.length());
            System.out.println("m: " + morseCh + ", p: " + demorse(morseCh));
            System.out.println(message);
        }
    }

    private String morse(char c) {
        switch (c) {
            case 'A':
                return ".-";
            case 'B':
                return "-...";
            case 'C':
                return "-.-.";
            case 'D':
                return "-..";
            case 'E':
                return ".";
            case 'F':
                return "..-.";
            case 'G':
                return "--.";
            case 'H':
                return "....";
            case 'I':
                return "..";
            case 'J':
                return ".---";
            case 'K':
                return "-.-";
            case 'L':
                return ".-..";
            case 'M':
                return "--";
            case 'N':
                return "-.";
            case 'O':
                return "---";
            case 'P':
                return ".--.";
            case 'Q':
                return "--.-";
            case 'R':
                return ".-.";
            case 'S':
                return "...";
            case 'T':
                return "-";
            case 'U':
                return "..-";
            case 'V':
                return "...-";
            case 'W':
                return ".--";
            case 'X':
                return "-..-";
            case 'Y':
                return "-.--";
            case 'Z':
                return "--..";
            case '_':
                return "..--";
            case ',':
                return ".-.-";
            case '.':
                return "---.";
            default:
                return "----";
        }
    }

    private String demorseify(String morse) {
        StringBuilder message = new StringBuilder();
        while(numbers.length() > 0) {
            int n = numbers.charAt(0) - '0';
            numbers.deleteCharAt(0);
            message.append(demorse(morse.substring(0, n)));
            morse = morse.substring(n);
        }
        return message.toString();
    }

    private char demorse(String s) {
        switch (s) {
            case ".-":
                return 'A';
            case "-...":
                return 'B';
            case "-.-.":
                return 'C';
            case "-..":
                return 'D';
            case ".":
                return 'E';
            case "..-.":
                return 'F';
            case "--.":
                return 'G';
            case "....":
                return 'H';
            case "..":
                return 'I';
            case ".---":
                return 'J';
            case "-.-":
                return 'K';
            case ".-..":
                return 'L';
            case "--":
                return 'M';
            case "-.":
                return 'N';
            case "---":
                return 'O';
            case ".--.":
                return 'P';
            case "--.-":
                return 'Q';
            case ".-.":
                return 'R';
            case "...":
                return 'S';
            case "-":
                return 'T';
            case "..-":
                return 'U';
            case "...-":
                return 'V';
            case ".--":
                return 'W';
            case "-..-":
                return 'X';
            case "-.--":
                return 'Y';
            case "--..":
                return 'Z';
            case "..--":
                return '_';
            case ".-.-":
                return ',';
            case "---.":
                return '.';
            default:
                return '?';
        }
    }

}
