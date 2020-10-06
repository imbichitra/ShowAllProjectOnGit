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
import com.bichi.showallprojectongit.databinding.FragmentUserBinding;
import com.bichi.showallprojectongit.databinding.FragmentUserLisBinding;
import com.bichi.showallprojectongit.model.User;
import com.bichi.showallprojectongit.network.ApiFactory;
import com.bichi.showallprojectongit.network.Resource;
import com.bichi.showallprojectongit.network.UserApi;
import com.bichi.showallprojectongit.repository.UserRepository;
import com.bichi.showallprojectongit.viewmodel.MyViewModelFactory;
import com.bichi.showallprojectongit.viewmodel.UserViewModel;

import java.util.List;


public class UserLisFragment extends Fragment {

    public static final String TAG = UserLisFragment.class.getSimpleName();
    UserViewModel userViewModel;
    FragmentUserLisBinding binding;

    public void observeResponse() {
        userViewModel.getResponse().observe(getViewLifecycleOwner(), new Observer<Resource<List<User>>>() {
            @Override
            public void onChanged(Resource<List<User>> listResource) {
                if (listResource != null){
                    switch (listResource.status){
                        case LOADING:{
                            Log.d(TAG, "onChanged: UserLisFragment: LOADING...");
                            break;
                        }

                        case SUCCESS:{
                            binding.setDataList(listResource.data);
                            Log.d(TAG, "onChanged: UserLisFragment: got posts."+listResource.data.get(0).getFullName());
                            break;
                        }

                        case ERROR:{
                            Log.d(TAG, "onChanged: UserLisFragment: ERROR... " + listResource.message);
                            break;
                        }
                    }
                }
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_user_lis,container,false);
        UserApi api = ApiFactory.create();
        UserRepository repository = new UserRepository(api);
        MyViewModelFactory factory = new MyViewModelFactory(repository);
        userViewModel = new ViewModelProvider(getActivity(),factory).get(UserViewModel.class);
        Log.d(TAG, "onCreate:UserLisFragment "+userViewModel.userName);
        observeResponse();

        return binding.getRoot();
    }
}