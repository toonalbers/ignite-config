package nl.tno.ignite;

import org.apache.ignite.Ignite;
import org.apache.ignite.Ignition;

public class Main {

	private final static String CONFIG_URI = "https://raw.githubusercontent.com/coenvl/ignite-config/master/p2p/peerclassloading-configuration.xml";
	
	public static void main(String [] args) {
		Ignite ignite = Ignition.start(CONFIG_URI);
        ignite.compute().broadcast(() -> System.out.println("Hello world!"));
        ignite.compute().run(Main::findMe);
        ignite.close();
	}
	
	public static void findMe() {
		System.out.println("Hello you!");
	}
	
}
