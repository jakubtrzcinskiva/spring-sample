package pl.valueadd.sandbox.sample.foo;

import lombok.RequiredArgsConstructor;
import pl.valueadd.sandbox.sample.foo.event.FooCreatedEvent;
import pl.valueadd.sandbox.sample.foo.event.FooUpdatedEvent;
import pl.valueadd.sandbox.sample.foo.event.FooDeletedEvent;
import pl.valueadd.sandbox.eventdispatcher.EventDispatcher;
import java.util.stream.Collectors;
import pl.valueadd.sandbox.sample.foo.dto.Foo;
import java.util.Optional;
import java.util.UUID;
import pl.valueadd.sandbox.sample.foo.dto.FooCreate;
import javax.validation.Valid;
import pl.valueadd.sandbox.sample.foo.dto.FooUpdate;
import java.util.List;
import pl.valueadd.sandbox.sample.foo.dto.FooRequest;
import pl.valueadd.sandbox.sample.foo.dto.FoosPage;

@RequiredArgsConstructor
class FooServiceImpl implements FooService {

    private final FooRepository repository;

    private final FooPermissionProvider permissionProvider;

    private final EventDispatcher eventDispatcher;

    @Override
    public Optional<Foo> findById(UUID id) {
        return repository.findById(id).map(this::enrich);
    }

    @Override
    public Foo getOne(UUID id) {
        return enrich(repository.getOne(id));
    }

    @Override
    public Foo create(@Valid() FooCreate model) {
        final var ret = enrich(repository.create(model));
        eventDispatcher.dispatch(new FooCreatedEvent(ret));
        return ret;
    }

    @Override
    public Foo update(UUID id, @Valid() FooUpdate model) {
        final var ret = enrich(repository.update(id, model));
        eventDispatcher.dispatch(new FooUpdatedEvent(ret));
        return ret;
    }

    @Override
    public void delete(UUID id) {
        eventDispatcher.dispatch(new FooDeletedEvent(getOne(id)));
        repository.delete(id);
    }

    @Override
    public List<Foo> findAll(FooRequest query) {
        return repository.findAll(query).stream().map(this::enrich).collect(Collectors.toList());
    }

    @Override
    public long count(FooRequest query) {
        return repository.count(query);
    }

    @Override
    public FoosPage getPage(FooRequest query) {
        return new FoosPage(permissionProvider.getList(), count(query), findAll(query));
    }

    private Foo enrich(Foo model) {
        model.setPermission(permissionProvider.get(model));
        return model;
    }
}
