package thread.start.test;

import static util.MyLogger.log;

import java.util.stream.IntStream;

public class StartTest3Main {

    public static void main(String[] args) {

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                IntStream.range(1, 6).forEach(i -> {
                    log("value: " + i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                });
            }
        };

        Thread thread = new Thread(runnable, "counter");
        thread.start();
    }

}
