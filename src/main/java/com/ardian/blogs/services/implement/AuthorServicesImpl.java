package com.ardian.blogs.services.implement;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import com.ardian.blogs.common.dto.request.AuthorSaveDTO;
import com.ardian.blogs.common.dto.request.DeleteDTO;
import com.ardian.blogs.common.dto.response.BaseResponse;
import com.ardian.blogs.common.dto.AuthorDTO;
import com.ardian.blogs.models.Author;
import com.ardian.blogs.repositories.AuthorRepository;
import com.ardian.blogs.services.*;
import com.ardian.blogs.utils.ObjectMapperUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorServicesImpl implements AuthorServices {

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public BaseResponse<List<AuthorDTO>> findAll() {
        List<AuthorDTO> authors = ObjectMapperUtils.mapAll(
            authorRepository.findAll(), AuthorDTO.class);

        return BaseResponse.ok(authors);
    }

    @Override
    public BaseResponse<List<AuthorDTO>> findByUsername(String username) {
        List<AuthorDTO> authors = ObjectMapperUtils.mapAll(
            authorRepository.findByUsername(username), AuthorDTO.class);
        
        return BaseResponse.ok(authors);
    }

	@Override
	public BaseResponse<AuthorDTO> save(AuthorSaveDTO request) {
        try {
            Boolean isUpdate = false;
            if (request.getId() != null) {
                isUpdate = true;
            }

            Author author = new Author();
            
            if (isUpdate) {
                author = authorRepository.getOne(request.getId());
                if (author.getId() == null) {
                    throw new EntityNotFoundException();
                }
            }
            
            author = ObjectMapperUtils.map(request, Author.class);
            Author authorSaved = authorRepository.save(author);

            if (!isUpdate) {
                author = authorRepository.getOne(authorSaved.getId());
            }

            AuthorDTO newAuthor = ObjectMapperUtils.map(author, AuthorDTO.class);

            return BaseResponse.ok(newAuthor); 
        } catch (Exception e) {
            e.printStackTrace();
            return BaseResponse.error("500", e.getMessage());
        }
        
	}

    public BaseResponse<AuthorDTO> delete(DeleteDTO request) {
        try {
            Author author = authorRepository.getOne(request.getId());
            authorRepository.delete(author);

            AuthorDTO deletedAuthor = ObjectMapperUtils.map(author, AuthorDTO.class);

            return BaseResponse.ok(deletedAuthor);
        } catch (Exception e) {
            e.printStackTrace();
            return BaseResponse.error("500", "Failed to delete author.");
        }
    }
}