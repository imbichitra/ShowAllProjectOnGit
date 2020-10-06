package com.bichi.showallprojectongit.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bichi.showallprojectongit.R;
import com.bichi.showallprojectongit.databinding.FragmentUserBinding;
import com.bichi.showallprojectongit.model.User;
import com.bichi.showallprojectongit.network.ApiFactory;
import com.bichi.showallprojectongit.network.Resource;
import com.bichi.showallprojectongit.network.UserApi;
import com.bichi.showallprojectongit.repository.UserRepository;
import com.bichi.showallprojectongit.viewmodel.MyViewModelFactory;
import com.bichi.showallprojectongit.viewmodel.UserViewModel;

import java.util.List;

public class UserFragment extends Fragment implements MyInterface{
    UserViewModel userViewModel;
    public static final String TAG = UserFragment.class.getSimpleName();
    FragmentUserBinding binding;
    NavController navController = null;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_user,container,false);
        //return inflater.inflate(R.layout.fragment_user, container, false);
        UserApi api = ApiFactory.create();
        UserRepository repository = new UserRepository(api);
        MyViewModelFactory factory = new MyViewModelFactory(repository);
        userViewModel = new ViewModelProvider(getActivity(),factory).get(UserViewModel.class);

        binding.setViewModel(userViewModel);
        binding.setMyinteface(this);
        //observeResponse();
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
    }

   /* public void observeResponse() {
        userViewModel.getResponse().observe(getViewLifecycleOwner(), new Observer<Resource<List<User>>>() {
            @Override
            public void onChanged(Resource<List<User>> listResource) {
                if (listResource != null){
                    switch (listResource.status){
                        case LOADING:{
                            Log.d(TAG, "onChanged: PostsFragment: LOADING...");
                            break;
                        }

                        case SUCCESS:{
                            Log.d(TAG, "onChanged: PostsFragment: got posts."+listResource.data.get(0).getFullName());
                            navController.navigate(R.id.action_userFragment_to_userLisFragment);
                            break;
                        }

                        case ERROR:{
                            Log.d(TAG, "onChanged: PostsFragment: ERROR... " + listResource.message);
                            break;
                        }
                    }
                }
            }
        });
    }*/

    @Override
    public void onSubmitClick() {
        if (userViewModel.userName != null &&!userViewModel.userName.isEmpty()) {
            navController.navigate(R.id.action_userFragment_to_userLisFragment);
        }else {
            Toast.makeText(getContext(), "Enter username", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void userClicked(User user) {

    }
}