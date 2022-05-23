package com.codeup.springblog.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="tags")
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length=50)
    private String name;

    @ManyToMany(mappedBy = "postTags")
    @JsonManagedReference
    private List<Post> tagsPost;




//    constructors
    public Tag(){};

    public Tag(long id, String name) {
        this.id = id;
        this.name = name;
    }






//  getters & setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Post> getTagsPost() {
        return tagsPost;
    }

    public void setTagsPost(List<Post> tagsPost) {
        this.tagsPost = tagsPost;
    }
}
