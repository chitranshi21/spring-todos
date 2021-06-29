package com.learn.springalltodos.controllers;

import com.learn.springalltodos.api.TodosApi;
import com.learn.springalltodos.model.Todo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.Arrays;
import java.util.List;

@Controller
@Slf4j
public class TodoController implements TodosApi {

    @Override
    public ResponseEntity<List<Todo>> getAllTodos() {
        return ResponseEntity.ok(Arrays.asList(new Todo()));
    }
}
