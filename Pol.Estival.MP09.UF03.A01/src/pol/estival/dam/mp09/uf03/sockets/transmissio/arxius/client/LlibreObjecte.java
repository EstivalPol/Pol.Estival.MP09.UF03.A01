package pol.estival.dam.mp09.uf03.sockets.transmissio.arxius.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import pol.estival.dam.mp09.uf03.sockets.transmissio.arxius.config.Settings;
import pol.estival.dam.mp09.uf03.sockets.transmissio.arxius.domain.Llibre;



public class LlibreObjecte {

	private Socket clienteSocket;

	private ObjectInputStream objectInputStream;
	private ObjectOutputStream objectOutputStream;

	public void procesar() throws UnknownHostException, IOException, ClassNotFoundException {
		clienteSocket = new Socket(Settings.IP, Settings.PORT);

		// =====================
		System.out.println("Esperant la transmisió del servidor...");
		objectInputStream = new ObjectInputStream(clienteSocket.getInputStream());
		Llibre llibreServidor = (Llibre) objectInputStream.readObject();
		System.out.println("Hem rebut del servidor: " + llibreServidor.toString());
		// =====================
		llibreServidor = this.getLlibre(llibreServidor);
		System.out.println("Enviarem al servidor el llibrerebut amb algunes modificacions: "
				+ llibreServidor.toString());
		objectOutputStream = new ObjectOutputStream(clienteSocket.getOutputStream());
		objectOutputStream.writeObject(llibreServidor);
		// =====================
		System.out.println("Ens desconnectem...");
		objectOutputStream.close();
		objectInputStream.close();
		clienteSocket.close();

	}

	private Llibre getLlibre(Llibre llibre) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Introdueixi el títol: ");
		llibre.setTitle(scanner.next());
		System.out.println("Introdueixi l'autor: ");
		llibre.setAutor(scanner.next());


		scanner.close();

		return llibre;
	}

}
