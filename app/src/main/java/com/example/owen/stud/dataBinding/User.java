package com.example.owen.stud.dataBinding;

/**
 * Created by loopeer on 2017/7/25.
 */
public class User {
    private final String mFirstName;
    private final String mLastName;
    private int mAge;

    public User(String firstName, String lastName, int age) {
        mFirstName = firstName;
        mLastName = lastName;
        mAge = age;
    }

    public String getFirstName() {
        return mFirstName;
    }

    public String getLastName() {
        return mLastName;
    }

    public int getAge() {
        return mAge;
    }
}