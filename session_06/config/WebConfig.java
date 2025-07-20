package com.data.session_06.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration // chú thích đây là 1 lớp cấu hình, định nghĩa các bean (các đối tượng đc spring khởi tạo quản lí)
@EnableWebMvc // sử dụng các cấu hình mặc định của Web MVC
@ComponentScan(basePackages = {"com.data.session_06.controller","com.data.session_06.model"}) // quét các thành phần của ứng dụng và tự tạo bean cho các thành phần đó
// quét các thành phần của ứng dụng và tự động tạo bean cho các thành phần đó: (@Component, @Controller, @Service, @Repository)
public class WebConfig {
    // tạo các bean view resolver
    @Bean
    public ViewResolver resolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/"); // chỉ định thư mục chứa giao diện
        resolver.setSuffix(".jsp"); // đuôi của giao diện
        return resolver;
    }
}
