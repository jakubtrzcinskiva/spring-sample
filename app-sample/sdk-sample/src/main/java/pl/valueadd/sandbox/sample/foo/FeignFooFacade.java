package pl.valueadd.sandbox.sample.foo;

import lombok.RequiredArgsConstructor;
import pl.valueadd.sandbox.sample.foo.exception.FooNotFoundException;
import pl.valueadd.sandbox.sample.foo.dto.Foo;
import java.util.Optional;
import java.util.UUID;
import pl.valueadd.sandbox.sample.foo.dto.FooCreate;
import pl.valueadd.sandbox.sample.foo.dto.FooUpdate;
import java.util.List;
import pl.valueadd.sandbox.sample.foo.dto.FooRequest;
import pl.valueadd.sandbox.sample.foo.dto.FoosPage;

@RequiredArgsConstructor
class FeignFooFacade implements FooFacade {

    private final FooClient client;

    public Optional<Foo> findById(UUID id) {
        return Optional.ofNullable(client.getOne(id));
    }

    public Foo getOne(UUID id) {
        return findById(id).orElseThrow(FooNotFoundException.ofId(id));
    }

    public Foo create(FooCreate model) {
        return client.create(model);
    }

    public Foo update(UUID id, FooUpdate model) {
        return client.update(id, model);
    }

    public void delete(UUID id) {
        client.delete(id);
    }

    public List<Foo> findAll(FooRequest query) {
        return getPage(query).getData();
    }

    public FoosPage getPage(FooRequest query) {
        return client.getPage(query);
    }
}
