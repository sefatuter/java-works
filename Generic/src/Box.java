// Define a generic class with a type parameter T
public class Box<T> {
    private T item;

    // Constructor
    public Box(T item) {
        this.item = item;
    }

    // Getter
    public T getItem() {
        return item;
    }

    // Setter
    public void setItem(T item) {
        this.item = item;
    }
}
