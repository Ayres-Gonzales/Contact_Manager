import java.io.*;
import java.nio.file.*;
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

//    public static void deleteContact() throws IOException {
//        Path testFilePath = Paths.get(String.valueOf(p));
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Please enter the first name of the contact you would like to delete: ");
//        String inputContact = sc.nextLine();
//        try {
//            List<String> lines = Files.readAllLines(testFilePath); //declare a list
//            List<String> lines1 = Files.readAllLines(testFilePath);
//            for (String line : lines) {
//                String[] splitString = line.split(" ");
//                if (splitString[0].equalsIgnoreCase(inputContact)) {
//                    lines.remove(line);
//                }
//                Files.write(testFilePath, lines1);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        displayAll();
//    }

    public static void deleteContact() throws IOException{
        File inputFile = new File(String.valueOf(p));
        File tempFile = new File("myTempFile.txt");
        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
        String currentLine;
        String lineToRemove;
        System.out.print("Enter the name of the contact you wish to delete: ");
        Scanner sc = new Scanner(System.in);
        String inputContact = sc.nextLine();
        lineToRemove = inputContact;
        while((currentLine = reader.readLine()) != null) {
            String trimmedLine = currentLine.trim();
            if(trimmedLine.startsWith(lineToRemove)) continue;
            System.out.println(trimmedLine);

            writer.write((currentLine) + System.getProperty("line.separator"));
        }
        writer.close();
        reader.close();
        Files.move(tempFile.toPath(), inputFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
        System.out.println("Contact was deleted");
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


