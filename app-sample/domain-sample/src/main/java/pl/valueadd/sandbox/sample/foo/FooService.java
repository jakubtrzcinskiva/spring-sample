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

interface FooService {

    Optional<Foo> findById(UUID id);

    Foo getOne(UUID id);

    Foo create(@Valid() FooCreate model);

    Foo update(UUID id, @Valid() FooUpdate model);

    void delete(UUID id);

    List<Foo> findAll(FooRequest query);

    long count(FooRequest query);

    FoosPage getPage(FooRequest query);
}
