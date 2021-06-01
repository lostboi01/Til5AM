package com.til5am.til5am.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.til5am.til5am.models.Roles;

@Repository("rolesRepository")
public interface RolesRepository extends JpaRepository<Roles, Integer> {

    Roles findByRole(String role);
}
