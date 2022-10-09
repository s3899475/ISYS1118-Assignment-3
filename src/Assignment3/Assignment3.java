package Assignment3;

import java.lang.System;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.io.*;


public class Assignment3 {
    // there will only be 1 Assignment3 Instance, so these can all be static
    private static Storage storage;
    private static ArrayList<User> users;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        // initialize and make interface with system
        System.out.println("Starting Assignment 3");

        storage = new Storage();
        users = new ArrayList<User>();

        // TESTING: create some dummy users
        User test_user = new User(storage);
        users.add(test_user);
        test_user.bookEvent(new Date(), "big", "fish", new String[] {"band", "jester"});

        User test_user2 = new User(storage);
        users.add(test_user2);
        test_user2.bookEvent(new Date(), "small", "meat", new String[] {"cake"});

        AuthorizedUser test_user3 = new AuthorizedUser("admin", "admin", storage);
        users.add(test_user3);

        while (true) {
            int choice = menu(new String[] {
                "Book Event",
                "Login as Normal User",
                "Login as Authorized User"
            });

            switch (choice) {
                case 1:
                    User new_user = new User(storage);
                    users.add(new_user);
                    createNewEvent(new_user);
                    break;

                case 2: // Normal User
                    int id = intQuestion("Input Event ID: ");
                    User usr = getUser(id);
                    if (usr == null) {
                        System.out.println("That user does not exist\n");
                    } else {
                        userMenu(usr);
                    }
                    break;

                case 3: // Authorized User
                    String username = question("Input username: ");
                    String password = question("Input password: ");
                    AuthorizedUser auth_user = getAuthUser(username, password);
                    if (auth_user == null) {
                        System.out.println("Username or password incorrect\n");
                    } else {
                        authUserMenu(auth_user);
                    }
                    break;

            
                default:
                    break;
            }
        }
    }

    private static void createNewEvent(User user) {
        String[] menu_options = {
            "fish",
            "meat",
            "vegetarian"
        };

        String[] pkg_options = {
            "1-10 people",
            "11-30 people",
            "31+ people"
        };

        ArrayList<String> extra_options = new ArrayList<String>();
        extra_options.add("band");
        extra_options.add("jester");
        extra_options.add("cake");

        ArrayList<String> options = new ArrayList<>();

        while (true) {
            try {
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
                Date date = formatter.parse(question("Enter event date (dd/MM/yyyy): "));

                String pkg = pkg_options[menu(pkg_options)-1];
                String menu = menu_options[menu(menu_options)-1];

                while (true) {
                    String choice = question("would you like any more optional extras[y/n]?: ");
                    if (choice.toLowerCase().equals("y")) {
                        int idx =  menu(extra_options.toArray(new String[0]));
                        options.add(extra_options.get(idx - 1));
                        // remove the choice so the user cannot choose it again
                        extra_options.remove(idx - 1);
                    } else {
                        break;
                    }
                }

                user.bookEvent(date, pkg, menu, pkg_options);
                break;
            } catch (Exception e) {
                System.out.println("Error in event creation, please try again.\n");
            }
        }
    }

    private static AuthorizedUser getAuthUser(String username, String password) {
        for (User user : users) {
            if (user instanceof AuthorizedUser) {
                // cast to subclass
                AuthorizedUser authUser = (AuthorizedUser) user;
                if (authUser.getUsername().equals(username) && authUser.getPassword().equals(password)) {
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
                    String content = question("Please enter your feedback: ");
                    storage.sent_feedback.add(new Feedback("default", content));
                    break;
                
                case 2:
                    String request = question("Please enter your modification request");
                    storage.sent_feedback.add(new Feedback("modification", request));
                    break;
                
                case 3:
                    Event event = storage.getEvent(user.getEventID());
                    printEvent(event);
                    break;

                case 4:
                    running = false;
                    break;
            
                default:
                    break;
            }
        }
    }


    private static void printEvent(Event event) {
        System.out.println("\n" + event.getEventID() + ":");
        System.out.println(event.getDate());
        System.out.println(event.getPkg());
        System.out.println(event.getMenu());
        System.out.println("options:");
        for (String opt : event.getOptions()) {
            System.out.println("\t" + opt);
        }
    }

    private static void authUserMenu(AuthorizedUser user) {
        boolean running = true;

        while (running) {
            int choice = menu(new String[] {
                "View all events",
                "New Bill",
                "View FeedBack",
                "View Bills",
                "Logout"
            });

            switch (choice) {
                case 1:
                    for (Event event : storage.events) {
                        printEvent(event);
                    }
                    break;

                case 2:
                    int amount = intQuestion("\nEnter amount: ");
                    String description = question("Enter description: ");
                    storage.bills.add(new Bill(amount, description));

                    break;
                
                case 3:
                    for (Feedback feedback : storage.sent_feedback) {
                        System.out.println(feedback.getType());
                        System.out.println(feedback.getContent() + "\n");
                    }
                    break;
                
                case 4:
                    System.out.println("\nBILLS: ");
                    for (Bill bill : storage.bills) {
                        System.out.println("$" + bill.getAmount() + ":");
                        System.out.println(bill.getDescription() + "\n");
                    }
                    break;

                case 5:
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
