import java.lang.System;
import java.io.*;

public class Assignment3 {
    public static void main(String[] args) {
        System.out.println("Starting Assignment 3");

        String[] o = {"One"};

        int choice = menu(o);
    }

    private static int menu(String[] options) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            for (int i = 0; i < options.length; i++) {
                System.out.printf("%d: %s\n", i+1, options[i]);
            }
            
            try {
                int choice = Integer.parseInt(br.readLine());

                if (choice > 0 && choice <= options.length) {
                    return choice;
                } else {
                    System.out.println("Please try again");
                }
            } catch (IOException e) {
                System.out.println(e);
            }
            
        }
        
    }
}
