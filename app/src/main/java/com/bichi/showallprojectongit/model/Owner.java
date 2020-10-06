package com.bichi.showallprojectongit.model;

import com.google.gson.annotations.SerializedName;

public class Owner {
    String login;
    @SerializedName("avatar_url")
    String avatarUrl;
    @SerializedName("followers_url")
    String followersUrl;

    public Owner(String login, String avatarUrl, String followersUrl) {
        this.login = login;
        this.avatarUrl = avatarUrl;
        this.followersUrl = followersUrl;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getFollowersUrl() {
        return followersUrl;
    }

    public void setFollowersUrl(String followersUrl) {
        this.followersUrl = followersUrl;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "login='" + login + '\'' +
                ", avatarUrl='" + avatarUrl + '\'' +
                ", followersUrl='" + followersUrl + '\'' +
                '}';
    }
}
