package com.til5am.til5am.services;
import com.til5am.til5am.models.Users;

public interface UserService {
    public Users findUserByEmail(String email);

    public void saveUser(Users user);
}
