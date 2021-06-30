package com.learn.springalltodos.controllers;

import com.learn.springalltodos.api.TodosApi;
import com.learn.springalltodos.model.SwaggerTodo;
import com.learn.springalltodos.services.TodoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@Slf4j
@RequiredArgsConstructor
public class TodoController implements TodosApi {

    private final TodoService service;

    @Override
    public ResponseEntity<List<SwaggerTodo>> getAllTodos() {
        return ResponseEntity.ok(service.getAllTodos());
    }

    @Override
    public ResponseEntity<SwaggerTodo> postTodo(@Valid SwaggerTodo swaggerTodo) {
        return ResponseEntity.of(Optional.ofNullable(service.addTodo(swaggerTodo)));
    }
}
