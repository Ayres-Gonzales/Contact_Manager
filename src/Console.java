import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

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
        for (String contact : contacts) {
            displayAll();
        }
    }


    ///Modify existing contact

//    public static void modifyExistingContact() throws IOException {
//        List<String> lines = Files.readAllLines(Paths.get("FileIo", "contacts.txt"));
//        List<String> modifiedList = new ArrayList<>();
//        String userInput = "Tim";
//        for (String line : lines) {
//            if (line.equals(userInput)) {
//                modifiedList.remove(line);
//                modifiedList.add("cream");
//                continue;
//            }
//            modifiedList.add(line);
//        } for (String name : lines) {
//            System.out.println(name);
//        }
//    }


    /// Deletes a contact

//    public static Path deleteContact (){
//        List<String> names = new ArrayList<>();
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Please enter a name");
//        String inputName = sc.nextLine();
//        names.add(inputName);
//        try {
//            Files.write(p, names, StandardOpenOption.DELETE_ON_CLOSE);
////            return Files.deleteIfExists(p, Collections.singleton(name));
//        }catch (IOException e) {
//            e.printStackTrace();
//        }
//        return p;
//    }

    public static void deleteContact() throws IOException {

        List<String> lines = Files.readAllLines(Paths.get("FileIo", "contacts.txt"));
        List<String> modifiedList = new ArrayList<>();
        Path testFilePath = Paths.get("FileIo", "contacts.txt");
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the fist name of the contact you would like to delete: ");
        String inputContact = sc.nextLine();
        for (String line : lines) {
            if (line.contentEquals(inputContact)) {
                modifiedList.remove(line);
                continue;
            }
            try {
                List<String> contacts = Files.readAllLines(testFilePath);
                contacts.remove(inputContact);
                Files.write(testFilePath, contacts);
            } catch (IOException e) {
                e.printStackTrace();
            }
            displayAll();

        }
    }
}
