package com.demo;

import javax.xml.ws.Endpoint;

public class DemoWs {
	
	public static void main(String[] args) {
		Endpoint.publish("http://localhost:8080/ws", new Cal());
	}

}
