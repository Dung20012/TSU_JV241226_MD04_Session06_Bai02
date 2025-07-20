package com.data.session_06.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

public class DispatcherServletInit extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        // khai báo các cấu hình gốc
        return new Class[0];
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        // các cấu hình liên quan tới web mvc
        return new Class[]{WebConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        // cấu hình đường dẫn ánh xạ
        return new String[]{"/"}; // khớp với localhost:8080
    }

    // cấu hình character encoding
    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding("UTF-8");
        filter.setForceEncoding(true);
        return new Filter[]{filter};
    }
}
