package pl.valueadd.sandbox.sample.foo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class FoosPage implements Serializable {

    private FoosPermission permission;

    private long total;

    private List<Foo> data;

    public Optional<Foo> findFirst() {
        return data.stream().findFirst();
    }
}
