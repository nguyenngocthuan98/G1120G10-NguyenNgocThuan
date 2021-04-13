package com.exercise_blog_ajax.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "blog")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    @Column(columnDefinition = "datetime")
    private String dateCreated;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "category", nullable = false, referencedColumnName = "category_id")
    private Category category;

    private String content;
    private String authorName;
    private String description;

    public Blog() {
    }

    public Blog(Integer id, String title, String dateCreated, Category category, String content, String authorName, String description) {
        this.id = id;
        this.title = title;
        this.dateCreated = dateCreated;
        this.category = category;
        this.content = content;
        this.authorName = authorName;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
