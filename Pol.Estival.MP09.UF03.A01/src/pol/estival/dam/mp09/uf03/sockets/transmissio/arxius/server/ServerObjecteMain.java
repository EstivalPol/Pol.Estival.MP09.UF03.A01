package pol.estival.dam.mp09.uf03.sockets.transmissio.arxius.server;

import java.io.IOException;

public class ServerObjecteMain {

	public static void main(String[] args) {
		
		try {
			new ServerObjecte().procesar();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
