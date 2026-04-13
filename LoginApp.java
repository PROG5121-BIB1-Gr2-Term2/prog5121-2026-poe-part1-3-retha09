/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.loginapp;

import java.util.Scanner;

/**
 *
 * @author retha
 */
 class Login {
    //Declarations
    String userName;
    String password;
    String cellPhone;
    
    Login(String userName, String password, String cellPhone)
    {
        this.userName = userName;
        this.password = password;
        this.cellPhone = cellPhone;
    }
    
    //Check if username contains undersore and is no more than 5 characters
    Boolean checkUserName()
    {
        return userName.contains("_") && userName.length()<=5;
    }
    
    //Check password complexity
    Boolean checkPasswordComplexity() 
    {
        if(password.length() < 8) return false;
        Boolean hasUpper =false, hasDigit =false, hasSpecial = false;
        
        for(char c: password.toCharArray())
        {
            if (Character.isUpperCase(c))hasUpper = true;
            else if (Character.isDigit(c))hasDigit = true;
            else if (Character.isLetterOrDigit(c)) hasSpecial = true;
            
            if (hasUpper && hasDigit && hasSpecial) return true;
        }
        return false;
    }
    //Check cell phone number (+27 followed by 9 digits)
    Boolean checkCellPhoneNumber()
    {
        return cellPhone.matches("\\+27\\d{9}");
    }
    
    //Regstration messaging 
    String registerUser()
    {
    if(!checkUserName())
    {
     return "Username successfully captured.";
     }
    {
    return "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.";
        }
    if (!checkPasswordComplexity()) {
        return "Password is not correctly formatted, please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
     }
    if (!checkCellPhoneNumber())
    {
        return "Cell phone number is incorrectly formatted or does not contain international code.";
    }
    return "User successfully registered.";
    }
    
    //Login check
    Boolean loginUser(String enteredUsername, String enteredPassword) 
    {
        return enteredUsername.equals(userName) && enteredPassword.equals(password);
    }
    
    //Return login status message 
    String returnLoginStatus(boolean loginSuccess, String firstName, String lastName)
    {
        if (loginSuccess)
        {
            return "Welcome" + firstName + "," + lastName + "it is great to see you again.";
        }
        else
        {
            return "Username or password incorrect, please try again.";
        }
    }
}
 public class LoginApp {
    public static void main(String[] args) {
        Scanner myInput = new Scanner(System.in);
        
        System.out.println("----Registration---");
        
        System.out.println("Enter username");
        String userName = myInput.nextLine();
        System.out.println("Enter password");
        String password = myInput.nextLine();
        System.out.println("Enter cell phone number");
        String cellPhone = myInput.nextLine();
        
        Login user = new Login(userName, password, cellPhone);
        System.out.println(user.registerUser());
        System.out.println("---Login---");
        System.out.print("Enter username");
        String loginUsername = myInput.nextLine();
        System.out.print("Enter password");
        String loginPassword = myInput.nextLine();
         
        boolean success = user.loginUser(loginUsername, loginPassword);
         
        System.out.print("Enter first name");
        String firstName = myInput.nextLine();
        System.out.print("Enter last name");
        String lastName = myInput.nextLine();
        
       
        System.out.println(user.returnLoginStatus(success, firstName, lastName));
    }
}

