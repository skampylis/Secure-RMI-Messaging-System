package Common;

import java.util.ArrayList;

public class Account {
    private final String username;
    private final ArrayList<Message> messageBox;

    public Account(String Username) {
        this.username = Username;
        messageBox = new ArrayList<>();
    }

    public void newMessage(String sender, String message) {
        messageBox.add(new Message(messageBox.size(),sender,message));
    }

    public String printInbox() {
        String results = "No inbox";
        for (Message message: messageBox) {
            results = message.getId() + ". from " + message.getSender();
            if (!message.isRead())
                results += ("*");
            results+=("\n");
        }
        return results;
    }

    public String printMessage(int messageId){
        StringBuilder messageBody = new StringBuilder();
        for (Message message: messageBox) {
            if (messageId == message.getId()) {
                messageBody.append("(").append(message.getSender()).append(") ").append(message.getMessage());
                message.setRead(true);
                return messageBody.toString();
            }
        }
        return "Message ID does not exist";
    }

    public boolean delete(int id) {
        for (Message message: messageBox)
            if (id == message.getId()) {
                messageBox.remove(message);
                return true;
            }
        return false;
    }

    public String getUsername() {
        return this.username;
    }

}
