package com.learn.springalltodos.services;


import com.learn.springalltodos.model.SwaggerTodo;
import com.learn.springalltodos.models.Todo;
import com.learn.springalltodos.repositories.TodoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;


@ExtendWith(SpringExtension.class)
@DataMongoTest
public class TodoServiceTest {

    @InjectMocks
    private TodoService service;

    @Mock
    private TodoRepository repository;

    @Test
    public void getAllTodoTest() {
        // given
        var testTodo = Todo.builder()
                .description("testDesc")
                .email("test@email.com")
                .topic("testTopic")
                .createdAt(new Date())
                .id("random_id")
                .build();
        given(repository.findAll()).willReturn(Arrays.asList(testTodo));

        // when
        List<SwaggerTodo> results = service.getAllTodos();

        //then
        assertThat(results.size()).isEqualTo(1);
        assertThat(results.get(0).getId()).isEqualTo(testTodo.getId());
    }
}
