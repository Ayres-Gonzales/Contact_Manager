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

//        Console.addNewContact();
        Console.displayAll();
        Console.deleteContact();


//        Console.modifyExistingContact();


    }



    private static String returnMenuDisplay() {
        String choices = "What would you like to do?\n" +
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
        int response = input.getInt(0);

        return response;
    }

}


//    Marge Simpson | 210-222-2222
//        Homer Simpson | 210-444-4444
//        Bart Simpson | 210-333-3333