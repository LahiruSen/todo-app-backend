package com.lahiru.todoappbackend.service.impl;

import com.lahiru.todoappbackend.dto.TodoDto;
import com.lahiru.todoappbackend.entity.Todo;
import com.lahiru.todoappbackend.repository.TodoRepository;
import com.lahiru.todoappbackend.service.TodoService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TodoServiceImpl implements TodoService {

    private TodoRepository todoRepository;

    private ModelMapper modelMapper;
    @Override
    public TodoDto addTodo(TodoDto todoDto) {

        Todo todo = modelMapper.map(todoDto, Todo.class);

        Todo savedTodo = todoRepository.save(todo);

        return modelMapper.map(savedTodo, TodoDto.class);
    }
}
