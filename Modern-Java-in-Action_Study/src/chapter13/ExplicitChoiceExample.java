package chapter13;

interface P {
    default void hello() {
        System.out.println("Hello from P");
    }
}

interface Q {
    default void hello() {
        System.out.println("Hello from Q");
    }
}

class R implements P, Q {
    @Override
    public void hello() {
        P.super.hello();
    }
}

public class ExplicitChoiceExample {
    public static void main(String[] args) {
        R r = new R();
        r.hello();
    }
}
