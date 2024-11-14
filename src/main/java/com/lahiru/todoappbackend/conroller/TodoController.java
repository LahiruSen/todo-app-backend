package com.lahiru.todoappbackend.conroller;

import com.lahiru.todoappbackend.dto.TodoDto;
import com.lahiru.todoappbackend.service.TodoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("api/todos")
@AllArgsConstructor
public class TodoController {

    private TodoService todoService;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<TodoDto> addTodo(@RequestBody TodoDto todoDto) {
        TodoDto savedTodo = todoService.addTodo(todoDto);
        return new ResponseEntity<>(savedTodo, HttpStatus.CREATED );
    }

    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @GetMapping("{id}")
    public ResponseEntity<TodoDto> getTodo(@PathVariable("id") Long todoId) {
        TodoDto todoDto =  todoService.getTodo(todoId);
        return new ResponseEntity<>(todoDto, HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @GetMapping
    public ResponseEntity<List<TodoDto>> getAllTodos() {
        List<TodoDto> todos = todoService.getAllTodos();
        return ResponseEntity.ok(todos);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("{id}")
    public ResponseEntity<TodoDto> updateTodo(@PathVariable("id") Long todoId, @RequestBody TodoDto todoDto) {
        TodoDto updatedTodo = todoService.updateTodo(todoId, todoDto);
        return ResponseEntity.ok(updatedTodo);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteTodo(@PathVariable("id") Long todoId) {
        todoService.deleteTodo(todoId);
        return ResponseEntity.ok("Todo Deleted with id: " + todoId);
    }

    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @PatchMapping("{id}/complete")
    public ResponseEntity<TodoDto> completeTodo(@PathVariable("id") Long todoId) {
        TodoDto todoDto = todoService.completeTodo(todoId);
        return ResponseEntity.ok(todoDto);
    }

    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @PatchMapping("{id}/incomplete")
    public ResponseEntity<TodoDto> incompleteTodo(@PathVariable("id") Long todoId) {
        TodoDto todoDto = todoService.incompleteTodo(todoId);
        return ResponseEntity.ok(todoDto);
    }
}
