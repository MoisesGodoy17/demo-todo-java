package com.example.demo.controllers;

import com.example.demo.services.TodoService;
import com.example.demo.entities.TodoEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RequestMapping("/api")
@CrossOrigin(origins = "*")
@RestController
public class TodoController {
    @Autowired
    private TodoService todoService;


    @PostMapping("/new")
    public TodoEntity createTodo(@RequestBody TodoEntity todo) {
        return todoService.createTodo(todo);
    }

    @GetMapping("/all-todo")
    public ResponseEntity<Iterable<TodoEntity>> getAllTodos() {
        Iterable<TodoEntity> todos = todoService.getAllTodos();
        return ResponseEntity.ok(todos);
    }

    @PostMapping("/filtro-estado")
    public ResponseEntity<Iterable<TodoEntity>> getTareasPorEstado(@RequestParam("estado") String estado) {
        Iterable<TodoEntity> todos = todoService.buscarPorEstado(estado);
        return ResponseEntity.ok(todos);
    }
}
