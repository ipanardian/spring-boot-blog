package com.ardian.blogs.models;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Data
@Entity
@Table(name="author")  
public class Author extends BaseModel {

    private static final long serialVersionUID = 8337828192639703776L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "firstname", nullable = false)
    // @NotEmpty(message = "* Please enter firstname.")
    private String firstname;
    
    @Column(name = "lastname")
    // @NotEmpty(message = "* Please enter lastname.")
    private String lastname;

    @Column(name = "username", nullable = false)
    // @NotEmpty(message = "* Please enter username.")
    private String username;

    @Column(name = "password", nullable = false)
    private String password;
    
    // @OneToMany(targetEntity = Post.class, mappedBy = "author", fetch = FetchType.LAZY)
    // @JsonManagedReference
    // @JsonIgnore
    // private Set<Post> posts;
}