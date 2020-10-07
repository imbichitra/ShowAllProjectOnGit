package com.bichi.showallprojectongit.viewmodel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.LiveDataReactiveStreams;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.bichi.showallprojectongit.model.Followers;
import com.bichi.showallprojectongit.model.User;
import com.bichi.showallprojectongit.network.Resource;
import com.bichi.showallprojectongit.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class UserViewModel extends ViewModel {
    public static final String TAG = UserViewModel.class.getSimpleName();
    public String userName;
    private UserRepository repository;
    private final MutableLiveData<Resource<List<User>>> mUsers = new MutableLiveData<>();
    private final MutableLiveData<Resource<List<Followers>>> followers = new MutableLiveData<>();


    public MutableLiveData<Resource<List<Followers>>> getFollowersData() {
        return followers;
    }
    public MutableLiveData<Resource<List<User>>> getResponse() {
        return mUsers;
    }

    public UserViewModel(UserRepository repository) {
        this.repository = repository;
    }

    public User clickedUser;

    public void fetchUserRepo() {
        repository.fetchUserRepo(userName)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(s -> mUsers.postValue(Resource.loading((List<User>) null)))
                //.doAfterTerminate(() -> loadingStatus.setValue(false))
                .subscribe(new Observer<List<User>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<User> listResource) {
                        mUsers.postValue(Resource.success(listResource));
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        mUsers.postValue(Resource.error(e.getMessage(), null));
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    public void getFollowers(){
        Log.d(TAG, "getFollowers: "+userName);
        repository.getFollowers(userName)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(s->followers.postValue(Resource.loading(null)))
                .subscribe(new Observer<List<Followers>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<Followers> mfollowers) {
                        followers.postValue(Resource.success(mfollowers));
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        followers.postValue(Resource.error(e.getMessage(),null));
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
