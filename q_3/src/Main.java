public class Main {
    int x;
    public int square(int number) {
        return number*number;
    }
    public static void main(String[] args) {
        System.out.println("Enter Number\n");
        System.in.read(x);
        System.out.println("square: %d", square(x));
    }
}