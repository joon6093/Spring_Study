package chapter19;

import java.util.function.Supplier;

class LazyList<T> implements MyList<T> {
    private final T head;
    private final Supplier<MyList<T>> tail;

    public LazyList(T head, Supplier<MyList<T>> tail) {
        this.head = head;
        this.tail = tail;
    }

    public T head() {
        return head;
    }

    public MyList<T> tail() {
        return tail.get();
    }

    public boolean isEmpty() {
        return false;
    }

    public static LazyList<Integer> from(int n) {
        return new LazyList<>(n, () -> from(n + 1));
    }
}

public class LazyListExample {
    public static void main(String[] args) {
        LazyList<Integer> numbers = LazyList.from(2);

        int two = numbers.head();
        int three = numbers.tail().head();
        int four = numbers.tail().tail().head();

        System.out.println(two + " " + three + " " + four); // 출력: 2 3 4
    }
}
