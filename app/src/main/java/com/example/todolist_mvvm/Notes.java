package com.example.todolist_mvvm;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "myNotesDb")
public class Notes {

    @PrimaryKey(autoGenerate = true)
    private  int id;
    private String title;
    private String disc;

    public Notes(String title, String disc) {
        this.title = title;
        this.disc = disc;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDisc() {
        return disc;
    }

    public void setDisc(String disc) {
        this.disc = disc;
    }
}
