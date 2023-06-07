package com.productapp.service.schedling;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.productapp.service.ProductService;

@Service
public class AppScheduler {
	
	private Logger logger=LoggerFactory.getLogger(AppScheduler.class);
	
	private ProductService productService;
	
	
	@Autowired
	public AppScheduler(ProductService productService) {
		this.productService = productService;
	}

	@Scheduled(cron = "0/5 * * * * *")
	public void invalidateCachedPeriodically() {
		logger.info("invalidateCachedPeriodically  ");
		productService.evict();
	}
	
//	@Scheduled(initialDelay = 1000, fixedRate = 1500)
//	public void callMe() {
//		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
//	}

}
