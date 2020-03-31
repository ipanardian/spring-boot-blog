package com.ardian.blogs.common.dto.request;

import java.util.Date;

import com.ardian.blogs.models.Author;
import com.ardian.blogs.models.Category;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class PostAddRequest {

    private Integer id;
    private Author author;
    private Category category;
    private String title;
    private String content;
}