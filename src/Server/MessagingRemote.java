package Server;

import Common.MessagingInterface;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Random;

public class MessagingRemote extends UnicastRemoteObject implements MessagingInterface {

    private final Database serverDatabase;
    public MessagingRemote() throws RemoteException {
        super();
        serverDatabase = new Database();
    }

    public String createAccount(String username) throws RemoteException {
        //Check if username exists
        if (serverDatabase.checkUsername(username))
            return "Sorry, the user already exists";
        if (!invalidUsername(username))
            return "Invalid Username";
        int authToken = createAuthToken();
        while(serverDatabase.getSavedAccounts().containsKey(authToken))
            authToken = createAuthToken();
        serverDatabase.addAccount(username,authToken);
        return String.valueOf(authToken);
    }

    public String showAccounts(int authToken) throws RemoteException {
        if (!serverDatabase.validAuthToken(authToken))
            return "Invalid Auth Token";
        return serverDatabase.printAccounts();
    }

    public String sendMessage(int authToken, String recipient, String messageBody) throws RemoteException {
        if(!serverDatabase.validAuthToken(authToken))
            return "Invalid Auth Token";
        if (!serverDatabase.checkUsername(recipient))
            return "User does not exist";
        serverDatabase.addNewMessageToRecipient(authToken,recipient,messageBody);
        return "OK";
    }

    public String showInbox(int authToken) throws RemoteException {
        if (!serverDatabase.validAuthToken(authToken))
            return "Invalid Auth Token";
        return serverDatabase.printInbox(authToken);
    }

    public String readMessage(int authToken, int messageId) throws RemoteException {
        if (!serverDatabase.validAuthToken(authToken))
            return "Invalid Auth Token";
        return serverDatabase.message(authToken,messageId);
    }

    public String deleteMessage(int authToken, int messageId) throws RemoteException {
        if (serverDatabase.validAuthToken(authToken) && serverDatabase.deleteMessageFromAccount(authToken, messageId) )
            return "ΟΚ";
        return "Message does not exist";
    }

    private boolean invalidUsername(String username) {
        for (char c: username.toCharArray())
            if(!Character.isLetterOrDigit(c) && c!='_')
                return false;
        return true;
    }

    private int createAuthToken(){
        Random rand = new Random();
        return rand.nextInt(1000000);
    }

}
