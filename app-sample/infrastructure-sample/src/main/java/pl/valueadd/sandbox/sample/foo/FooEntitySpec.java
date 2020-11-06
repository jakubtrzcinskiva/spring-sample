package pl.valueadd.sandbox.sample.foo;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import pl.valueadd.sandbox.sample.foo.dto.FooRequest;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaBuilder;

@RequiredArgsConstructor
class FooEntitySpec implements Specification<FooEntity> {

    private final FooRequest spec;

    @Override
    public Predicate toPredicate(Root<FooEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        return null;
    }
}
