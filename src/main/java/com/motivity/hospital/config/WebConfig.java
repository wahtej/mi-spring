package com.motivity.hospital.config;

import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.Arrays;
import java.util.Collections;

@EnableWebMvc
@Configuration
public class WebConfig {

    private static final int CORS_FILTER_ORDER = -102;
    //@Value("${domain.name}")
    private String domain;
    @Bean
    public FilterRegistrationBean corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
 config.setAllowedOriginPatterns(Arrays.asList("*"));
 config.setAllowedHeaders(Arrays.asList("*"));
 config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE"));
    //source.registerCorsConfiguration("/**", config);
//        config.setAllowCredentials(true);

//        config.addAllowedOrigin(domain);
        /*
        config.setAllowedHeaders(Arrays.asList(
                HttpHeaders.AUTHORIZATION,
                "X-XSRF-TOKEN",
                HttpHeaders.CONTENT_TYPE,
                HttpHeaders.ACCEPT));
        config.setAllowedMethods(Arrays.asList(
                HttpMethod.GET.name(),
                HttpMethod.POST.name(),
                HttpMethod.PUT.name(),
                HttpMethod.OPTIONS.name(),
                HttpMethod.DELETE.name())); */
        source.registerCorsConfiguration("/**", config);
        FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));

        // should be set order to -100 because we need to CorsFilter before SpringSecurityFilter
        //bean.setOrder(CORS_FILTER_ORDER);

        return bean;
    }
}
