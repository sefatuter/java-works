public class Main {
    public static void main(String[] args) {

    // It is the keyword that allows us to access variables or methods in a class directly
    // from the class name without creating an object from the class.

        // Normally we do this
        /*
        Student student = new Student();
        student.setName("Can");
        System.out.println(student.getName());
        */

//        Student.number = "12312321"; // Can accessible now without creating object.

//        System.out.println("Number: " + Student.number);

        Student.writeNumber("123453"); // Using Static Method

        System.out.println();

        Student student = new Student(); // Using without static
        student.setId(12L);
        student.studentInfo();
    }
}