package chapter13;

interface A {
    default void hello() {
        System.out.println("Hello from A");
    }
}

class B {
    public void hello() {
        System.out.println("Hello from B");
    }
}

class C extends B implements A {
}

public class ClassWinsExample {
    public static void main(String[] args) {
        C c = new C();
        c.hello();
    }
}
