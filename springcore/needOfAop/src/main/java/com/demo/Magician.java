package com.demo;

import org.springframework.stereotype.Component;

@Component
 public class Magician {
	public String doMagic() {
		System.out.println("abra ka dabra...");
		return "rabbit from the hat";
		
	}
}
