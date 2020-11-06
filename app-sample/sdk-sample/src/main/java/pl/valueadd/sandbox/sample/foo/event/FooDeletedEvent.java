package pl.valueadd.sandbox.sample.foo.event;

import java.io.Serializable;
import pl.valueadd.sandbox.sample.foo.dto.Foo;
import lombok.RequiredArgsConstructor;
import lombok.Getter;

@RequiredArgsConstructor
@Getter
public class FooDeletedEvent implements Serializable {

    private final Foo foo;
}
