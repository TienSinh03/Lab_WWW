package vn.edu.iuh.fit.backend.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "post")
public class Post implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "author_id", nullable = false)
    private User author;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private Post parent;

    @Column(name = "title", nullable = false, length = 75)
    private String title;

    @Column(name = "meta_title", length = 100)
    private String metaTitle;

    @Lob
    @Column(name = "summary")
    private String summary;

    @Column(name = "published", nullable = false)
    private Boolean published = false;

    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    @Column(name = "updated_at")
    private Instant updatedAt;

    @Column(name = "published_at")
    private Instant publishedAt;

    @Lob
    @Column(name = "content",columnDefinition = "TEXT")
    private String content;

    @OneToMany(mappedBy = "parent")
    private Set<Post> posts = new LinkedHashSet<>();

    @OneToMany(mappedBy = "post")
    private Set<PostComment> postComments = new LinkedHashSet<>();

    public Post(Long id, User author, Post parent, String title, String metaTitle, String summary, Boolean published, Instant createdAt, Instant updatedAt, Instant publishedAt, String content) {
        this.id = id;
        this.author = author;
        this.parent = parent;
        this.title = title;
        this.metaTitle = metaTitle;
        this.summary = summary;
        this.published = published;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.publishedAt = publishedAt;
        this.content = content;
    }

    public Post(String title, String metaTitle, String summary, Boolean published, Instant createdAt, Instant updatedAt, Instant publishedAt) {
        this.title = title;
        this.metaTitle = metaTitle;
        this.summary = summary;
        this.published = published;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.publishedAt = publishedAt;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", author=" + author +
                ", parent=" + parent +
                ", title='" + title + '\'' +
                ", metaTitle='" + metaTitle + '\'' +
                ", summary='" + summary + '\'' +
                ", published=" + published +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", publishedAt=" + publishedAt +
                ", content='" + content + '\'' +
                '}';
    }
}