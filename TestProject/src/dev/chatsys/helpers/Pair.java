package dev.chatsys.helpers;

import java.util.Objects;

public class Pair<User,String> {
    User member;
    String messageOfMember;

    public Pair(User member, String messagesOfMember) {
        this.member = member;
        this.messageOfMember = messagesOfMember;
    }

    public User getMember() {
        return member;
    }

    public void setMember(User member) {
        this.member = member;
    }

    public String getMessageOfMember() {
        return messageOfMember;
    }

    public void setMessageOfMember(String messageOfMember) {
        this.messageOfMember = messageOfMember;
    }

    @Override
    public java.lang.String toString() {
        return "Pair{" +
                "member=" + member +
                ", messageOfMember=" + messageOfMember +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair<?, ?> pair = (Pair<?, ?>) o;
        return Objects.equals(member, pair.member) && Objects.equals(messageOfMember, pair.messageOfMember);
    }

    @Override
    public int hashCode() {
        return Objects.hash(member, messageOfMember);
    }
}
