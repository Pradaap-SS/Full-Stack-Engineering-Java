package com.spring.app;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("com.spring.app")
public class ApplicationConfig {
    
    @Bean(name="pass")
    public Passport passport(){
        return new Passport();
    }
   
    @Bean(name="emp")
    public Employee employee(){
        return new Employee();
    }

}
