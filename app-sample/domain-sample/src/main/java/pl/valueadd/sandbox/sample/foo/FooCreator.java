package pl.valueadd.sandbox.sample.foo;

import lombok.RequiredArgsConstructor;
import pl.valueadd.sandbox.sample.foo.dto.Foo;
import pl.valueadd.sandbox.sample.foo.dto.FooCreate;
import javax.validation.Valid;

@RequiredArgsConstructor
class FooCreator {

    private final FooService service;

    private final FooMapper mapper;

    public Foo execute(@Valid() FooCreate create) {
        return mapper.toDto(service.create(mapper.toState(create)));
    }
}
