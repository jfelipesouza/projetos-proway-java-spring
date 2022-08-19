package com.projeto.tasks.repository;

import org.springframework.data.repository.CrudRepository;

import com.projeto.tasks.entidades.Task;


public interface TaskRepository extends CrudRepository<Task, Long> {

}
