package com.bichi.showallprojectongit.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import com.bichi.showallprojectongit.BR;
import com.bichi.showallprojectongit.databinding.FollowersItemBinding;
import com.bichi.showallprojectongit.model.Followers;

import java.util.List;

public class FollowersAdapter extends RecyclerView.Adapter<FollowersAdapter.GenericViewHolder> {
    public static final String TAG = FollowersAdapter.class.getSimpleName();
    private Context context;
    private List<Followers> followers;
    public FollowersAdapter(Context context,List<Followers> followers){
        Log.d(TAG, "FollowersAdapter: ");
        this.context = context;
        this.followers = followers;
    }
    @NonNull
    @Override
    public GenericViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ViewDataBinding binding = FollowersItemBinding.inflate(layoutInflater,parent,false);
        return new GenericViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull GenericViewHolder holder, int position) {
        Followers mfollowers = followers.get(position);
        holder.itemView.setVariable(BR.follower,mfollowers);
    }

    @Override
    public int getItemCount() {
        return followers==null?0:followers.size();
    }

    public static class GenericViewHolder extends RecyclerView.ViewHolder{
        public ViewDataBinding itemView;
        public GenericViewHolder(@NonNull ViewDataBinding itemView) {
            super(itemView.getRoot());
            this.itemView = itemView;
        }
    }
}
