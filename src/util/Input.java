package util;

import java.util.Scanner;

public class Input {

    public static Object toLowerCase;
    private Scanner scanner;

    public Input() {

        this.scanner = new Scanner(System.in);
    }

    public String getString() {

        return scanner.nextLine();
    }

    public boolean yesNo() {
        String input = scanner.next();
        return input.equalsIgnoreCase("y") || input.equalsIgnoreCase("yes");
    }

    public int getInt() {
        if (scanner.hasNextInt()){
            return scanner.nextInt();
        } else {
            System.out.println("Invalid input; please enter an integer");
            scanner.nextLine();
            return getInt();
        }
    }

    public double getDouble() {
        if(scanner.hasNextDouble()) {
            return scanner.nextDouble();
        } else {
            System.out.println("Invalid double. Please enter a double.");
            scanner.nextLine();
            return getDouble();
        }
    }

//    public getDouble(double min, double max) {
//        double userDouble = getDouble();
//        if (userDouble >= min && userDouble <= max) {
//            return userDouble;
//        } else {
//            System.out.println("Out of range; please enter a number between " + min + " and " + max);
//            return getDouble(min, max);
//        }
//    }










//    int getInt(int min, int max)
//    int getInt()
//    double getDouble(double min, double max)
//    double getDouble()

    public static void main(String[] args) {
        System.out.println("Hello, and welcome to my class. What's your name?");
        Input input = new Input();
        String userInput= input.getString();
        System.out.println("Hi, " + userInput);
        System.out.println("Would you like to continue?");
        boolean willContinue = input.yesNo();
        if (willContinue) {
            System.out.println("Continuing...");
        } else {
            System.out.println("Exiting...");
        }

        System.out.println("Please enter a double.");
        double userDouble = input.getDouble();
        System.out.println("Your lucky double is: " + userDouble);

//        System.out.println("Please enter a double");
//        double userDouble = input.getDouble(1, 5);
//        System.out.println("Your lucky double is: " + userDouble);

    }

    public int getInt(int i) {
        return 0;
    }
}