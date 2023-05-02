package dev.chatsys.users;

import dev.chatsys.chats.Chat;
import dev.chatsys.services.friendService;

import java.util.ArrayList;

public class User implements friendService {
    static int counter;
    private final int id;
    private String name;
    private String surname;
    private int age;
    private String city;
    private ArrayList<User> friends;

    private ArrayList<Chat> listOfChats;

    public User(String name, String surname, int age, String city, ArrayList<User> friends, ArrayList<Chat> chats) {
        if (User.counter == 0) {
            User.counter = 1;
        } else {
            User.counter += 1;
        }
        this.id = counter;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.city = city;
        this.friends = friends;
        this.listOfChats = chats;
    }

    public int getId() {
        return id;
    }

//    public void setId(int id) {
//        User.counter = id;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public ArrayList<User> getFriends() {
        return friends;
    }

    public void setFriends(ArrayList<User> friends) {
        this.friends = friends;
    }


    public ArrayList<Chat> getListOfChats() {
        return this.listOfChats;
    }

    public void setListOfChats(ArrayList<Chat> listOfChats) {
        this.listOfChats = listOfChats;
    }

   public void setChat(Chat chat) {
        if (getListOfChats().isEmpty()) {
            setListOfChats(new ArrayList<>());
            getListOfChats().add(chat);
        }
        else {
            getListOfChats().add(chat);
        }
   }

    //finding all dev.chatsys.messages by chat id
    public ArrayList<String> getAllMessagesInChatById(int chatId) {
        ArrayList<String> chatMessages = new ArrayList<>();
        for (Chat chat : this.getListOfChats()) {
            if (chat.getChatId() == chatId) {
                chatMessages.add(chat.getMessages().toString());
            }
        }
        return chatMessages;
    }
    //check if user is friend or not
    public boolean isFriend(User user) {
        return friends.contains(user);
    }

    public String[] chatList() {
        String[] result = new String[getListOfChats().size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = String.valueOf(getListOfChats().get(i));
        }
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", city='" + city + '\'' +
//                ", friends=" + friends +
                ", listOfChats=" + listOfChats +
                '}';
    }

    @Override
    public void addFriend(User user) {
        ArrayList<User> friends = this.getFriends();
        if (!friends.contains(user)) { // check if user is not already in the list
            friends.add(user);
            this.setFriends(friends);
            user.addFriend(this); // add current user as friend to new friend's list
        }
    }

    @Override
    public void deleteFriend(User user) {
        this.getFriends().remove(user);

    }
}