package com.repeatsubmit.autoconfigure;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author wzy
 * @date 2022/9/26 13:47
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
