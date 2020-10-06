package com.bichi.showallprojectongit.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;

import com.bichi.showallprojectongit.R;
import com.bichi.showallprojectongit.model.User;
import com.bichi.showallprojectongit.network.ApiFactory;
import com.bichi.showallprojectongit.network.Resource;
import com.bichi.showallprojectongit.network.UserApi;
import com.bichi.showallprojectongit.repository.UserRepository;
import com.bichi.showallprojectongit.viewmodel.MyViewModelFactory;
import com.bichi.showallprojectongit.viewmodel.UserViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = MainActivity.class.getSimpleName();
    UserViewModel userViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}