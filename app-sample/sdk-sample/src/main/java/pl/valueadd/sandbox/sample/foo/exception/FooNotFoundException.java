package pl.valueadd.sandbox.sample.foo.exception;

import java.util.function.Supplier;
import java.util.UUID;

public class FooNotFoundException extends RuntimeException {

    public static Supplier<FooNotFoundException> ofId(UUID id) {
        return () -> new FooNotFoundException("With id: " + id);
    }

    FooNotFoundException(String message) {
        super(message);
    }
}
