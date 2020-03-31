package com.ardian.blogs.controllers;

import java.util.List;

import com.ardian.blogs.common.dto.request.DeleteDTO;
import com.ardian.blogs.common.dto.request.PostAddRequest;
import com.ardian.blogs.common.dto.response.BaseResponse;
import com.ardian.blogs.common.dto.PostDTO;
import com.ardian.blogs.services.PostServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class PostController {

    @Autowired
    private PostServices postServices;
    
    @GetMapping("/posts")
    public BaseResponse<List<PostDTO>> list(
        @RequestParam(required = false, name = "categoryId") Integer category_id,
        @RequestParam(required = false, name = "title") String title) {
        
        // Filtering
        if (category_id != null) {
            return postServices.findPostByCategoriesId(category_id);
        }
        if (title != null) {
            // TODO validate length
            return postServices.findByTitle(title);
        }

        return postServices.findAll();
    }

    @PostMapping("/posts")
    public BaseResponse<PostDTO> add(@RequestBody PostAddRequest request) {
        return postServices.save(request);
    }

    @PutMapping("/posts")
    public BaseResponse<PostDTO> update(@RequestBody PostAddRequest request) {
        return postServices.save(request);
    }

    @DeleteMapping("/posts")
    public BaseResponse<PostDTO> delete(@RequestBody DeleteDTO request) {
        return postServices.delete(request);
    }
}