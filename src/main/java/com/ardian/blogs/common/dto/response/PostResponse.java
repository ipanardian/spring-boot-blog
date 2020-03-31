package com.ardian.blogs.common.dto.response;

import java.util.Date;

import com.ardian.blogs.models.Author;
import com.ardian.blogs.models.Category;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PostResponse {

    private Integer id;
    private PostAuthorResponse author;
    private PostCategoryResponse category;
    private String title;
    private String content;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss", timezone = "GMT+7")
    @JsonProperty("created_at")
    private Date createdAt;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss", timezone = "GMT+7")
    @JsonProperty("updated_at")
    private Date updatedAt;
}