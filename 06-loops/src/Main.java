import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Find Prime Number
        System.out.print("Enter number to find if its prime or not: ");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        boolean isPrime = true;

        for (int i = 2; i < num; i++) {

            if (num % i == 0) {
                System.out.println("It's Not Prime Number");
                isPrime = false;
                break;
            }
        }
        if (isPrime) {
            System.out.println("It's Prime Number");
        }
    }
}