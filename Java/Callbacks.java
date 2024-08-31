// Define a functional interface for the callback
@FunctionalInterface
interface AsyncCallback {
    void onComplete(Result<String> result);
}

// A simple Result wrapper class to handle both success and error scenarios
class Result<T> {
    private final T value;
    private final Exception exception;

    private Result(T value, Exception exception) {
        this.value = value;
        this.exception = exception;
    }

    public static <T> Result<T> success(T value) {
        return new Result<>(value, null);
    }

    public static <T> Result<T> failure(Exception exception) {
        return new Result<>(null, exception);
    }

    public boolean isSuccess() {
        return exception == null;
    }

    public T getValue() {
        return value;
    }

    public Exception getException() {
        return exception;
    }
}

// Class to simulate asynchronous processing
class AsyncProcessor {


    public void executeAsync(AsyncCallback callback) {
        new Thread(() -> {
            try {
                // Simulate processing by sleeping for 1 second
                Thread.sleep(1000);
                // Simulate success
                callback.onComplete(Result.success("Processing complete!"));
            } catch (Exception e) {
                // In case of error, pass the exception to the callback
                callback.onComplete(Result.failure(e));
            }
        }).start();
    }
}

// Main class to demonstrate the usage of the AsyncProcessor with a callback
 public class Callbacks {
    public static void main(String[] args) {
        AsyncProcessor processor = new AsyncProcessor();

        // Using a lambda expression for the callback
        processor.executeAsync(result -> {
            if (result.isSuccess()) {
                System.out.println("Success: " + result.getValue());
            } else {
                System.out.println("Error: " + result.getException().getMessage());
            }
        });
    }
}
