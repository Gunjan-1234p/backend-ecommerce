package com.gp.ecommerce.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import com.gp.ecommerce.entity.Product;
import com.gp.ecommerce.entity.ProductCategory;
@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {

	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
		// TODO Auto-generated method stub
		RepositoryRestConfigurer.super.configureRepositoryRestConfiguration(config, cors);
	HttpMethod[] theUnsupportedActions = {HttpMethod.DELETE,
			HttpMethod.PUT,HttpMethod.POST};
	//disable httpsmethods put, post and delete for product
	config.getExposureConfiguration()
	.forDomainType(Product.class)
	.withItemExposure((metdata,httpMethods)->httpMethods.disable(theUnsupportedActions))
	.withCollectionExposure((metdata,httpMethods)->httpMethods.disable(theUnsupportedActions));
	
	//diable httpsmethod put,post and delete for product-category
	
	config.getExposureConfiguration()
	.forDomainType(ProductCategory.class)
	.withItemExposure((metdata,httpMethods)->httpMethods.disable(theUnsupportedActions))
	.withCollectionExposure((metdata,httpMethods)->httpMethods.disable(theUnsupportedActions));
	
	}
	
	
	
	

}
