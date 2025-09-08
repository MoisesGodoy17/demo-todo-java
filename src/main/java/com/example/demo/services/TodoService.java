package com.example.demo.services;

import com.example.demo.entities.TodoEntity;
import com.example.demo.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public TodoEntity createTodo(TodoEntity todo) {
        TodoEntity todoNew = new TodoEntity(
                todo.getId(),
                todo.getTitle(),
                "false",
                todo.getDescription()
        );

        return todoRepository.save(todoNew);
    }

    public Iterable<TodoEntity> buscarPorEstado(String estado) {
        return todoRepository.findByCompleted(estado);
    }

    public Iterable<TodoEntity> getAllTodos() {
        return todoRepository.findAll();
    }
}
