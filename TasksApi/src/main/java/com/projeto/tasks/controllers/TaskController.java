package com.projeto.tasks.controllers;

import java.util.List;
import java.util.Optional;

import org.apache.catalina.startup.ClassLoaderFactory.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.tasks.entidades.Task;
import com.projeto.tasks.repository.TaskRepository;

@RestController
@RequestMapping("/")
public class TaskController {
	@Autowired
	TaskRepository repo;

	@GetMapping("/task")
	public ResponseEntity<List<Task>> getTasks() {
		List<Task> tasks = (List<Task>) repo.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(tasks);
	}
	@GetMapping("/task/{idtask}")
	public ResponseEntity<Task> getTaskById(@PathVariable("idtask") Long idtask) {
		Optional<Task> task = repo.findById(idtask);
		return 	task.isPresent()
				? ResponseEntity.status(HttpStatus.OK).body(task.get())
			    : ResponseEntity.notFound().build();
	}
	@PostMapping("/task")
	public ResponseEntity<Task> saveTask(@RequestBody Task task) {
		Task newTask = repo.save(task);
		return ResponseEntity.status(HttpStatus.CREATED).body(newTask);
	}
	@DeleteMapping("/task/{idtask}")
	public ResponseEntity<String> deleteTask(@PathVariable("idtask") Long idtask) {
		repo.deleteById(idtask);
		return ResponseEntity.status(HttpStatus.OK).body("Deletado com sucesso");
	}
	@PutMapping("/task/{idtask}")
	public ResponseEntity<Task> updateTask(@PathVariable("idtask") Long idtask,
			@RequestBody Task task) {
		task.setId(idtask);
		return ResponseEntity.ok(repo.save(task));
	};
	@PatchMapping("/task/{idtask}/status/{status}")
	public ResponseEntity<Task> updateTask(@PathVariable("idtask") Long idtask,
			@PathVariable("status") Boolean status) {
		Task newTask = repo.findById(idtask).get();
		newTask.setStatus(status);
		repo.save(newTask);
		
		return ResponseEntity.status(HttpStatus.OK).body(newTask);
	
	};
	
	

}