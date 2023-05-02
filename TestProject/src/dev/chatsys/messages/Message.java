package dev.chatsys.messages;

public class Message {
    private int chatRelatedId;
    private String context;

    public Message(int chatRelatedId, String context) {
        this.chatRelatedId = chatRelatedId;
        this.context = context;
    }

    public int getChatRelatedId() {
        return chatRelatedId;
    }

    public void setChatRelatedId(int chatRelatedId) {
        this.chatRelatedId = chatRelatedId;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

}
