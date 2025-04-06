package Server;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
    public static void main(String[] args) {
        try {
            MessagingRemote messagingRemote = new MessagingRemote();
            int port = Integer.parseInt(args[0]);
            Registry rmiRegistry = LocateRegistry.createRegistry(port);
            rmiRegistry.rebind("Messenger", messagingRemote);
            System.out.println("Server start");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}