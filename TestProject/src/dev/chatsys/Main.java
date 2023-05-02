package dev.chatsys;

import dev.chatsys.chats.Chat;
import dev.chatsys.chats.MessageCounter;
import dev.chatsys.messages.Message;
import dev.chatsys.messages.MessageWriter;
import dev.chatsys.users.User;

import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        User nikolay = new User( "Nikolay","Fekunov",15,"Moscow",new ArrayList<>(),new ArrayList<>());
        User mikhail = new User("Mikhail","Petrov", 18,"New-York",new ArrayList<>(),new ArrayList<>());
        User andrew = new User("Andrey","Alexeev", 20,"Chicago",new ArrayList<>(),new ArrayList<>());
        Chat chat = new Chat(1, new ArrayList<>(),"chatMikhailwithNikolay",new ArrayList<>());
        chat.addMembersToChat(nikolay);
        chat.addMembersToChat(mikhail);
        nikolay.setChat(chat);
        mikhail.setChat(chat);
        System.out.println("Getting chat of the user " + nikolay.getListOfChats());


        MessageWriter messageWriterOfNikolay = new MessageWriter(nikolay,chat);
        MessageWriter messageWriterOfMikhail = new MessageWriter(mikhail,chat);
        System.out.println(chat.getMessages().size() + " before adding any dev.chatsys.messages");
        messageWriterOfNikolay.writeMessageInChat(new Message(chat.getChatId(),"Hello, my friend"));
        System.out.println(chat.getMessages().size() + " after adding \"Hello, my friend\"");
        messageWriterOfMikhail.writeMessageInChat(new Message(chat.getChatId(),"Hello"));
        System.out.println(chat.getMessages().size() + " after adding \"Hello\"");
        messageWriterOfMikhail.writeMessageInChat(new Message(chat.getChatId(),"How are you?"));
        System.out.println(chat.getMessages().size() + " after adding \"How are you?\"");
        System.out.println(chat.getMessages());
        MessageCounter messageCounter = new MessageCounter(chat);
        System.out.println(messageCounter.counterOfMessages(chat));
        System.out.println("---------------");
        System.out.println("Chat get members " + chat.getMembersOfChat());
        System.out.println("List of dev.chatsys.messages");
        System.out.println(chat.getMessages());
        System.out.println(chat.chatInfo());

        //implement friend adding
        mikhail.addFriend(nikolay);
        mikhail.addFriend(andrew);
//        System.out.println(mikhail.getFriends());
        System.out.println("list of friends " + mikhail.getFriends());
        System.out.println("friend list of opponent " + nikolay.getFriends());

//        mikhail.deleteFriend(nikolay);
//        System.out.println("list of opponent friend " + nikolay.getFriends());

    }
}