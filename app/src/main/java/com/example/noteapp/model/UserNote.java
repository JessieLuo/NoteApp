package com.example.noteapp.model;

public class UserNote {
    private int user_id;
    private String UserNote;

    public UserNote(String userNote) {
        UserNote = userNote;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUserNote() {
        return UserNote;
    }

    public void setUserNote(String userNote) {
        UserNote = userNote;
    }
}
