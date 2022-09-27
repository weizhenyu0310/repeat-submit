package com.repeatsubmit.autoconfigure;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.*;

/**
 * Filter配置
 *
 * @author repeatsubmit
 */
@Configuration
//@ComponentScan("com.repeatsubmit.autoconfigure")
@EnableConfigurationProperties(RepeatSubmitProperties.class)
@ConditionalOnProperty(
        prefix = "repeatsubmit",
        name = "enable",
        havingValue = "true",
        matchIfMissing = true
)
public class RepeatSubmitAutoConfiguration {

    private static final Logger logger = LoggerFactory.getLogger(RepeatSubmitAutoConfiguration.class);

    private final RepeatSubmitProperties properties;

    public RepeatSubmitAutoConfiguration(RepeatSubmitProperties properties) {
        this.properties = properties;
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Bean
    public FilterRegistrationBean someFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new RepeatableFilter());
        registration.addUrlPatterns("/*");
        registration.setName("repeatableFilter");
        registration.setOrder(FilterRegistrationBean.LOWEST_PRECEDENCE);
        return registration;
    }

}
