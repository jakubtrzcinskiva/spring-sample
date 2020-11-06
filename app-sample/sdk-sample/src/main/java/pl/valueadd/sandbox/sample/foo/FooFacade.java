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

public interface FooFacade {

    Optional<Foo> findById(UUID id);

    Foo getOne(UUID id);

    Foo create(FooCreate model);

    Foo update(UUID id, FooUpdate model);

    void delete(UUID id);

    List<Foo> findAll(FooRequest query);

    FoosPage getPage(FooRequest query);
}
