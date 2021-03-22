import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class ContactApp {

    public static void main(String[] args) {
//        System.out.println(displayAll());
//    }

//    public static void displayAll() {

        Path p = Paths.get("FileIo", "contacts.txt");

        System.out.println(p);


        List<String> lines = new ArrayList<>();

        try {
            lines = Files.readAllLines(p);
        } catch (
                IOException e) {
            e.printStackTrace();
        }

        for (String name : lines) {
            System.out.println(name);
        }
    }

}
