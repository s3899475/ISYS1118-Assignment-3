package Assignment3;

import java.lang.System;
import java.util.ArrayList;
import java.util.Date;
import java.io.*;


public class Assignment3 {
    // there will only be 1 Assignment3 Instance, so these can all be static
    private static EventStorage manager;
    private static ArrayList<User> users;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        // initialize and make interface with system
        System.out.println("Starting Assignment 3");

        int choice = menu(new String[] {
            "Book Event",
            "Login as Normal User",
            "Login as Authorized User"
        });

        manager = new EventStorage();
        users = new ArrayList<User>();

        // TESTING: create some dummy users
        User test_user = new User(manager);
        users.add(test_user);
        test_user.bookEvent(new Date());

        User test_user2 = new User(manager);
        users.add(test_user2);
        test_user2.bookEvent(new Date());

        AuthorizedUser test_user3 = new AuthorizedUser("admin", "admin", manager);
        users.add(test_user3);

        switch (choice) {
            case 1:
                // TODO: add event options here
                User new_user = new User(manager);

                users.add(new_user);
                new_user.bookEvent(new Date());
                manager.printAllEvents();
                break;

            case 2: // Authorized User
                manager.printAllEvents();
                int id = intQuestion("Input Event ID: ");
                User usr = getUser(id);
                if (usr == null) {
                    System.out.println("That user does not exist\n");
                } else {
                    userMenu(usr);
                }
                break;

            case 3: // Normal User
                String username = question("Input username: ");
                String password = question("Input password: ");
                User auth_user = getAuthUser(username, password);
                if (auth_user == null) {
                    System.out.println("Username or password incorrect\n");
                } else {
                    //authUserMenu(auth_user);
                }
                break;

        
            default:
                break;
        }
    }

    private static AuthorizedUser getAuthUser(String username, String password) {
        for (User user : users) {
            if (user instanceof AuthorizedUser) {
                // cast to subclass
                AuthorizedUser authUser = (AuthorizedUser) user;
                if (authUser.getUsername() == username && authUser.getPassword() == password) {
                    return authUser;
                }
            }
        }
        return null;
    }

    private static User getUser(int eventID) {
        for (User user : users) {
            System.out.println(eventID);
            System.out.println(user.getEventID());
            if (user.getEventID() != 0 && user.getEventID() == eventID) {
                return user;
            }
        }
        return null;
    }

    private static String question(String str) {
        System.out.println(str);
        try {
            return br.readLine();
        } catch (Exception e) {
            return "";
        }
    }

    private static int intQuestion(String str) {
        System.out.print(str);
        try {
            return Integer.parseInt(br.readLine());
        } catch (Exception e) {
            return -1;
        }
    }

    //TODO
    private static void userMenu(User user) {
        boolean running = true;

        while (running) {
            int choice = menu( new String[] {
                "Send FeedBack",
                "Ask for modification to Event",
                "View event details",
                "Logout"
            });

            switch (choice) {
                case 1:
                    break;
                
                case 2:
                    break;
                
                case 3:
                    break;

                case 4:
                    running = false;
                    break;
            
                default:
                    break;
            }
        }
    }

    private static int menu(String[] options) {
        

        // loop until a valid choice is made
        while (true) {
            // print menu
            System.out.println("What would you like to do? Enter a number.");
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
