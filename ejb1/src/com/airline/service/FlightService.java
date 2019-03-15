package com.airline.service;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class FlightService {

	private Integer id;
	private String to;
	private String from;
	private String airplaneModel;
	private Integer price;
	private Integer numOfSeats;
	
	public FlightService() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getAirplaneModel() {
		return airplaneModel;
	}

	public void setAirplaneModel(String airplaneModel) {
		this.airplaneModel = airplaneModel;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getNumOfSeats() {
		return numOfSeats;
	}

	public void setNumOfSeats(Integer numOfSeats) {
		this.numOfSeats = numOfSeats;
	}

	@Override
	public String toString() {
		return "FlightService [id=" + id + ", to=" + to + ", from=" + from + ", airplaneModel=" + airplaneModel
				+ ", price=" + price + ", numOfSeats=" + numOfSeats + "]";
	}
	
}
