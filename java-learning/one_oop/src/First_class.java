class MyClass {
    String name;
    int age;

    public MyClass(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public void Info() {
        System.out.println("I am " + this.name);
        System.out.println("I am " + this.age + " years old.");
    }
}

public class First_class {
    public static void main(String[] args) {
        MyClass myClass = new MyClass("Maksym", 15);
        myClass.Info();
    }
}
