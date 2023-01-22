package org.example;

import java.util.Scanner;

public class LoginPage {
    private CreateAccountPage createAccountPage = new CreateAccountPage();

    public void displayLogin(){
        Scanner input = new Scanner(System.in);
        System.out.println("Login here\n\nEnter your email: ");
        String email = input.next();

        System.out.println("Enter your password: ");
        String password = input.next();

        if (isValidCredentials(email, password)){
            System.out.println("Login Successful");
        }
        //proceed to home page
            else {
            System.out.println("Invalid email or password, please try again");
            displayLogin();
        }
    }

    private boolean isValidCredentials(String email, String password){
        User[] users = createAccountPage.getUsers();
        if(createAccountPage.getUserCount() == 0) return false;
        for (User user : users){
            if(user == null) continue;
            if (user.getEmail().equals(email) && user.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }
}
