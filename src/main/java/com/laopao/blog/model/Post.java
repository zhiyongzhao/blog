package com.laopao.blog.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

/**
 * @Description: //
 * @Title: Post
 * @Package com.laopao.blog.model
 * @Author: zhaozhiyong
 * @Copyright 版权归**企业（或个人）所有
 * @CreateTime: 2023/4/27 17:32
 */
    @Entity
    @Table(name = "posts")
    public class Post {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(nullable = false)
        private String title;

        @Column(nullable = false, columnDefinition = "TEXT")
        private String content;

        @Column(nullable = false, unique = true)
        private String slug;

        @Column(name = "date_created")
        private LocalDateTime dateCreated;

        @Column(name = "date_updated")
        private LocalDateTime dateUpdated;

        public Post(Long id, String title, String content, String slug, LocalDateTime dateCreated, LocalDateTime dateUpdated) {
            this.id = id;
            this.title = title;
            this.content = content;
            this.slug = slug;
            this.dateCreated = dateCreated;
            this.dateUpdated = dateUpdated;
        }

        public Post() {
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getSlug() {
            return slug;
        }

        public void setSlug(String slug) {
            this.slug = slug;
        }

        public LocalDateTime getDateCreated() {
            return dateCreated;
        }

        public void setDateCreated(LocalDateTime dateCreated) {
            this.dateCreated = dateCreated;
        }

        public LocalDateTime getDateUpdated() {
            return dateUpdated;
        }

        public void setDateUpdated(LocalDateTime dateUpdated) {
            this.dateUpdated = dateUpdated;
        }

        @Override
        public String toString() {
            return "Post{" +
                    "id=" + id +
                    ", title='" + title + '\'' +
                    ", content='" + content + '\'' +
                    ", slug='" + slug + '\'' +
                    ", dateCreated=" + dateCreated +
                    ", dateUpdated=" + dateUpdated +
                    '}';
        }
}
