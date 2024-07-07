package chapter13;

// InterfaceA
interface InterfaceA {
    default void hello() {
        System.out.println("Hello from InterfaceA");
    }
}

// AbstractClassB
abstract class AbstractClassB implements InterfaceA{
    public abstract void hello();
}

// ClassC
class ClassC extends AbstractClassB implements InterfaceA {
    @Override
    public void hello() {
        System.out.println("Hello from Interface C");
    }
}

// Main class
public class CombinedExample {
    public static void main(String[] args) {
        ClassC c = new ClassC();
        c.hello();
    }
}
