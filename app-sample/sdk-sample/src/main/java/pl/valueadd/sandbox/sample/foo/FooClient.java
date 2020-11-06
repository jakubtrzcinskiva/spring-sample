package pl.valueadd.sandbox.sample.foo;

import org.springframework.web.bind.annotation.RequestMapping;
import pl.valueadd.sandbox.sample.foo.dto.Foo;
import java.util.UUID;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import pl.valueadd.sandbox.sample.foo.dto.FoosPage;
import pl.valueadd.sandbox.sample.foo.dto.FooRequest;
import org.springframework.web.bind.annotation.PostMapping;
import pl.valueadd.sandbox.sample.foo.dto.FooUpdate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import pl.valueadd.sandbox.sample.foo.dto.FooCreate;
import org.springframework.web.bind.annotation.DeleteMapping;

@RequestMapping(value = "foo")
public interface FooClient {

    @GetMapping(value = "/{id}")
    public Foo getOne(@PathVariable(value = "id") UUID id);

    @PostMapping(value = "list")
    public FoosPage getPage(FooRequest query);

    @PutMapping(value = "/{id}", consumes = "application/json")
    public Foo update(@PathVariable(value = "id") UUID id, @RequestBody() FooUpdate update);

    @PostMapping(value = "", consumes = "application/json")
    public Foo create(@RequestBody() FooCreate create);

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable(value = "id") UUID id);
}
