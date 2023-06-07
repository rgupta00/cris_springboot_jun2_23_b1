package com.demo.session1.ex4;

import java.util.Optional;

//A car may or may not have a insurance
class Car {
	private Optional<Insurance> insurance;

	public Optional<Insurance> getInsurance() {
		return insurance;
	}

	public void setInsurance(Optional<Insurance> insurance) {
		this.insurance = insurance;
	}

	
	
}