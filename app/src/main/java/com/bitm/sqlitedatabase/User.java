package com.bitm.sqlitedatabase;

public class User {


    public User() {
    }

    private int Id;
    private String Name;
    private String Age;

    public User(int id, String name, String age) {
        Id = id;
        Name = name;
        Age = age;
    }

    public int getId() {
        return Id;
    }

    public String getName() {
        return Name;
    }

    public String getAge() {
        return Age;
    }
}
