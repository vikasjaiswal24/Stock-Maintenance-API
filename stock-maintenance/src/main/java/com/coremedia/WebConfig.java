package com.coremedia;

import com.coremedia.handlerInterceptor.RedirectHandlerInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * This annotation is the main artifact used by the Java-based Spring configuration;
 * it is itself meta-annotated with @Component, which makes the annotated classes standard beans
 * and as such, also candidates for component-scanning.
 *
 * The main purpose of @Configuration classes is to be sources of bean definitions for the Spring IoC Container.
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    RedirectHandlerInterceptor requestHandler;

    /**
     * To add our interceptors into Spring configuration, we need to override addInterceptors() method
     * inside WebConfig class that implements WebMvcConfigurer:
     *
     * We may achieve the same configuration by editing our XML Spring configuration file like below:
     * <mvc:interceptors>
     *     <bean id="loggerInterceptor" class="org.baeldung.web.interceptor.LoggerInterceptor"/>
     * </mvc:interceptors>
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(requestHandler);
    }
}
