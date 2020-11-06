package pl.valueadd.sandbox.sample.foo;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
abstract class FooEntityMapper {

    public abstract FooState toDto(FooEntity entity);

    public abstract FooEntity toEntity(FooState model);

    public abstract FooEntity applyChanges(@MappingTarget() FooEntity entity, FooState model);
}
