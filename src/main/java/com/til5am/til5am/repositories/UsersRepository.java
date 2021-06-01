package com.til5am.til5am.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.til5am.til5am.models.Users;

@Repository("usersRepository")
public interface UsersRepository extends JpaRepository<Users, Long> {

    Users findByEmail(String email);
}
