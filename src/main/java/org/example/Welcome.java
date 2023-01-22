package org.example;

import java.util.Scanner;

public class Welcome {
    private CreateAccountPage createAccountPage = new CreateAccountPage();

    public static void main(String[] args) {
        Welcome welcome = new Welcome();
        welcome.showWelcomePrompt();
    }
    private void showWelcomePrompt(){
        System.out.println("Welcome, please Create an account or Log in\\nType 'Create' to create an account or 'Login' to log in: ");
        Scanner input = new Scanner(System.in);
        String nav = input.next();
        navigateToPage(nav);
    }

    private void navigateToPage(String nav){
        if (nav.equals("Login")){
            LoginPage login = new LoginPage();
            login.displayLogin();
        }
        else if (nav.equals("Create")){
            CreateAccountPage create = new CreateAccountPage();
            createAccountPage.displayCreateAccount();
        }
        else{
            System.out.println("Invalid input, please try again");
        }
    }
}