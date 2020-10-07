package com.bichi.showallprojectongit.model;

import com.google.gson.annotations.SerializedName;

public class Followers {
    String login;
    @SerializedName("avatar_url")
    String avatarUrl;

    public Followers(String login, String avatarUrl) {
        this.login = login;
        this.avatarUrl = avatarUrl;
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
}
