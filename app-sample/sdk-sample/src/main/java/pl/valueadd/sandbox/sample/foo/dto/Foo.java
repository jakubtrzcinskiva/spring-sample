package pl.valueadd.sandbox.sample.foo.dto;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Foo implements Serializable {

    private UUID id;

    private FooPermission permission;
}
