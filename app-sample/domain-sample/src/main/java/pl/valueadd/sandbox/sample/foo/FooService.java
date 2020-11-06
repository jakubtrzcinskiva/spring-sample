package pl.valueadd.sandbox.sample.foo;

import pl.valueadd.sandbox.sample.foo.dto.*;

import java.util.Optional;
import java.util.UUID;
import javax.validation.Valid;
import java.util.List;

interface FooService {

    Optional<FooState> findById(UUID id);

    FooState getOne(UUID id);

    FooState create(@Valid() FooState model);

    FooState update(UUID id, @Valid() FooState model);

    void delete(UUID id);

    List<FooState> findAll(FooRequest query);

    long count(FooRequest query);

}
