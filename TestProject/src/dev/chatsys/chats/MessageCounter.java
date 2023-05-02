package dev.chatsys.chats;

import dev.chatsys.helpers.Pair;
import dev.chatsys.users.User;

import java.util.HashMap;

public class MessageCounter {
    Chat chat;

    public MessageCounter(Chat chat) {
        this.chat = chat;
    }

    public HashMap<String, Integer> counterOfMessages(Chat chat)  {
        HashMap<String, Integer> map = new HashMap<>();
        for (Pair<User,String> message: chat.getMessages()) {
            map.merge(message.getMember().getName(), 1, Integer::sum);
        }
        return map;
    }
}
