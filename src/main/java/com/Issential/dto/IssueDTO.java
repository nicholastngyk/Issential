package com.Issential.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class IssueDTO {
    private Long id;

    private String title;

    private String description;

    private LocalDate dueDate;

    private UserDTO asignee;
}
