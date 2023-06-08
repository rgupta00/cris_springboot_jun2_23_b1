package com.productapp.service.actuator;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

@Service
@Endpoint(id = "custom-endpoint")
public class CustomEndpoints {
   
	@Autowired
	private DataSource dataSource;
	
	@ReadOperation
    public String getCustomData(){
		String message="databse is down";
		if(dataSource!=null) {
			message="databse is up";
		}
        return message;
    }
}
