package blog;

import blog.command.BlogCommands;
import blog.exception.ModelNotFoundException;
import blog.model.User;
import blog.model.UserType;
import blog.storage.BlogStorage;

import java.util.Scanner;

public class BlogMain implements BlogCommands {
    public static final Scanner SCANNER = new Scanner(System.in);
    public static final BlogStorage BLOG_STORAGE = new BlogStorage();
    public static User currentUser = null;

    public static void main(String[] args) {
        boolean isRun = true;
        while (isRun) {
            BLOG_STORAGE.printAllPosts();
            BlogCommands.printMainCommands();
            int command;
            try {
                command = Integer.parseInt(SCANNER.nextLine());
            } catch (NumberFormatException e) {
                command = -1;
            }
            switch (command) {
                case EXIT:
                    isRun = false;
                    break;
                case LOGIN:
                    login();
                    break;
                case REGISTER:
                    register();
                    break;
                case POST_BY_CATEGORY:
                    printPostByCategory();
                    break;
                case POST_BY_USER:
                    printPostByUser();
                    break;
                default:
                    System.out.println("Invalid Command");
            }
        }
    }

    private static void printPostByUser() {
    }

    private static void printPostByCategory() {
    }

    private static void register() {
        System.out.println("Please Input name, surname,email,password");
        try {


            String userStr = SCANNER.nextLine();
            String[] userData = userStr.split(",");
            User user = new User();
            user.setName(userData[0]);
            user.setSurnaname(userData[1]);
            user.setEmail(userData[2]);
            user.setPassword(userData[3]);
            user.setUserType(UserType.USER);
            try {
                BLOG_STORAGE.getUserByEmail(userData[2]);
                System.out.println("Email already exist");
            } catch (ModelNotFoundException e) {
                BLOG_STORAGE.add(user);
                System.out.println("Thank you!");
            }


        } catch (Exception e) {
            System.out.println("please input valid data");
            register();

        }
    }

    private static void login() {
        System.out.println("please input email,password");
        String userStr = SCANNER.nextLine();
        String[] userData = userStr.split(",");
        try {
            currentUser = BLOG_STORAGE.getUserByEmailAndPassword(userData[0], userData[2]);
            if (currentUser.getUserType() == UserType.ADMIN) {
                loginAdmin();
            } else {
                loginUser();
            }
        } catch (ModelNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void loginUser() {
        boolean isRun = true;
        while (isRun) {
            BlogCommands.printUserCommands();
            int command;
            try {
                command = Integer.parseInt(SCANNER.nextLine());
            } catch (NumberFormatException e) {
                command = -1;
            }
            switch (command) {
                case LOGOUT:
                    isRun = false;
                    break;
                case ADD_POST:
                    addPost();
                    break;
                case DELETE_MY_POST:
                    deleteMyPost();
                    break;
                default:
                    System.out.println("Invalid command");
            }
        }
    }

    private static void deleteMyPost() {
        BLOG_STORAGE.printPostsByUser(currentUser);
        System.out.println("please select by title");
        String title = SCANNER.nextLine();
        try {
            BLOG_STORAGE.getPostBytitle(title);
        } catch (ModelNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void addPost() {
    }

    private static void loginAdmin() {
        boolean isRun = true;
        while (isRun) {
            BlogCommands.printAdminCommands();
            int command;
            try {
                command = Integer.parseInt(SCANNER.nextLine());
            } catch (NumberFormatException e) {
                command = -1;
            }
            switch (command) {
                case LOGOUT:
                    isRun = false;
                    break;
                case DELETE_USER:
                    deleteUser();
                    break;
                case DELETE_POST:
                    deletePost();
                    break;
                default:
                    System.out.println("Invalid command");

            }
        }

    }

    private static void deletePost() {
    }

    private static void deleteUser() {
    }
}