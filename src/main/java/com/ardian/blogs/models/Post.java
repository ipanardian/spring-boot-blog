package com.ardian.blogs.models;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Data
@Entity
@Table(name="posts")  
public class Post extends BaseModel {

    private static final long serialVersionUID = 4287668475097968581L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    @JsonManagedReference
    @JsonIgnoreProperties(ignoreUnknown = true, value =  {"hibernateLazyInitializer", "password", "posts"})
    private Author author;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categories_id")
    @JsonManagedReference
    @JsonIgnoreProperties("hibernateLazyInitializer")
    private Category category;

    @Column(name = "title", nullable = false)
    @NotEmpty(message = "* Please enter title.")
    private String title;

    @Column(name = "content")
    private String content;

    @OneToMany(targetEntity = Comment.class, mappedBy = "post", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Comment> comments;

    @OneToMany(targetEntity = Tag.class, mappedBy = "post", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Tag> tags;
    
}