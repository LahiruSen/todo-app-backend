package com.lahiru.todoappbackend.service.impl;

import com.lahiru.todoappbackend.dto.TodoDto;
import com.lahiru.todoappbackend.entity.Todo;
import com.lahiru.todoappbackend.repository.TodoRepository;
import com.lahiru.todoappbackend.service.TodoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TodoServiceImpl implements TodoService {

    private TodoRepository todoRepository;
    @Override
    public TodoDto addTodo(TodoDto todoDto) {

        Todo todo = new Todo();
        todo.setTitle(todoDto.getTitle());
        todo.setDescription(todoDto.getDescription());
        todo.setCompleted(todoDto.isCompleted());

        Todo savedTodo = todoRepository.save(todo);

        TodoDto savedTodoDto = new TodoDto(
                savedTodo.getId(),
                savedTodo.getTitle(),
                savedTodo.getDescription(),
                savedTodo.isCompleted()
        );

        return savedTodoDto;
    }
}
