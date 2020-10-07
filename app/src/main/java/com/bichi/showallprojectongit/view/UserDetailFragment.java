package com.bichi.showallprojectongit.view;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bichi.showallprojectongit.R;
import com.bichi.showallprojectongit.databinding.FragmentUserDetailBinding;
import com.bichi.showallprojectongit.model.Followers;
import com.bichi.showallprojectongit.network.ApiFactory;
import com.bichi.showallprojectongit.network.Resource;
import com.bichi.showallprojectongit.network.UserApi;
import com.bichi.showallprojectongit.repository.UserRepository;
import com.bichi.showallprojectongit.viewmodel.MyViewModelFactory;
import com.bichi.showallprojectongit.viewmodel.UserViewModel;

import java.util.List;

public class UserDetailFragment extends Fragment {
    public static final String TAG = UserDetailFragment.class.getSimpleName();
    FragmentUserDetailBinding binding;
    UserViewModel userViewModel;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_user_detail,container,false);
        UserApi api = ApiFactory.create();
        UserRepository repository = new UserRepository(api);
        MyViewModelFactory factory = new MyViewModelFactory(repository);
        userViewModel = new ViewModelProvider(getActivity(),factory).get(UserViewModel.class);
        binding.setUser(userViewModel.clickedUser);
        observeFollowers();
        userViewModel.getFollowers();
        return binding.getRoot();
    }

    private void observeFollowers(){
        userViewModel.getFollowersData().observe(getViewLifecycleOwner(), listResource -> {
            if (listResource != null){
                switch (listResource.status){
                    case LOADING:{
                        Log.d(TAG, "onChanged: UserDetailFragment: LOADING...");
                        break;
                    }

                    case SUCCESS:{
                        binding.setFollowers(listResource.data);
                        //Log.d(TAG, "onChanged: UserDetailFragment: got posts."+listResource.data.get(0).getLogin());
                        break;
                    }

                    case ERROR:{
                        Log.d(TAG, "onChanged: UserDetailFragment: ERROR... " + listResource.message);
                        break;
                    }
                }
            }
        });
    }
}