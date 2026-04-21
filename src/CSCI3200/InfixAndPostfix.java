//--------------------------------------------------------------
//Group Members: Anthony Torres, Gareth Clapper
//Date: 4/24/2026
//Course: Data Structures and Algorithm Analysis (CSCI 3200)
//Project Description: Make a program that converts an Infix to
//Postfix Expression and Convert Postfix to Infix
//Expression using Stacks.
//--------------------------------------------------------------

package CSCI3200;

import java.util.Scanner;

public class InfixAndPostfix {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);  //Scanner object that reads user input
        int choice = -1; //initializes variable integer, starts at -1 so loop begins

        while (choice != 0) {   //runs while the choice variable is not 0

            menu();     //calls the menu method

            if (!scan.hasNextInt()) {   //prints invalid input if user does not type an integer
                System.out.println("Invalid input.\n");
                scan.nextLine();    //clears invalid input from input buffer
                continue;   //restarts while loop
            }

            choice = scan.nextInt();    //stores the integer the user typed
            scan.nextLine();    //removes \n from buffer

            if (choice == 1) {  //prompts for and converts an infix expression into a postfix expression
                System.out.print("Enter an infix expression: ");    //prompts for an infix expression
                String infix = scan.nextLine();     //stores the inputted expression into a string variable

                ConvertInfixAndPostfix obj = new ConvertInfixAndPostfix(infix);

                String postfix = obj.convertToPostfix();

                System.out.println("The postfix expression of " + infix + " = " + postfix);     //displays the inputted expression and converted expression
            }

            else if (choice == 2) {     //prompts for and converts a postfix expression into an infix expression
                System.out.print("Enter a postfix expression: ");    //prompts for a postfix expression
                String postfix = scan.nextLine();     //stores the inputted expression into a string variable

                ConvertInfixAndPostfix obj = new ConvertInfixAndPostfix(postfix);

                String infix = obj.convertToInfix();

                System.out.println("The infix expression of " + postfix + " = " + infix);     //displays the inputted expression and converted expression
            }

            else if (choice == 0) {     //if the user inputs 0, the loop ends
                System.out.println("Goodbye!");
            }

            else {      //if the user inputs an integer that is not 0, 1, or 2, tells them its an invalid choice
                System.out.println("Invalid choice.");
            }

            System.out.println();
        }

        scan.close();   //shuts down the scan obj
    }

    public static void menu() {     //method to print the choices the user can make.
        System.out.println("//////////////////////////////////////");
        System.out.println("/ 0: Exit /");
        System.out.println("/ 1: Infix to Postfix /");
        System.out.println("/ 2: Postfix to Infix /");
        System.out.println("//////////////////////////////////////");
        System.out.print("Enter a choice: ");
    }
}


