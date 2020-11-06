package pl.valueadd.sandbox.sample.foo;

import lombok.RequiredArgsConstructor;
import pl.valueadd.sandbox.sample.foo.dto.Foo;
import java.util.UUID;
import pl.valueadd.sandbox.sample.foo.dto.FooUpdate;
import javax.validation.Valid;

@RequiredArgsConstructor
class FooUpdater {

    private final FooService service;

    private final FooMapper fooMapper;

    public Foo execute(UUID id, @Valid() FooUpdate update) {
        return fooMapper.toDto(
                service.update(id, fooMapper.applyChanges(service.getOne(id), update))
        );
    }
}
