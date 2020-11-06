package pl.valueadd.sandbox.sample.foo.controller;

import pl.valueadd.sandbox.sample.foo.FooClient;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import pl.valueadd.sandbox.sample.foo.FooFacade;
import pl.valueadd.sandbox.sample.foo.dto.Foo;
import java.util.UUID;
import org.springframework.web.bind.annotation.PathVariable;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import pl.valueadd.sandbox.sample.foo.dto.FoosPage;
import pl.valueadd.sandbox.sample.foo.dto.FooRequest;
import org.springframework.web.bind.annotation.GetMapping;
import pl.valueadd.sandbox.sample.foo.dto.FooUpdate;
import org.springframework.web.bind.annotation.RequestBody;
import pl.valueadd.sandbox.sample.foo.dto.FooCreate;

@RestController
@Api(tags = "Foos")
@RequiredArgsConstructor
class FooController implements FooClient {

    private final FooFacade facade;

    @ApiOperation(value = "Get single Foo")
    @PreAuthorize(value = "@permission.validate(@fooPermissionProvider.canRead(@fooFacade.getOne(#id)))")
    public Foo getOne(@PathVariable(value = "id") UUID id) {
        return facade.getOne(id);
    }

    @ApiOperation(value = "Find all Foos")
    @PreAuthorize(value = "@permission.validate(@fooPermissionProvider.canRead(#query))")
    public FoosPage getPage(FooRequest query) {
        return facade.getPage(query);
    }

    @GetMapping
    @ApiOperation(value = "Find all Foos")
    @PreAuthorize(value = "@permission.validate(@fooPermissionProvider.canRead(#query))")
    public FoosPage getPageGet(FooRequest query) {
        return facade.getPage(query);
    }

    @ApiOperation(value = "Update Foo")
    @PreAuthorize(value = "@permission.validate(@fooPermissionProvider.canUpdate(@fooFacade.getOne(#id), #update))")
    public Foo update(@PathVariable(value = "id") UUID id, @RequestBody() FooUpdate update) {
        return facade.update(id, update);
    }

    @ApiOperation(value = "Create Foo")
    @PreAuthorize(value = "@permission.validate(@fooPermissionProvider.canCreate(#create))")
    public Foo create(@RequestBody() FooCreate create) {
        return facade.create(create);
    }

    @ApiOperation(value = "Delete Foo")
    @PreAuthorize(value = "@permission.validate(@fooPermissionProvider.canDelete(@fooFacade.getOne(#id)))")
    public void delete(@PathVariable(value = "id") UUID id) {
        facade.delete(id);
    }
}
