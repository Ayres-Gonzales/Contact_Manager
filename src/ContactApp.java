import util.Input;

import java.io.IOException;


public class ContactApp {

    public static void main(String[] args) throws IOException {

        boolean running = true;

        while (running) {
            System.out.println(returnMenuDisplay());

            int userResponse = promptUserForChoice();
            running = executeUserChoice(userResponse);
        }

    }

    private static boolean executeUserChoice(int choice) throws IOException {
        boolean continueRunning = true;

        switch (choice) {

            case 1:
                Console.displayAll();
                break;

            case 2:
                Console.addNewContact();
                break;

            case 3:
                Console.searchForContact();
                break;

            case 4:
                Console.deleteContact();
                break;

            case 5:
                System.out.println("See you later!");
                continueRunning = false;
                break;
        }

        return continueRunning;

    }


    private static String returnMenuDisplay() {

        String choices = "\nWelcome to the Contacts Manager!\n" +
                "\n" + "" +
                "What would you like to do?\n" +
                "\n" +
                "1. View contacts.\n" +
                "2. Add a new contact.\n" +
                "3. Search a contact by name.\n" +
                "4. Delete an existing contact.\n" +
                "5. Exit.\n";

        return choices;
    }

    private static int promptUserForChoice() {
        Input input = new Input();
        System.out.println("Enter an option (1, 2, 3, 4 or 5):");
        int response = input.getInt(1, 5);
        return response;
    }
}

//Marge Simpson 210-444-4444
//Bart Simpson 210-333-3333
//Lisa Simpson 210-555-5555
//Maggie Simpson 210-888-8888
//Homer Simpson 210-222-2222
//Bumblebee Man 210-555-2222
//Disco Stew 512-222-2222
//Duff Man 830-533-9982
//Rich Texan 210-534-8933
//Apu Nahasapeemapetilon 830-282-8282