package com.taskmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.taskmanagement.model.Task;
import com.taskmanagement.model.User;
import com.taskmanagement.service.TaskService;
import com.taskmanagement.service.UserService;

@Controller
public class TaskController {

	@Autowired
	private UserService userService;
	@Autowired
	private TaskService taskService;

	@GetMapping({ "/", "/login" })
	public String login() {
		return "login";
	}

	@GetMapping("/register")
	public String register() {
		return "register";
	}

	@PostMapping("/register")
	public String registerUser(@RequestParam String username, @RequestParam String password,
			@RequestParam String email) {
		User user = new User(username, password, email);
		userService.saveUser(user);
		return "redirect:/login";
	}

	@GetMapping("/home")
	public String home(Authentication authentication, Model model) {
		if (authentication == null || authentication.getName() == null) {
			return "redirect:/login";
		}

		String username = authentication.getName();
		User user = userService.findUserByUsername(username);

		model.addAttribute("tasks", taskService.findByUserId(user.getId()));
		return "home";
	}

	@PostMapping("/add-task")
	public String addTask(@RequestParam String title, @RequestParam String description, @RequestParam String status,
			Authentication auth) {
		User user = userService.findUserByUsername(auth.getName());
		Task task = new Task(title, description, status, user);
		taskService.save(task);
		return "redirect:/home";
	}

	@GetMapping("/edit-task/{id}")
	public String editForm(@PathVariable Long id, Model model) {
		model.addAttribute("task", taskService.findById(id));
		return "edit-task";
	}

	@PostMapping("/edit-task/{id}")
	public String editTask(@PathVariable Long id, @RequestParam String title, @RequestParam String description,
			@RequestParam String status) {
		Task task = taskService.findById(id);
		task.setTitle(title);
		task.setDescription(description);
		task.setStatus(status);
		taskService.save(task);
		return "redirect:/home";
	}

	@PostMapping("/delete-task")
	public String delete(@RequestParam Long taskId) {
		taskService.delete(taskId);
		return "redirect:/home";
	}
}