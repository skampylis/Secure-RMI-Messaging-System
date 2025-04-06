package Common;

public class Message {
    private final int Id;
    private boolean isRead;
    private final String sender;
    private final String message;

    public Message(int Id,String sender, String message) {
        this.Id = Id;
        isRead = false;
        this.sender = sender;
        this.message = message;
    }

    public boolean isRead() {
        return this.isRead;
    }

    public void setRead(boolean read) {
        this.isRead = read;
    }

    public String getSender() {
        return this.sender;
    }

    public String getMessage() {
        return this.message;
    }

    public int getId() {
        return this.Id;
    }
}
