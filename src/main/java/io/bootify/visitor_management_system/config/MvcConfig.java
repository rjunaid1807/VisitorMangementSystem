package io.bootify.visitor_management_system.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class MvcConfig  implements WebMvcConfigurer {
    @Value("${static.dir.path}")
    private String staticDir;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("/files/**")
                .addResourceLocations("file:///C:/Users/rjuna/IdeaProjects/visitor-management-system/images/");
    }
}
// http://localhost:8080/files/testfile_1678608008323_Amit.jpg