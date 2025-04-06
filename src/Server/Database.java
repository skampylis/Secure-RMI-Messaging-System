package Server;

import Common.Account;
import java.util.HashMap;

public class Database {
    private final HashMap<Integer, Account> savedAccounts;

    public Database() {
        savedAccounts = new HashMap<>();
        addAccount("User1",1);
        addAccount("User2",2);
    }

    public void addAccount(String username,int authToken) {
        savedAccounts.put(authToken,new Account(username));
    }

    public boolean validAuthToken(int authToken) {
        return savedAccounts.containsKey(authToken);
    }

    private String returnUsername(int authToken) {
        return savedAccounts.get(authToken).getUsername();
    }

    public boolean checkUsername(String username){
        for (Integer token: savedAccounts.keySet())
            if (savedAccounts.get(token).getUsername().equals(username))
                return true;
        return false;
    }

    public String printAccounts(){
        StringBuilder results = new StringBuilder();
        int i = 1;
        for (Integer token :savedAccounts.keySet()) {
            System.out.println(savedAccounts.get(token).getUsername());
            results.append(i).append(". ").append(savedAccounts.get(token).getUsername()).append("\n");
            i++;
        }
        return results.toString();
    }

    public String printInbox(int authToken) {
        return savedAccounts.get(authToken).printInbox();
    }

    public void addNewMessageToRecipient(int authToken,String recipient,String messageBody) {
        for (Integer token : savedAccounts.keySet())
            if(savedAccounts.get(token).getUsername().equals(recipient)) {
                savedAccounts.get(token).newMessage(returnUsername(authToken),messageBody);
                break;
            }
    }

    public String message(int authToken, int messageId) {
        return savedAccounts.get(authToken).printMessage(messageId);
    }

    public boolean deleteMessageFromAccount(int authToken,int messageId) {
        return savedAccounts.get(authToken).delete(messageId);
    }


    public HashMap<Integer, Account> getSavedAccounts() {
        return this.savedAccounts;
    }
}