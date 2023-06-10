package com.jebolwski.learning.repositories;

import com.jebolwski.learning.entities.ERole;
import com.jebolwski.learning.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role,Long> {
    Optional<Role> findByName(ERole name);
}
