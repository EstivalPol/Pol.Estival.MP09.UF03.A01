package pol.estival.dam.mp09.uf03.sockets.transmissio.arxius.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import pol.estival.dam.mp09.uf03.sockets.transmissio.arxius.config.Settings;
import pol.estival.dam.mp09.uf03.sockets.transmissio.arxius.domain.Llibre;


public class ServerObjecte {

	private ServerSocket serverSocket;
	private Socket clienteSocket;

	private ObjectInputStream objectInputStream;
	private ObjectOutputStream objectOutputStream;

	public void procesar() throws IOException, ClassNotFoundException {
		serverSocket = new ServerSocket(Settings.PORT);

		while (true) {
			System.out.println("Esperant connexions de cliets...");
			clienteSocket = serverSocket.accept();

			System.out.println("Client connectat");

			// ========================
			Llibre llibreServidor = this.getLlibre();
			System.out.println("S: Enviem aquest llibre al client: " + llibreServidor.toString());
			// ========================
			objectOutputStream = new ObjectOutputStream(clienteSocket.getOutputStream());
			objectOutputStream.writeObject(llibreServidor);
			// =============================================
			System.out.println("Esperant a que el client transmeti...");
			objectInputStream = new ObjectInputStream(clienteSocket.getInputStream());
			// Quedamos a la espera de que el cliente transmita
			Llibre llibreCliente = (Llibre) objectInputStream.readObject();
			System.out.println("Hem rebut el client: " + llibreCliente.toString());
			// =============================================
			System.out.println("Procedim a desconnnectar el client:");
			objectOutputStream.close();
			objectInputStream.close();
			clienteSocket.close();

		}
	}

	private Llibre getLlibre() {
		Llibre llibre = new Llibre();

		Scanner scanner = new Scanner(System.in);
		System.out.println("Introdueixi el títol: ");
		llibre.setTitle(scanner.next());
		System.out.println("Introdueixi l'autor: ");
		llibre.setAutor(scanner.next());

		scanner.close();

		return llibre;
	}

}
