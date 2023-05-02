package dev.chatsys.messages;

import dev.chatsys.chats.Chat;
import dev.chatsys.helpers.Pair;
import dev.chatsys.users.User;

import java.util.ArrayList;

public class MessageWriter {
    private final User user;
    private final Chat chat;

    public MessageWriter(User user, Chat chat) {
        this.user = user;
        this.chat = chat;
    }

    public void writeMessageInChat(Message message) {
            this.chat.setOneMessage(user,message);
        }

    @Override
    public String toString() {
        return "MessageWriter{" +
                "user=" + user +
                ", chat=" + chat +
                '}';
    }

    public ArrayList<String> infoAboutMessages() {
        ArrayList<String> messages = new ArrayList<>();
        for (Pair<User, String> message: chat.getMessages())
            messages.add((String) message.getMessageOfMember());
        return messages;
    }
}
