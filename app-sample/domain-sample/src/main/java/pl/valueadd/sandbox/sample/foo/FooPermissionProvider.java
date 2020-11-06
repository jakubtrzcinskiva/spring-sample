package pl.valueadd.sandbox.sample.foo;

import lombok.RequiredArgsConstructor;
import pl.valueadd.sandbox.permission.dto.Permission;
import pl.valueadd.sandbox.sample.foo.dto.Foo;
import pl.valueadd.sandbox.sample.foo.dto.FooUpdate;
import pl.valueadd.sandbox.sample.foo.dto.FooCreate;
import pl.valueadd.sandbox.sample.foo.dto.FooRequest;
import pl.valueadd.sandbox.sample.foo.dto.FooPermission;
import pl.valueadd.sandbox.sample.foo.dto.FoosPermission;

@RequiredArgsConstructor
class FooPermissionProvider {

    public Permission canUpdate(Foo model) {
        return Permission.allow();
    }

    public Permission canUpdate(Foo model, FooUpdate update) {
        return Permission.allow();
    }

    public Permission canCreate(FooCreate create) {
        return Permission.allow();
    }

    public Permission canDelete(Foo model) {
        return Permission.allow();
    }

    public Permission canRead(Foo model) {
        return Permission.allow();
    }

    public Permission canRead(FooRequest query) {
        return Permission.allow();
    }

    public FooPermission get(Foo model) {
        return new FooPermission(canUpdate(model), canDelete(model));
    }

    public FoosPermission getList() {
        return new FoosPermission(Permission.allow());
    }
}
