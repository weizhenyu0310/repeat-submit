package com.repeatsubmit.autoconfigure;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * WebMvcConfigurer
 *
 * @author repeatsubmit
 */
@Component
public class RepeatSubmitWebMvcConfigurer implements WebMvcConfigurer {

    private final SameUrlDataInterceptor sameUrlDataInterceptor;

    public RepeatSubmitWebMvcConfigurer(SameUrlDataInterceptor sameUrlDataInterceptor) {
        this.sameUrlDataInterceptor = sameUrlDataInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(sameUrlDataInterceptor).addPathPatterns("/**");
    }
}
