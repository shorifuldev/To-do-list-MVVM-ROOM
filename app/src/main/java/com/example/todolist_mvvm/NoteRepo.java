package com.example.todolist_mvvm;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class NoteRepo {

    private NotesDao notesDao;
    private LiveData<List<Notes>> noteList;

    public NoteRepo(Application application)
    {
        NotesDatabase notesDatabase = NotesDatabase.getInstance(application);
        notesDao= notesDatabase.notesDao();
        noteList= notesDao.gelAllData();

    }
    public void insertData(Notes notes)
    {
        new insertTask(notesDao).execute(notes);
    }
    public void updateData(Notes notes)
    {
        new updateTask(notesDao).execute(notes);
    }
    public void deleteData(Notes notes)
    {
        new deleteTask(notesDao).execute(notes);
    }

    public LiveData<List<Notes>> gelAllData()
    {
        return noteList;
    }

    private static class insertTask extends AsyncTask<Notes,Void,Void>
    {
        private NotesDao notesDao;

        public insertTask(NotesDao notesDao) {
            this.notesDao = notesDao;
        }

        @Override
        protected Void doInBackground(Notes... notes) {
            notesDao.insert(notes[0]);
            return null;
        }
    }

    private static class updateTask extends AsyncTask<Notes,Void,Void>
    {
        private NotesDao notesDao;

        public updateTask(NotesDao notesDao) {
            this.notesDao = notesDao;
        }

        @Override
        protected Void doInBackground(Notes... notes) {
            notesDao.update(notes[0]);
            return null;
        }
    }
    private static class deleteTask extends AsyncTask<Notes,Void,Void>
    {
        private NotesDao notesDao;

        public deleteTask(NotesDao notesDao) {
            this.notesDao = notesDao;
        }

        @Override
        protected Void doInBackground(Notes... notes) {
            notesDao.delete(notes[0]);
            return null;
        }
    }
}
