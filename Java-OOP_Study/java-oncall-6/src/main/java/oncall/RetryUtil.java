package oncall;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class RetryUtil {

    private RetryUtil() {
    }

    public static <T> T executeWithRetry(final Supplier<T> supplier, final Consumer<String> errorHandler) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                errorHandler.accept(e.getMessage());
            }
        }
    }

    public static void executeWithRetry(final Runnable runnable, final Consumer<String> errorHandler) {
        while (true) {
            try {
                runnable.run();
                break;
            } catch (IllegalArgumentException e) {
                errorHandler.accept(e.getMessage());
            }
        }
    }
}
