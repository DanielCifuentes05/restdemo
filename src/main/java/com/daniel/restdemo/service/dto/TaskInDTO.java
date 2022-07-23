package com.daniel.restdemo.service.dto;

import com.daniel.restdemo.persistence.entity.TaskStatus;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TaskInDTO {

    private String title;
    private String description;
    private LocalDateTime eta;

}
