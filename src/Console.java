import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

public class Console {

    static Path p = Paths.get("FileIo", "contacts.txt");


/// Displays all contacts

    public static void displayAll() {
        List<String> lines;
        try {
            lines = Files.readAllLines(p);
            for (String contact : lines) {
                String[] splitString = contact.split(" ");
                if (splitString.length == 3) {
                    System.out.println(splitString[0] + " " + splitString[1] + "\t | " + splitString[2]);
                }
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

    }

/// Adds a new contact

    public static void addNewContact() {
        List<String> contacts = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the first name and last name of the person you would like to add, followed " +
                "by their phone number: ");
        String inputContact = sc.nextLine();
        contacts.add(inputContact);
        try {
            Files.write(p, contacts, StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
        displayAll();
    }

    /// Searches for contact

    public static void searchForContact() throws IOException {
        Path testFilePath = Paths.get(String.valueOf(p));
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the first name of the contact you are searching for: ");
        String userInput = sc.nextLine().toLowerCase();
        try {
            List<String> lines = Files.readAllLines(testFilePath);
            for (String line : lines) {
                String[] splitString = line.split(" ");
                if (splitString[0].equalsIgnoreCase(userInput)) {
                    System.out.println(splitString[0] + " " + splitString[1] + "\t | " + splitString[2]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

/// Deletes a contact

    public static void deleteContact() throws IOException {
        Path testFilePath = Paths.get(String.valueOf(p));
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the first name of the contact you would like to delete: ");
        String inputContact = sc.nextLine();
        try {
            List<String> lines = Files.readAllLines(testFilePath);
            for (String line : lines) {
                String[] splitString = line.split(" ");
                if (splitString[0].equalsIgnoreCase(inputContact)) {
                    lines.remove(line);
                }
                Files.write(testFilePath, lines);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        displayAll();
    }
}

    ///Modify existing contact

//    public static void modifyExistingContact() throws IOException {
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Please enter the contacts new full information with desired edits: ");
//        String editContact = sc.nextLine().toLowerCase();
//        System.out.println();
//        List<String> lines = new ArrayList<>();
//        for (String line : lines) {
//            if (line.equals(userInput)) {
//                lines.add(editContact);
//                continue;
//            }
//            lines.add(line);
//        }
//
//        Files.write(Paths.get(String.valueOf(p)), lines);
//    }
//        try {
//            List<String> lines = Files.readAllLines(testFilePath);
//            for (String line : lines) {
//                String[] splitString = line.split(" ");
//                if (splitString[0].contains(userInput)) {
//                    lines.remove(line);
////                    lines.add(modifiedResponse);
//                    Files.write(testFilePath, lines);
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


