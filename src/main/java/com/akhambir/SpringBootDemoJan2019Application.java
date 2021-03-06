package com.akhambir;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;


//@EnableScheduling
@SpringBootApplication
public class SpringBootDemoJan2019Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemoJan2019Application.class, args);
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration conf = new CorsConfiguration().applyPermitDefaultValues();
        conf.addAllowedOrigin("http://localhost:4200");
        conf.addAllowedMethod(HttpMethod.GET);
        conf.addAllowedMethod(HttpMethod.POST);
        conf.addAllowedMethod(HttpMethod.PUT);
        source.registerCorsConfiguration("/**", conf);
        return source;
    }
}
