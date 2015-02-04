package com.cardgame.doublesir.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

@Configuration
@ComponentScan(basePackages = "com.cardgame.doublesir", excludeFilters = {
    @Filter(value = Controller.class),
    @Filter(value = Configuration.class)
})
public class AppConfig {

}