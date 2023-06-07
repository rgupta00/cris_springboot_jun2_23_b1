package com.demo.session1.ex4;

import java.util.Optional;


// a person may or may not have a car!
class Person {
	private Optional<Car> car;

	public Optional<Car> getCar() {
		return car;
	}

	public void setCar(Optional<Car> car) {
		this.car = car;
	}
}