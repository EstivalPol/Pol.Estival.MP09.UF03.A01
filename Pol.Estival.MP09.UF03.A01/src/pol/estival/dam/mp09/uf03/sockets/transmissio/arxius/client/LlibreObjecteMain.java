package pol.estival.dam.mp09.uf03.sockets.transmissio.arxius.client;

import java.io.IOException;
import java.net.UnknownHostException;

public class LlibreObjecteMain {

	public static void main(String[] args) {
		
		try {
			new LlibreObjecte().procesar();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
