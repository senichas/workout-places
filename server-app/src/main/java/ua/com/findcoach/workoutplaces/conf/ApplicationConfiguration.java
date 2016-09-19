package ua.com.findcoach.workoutplaces.conf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan({"ua.com.findcoach.workoutplaces.controllers",
                "ua.com.findcoach.workoutplaces.services",
                "ua.com.findcoach.workoutplaces.converters"})
@PropertySources({
    @PropertySource({"classpath:jdbc.properties"}),
    @PropertySource({"classpath:environment.properties"})
})
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
@Import({DatabaseConfiguration.class})
public class ApplicationConfiguration {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationConfiguration.class, args);
    }

}
