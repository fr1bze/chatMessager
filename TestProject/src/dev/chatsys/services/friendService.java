package dev.chatsys.services;

import dev.chatsys.users.User;

public interface friendService {
    public void addFriend(User user);
    public void deleteFriend(User user);
}
