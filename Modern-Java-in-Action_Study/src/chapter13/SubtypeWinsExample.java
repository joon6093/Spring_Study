package chapter13;

interface X {
    default void hello() {
        System.out.println("Hello from X");
    }
}

interface Y extends X {
    default void hello() {
        System.out.println("Hello from Y");
    }
}

class Z implements Y {
}

public class SubtypeWinsExample {
    public static void main(String[] args) {
        Z z = new Z();
        z.hello();
    }
}
