package Common;

import java.rmi.*;

public interface MessagingInterface extends Remote {

    String createAccount(String username) throws RemoteException;

    String showAccounts(int authToken) throws RemoteException;

    String sendMessage(int authToken, String recipient, String messageBody) throws RemoteException;

    String showInbox(int authToken) throws RemoteException;

    String readMessage(int authToken, int messageId) throws RemoteException;


    String deleteMessage(int authToken, int messageId) throws RemoteException;
}
