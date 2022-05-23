package com.codeup.springblog.models;

import javax.persistence.*;

@Entity
@Table(name="ads")
public class Ad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private long userId;
    @Column(nullable = false, length = 500)
    private String title;
    @Column(nullable = false, length = 999)
    private String description;
    @Column(nullable = false, length = 2)
    private long category;
    @Column(nullable = false, length = 500)
    private String photo;






//    constructors
    public Ad() {
    }

    public Ad(long userId, String title, String description, long category, String photo) {
        this.userId = userId;
        this.title = title;
        this.description = description;
        this.category = category;
        this.photo = photo;
    }



//    getters & setters

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public long getUserId() {
        return userId;
    }
    public void setUserId(long userId) {
        this.userId = userId;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public long getCategory() {
        return category;
    }
    public void setCategory(long category) {
        this.category = category;
    }
    public String getPhoto() {
        return photo;
    }
    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
