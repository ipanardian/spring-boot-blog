package com.ardian.blogs.services.implement;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.function.IntToLongFunction;

import com.ardian.blogs.common.dto.request.DeleteDTO;
import com.ardian.blogs.common.dto.request.PostAddRequest;
import com.ardian.blogs.common.dto.response.BaseResponse;
import com.ardian.blogs.common.dto.response.PostAuthorResponse;
import com.ardian.blogs.common.dto.response.PostCategoryResponse;
import com.ardian.blogs.common.dto.PostDTO;
import com.ardian.blogs.models.Post;
import com.ardian.blogs.repositories.PostRepository;
import com.ardian.blogs.services.*;
import com.ardian.blogs.utils.ObjectMapperUtils;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.stereotype.Service;

@Service
public class PostServicesImpl implements PostServices {

    @Autowired
    private PostRepository postRepository;

    @Override
    public BaseResponse<List<PostDTO>> findAll() {
        List<PostDTO> postsDTO = ObjectMapperUtils.mapAll(
            postRepository.findAll(), PostDTO.class);

        return BaseResponse.ok(postsDTO);
    }

    @Override
    public BaseResponse<List<PostDTO>> findPostByCategoriesId(Integer category_id) {
        List<PostDTO> posts = ObjectMapperUtils.mapAll(
            postRepository.findByCategoriesId(category_id), PostDTO.class);

        return BaseResponse.ok(posts);
    }

    @Override
    public BaseResponse<List<PostDTO>> findByTitle(String title) {
        List<PostDTO> posts = ObjectMapperUtils.mapAll(
            postRepository.findByTitle(title), PostDTO.class);
        
        return BaseResponse.ok(posts);
    }

	@Override
	public BaseResponse<PostDTO> save(PostAddRequest request) {
        try {
            Post post = new Post();

            // For update
            if (request.getId() != null) {
                post = postRepository.getOne(request.getId());
            }

            post.setTitle(request.getTitle());
            post.setContent(request.getContent());
            post.setCategory(request.getCategory());
            post.setAuthor(request.getAuthor());
            post.setCreatedAt(new Date());
            post.setUpdatedAt(new Date());

            Post postSaved = postRepository.save(post);

            // If new post get the data
            if (request.getId() == null) {
                post = postRepository.getOne(postSaved.getId());
            }

            PostDTO newPost = ObjectMapperUtils.map(post, PostDTO.class);

            return BaseResponse.ok(newPost); 
        } catch (Exception e) {
            e.printStackTrace();
            return BaseResponse.error("500", "Failed to add new post.");
        }
        
	}

    public BaseResponse<PostDTO> delete(DeleteDTO request) {
        try {
            Post post = postRepository.getOne(request.getId());
            postRepository.delete(post);

            PostDTO deletedPost = ObjectMapperUtils.map(post, PostDTO.class);

            return BaseResponse.ok(deletedPost);
        } catch (Exception e) {
            e.printStackTrace();
            return BaseResponse.error("500", "Failed to delete post.");
        }
    }
}