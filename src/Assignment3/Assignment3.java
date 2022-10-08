package Assignment3;

import java.lang.System;
import java.util.Date;
import java.io.*;


public class Assignment3 {
    public static void main(String[] args) {
        // initialize and make interface with system
        System.out.println("Starting Assignment 3");

        int choice = menu(new String[] {
            "Event System",
            "Feedback system",
            "Three"
        });

        EventStorage manager = new EventStorage();

        switch (choice) {
            case 1:
                User usr = new User(manager);
                usr.bookEvent(new Date());
                manager.printAllEvents();
                break;
        
            default:
                break;
        }
    }

    private static int menu(String[] options) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // loop until a valid choice is made
        while (true) {
            // print menu
            for (int i = 0; i < options.length; i++) {
                System.out.printf("%d: %s\n", i+1, options[i]);
            }
            
            try {
                // read a line from stdin and convert it to an integer
                int choice = Integer.parseInt(br.readLine());

                // check if choice is within bounds
                if (choice > 0 && choice <= options.length) {
                    return choice;
                // make user try again if they enter a letter or an invald number
                } else {
                    System.out.printf("Please enter a number from 1 to %d.\n", options.length);
                }
            } catch (IOException | NumberFormatException e) {
                System.out.println("Please enter a number.");
            }
        }   
    }
}
