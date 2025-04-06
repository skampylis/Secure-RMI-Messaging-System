package Client;

import Common.MessagingInterface;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    public static void main(String[] args) {
        try {
            int fk_id=Integer.parseInt(args[2]);
            Registry rmiRegistry = LocateRegistry.getRegistry(Integer.parseInt(args[1]));
            MessagingInterface messagingInterface = (MessagingInterface) rmiRegistry.lookup("Messenger");
            System.out.println("Connected to Server");
            if (fk_id == 1 ) {
                String username = args[3];
                System.out.println(messagingInterface.createAccount(username));
            }
            else if (fk_id == 2) {
                int token = Integer.parseInt(args[3]);
                System.out.println(messagingInterface.showAccounts(token));
            }
            else if (fk_id == 3) {
                int token = Integer.parseInt(args[3]);
                String receiver = args[4];
                StringBuilder message = new StringBuilder();
                for(int i =5; i<args.length; i++)
                    message.append(args[i]).append(" ");
                System.out.println(messagingInterface.sendMessage(token, receiver, message.toString()));
            }
            else if (fk_id == 4) {
                int token = Integer.parseInt(args[3]);
                System.out.println(messagingInterface.showInbox(token));
            }
            else if (fk_id == 5) {
                int token = Integer.parseInt(args[3]);
                int message_id = Integer.parseInt(args[4]);
                System.out.println(messagingInterface.readMessage(token, message_id));
            }
            else if (fk_id == 6) {
                int token = Integer.parseInt(args[3]);
                int message_id = Integer.parseInt(args[4]);
                System.out.println(messagingInterface.deleteMessage(token,message_id));
            }
            else
                System.out.println("1-6");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
