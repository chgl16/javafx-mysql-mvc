package model;

public class User {

    private static String username;
    private static String password;

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        User.username = username;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        User.password = password;
    }

    public User() {

    }


    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

}
