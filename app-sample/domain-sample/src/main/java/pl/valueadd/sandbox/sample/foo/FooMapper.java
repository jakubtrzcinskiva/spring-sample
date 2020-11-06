package pl.valueadd.sandbox.sample.foo;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;
import pl.valueadd.sandbox.sample.foo.dto.Foo;
import pl.valueadd.sandbox.sample.foo.dto.FooCreate;
import pl.valueadd.sandbox.sample.foo.dto.FooUpdate;

@Mapper(componentModel = "spring")
abstract class FooMapper {

    @Autowired
    protected FooPermissionProvider permissionProvider;

    @Mapping(target = "permission", expression = "java(permissionProvider.get(foo))")
    public abstract Foo toDto(FooState state);

    public abstract FooState toState(FooCreate model);

    public abstract FooState applyChanges(@MappingTarget() FooState state, FooUpdate model);
}
