package com.bichi.showallprojectongit.adapter;

import android.util.Log;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bichi.showallprojectongit.model.User;

import java.util.List;

import static android.content.ContentValues.TAG;

public class ListUsersBindings {
    @BindingAdapter("dataList")
    public static void loadUsers(RecyclerView recyclerView, List<User> users) {
        if (users.isEmpty())
            return;

        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if(layoutManager == null){
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        }
        Log.d(TAG, "loadUsers: ");
        ListUsersAdapter adapter = new ListUsersAdapter(recyclerView.getContext(),users);
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(),DividerItemDecoration.VERTICAL));
    }

    /*@BindingAdapter("load_user_avatar")
    public static void loadUserAvatar(SimpleDraweeView simpleDraweeView, User user) {
        RoundingParams roundingParams = RoundingParams.fromCornersRadius(5f);
        roundingParams.setRoundAsCircle(true);

        simpleDraweeView.getHierarchy().setRoundingParams(roundingParams);
        simpleDraweeView.setImageURI(user.getAvatarUrl());
    }*/
}
