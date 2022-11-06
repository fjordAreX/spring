package ru.test.spring.repository;

import org.springframework.data.repository.CrudRepository;
import ru.test.spring.entity.ToDoEntity;


public interface ToDoRepository extends CrudRepository<ToDoEntity,Long> {



}
