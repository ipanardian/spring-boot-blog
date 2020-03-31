package com.ardian.blogs.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.util.Set;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(exclude = "posts")
@Entity
@Table(name="categories")  
public class Category extends BaseModel {

    private static final long serialVersionUID = 2469801940521808446L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "categories_name", nullable = false)
    @NotEmpty(message = "* Please enter category name.")
    private String categories_name;
    
    // @OneToMany(targetEntity = Post.class, mappedBy = "category", fetch = FetchType.LAZY)
    // @JsonIgnore
    // @JsonManagedReference
    // private Set<Post> posts;
}