package com.task.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.task.spring.model.TaskManager;
import com.task.spring.service.TaskManagerService;

@RestController
public class TaskManagerController {

	@Autowired
	private TaskManagerService  taskManagerService;
	
	@GetMapping("/api/taskmanager")
	public ResponseEntity<List<TaskManager>> list(){
		List<TaskManager> list =  taskManagerService.list();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/api/taskmanager/{id}")
	public ResponseEntity<TaskManager> get(@PathVariable("id") int id){
		TaskManager tb =  taskManagerService.get(id);
		return ResponseEntity.ok().body(tb);
	}
	
	
	@PostMapping("/api/task")
	
	public ResponseEntity<?> save(@RequestBody TaskManager tb){
		int id = (int) taskManagerService.save(tb);
		return ResponseEntity.ok().body("Task Id" + id);
	}
	
@PutMapping("/api/task/{id}")
	
	public ResponseEntity<?> update(@PathVariable("id") int id,@RequestBody TaskManager tb){
		  taskManagerService.update(id, tb);
		return ResponseEntity.ok().body("Updated Task Id") ;
	}
	

@DeleteMapping("/api/task/{id}")
	
	public ResponseEntity<?> delete(@PathVariable("id") int id){
		  taskManagerService.delete(id);
		return ResponseEntity.ok().body("Deleted Task Id") ;
	}
	
}
