package com.til5am.til5am.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.til5am.til5am.models.Users;
import com.til5am.til5am.models.Roles;
import com.til5am.til5am.repositories.UsersRepository;
import com.til5am.til5am.repositories.RolesRepository;
import java.util.Arrays;
import java.util.HashSet;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Qualifier("usersRepository")
    @Autowired
    private UsersRepository usersRepository;

    @Qualifier("rolesRepository")
    @Autowired
    private RolesRepository rolesRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public Users findUserByEmail(String email) {
        return usersRepository.findByEmail(email);
    }

    @Override
    public void saveUser(Users user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(1);
        Roles userRole = rolesRepository.findByRole("ADMIN");
        user.setRoles(new HashSet<Roles>(Arrays.asList(userRole)));
        usersRepository.save(user);
    }
}
