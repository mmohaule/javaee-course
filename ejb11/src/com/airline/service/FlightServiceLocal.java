package com.airline.service;

import javax.ejb.Local;

@Local
public interface FlightServiceLocal {

	public Integer getId();

	public void setId(Integer id);

	public String getTo();

	public void setTo(String to);

	public String getFrom();

	public void setFrom(String from);

	public String getAirplaneModel();

	public void setAirplaneModel(String airplaneModel);

	public Integer getPrice();

	public void setPrice(Integer price);

	public Integer getNumOfSeats();

	public void setNumOfSeats(Integer numOfSeats);

	public String toString();
}
