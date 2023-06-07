package com.productapp.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//---Infra bean + BB
@Configuration
public class CacheConfig {

	//@Bean is used to define infra str bean 
	//@Bean vs @Component
	
	@Bean
	public CacheManager cacheManager() {
		ConcurrentMapCacheManager cacheObject=new ConcurrentMapCacheManager("ProductCache");
		return cacheObject;
	}
}
