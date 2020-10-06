package com.bichi.showallprojectongit.view;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bichi.showallprojectongit.R;
import com.bichi.showallprojectongit.databinding.FragmentUserDetailBinding;
import com.bichi.showallprojectongit.network.ApiFactory;
import com.bichi.showallprojectongit.network.UserApi;
import com.bichi.showallprojectongit.repository.UserRepository;
import com.bichi.showallprojectongit.viewmodel.MyViewModelFactory;
import com.bichi.showallprojectongit.viewmodel.UserViewModel;

public class UserDetailFragment extends Fragment {

    FragmentUserDetailBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_user_detail,container,false);
        UserApi api = ApiFactory.create();
        UserRepository repository = new UserRepository(api);
        MyViewModelFactory factory = new MyViewModelFactory(repository);
        UserViewModel userViewModel = new ViewModelProvider(getActivity(),factory).get(UserViewModel.class);
        binding.setUser(userViewModel.clickedUser);
        return binding.getRoot();
    }
}