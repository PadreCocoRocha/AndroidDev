package com.example.android.todolist;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;

import com.example.android.todolist.database.AppDatabase;

// COMPLETE (1) Make this class extend ViewModel ViewModelProvider.NewInstanceFactory
public class AddTaskViewModelFactory extends ViewModelProvider.NewInstanceFactory{
    private int mTaskId;
    private AppDatabase mDb;

    // COMPLETE (2) Add two member variables. One for the database and one for the taskId

    // COMPLETE (3) Initialize the member variables in the constructor with the parameters received
    public AddTaskViewModelFactory(AppDatabase db, int mTaskId) {
        this.mTaskId = mTaskId;
        this.mDb = db;
    }

    // COMPLETE (4) Uncomment the following method
    // Note: This can be reused with minor modifications
    @Override
    public <T extends ViewModel> T create(Class<T> modelClass){
        return (T) new AddTaskViewModel(mDb, mTaskId);
    }
}
