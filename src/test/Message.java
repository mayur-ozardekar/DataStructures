package test;

public class Message {
    public int sender;
    public int recipient;
    public int conversationId;

    public Message(int sender, int recipient, int conversationId) {
        this.sender = sender;
        this.recipient = recipient;
        this.conversationId = conversationId;
    }
}
