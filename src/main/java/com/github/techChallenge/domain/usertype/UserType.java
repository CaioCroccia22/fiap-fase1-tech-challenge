package com.github.techChallenge.domain.usertype;

public class UserType {
    private int id;
    private String title;

    public UserType() {
    }

    public UserType(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public static UserType create(String title) {
        return new UserType(0, title);
    }
}
