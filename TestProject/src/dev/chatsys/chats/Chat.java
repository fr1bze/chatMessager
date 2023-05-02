package dev.chatsys.chats;

import dev.chatsys.helpers.Pair;
import dev.chatsys.messages.Message;
import dev.chatsys.users.User;

import java.util.ArrayList;

public class Chat {
    private int chatId;
    private ArrayList<User> membersOfChat;
    private String nameOfChat;
    private ArrayList<Pair> messages;

    public Chat(int chatId, ArrayList<User> membersOfChat, String nameOfChat, ArrayList<Pair> messages) {
        this.chatId = chatId;
        this.membersOfChat = membersOfChat;
        this.nameOfChat = nameOfChat;
        this.messages = messages;
    }

    public int getChatId() {
        return chatId;
    }

    public void setChatId(int chatId) {
        this.chatId = chatId;
    }

    public ArrayList<User> getMembersOfChat() {
        return membersOfChat;
    }

    public void setMembersOfChat(ArrayList<User> membersOfChat) {
        this.membersOfChat = membersOfChat;
    }

    public String getNameOfChat() {
        return this.nameOfChat;
    }

    public void setNameOfChat(String nameOfChat) {
        this.nameOfChat = nameOfChat;
    }

    public ArrayList<Pair> getMessages() {
        return messages;
    }

    public void setMessages(ArrayList<Pair> messages) {
        this.messages = messages;
    }

    public void setOneMessage(User user, Message message) {
        if (!isEmptyListOfMessages())
            this.messages.add(new Pair<>(user,message.getContext()));
        else {
            this.setMessages(new ArrayList<>());
            this.messages.add(new Pair<>(user,
                    message.getContext()));
        }
    }

    private boolean isEmptyListOfMessages() {
        return this.getMessages().isEmpty();
    }

    public void addMembersToChat(User user) {
        if (!getMembersOfChat().isEmpty()) {
            this.membersOfChat.add(user);
        }
        else {
            membersOfChat = new ArrayList<>();
            membersOfChat.add(user);
        }
//        user.setChat(this);
    }


    public String chatInfo() {
        return "Chat{" +
                "chatId=" + chatId +
                ", membersOfChat=" + membersOfChat +
                ", nameOfChat='" + nameOfChat + '\'' +
                ", dev.chatsys.messages=" + messages +
                '}';
    }
}
