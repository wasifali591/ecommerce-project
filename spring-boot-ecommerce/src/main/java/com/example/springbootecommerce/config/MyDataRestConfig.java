package com.example.springbootecommerce.config;

import com.example.springbootecommerce.entity.Product;
import com.example.springbootecommerce.entity.ProductCategory;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {

        HttpMethod[] theUnsupportedAction = {HttpMethod.PUT, HttpMethod.DELETE, HttpMethod.POST};

        //disable HttpMethod for Product: POST, PUT, DELETE
        config.getExposureConfiguration()
                .forDomainType(Product.class)
                .withItemExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedAction))
                .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedAction));
        RepositoryRestConfigurer.super.configureRepositoryRestConfiguration(config, cors);

        //disable HttpMethod for ProductCategory: POST, PUT, DELETE
        config.getExposureConfiguration()
                .forDomainType(ProductCategory.class)
                .withItemExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedAction))
                .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedAction));
        RepositoryRestConfigurer.super.configureRepositoryRestConfiguration(config, cors);
    }
}
