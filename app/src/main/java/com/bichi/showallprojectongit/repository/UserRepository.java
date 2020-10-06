package com.bichi.showallprojectongit.repository;

import com.bichi.showallprojectongit.model.User;
import com.bichi.showallprojectongit.network.UserApi;

import java.util.List;

import io.reactivex.Observable;

public class UserRepository {

    private UserApi api;
    public UserRepository(UserApi api){
        this.api = api;
    }

    public Observable<List<User>> fetchUserRepo(String userName){
        return api.fetchRepoList(userName);
    }
}
