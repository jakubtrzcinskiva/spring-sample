package pl.valueadd.sandbox.sample.foo;

import org.mapstruct.Mapper;
import pl.valueadd.sandbox.sample.foo.dto.Foo;
import pl.valueadd.sandbox.sample.foo.dto.FooCreate;
import org.mapstruct.MappingTarget;
import pl.valueadd.sandbox.sample.foo.dto.FooUpdate;

@Mapper(componentModel = "spring")
abstract class FooMapper {

    public abstract Foo toDto(FooEntity entity);

    public abstract FooEntity toEntity(FooCreate model);

    public abstract FooEntity applyChanges(@MappingTarget() FooEntity entity, FooUpdate model);
}
