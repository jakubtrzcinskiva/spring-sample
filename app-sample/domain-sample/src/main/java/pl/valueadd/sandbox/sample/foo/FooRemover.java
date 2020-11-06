package pl.valueadd.sandbox.sample.foo;

import lombok.RequiredArgsConstructor;
import java.util.UUID;

@RequiredArgsConstructor
class FooRemover {

    private final FooService service;

    public void execute(UUID id) {
        service.delete(id);
    }
}
