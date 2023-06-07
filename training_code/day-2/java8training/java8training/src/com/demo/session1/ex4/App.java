package com.demo.session1.ex4;

import java.util.Optional;
class InsuranceNotFound extends RuntimeException{
}
public class App {

	
	public static String getInsuranceCompanyName(Optional<Person> opPerson) {
	
		
			Optional<String> map = opPerson
					.flatMap(p->p.getCar())
					.flatMap(c->c.getInsurance())
					.map(i->i.getCompanyName());
				
		

		
		
		return opPerson
				.flatMap(p->p.getCar())
				.flatMap(c->c.getInsurance())
				.map(i->i.getCompanyName()).orElse("not found");
	
		

	}

}
