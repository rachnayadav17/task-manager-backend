package com.rj.TaskManager.rest;

import com.rj.TaskManager.entity.Task;
import com.rj.TaskManager.repo.TaskRepo;
import com.rj.TaskManager.services.TaskService;

import jakarta.validation.Valid;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/task")
@CrossOrigin
public class TaskController {

	@Autowired
	private TaskService taskService;

	@GetMapping
	public List<Task> getTasks() {
		return taskService.getAllTasks();
	}

	@PostMapping
	public Task createTask(@Valid @RequestBody Task task) {
		return taskService.createTask(task);
	}

	@PutMapping("/{id}")
	public Task updateTaskStatus(@PathVariable Long id, @RequestBody Task task) {
		return taskService.updateTaskStatus(id, task);
	}

	@DeleteMapping("/{id}")
	public Task deleteTask(@PathVariable Long id) {
		return taskService.deleteTask(id);
	}

}
