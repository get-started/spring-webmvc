package org.spring.examples.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by L.x on 15-1-22.
 */
@Configuration
@EnableWebMvc
@ComponentScan("org.spring.examples.scope")
public class ApplicationConfig {
}
