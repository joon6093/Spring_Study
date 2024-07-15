package chapter19;

interface MyList<T> {
    T head();
    MyList<T> tail();
    default boolean isEmpty() {
        return true;
    }
}

class MyLinkedList<T> implements MyList<T> {
    private final T head;
    private final MyList<T> tail;

    public MyLinkedList(T head, MyList<T> tail) {
        this.head = head;
        this.tail = tail;
    }

    public T head() {
        return head;
    }

    public MyList<T> tail() {
        return tail;
    }

    public boolean isEmpty() {
        return false;
    }
}

class Empty<T> implements MyList<T> {
    public T head() {
        throw new UnsupportedOperationException();
    }

    public MyList<T> tail() {
        throw new UnsupportedOperationException();
    }
}

public class EagerListExample {
    public static void main(String[] args) {
        MyList<Integer> list = new MyLinkedList<>(5, new MyLinkedList<>(10, new Empty<>()));

        System.out.println(list.head()); // 출력: 5
        System.out.println(list.tail().head()); // 출력: 10
        System.out.println(list.tail().tail().isEmpty()); // 출력: true
    }
}
