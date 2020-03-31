package com.ardian.blogs.services;

import java.util.List;

import com.ardian.blogs.common.dto.request.AuthorSaveDTO;
import com.ardian.blogs.common.dto.request.DeleteDTO;
import com.ardian.blogs.common.dto.response.BaseResponse;
import com.ardian.blogs.common.dto.AuthorDTO;

public interface AuthorServices {

    BaseResponse<List<AuthorDTO>> findAll();
    BaseResponse<List<AuthorDTO>> findByUsername(String username);
    BaseResponse<AuthorDTO> save(AuthorSaveDTO request);
    BaseResponse<AuthorDTO> delete(DeleteDTO request);
}