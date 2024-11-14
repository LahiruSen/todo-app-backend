package com.lahiru.todoappbackend.repository;

import com.lahiru.todoappbackend.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
