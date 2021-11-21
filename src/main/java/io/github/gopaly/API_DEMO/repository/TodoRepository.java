package io.github.gopaly.API_DEMO.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import io.github.gopaly.API_DEMO.model.Todo;

public interface TodoRepository extends MongoRepository<Todo, String> {

    @Query("{'status':'new'}")
    Todo findTodoByStatus(String status);

    @Query(value = "{'status':'new'}", fields = "{'name':1,'status':1}")
    List<Todo> findAll(String status);

    public long count();
}
