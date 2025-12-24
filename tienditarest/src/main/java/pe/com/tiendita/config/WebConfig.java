package pe.com.tiendita.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer{
    
    
    public void addCorsMapings(CorsRegistry registry){
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("GET","POST","PUT","DELETE")
                .allowedHeaders("*");
    }
}
