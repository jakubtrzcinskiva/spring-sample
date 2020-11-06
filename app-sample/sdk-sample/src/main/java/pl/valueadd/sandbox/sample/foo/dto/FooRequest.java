package pl.valueadd.sandbox.sample.foo.dto;

import pl.valueadd.sandbox.request.dto.BaseRequest;
import lombok.Getter;
import lombok.AllArgsConstructor;
import java.io.Serializable;

@Getter
@AllArgsConstructor
public class FooRequest extends BaseRequest implements Serializable {
}
