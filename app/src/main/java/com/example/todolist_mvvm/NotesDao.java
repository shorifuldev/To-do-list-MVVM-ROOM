package com.example.todolist_mvvm;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface NotesDao {

    @Insert
    public void insert(Notes notes);

    @Update
    public void update (Notes notes);

    @Delete
    public void delete(Notes notes);

    @Query("Select * from myNotesDb")
    public LiveData<List<Notes>> gelAllData();

}
