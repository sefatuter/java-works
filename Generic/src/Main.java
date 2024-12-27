import java.awt.*;
import java.util.ArrayList;

// Using the Generic Class
public class Main {
    public static void main(String[] args) {
        // Box for Integer
        Box<Integer> intBox = new Box<>(123);
        System.out.println("Integer Value: " + intBox.getItem());

        // Box for String
        Box<String> strBox = new Box<>("Hello Generics");
        System.out.println("String Value: " + strBox.getItem());    
    }
}
