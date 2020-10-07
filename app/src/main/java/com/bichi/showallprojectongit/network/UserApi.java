package com.bichi.showallprojectongit.network;

import com.bichi.showallprojectongit.model.ApiListResponse;
import com.bichi.showallprojectongit.model.Followers;
import com.bichi.showallprojectongit.model.User;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public interface UserApi {
    @GET("{username}/repos")
    @Headers("Content-Type: application/json")
    Observable<List<User>> fetchRepoList(@Path(value = "username") String username);

    @GET("{username}/followers")
    @Headers("Content-Type: application/json")
    Observable<List<Followers>> getFollowers(@Path(value = "username") String username);
}
