package blog.command;

public interface BlogCommands {

    //main commands
    int EXIT = 0;
    int LOGIN = 1;
    int REGISTER = 2;
    int POST_BY_CATEGORY = 3;
    int POST_BY_USER = 4;


     //admin's commands

    int LOGOUT = 0;
    int DELETE_USER = 1;
    int DELETE_POST = 2;

    //user's commands
    int ADD_POST = 1;
    int DELETE_MY_POST = 2;

    static void printMainCommands(){
        System.out.println("Please input    " + EXIT + "for EXIT");
        System.out.println("Please input    " + LOGIN + "for LOGIN");
        System.out.println("Please input    " + REGISTER + "for REGISTER");
        System.out.println("Please input    " + POST_BY_CATEGORY + "for PRINT_BY_CATEGORY");
        System.out.println("Please input    " + POST_BY_USER+ "for PRINT_BY_USER");
    }
    static void printUserCommands(){
        System.out.println("Please input    " + LOGOUT + "for LOGOUT");
        System.out.println("Please input    " + ADD_POST + "for ADD_POST");
        System.out.println("Please input    " + DELETE_MY_POST + "DELETE_MY_POST ");

    }
    static void printAdminCommands(){
        System.out.println("Please input    " + LOGOUT + "for LOGOUT");
        System.out.println("Please input    " + DELETE_USER + "for ADD_POST");
        System.out.println("Please input    " + DELETE_POST + " for DELETE_POST ");

    }
}
