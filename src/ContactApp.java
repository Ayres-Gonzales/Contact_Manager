import util.Input;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ContactApp {

    public static void main(String[] args) throws IOException {

        boolean running = true;

        while (running) {
            System.out.println(returnMenuDisplay());

            int userResponse = promptUserForChoice();
            running = executeUserChoice(userResponse);
        }


//        Console.addNewContact();
//        Console.displayAll();
//        Console.deleteContact();
//        Console.modifyExistingContact();
    }

        private static boolean executeUserChoice ( int choice) throws IOException {
            boolean continueRunning = true;

            switch (choice) {

                case 1:
                    Console.displayAll();

            break;
            case 2:
                Console.addNewContact();
                break;

            case 3:
                Console.modifyExistingContact();
                break;
            case 4:
                Console.deleteContact();
                break;
            case 5:

                continueRunning = false;
                break;
        }

        return continueRunning;

    }


    private static String returnMenuDisplay() {

        String choices = "Welcome to the Contacts Manager!\n What would you like to do?\n" +
                "\n" +
                "1. View contacts." +
                "2. Add a new contact." +
                "3. Search a contact by name." +
                "4. Delete an existing contact." +
                "5. Exit." +
                "Enter an option (1, 2, 3, 4 or 5):";

        return choices;
    }

    private static int promptUserForChoice() {

        Input input = new Input();

        System.out.println("Enter your choice: ");

        int response = input.getInt(1, 5);

        return response;
    }
}



//    Marge Simpson | 210-222-2222
//        Homer Simpson | 210-444-4444
//        Bart Simpson | 210-333-3333