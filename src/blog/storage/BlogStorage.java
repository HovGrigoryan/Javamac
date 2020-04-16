package blog.storage;

import blog.exception.ModelNotFoundException;
import blog.model.Post;
import blog.model.PostCategory;
import blog.model.User;
import javafx.geometry.Pos;

public class BlogStorage {
    private User[] users = new User[16];
    private Post[] posts = new Post[16];
    private int userSize = 0;
    private int postSize = 0;


    public void add(User user) {
        users[userSize++] = user;
    }

    public void add(Post post) {
        posts[postSize++] = post;
    }

    private void ExtendUsers() {
        User tmp[] = new User[users.length + 10];
        System.arraycopy(users, 0, tmp, 0, users.length);
    }

    private void ExtendPosts() {
        Post tmp[] = new Post[posts.length + 10];
        System.arraycopy(posts, 0, tmp, 0, posts.length);
    }

    public User getUserByEmailAndPassword(String email, String password) throws ModelNotFoundException {
        for (int i = 0; i < userSize; i++) {
            User user = users[i];
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                return user;
            }
        }
        throw new ModelNotFoundException(String.format("User with %s email and % password does not exist", email, password));
    }

    public void printAllPosts() {
        for (int i = 0; i < postSize; i++) {
            printPost(posts[i]);
        }
    }

    public void printPostsByCategory(PostCategory category) {
        for (int i = 0; i < postSize; i++) {
            Post post = posts[i];
            if (post.getPostCategory() == category) {
                printPost(post);
            }

        }
    }

    public void printPostsByUser(User user) {
        for (int i = 0; i < postSize; i++) {
            Post post = posts[i];
            if (post.getUser().equals(user)) {
                printPost(post);

            }

        }
    }

    private int getUserIndex(User user) throws ModelNotFoundException {
        for (int i = 0; i < userSize; i++) {
            if (users[i].equals(user)) {
                return i;
            }
        }
        throw new ModelNotFoundException(String.format("User with %s email does not exist", user.getEmail()));
    }

    private int getPostIndex(Post post) throws ModelNotFoundException {
        for (int i = 0; i < postSize; i++) {
            if (users[i].equals(post)) {
                return i;
            }
        }
        throw new ModelNotFoundException(String.format("Post with %s title does not exist", post.getTitle()));
    }

    public void deleteUser(User user) throws ModelNotFoundException {
        int userIndex = getUserIndex(user);
//        for (int i = userIndex +1; i <userSize ; i++) {
//            users[i - 1] = users[i];
//        }
//        userSize--;
        if (userSize - userIndex + 1 >= 0)
            System.arraycopy(users, userIndex + 1, users, userIndex + 1 - 1, userSize - userIndex + 1);
        userSize--;
    }


    public void deletePost(Post post) throws ModelNotFoundException {
        int postIndex = getPostIndex(post);
//        for (int i = postIndex +1; i <postSize ; i++) {
//            posts[i - 1] = posts[i];
//        }
//        postSize--;
        if (postSize - postIndex + 1 >= 0)
            System.arraycopy(posts, postIndex + 1, posts, postIndex + 1 - 1, postSize - postIndex + 1);
        postSize--;

    }

    private void printPost(Post post) {
        System.out.printf(post.getTitle());
        System.out.printf("posted: " + post.getCreatedDate());
        System.out.printf("by: " + post.getUser().getName() + post.getUser().getSurnaname());
        System.out.printf(post.getText());
        System.out.printf("---------------------------");
    }

    public Post getPostBytitle(String title) throws ModelNotFoundException {
        for (int i = 0; i < postSize; i++) {
            if (title.equals(posts[i].getTitle())) {
                return posts[i];
            }
        }
        throw new ModelNotFoundException(String.format("Post with %s title does not exist", title));
    }

    public User getUserByEmail(String email) throws ModelNotFoundException {
        for (int i = 0; i < userSize; i++) {
            User user = users[i];
            if (user.getEmail().equals(email) ) {
                return user;
            }
        }
        throw new ModelNotFoundException(String.format("User with %s email  does not exist", email));
    }
}
