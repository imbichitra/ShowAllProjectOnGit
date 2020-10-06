package com.bichi.showallprojectongit.model;

import java.util.List;

public class ApiListResponse<T> {
    private List<T> user;

    public ApiListResponse(List<T> user) {
        this.user = user;
    }

    public List<T> getUser() {
        return user;
    }

    public void setUser(List<T> user) {
        this.user = user;
    }
}
