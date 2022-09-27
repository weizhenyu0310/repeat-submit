package com.repeatsubmit.autoconfigure;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;

/**
 * 注册Bean
 *
 * @author repeatsubmit
 */
@Configuration
@ConditionalOnProperty(
        prefix = "repeatsubmit",
        name = "enable",
        havingValue = "true",
        matchIfMissing = true
)
public class DefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {

        @Override
        public void postProcessBeanFactory(ConfigurableListableBeanFactory arg0)
                throws BeansException {

        }

        /**
         * 先执行postProcessBeanDefinitionRegistry方法
         * 在执行postProcessBeanFactory方法
         */
        @Override
        public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry)
                throws BeansException {
            // 注册bean
            registerBean(registry, "repeatSubmitWebMvcConfigurer", RepeatSubmitWebMvcConfigurer.class);
            registerBean(registry, "sameUrlDataInterceptor", SameUrlDataInterceptor.class);
        }
        /**
         注册bean
         **/
        private void registerBean(BeanDefinitionRegistry registry, String name, Class<?> beanClass) {
            RootBeanDefinition bean = new RootBeanDefinition(beanClass);
            registry.registerBeanDefinition(name, bean);
        }
    }