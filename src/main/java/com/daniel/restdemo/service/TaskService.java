package com.daniel.restdemo.service;

import com.daniel.restdemo.exceptions.TaskExceptions;
import com.daniel.restdemo.mapper.TaskInDTOToTask;
import com.daniel.restdemo.persistence.entity.Task;
import com.daniel.restdemo.persistence.entity.TaskStatus;
import com.daniel.restdemo.persistence.repository.TaskRepository;
import com.daniel.restdemo.service.dto.TaskInDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository repository;

    @Autowired
    private TaskInDTOToTask mapper;

    public Task createTask(TaskInDTO taskInDTO){
        Task task = mapper.map(taskInDTO);
        return this.repository.save(task);
    }

    public List<Task> findAll(){
        return this.repository.findAll();
    }

    public List<Task> findAllByTaskStatus (TaskStatus status){
        return this.repository.findAllByTaskStatus(status);
    }

    @Transactional
    public void updateTaskAsFinished(Long id){

        if(this.repository.findById(id).isEmpty()){
            throw new TaskExceptions("Task not found", HttpStatus.NOT_FOUND);
        }

        this.repository.markTaskAsFinished(id);
    }

    public void deleteTask(Long id){

        if(this.repository.findById(id).isEmpty()){
            throw new TaskExceptions("Task not found", HttpStatus.NOT_FOUND);
        }

        this.repository.deleteById(id);
    }

}
