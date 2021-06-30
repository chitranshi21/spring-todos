package com.learn.springalltodos.services;

import com.learn.springalltodos.model.SwaggerTodo;
import com.learn.springalltodos.models.Todo;
import com.learn.springalltodos.repositories.TodoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;


    public List<SwaggerTodo> getAllTodos() {
        return todoRepository.findAll().stream().map(this::toSwaggerTodo).collect(Collectors.toList());
    }

    public SwaggerTodo addTodo(SwaggerTodo inputTodo) {
        var todo = Todo.builder()
                .topic(inputTodo.getTopic())
                .description(inputTodo.getDescription())
                .email(inputTodo.getEmail())
                .build();
        return toSwaggerTodo(todoRepository.save(todo));
    }


    private SwaggerTodo toSwaggerTodo(Todo todo) {
        return SwaggerTodo.builder()
                .id(todo.getId())
                .createdAt(String.valueOf(todo.getCreatedAt().toInstant().getEpochSecond()))
                .topic(todo.getTopic())
                .description(todo.getDescription())
                .email(todo.getEmail())
                .build();
    }

}
