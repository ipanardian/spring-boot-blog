package com.ardian.blogs.services;

import java.util.List;

import com.ardian.blogs.common.dto.request.DeleteDTO;
import com.ardian.blogs.common.dto.request.PostAddRequest;
import com.ardian.blogs.common.dto.response.BaseResponse;
import com.ardian.blogs.common.dto.PostDTO;
import com.ardian.blogs.models.Post;

public interface PostServices {

    BaseResponse<List<PostDTO>> findAll();
    BaseResponse<List<PostDTO>> findPostByCategoriesId(Integer category_id);
    BaseResponse<List<PostDTO>> findByTitle(String title);
    BaseResponse<PostDTO> save(PostAddRequest request);
    BaseResponse<PostDTO> delete(DeleteDTO request);
}