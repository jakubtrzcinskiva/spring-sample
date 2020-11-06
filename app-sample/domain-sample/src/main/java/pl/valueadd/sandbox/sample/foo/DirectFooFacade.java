package pl.valueadd.sandbox.sample.foo;

import lombok.RequiredArgsConstructor;
import pl.valueadd.sandbox.sample.foo.dto.Foo;
import java.util.Optional;
import java.util.UUID;
import pl.valueadd.sandbox.sample.foo.dto.FooCreate;
import pl.valueadd.sandbox.sample.foo.dto.FooUpdate;
import java.util.List;
import pl.valueadd.sandbox.sample.foo.dto.FooRequest;
import pl.valueadd.sandbox.sample.foo.dto.FoosPage;

@RequiredArgsConstructor
class DirectFooFacade implements FooFacade {

    private final FooService service;

    private final FooCreator createUseCase;

    private final FooUpdater updateUseCase;

    private final FooRemover deleteUseCase;

    @Override
    public Optional<Foo> findById(UUID id) {
        return service.findById(id);
    }

    @Override
    public Foo getOne(UUID id) {
        return service.getOne(id);
    }

    @Override
    public Foo create(FooCreate model) {
        return createUseCase.execute(model);
    }

    @Override
    public Foo update(UUID id, FooUpdate model) {
        return updateUseCase.execute(id, model);
    }

    @Override
    public void delete(UUID id) {
        deleteUseCase.execute(id);
    }

    @Override
    public List<Foo> findAll(FooRequest query) {
        return service.findAll(query);
    }

    @Override
    public FoosPage getPage(FooRequest query) {
        return service.getPage(query);
    }
}
