package low_level_design_two.design_pattterns.creational.builder.assignments.one;

@WithBuilder
public class MessageBuilder {

    private MessageType messageType;
    private String content;
    private String sender;
    private String recipient;
    private boolean isDelivered;
    private long timestamp;

    public MessageBuilder setMessageType(MessageType messageType) {
        this.messageType = messageType;
        return this;
    }

    public MessageBuilder setContent(String content) {
        this.content = content;
        return this;
    }

    public MessageBuilder setSender(String sender) {
        this.sender = sender;
        return this;
    }

    public MessageBuilder setRecipient(String recipient) {
        this.recipient = recipient;
        return this;
    }

    public MessageBuilder setIsDelivered(boolean isDelivered) {
        this.isDelivered = isDelivered;
        return this;
    }

    public MessageBuilder setTimestamp(long timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public Message build(){
        return new Message(messageType, content, sender, recipient, isDelivered, timestamp);
    }
}