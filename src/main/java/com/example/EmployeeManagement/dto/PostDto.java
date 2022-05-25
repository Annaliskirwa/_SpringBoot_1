package com.example.EmployeeManagement.dto;

import lombok.Data;

@Data
public class PostDto {
    private long id;
    private String title;
    private String description;
    private String content;

}
//in dto, only include the files needed by the client.
//Almost similar to model and entity, above is the difference