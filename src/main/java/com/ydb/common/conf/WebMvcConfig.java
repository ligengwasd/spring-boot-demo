package com.ydb.common.conf;

import com.ydb.common.interceptor.AuthInterceptor;
import com.ydb.common.validation.MessageAspect;
import com.ydb.common.validation.ValidAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by ligeng on 17/1/17.
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AuthInterceptor());
    }

    @Bean
    public ValidAspect commonValidAspect(){
        return new ValidAspect();
    }

    @Bean
    public MessageAspect messageAspect(){
        return new MessageAspect();
    }

    @Bean
    public ResourceBundleMessageSource messageSource(){
        ResourceBundleMessageSource source = new ResourceBundleMessageSource();
        source.setBasename("i18n.message");
        return source;
    }
}
