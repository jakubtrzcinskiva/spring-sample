package pl.valueadd.sandbox.sample.foo;

import lombok.RequiredArgsConstructor;
import pl.valueadd.sandbox.sample.foo.dto.*;
import pl.valueadd.sandbox.sample.foo.event.FooCreatedEvent;
import pl.valueadd.sandbox.sample.foo.event.FooUpdatedEvent;
import pl.valueadd.sandbox.sample.foo.event.FooDeletedEvent;
import pl.valueadd.sandbox.eventdispatcher.EventDispatcher;
import java.util.stream.Collectors;
import java.util.Optional;
import java.util.UUID;
import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
class FooServiceImpl implements FooService {

    private final FooRepository repository;

    private final EventDispatcher eventDispatcher;

    private final FooMapper fooMapper;

    @Override
    public Optional<FooState> findById(UUID id) {
        return repository.findById(id).map(this::enrich);
    }

    @Override
    public FooState getOne(UUID id) {
        return enrich(repository.getOne(id));
    }

    @Override
    public FooState create(@Valid() FooState model) {
        final var ret = enrich(repository.create(model));
        eventDispatcher.dispatch(new FooCreatedEvent(fooMapper.toDto(ret)));
        return ret;
    }

    @Override
    public FooState update(UUID id, @Valid() FooState model) {
        final var ret = enrich(repository.update(id, model));
        eventDispatcher.dispatch(new FooUpdatedEvent(fooMapper.toDto(ret)));
        return ret;
    }

    @Override
    public void delete(UUID id) {
        eventDispatcher.dispatch(new FooDeletedEvent(fooMapper.toDto(getOne(id))));
        repository.delete(id);
    }

    @Override
    public List<FooState> findAll(FooRequest query) {
        return repository.findAll(query).stream().map(this::enrich).collect(Collectors.toList());
    }

    @Override
    public long count(FooRequest query) {
        return repository.count(query);
    }

    private FooState enrich(FooState model) {
        return model;
    }
}
