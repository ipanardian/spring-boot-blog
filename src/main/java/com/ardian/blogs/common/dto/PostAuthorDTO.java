package com.ardian.blogs.common.dto;

import lombok.Data;

@Data
public class PostAuthorDTO {
    private Integer id;
    private String firstname;
    private String lastname;
    private String username;
}