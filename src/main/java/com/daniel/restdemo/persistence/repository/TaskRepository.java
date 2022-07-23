package com.daniel.restdemo.persistence.repository;

import com.daniel.restdemo.persistence.entity.Task;
import com.daniel.restdemo.persistence.entity.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    public List<Task> findAllByTaskStatus(TaskStatus status);
}
