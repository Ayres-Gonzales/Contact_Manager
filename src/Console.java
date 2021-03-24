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
        List<String> lines = new ArrayList<>();
        try {
            lines = Files.readAllLines(p);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        for (String contact : lines) {
            System.out.println(contact);
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
                    System.out.println(line);
//                    modifyExistingContact();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


///Modify existing contact

//    public static void modifyExistingContact() throws IOException {
//        Path testFilePath = Paths.get("FileIo", "contacts.txt");
//        Scanner sc = new Scanner(System.in);
////        System.out.println("Please enter the first name of the contact you would like to search for: ");
////        String userInput = sc.nextLine();
//        System.out.println("Would you like to modify the contact info? (y/n)");
//        String toModify = sc.nextLine().toLowerCase();
//        if (toModify.equals("y")) {
//            System.out.println("Please enter the contacts full information with desired edits: ");
//            String modifiedResponse = sc.nextLine().toLowerCase();
//        }
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
//    }


/// Deletes a contact

//    public static void deleteContact() {
//        Path p = Paths.get("FileIo", "contacts.txt");
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Please enter the first name of the contact you would like to delete: ");
//        String inputContact = sc.nextLine();
//        try {
//            List<String> names = Files.readAllLines(p);
//            for (String name : names) {
//                String[] splitString = name.split(" ");
//                if (splitString[0].equalsIgnoreCase(inputContact)) {
//                    names.remove(name);
//                    Files.write(p, names);
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        displayAll();
//    }

    public static void deleteContact() {
//        Path testFilePath = Paths.get("src", "fileIoLecture", "test.txt");
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the first name of the contact you would like to delete: ");
        String inputContact = sc.nextLine();
        try {
            List<String> names = Files.readAllLines(p);
            names.remove(inputContact);
            Files.write(p, names);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
