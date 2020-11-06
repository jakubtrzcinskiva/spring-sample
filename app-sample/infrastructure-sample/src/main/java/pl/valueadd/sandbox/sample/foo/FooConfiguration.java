package pl.valueadd.sandbox.sample.foo;

import org.springframework.context.annotation.Configuration;
import pl.valueadd.sandbox.eventdispatcher.EventDispatcher;
import org.springframework.context.annotation.Bean;

@Configuration
class FooConfiguration {

    @Bean
    public FooFacade fooFacade(FooRepository domainRepo, EventDispatcher eventDispatcher, FooMapper mapper) {
        var service = new FooServiceImpl(domainRepo, eventDispatcher, mapper);
        return new DirectFooFacade(
                service,
                new FooCreator(service, mapper),
                new FooUpdater(service, mapper),
                new FooRemover(service),
                mapper,
                fooPermissionProvider()
        );
    }

    @Bean
    public FooPermissionProvider fooPermissionProvider() {
        return new FooPermissionProvider();
    }
}
