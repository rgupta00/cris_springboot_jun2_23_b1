package com.demo.session1.ex4;

import java.util.Optional;

public class Demo {

	public static void main(String[] args) {
		Person p = new Person();
		Car c = new Car();
		Insurance ic = null; //	ic.setCompanyName("sun life");

		Optional<Person> pOpt = Optional.ofNullable(p);
		Optional<Car> carOpt = Optional.ofNullable(c);
		Optional<Insurance> icOpt = Optional.ofNullable(ic);

		p.setCar(carOpt);
		c.setInsurance(icOpt);
		
		String companyName=App.getInsuranceCompanyName(pOpt);
		
		System.out.println(companyName);
	}
}










