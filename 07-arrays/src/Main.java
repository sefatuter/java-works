import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

//        String[] names = new String[5]; // Create Array
        // accepts only data of the type of array defined.
          String[] names = new String[]{"john", "jake", "james", "jake"};
//        names[0] = "John Doe";
//        names[1] = "Jane Doe";
//        names[2] = "James Doe";
//        names[3] = "Jake Doe";
        // names[5] = 12; // Required type: String, Provided: int



        for (String name : names) System.out.println(name); // first way to do
        System.out.println();
        for (int i = 0; i < names.length; i++) System.out.println(names[i]); // second way to do


        int[] numbers = new int[6];
        for (int i = 0; i < numbers.length; i++) numbers[i] = i + 1; // Assign

        for (int i = 0; i < numbers.length; i++) System.out.println(numbers[i]); // Print


        // Taking array items from user

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter length of array: ");
        int arrayLength = scanner.nextInt();
        Integer[] numbersArray = new Integer[arrayLength];

        for (int i = 0; i < arrayLength; i++){
            System.out.print("Enter an integer for " + i + ". index"+ ": ");
            numbersArray[i] = scanner.nextInt();
        }

        System.out.print("Which index do you want to see: ");
        int selected = scanner.nextInt();
        System.out.println(numbersArray[selected]);

        System.out.println("ALL indexes");
        for (int i = 0; i < numbersArray.length; i++) System.out.println(numbersArray[i]);

    }
}