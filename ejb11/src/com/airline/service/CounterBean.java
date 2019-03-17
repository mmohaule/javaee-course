package com.airline.service;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;

@Singleton
@LocalBean
public class CounterBean {
	
	Integer counter = 0;

	public CounterBean() {
    }
	
	public Integer getCounter() {
		return counter;
	}

	public void setCounter(Integer counter) {
		this.counter = counter;
	}
	
	public void incrementCounter() {
		counter++;
	}

}
