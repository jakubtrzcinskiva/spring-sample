package pl.valueadd.sandbox.sample.foo;

import lombok.RequiredArgsConstructor;
import pl.valueadd.sandbox.sample.foo.dto.Foo;
import java.util.UUID;
import pl.valueadd.sandbox.sample.foo.dto.FooUpdate;
import javax.validation.Valid;

@RequiredArgsConstructor
class FooUpdater {

    private final FooService service;

    public Foo execute(UUID id, @Valid() FooUpdate update) {
        return service.update(id, update);
    }
}
