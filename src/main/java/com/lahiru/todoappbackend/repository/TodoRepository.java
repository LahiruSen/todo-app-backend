package com.lahiru.todoappbackend.repository;

import com.lahiru.todoappbackend.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}
