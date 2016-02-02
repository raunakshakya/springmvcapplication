package com.springapp.mvc.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by Raunak Shakya on 2/2/2016.
 */
@Configuration
@EnableWebMvc
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
        //registry.addResourceHandler("/styles*").addResourceLocations("/styles/");
        //registry.addResourceHandler("/fonts*").addResourceLocations("/fonts/");
        //registry.addResourceHandler("/scripts*").addResourceLocations("/scripts/");
    }

/*    public void addResourceHandlersTEST(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/assets*")
                .addResourceLocations("classpath:/assets/");
        registry.addResourceHandler("/styles*")
                .addResourceLocations("/styles/");
        registry.addResourceHandler("/fonts*")
                .addResourceLocations("/fonts/");
        registry.addResourceHandler("/scripts*")
                .addResourceLocations("/scripts/");
    }*/
}
