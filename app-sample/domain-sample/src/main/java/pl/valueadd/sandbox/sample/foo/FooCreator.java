package pl.valueadd.sandbox.sample.foo;

import lombok.RequiredArgsConstructor;
import pl.valueadd.sandbox.sample.foo.dto.Foo;
import pl.valueadd.sandbox.sample.foo.dto.FooCreate;
import javax.validation.Valid;

@RequiredArgsConstructor
class FooCreator {

    private final FooService service;

    public Foo execute(@Valid() FooCreate create) {
        return service.create(create);
    }
}
