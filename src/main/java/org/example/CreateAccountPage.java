package org.example;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CreateAccountPage {
    private User[] users = new User[2];
    private int userCount = 0;

    public void displayCreateAccount(){
        System.out.println("Create your account here.\n");

        //get user email, password and name
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String name = input.next();
        System.out.println("Enter your email: ");
        String email = input.next();
        System.out.println("Enter your password: ");
        String password = input.next();

        if (!isValidInput(name, email, password)) {
            return;
        }

        User newUser = new User(email, password, name);
        users[userCount++] = newUser;

        //navigate to loginPage
        LoginPage login = new LoginPage();
        login.displayLogin();
    }
    public User[] getUsers(){
        return users;
    }

    private boolean isValidInput(String name, String email, String password){
        if (isEmailInUse(email)){
            System.out.println("Email already in use, please use a different email");
            return false;
        }
        if (isValidPassword(password)){
            System.out.println("Invalid password, please try again");
            return false;
        }
        return true;
    }

    private boolean isEmailInUse(String email){
        for (int i = 0; i < userCount; i++){
            if (users[i].getEmail().equals(email)){
                return true;
            }
        }
        return false;
    }

    private boolean isValidPassword(String password) {
        //check if password contains at least 8 characters, 1 uppercase letter, 1 lowercase letter and 1 digit
        Pattern pattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$");
        Matcher matcher = pattern.matcher(password);
        if(matcher.matches()){
            return true;
        }
        else{
            return false;
        }
    }
    public int getUserCount(){
        return userCount;
    }
}
