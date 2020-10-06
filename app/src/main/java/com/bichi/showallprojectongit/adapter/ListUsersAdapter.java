package com.bichi.showallprojectongit.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bichi.showallprojectongit.databinding.ItemUserBinding;
import com.bichi.showallprojectongit.model.User;

import java.util.List;

public class ListUsersAdapter extends RecyclerView.Adapter<ListUsersAdapter.UserHolder>{

    private Context context;
    private List<User> users;

    public ListUsersAdapter(Context context,List<User> users){
        this.context = context;
        this.users = users;
    }
    @NonNull
    @Override
    public ListUsersAdapter.UserHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemUserBinding binding = ItemUserBinding.inflate(LayoutInflater.from(context),parent,false);
        return new UserHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ListUsersAdapter.UserHolder holder, int position) {
        User user = users.get(position);
        holder.itemView.setUser(user);
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class UserHolder extends RecyclerView.ViewHolder {
        public ItemUserBinding itemView;
        public UserHolder(@NonNull ItemUserBinding itemView) {
            super(itemView.getRoot());
            this.itemView = itemView;
        }
    }
}
