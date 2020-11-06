package pl.valueadd.sandbox.sample.foo.event;

import java.io.Serializable;
import pl.valueadd.sandbox.sample.foo.dto.Foo;
import lombok.RequiredArgsConstructor;
import lombok.Getter;

@RequiredArgsConstructor
@Getter
public class FooCreatedEvent implements Serializable {

    private final Foo foo;
}
