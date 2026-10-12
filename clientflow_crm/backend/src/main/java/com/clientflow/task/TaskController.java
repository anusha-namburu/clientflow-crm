package com.clientflow.task;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    private final TaskRepository repository;
    public TaskController(TaskRepository repository) { this.repository = repository; }

    @GetMapping
    public List<FollowUpTask> all() { return repository.findAll(); }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public FollowUpTask create(@Valid @RequestBody FollowUpTask task) {
        task.setId(null);
        if (task.getStatus() == null || task.getStatus().isBlank()) task.setStatus("Pending");
        if (task.getPriority() == null || task.getPriority().isBlank()) task.setPriority("Medium");
        return repository.save(task);
    }
}
