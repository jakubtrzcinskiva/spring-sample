package pl.valueadd.sandbox.sample.foo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.io.Serializable;
import pl.valueadd.sandbox.permission.dto.Permission;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class FooPermission implements Serializable {

    private Permission update;

    private Permission delete;
}
