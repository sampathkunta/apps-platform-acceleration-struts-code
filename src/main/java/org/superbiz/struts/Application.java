package org.superbiz.struts;

import com.opensymphony.module.sitemesh.filter.PageFilter;
import org.apache.struts2.dispatcher.ActionContextCleanUp;
import org.apache.struts2.dispatcher.FilterDispatcher;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import java.util.Collections;

@SpringBootApplication
public class Application {

    public static void main(String... args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public FilterRegistrationBean filterDispatcher(){
        return buildFilterRegistration(0, new FilterDispatcher());
    }

    @Bean
    public FilterRegistrationBean actionContextCleanUp() {
        return buildFilterRegistration(1, new ActionContextCleanUp());
    }

    @Bean
    public FilterRegistrationBean pageFilter() {
        return buildFilterRegistration(2, new PageFilter());
    }

    private FilterRegistrationBean buildFilterRegistration(int order, javax.servlet.Filter filter) {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(filter);
        filterRegistrationBean.setUrlPatterns(Collections.singletonList("/*"));
        filterRegistrationBean.setOrder(order);
        return filterRegistrationBean;
    }
}
