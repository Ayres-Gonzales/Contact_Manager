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

        for (String name : lines) {
            System.out.println(name);
        }
    }


/// Adds a new contact

    public static void addNewContact() {
        List<String> names = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter a name");
        String inputName = sc.nextLine();
        names.add(inputName);
        try {
            Files.write(p, names, StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String name : names) {
            System.out.println(name);
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

    public static void deleteContact(String name) {
        Path testFilePath = Paths.get("FileIo", "contacts.txt");
        try {
            List<String> names = Files.readAllLines(testFilePath);
            names.remove(name);
            Files.write(testFilePath, names);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
