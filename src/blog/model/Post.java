package blog.model;

import java.util.Date;
import java.util.Objects;

public class Post {
    private String title;
    private String text;
    private Date createdDate;
    private PostCategory postCategory;
    private User user;

    public Post(String title, String text, Date createdDate, PostCategory postCategory, User user) {
        this.title = title;
        this.text = text;
        this.createdDate = createdDate;
        this.postCategory = postCategory;
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public PostCategory getPostCategory() {
        return postCategory;
    }

    public void setPostCategory(PostCategory postCategory) {
        this.postCategory = postCategory;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Objects.equals(title, post.title) &&
                Objects.equals(text, post.text) &&
                Objects.equals(createdDate, post.createdDate) &&
                postCategory == post.postCategory &&
                Objects.equals(user, post.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, text, createdDate, postCategory, user);
    }

    @Override
    public String toString() {
        return "Post{" +
                "title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", createdDate=" + createdDate +
                ", postCategory=" + postCategory +
                ", user=" + user +
                '}';
    }
}
