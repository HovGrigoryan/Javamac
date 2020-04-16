package blog;

import blog.command.BlogCommands;
import blog.model.User;
import blog.model.UserType;
import blog.storage.BlogStorage;

import java.util.Scanner;

public class BlogMain implements BlogCommands {
    public static final Scanner SCANNER = new Scanner(System.in);
    public static final BlogStorage BLOG_STORAGE = new BlogStorage();

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
                    System.out.printf("Invalid Command");
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
            BLOG_STORAGE.add(user);
            System.out.printf("Thank you!");
        } catch (Exception e) {
            System.out.printf("please input valid data");
            register();

        }
    }

    private static void login() {
        System.out.printf("please input email,password");
        String userStr = SCANNER.nextLine();
        String[] userData = userStr.split(",");
        BLOG_STORAGE
    }
}
