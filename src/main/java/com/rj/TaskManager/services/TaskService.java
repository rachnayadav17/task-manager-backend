package com.rj.TaskManager.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.rj.TaskManager.entity.Task;
import com.rj.TaskManager.repo.TaskRepo;

@Service
public class TaskService {

	@Autowired
	private TaskRepo taskRepo;

	public List<Task> getAllTasks() {
		return taskRepo.findAll();
	}

	public Task createTask(@RequestBody Task task) {
		return taskRepo.save(task);
	}

	public Task updateTaskStatus(@PathVariable Long id, @RequestBody Task task) {
		Task dbTask = taskRepo.findById(id).orElseThrow(RuntimeException::new);
		dbTask.setCompleted(task.isCompleted());
		return taskRepo.save(dbTask);
	}

	public Task deleteTask(@PathVariable Long id) {
		Task dbTask = taskRepo.findById(id).orElseThrow(RuntimeException::new);
		taskRepo.delete(dbTask);
		return dbTask;
	}
}
