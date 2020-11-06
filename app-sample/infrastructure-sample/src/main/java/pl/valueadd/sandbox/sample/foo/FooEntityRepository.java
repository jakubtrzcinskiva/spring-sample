package pl.valueadd.sandbox.sample.foo;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

interface FooEntityRepository extends JpaRepository<FooEntity, UUID>, JpaSpecificationExecutor<FooEntity> {
}
