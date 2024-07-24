public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!"); // Comment line
        System.out.println(1000);
        System.out.println(11 * 11);

        String name = "john";
        int age = 20; // age = 11;
        float myFloat = 5.99f;
        boolean myBoolean = true;
        char myChar = 'A';

        System.out.println(name);
        System.out.println(age);
        System.out.println(myFloat);
        System.out.println(myBoolean);
        System.out.println(myChar);
        System.out.println("Hello " + name + " " + age + " " + myFloat + " " + myBoolean + " " + myChar);


        long num = 12314214124L; // Add L to end of the line
        System.out.println(num);

        long a = Long.MAX_VALUE, b = Long.MIN_VALUE;
        System.out.println(a);
        System.out.println(b);

        // -128 to 128 1 byte

        byte num2 = (byte) 12;
        System.out.println(num2);

        // -32768 to 32768
        short num3 = (short) 123;
        System.out.println(num3);
        System.out.println();

        // int and Integer class
        // long and Long
        // double and Double

        float maxFloat = Float.MAX_VALUE;
        System.out.println(maxFloat);
        float minFloat = Float.MIN_VALUE;
        System.out.println(minFloat);

        float floatNum = 16.7f;
        System.out.println(floatNum);

        // double D
        double maxDouble = Double.MAX_VALUE;
        System.out.println(maxDouble);
        double minDouble = Double.MIN_VALUE;
        System.out.println(minDouble);

        double doubleNum = 16.71827392649824D;
        System.out.println(doubleNum);


        boolean result = true;
        System.out.println(result);



    }
}