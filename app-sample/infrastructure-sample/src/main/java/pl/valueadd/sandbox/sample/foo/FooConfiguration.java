package pl.valueadd.sandbox.sample.foo;

import org.springframework.context.annotation.Configuration;
import pl.valueadd.sandbox.eventdispatcher.EventDispatcher;
import org.springframework.context.annotation.Bean;

@Configuration
class FooConfiguration {

    @Bean
    public FooFacade fooFacade(FooRepository domainRepo, EventDispatcher eventDispatcher) {
        var service = new FooServiceImpl(domainRepo, fooPermissionProvider(), eventDispatcher);
        return new DirectFooFacade(service, new FooCreator(service), new FooUpdater(service), new FooRemover(service));
    }

    @Bean
    public FooPermissionProvider fooPermissionProvider() {
        return new FooPermissionProvider();
    }
}
