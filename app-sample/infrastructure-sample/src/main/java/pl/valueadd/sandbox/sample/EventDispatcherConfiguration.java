package pl.valueadd.sandbox.sample;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.valueadd.sandbox.eventdispatcher.EventDispatcher;

@Configuration
class EventDispatcherConfiguration {
    @Bean
    public EventDispatcher eventDispatcher(){
        return event -> {
            // TODO empty event dispatcher
        };
    }
}
