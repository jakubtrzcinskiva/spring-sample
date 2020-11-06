package pl.valueadd.sandbox.sample;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.valueadd.sandbox.permission.PermissionValidator;

@Configuration
class PermissionValidatorConfiguration {
    @Bean(name = "permission")
    public PermissionValidator permissionValidator(){
        return new PermissionValidator();
    }
}
