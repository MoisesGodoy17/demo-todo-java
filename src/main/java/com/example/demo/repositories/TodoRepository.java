package com.example.demo.repositories;

import com.example.demo.entities.TodoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<TodoEntity, Long> {

    Iterable<TodoEntity> findByCompleted(String completed);

}
