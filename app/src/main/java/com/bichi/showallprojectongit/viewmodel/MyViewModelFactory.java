package com.bichi.showallprojectongit.viewmodel;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.bichi.showallprojectongit.repository.UserRepository;

public class MyViewModelFactory implements ViewModelProvider.Factory {
    private UserRepository repository;

    public MyViewModelFactory(UserRepository repository){
        this.repository = repository;
    }
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new UserViewModel(repository);
    }
}
