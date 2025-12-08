package com.taskmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taskmanagement.model.Task;
import com.taskmanagement.repository.TaskRepository;

@Service
public class TaskService {

	@Autowired
	private TaskRepository taskRepository;

	public List<Task> findByUserId(Long userId) {
		return taskRepository.findByUserId(userId);
	}

	public Task save(Task task) {
		return taskRepository.save(task);
	}

	public void delete(Long taskId) {
		taskRepository.deleteById(taskId);
	}

	public Task findById(Long taskId) {
		return taskRepository.findById(taskId).orElse(null);
	}
}
