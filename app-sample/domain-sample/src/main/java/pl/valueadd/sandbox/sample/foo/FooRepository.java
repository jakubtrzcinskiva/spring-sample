package pl.valueadd.sandbox.sample.foo;

import lombok.RequiredArgsConstructor;
import java.util.stream.Collectors;
import pl.valueadd.sandbox.sample.foo.exception.FooNotFoundException;
import pl.valueadd.sandbox.sample.foo.dto.Foo;
import java.util.Optional;
import java.util.UUID;
import pl.valueadd.sandbox.sample.foo.dto.FooCreate;
import javax.validation.Valid;
import pl.valueadd.sandbox.sample.foo.dto.FooUpdate;
import java.util.List;
import pl.valueadd.sandbox.sample.foo.dto.FooRequest;

interface FooRepository {

    Optional<Foo> findById(UUID id);

    Foo getOne(UUID id);

    Foo create(@Valid() FooCreate model);

    Foo update(UUID id, @Valid() FooUpdate model);

    void delete(UUID id);

    List<Foo> findAll(FooRequest query);

    long count(FooRequest query);
}
