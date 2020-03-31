package com.ardian.blogs.controllers;

import java.util.List;

import com.ardian.blogs.common.dto.request.AuthorSaveDTO;
import com.ardian.blogs.common.dto.request.DeleteDTO;
import com.ardian.blogs.common.dto.request.PostAddRequest;
import com.ardian.blogs.common.dto.response.BaseResponse;
import com.ardian.blogs.common.dto.AuthorDTO;
import com.ardian.blogs.common.dto.PostDTO;
import com.ardian.blogs.services.AuthorServices;

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
public class AuthorController {

    @Autowired
    private AuthorServices authorServices;
    
    @GetMapping("/authors")
    public BaseResponse<List<AuthorDTO>> list(
        @RequestParam(required = false, name = "username") String username) {
        
        // Filtering
        if (username != null) {
            // TODO validate length
            return authorServices.findByUsername(username);
        }

        return authorServices.findAll();
    }

    @PostMapping("/authors")
    public BaseResponse<AuthorDTO> add(@RequestBody AuthorSaveDTO request) {
        return authorServices.save(request);
    }

    @PutMapping("/authors")
    public BaseResponse<AuthorDTO> update(@RequestBody AuthorSaveDTO request) {
        return authorServices.save(request);
    }

    @DeleteMapping("/authors")
    public BaseResponse<AuthorDTO> delete(@RequestBody DeleteDTO request) {
        return authorServices.delete(request);
    }
}