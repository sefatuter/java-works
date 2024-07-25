import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        double firstBalance = 2450;
        double secondBalance = 3000;

        String options = "See Balance --> 1" +
                "Withdraw Money --> 2" +
                "Deposit Money To Another Account --> 3" +
                "Exit --> 4";

        String firstName = "Jane";
        String pass1 = "1234";
        String firstAcc = "BG129 912384 112";

        String secondAcc = "BG125 485663 511";
        String secondName = "John";
        String pass2 = "1234";

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to ATM Machine");
        System.out.println("Please Enter Your Credentials.");

        System.out.println("Name: ");
        String name = scanner.nextLine();

        System.out.println("Password: ");
        String pass = scanner.nextLine();

        if (name.equals(firstName) && pass.equals(pass1)) {
            System.out.println("You have been successfully logged in. " + firstName);
            System.out.println(options);

            System.out.println("Select = ");
            String option = scanner.nextLine();

            switch (option) {
                case "1":
                    System.out.println("Your Balance: " + firstBalance);
                    break;
                case "2":
                    System.out.println("Enter For Withdraw: ");
                    int withdraw = scanner.nextInt();
                    if (withdraw <= firstBalance) {
                        firstBalance -= withdraw;
                        System.out.println("You have been successfully withdrawn.");
                        System.out.println("New Balance: " + firstBalance);
                    } else {
                        System.out.println("Withdraw Failed.");
                    }
                    break;
                case "3":
                    System.out.println("Enter IBAN for Deposit Money: ");
                    String iban = scanner.nextLine();
                    if (iban.equals(secondAcc)) {
                        System.out.println("Enter Amount to Deposit Money: ");
                        double amount = scanner.nextDouble();
                        if (amount <= firstBalance) {
                            firstBalance -= amount;
                            secondBalance += amount;
                            System.out.println("You have been successfully deposited.");
                        } else {
                            System.out.println("Deposit Failed.");
                        }
                    }
                    break;
                case "4":
                    System.out.println("Exited");
                    break;
            }
        } else if ( name.equals(secondName) && pass.equals(pass2)) {
            System.out.println("You have been successfully logged in. " + secondName);
        }


    }
}