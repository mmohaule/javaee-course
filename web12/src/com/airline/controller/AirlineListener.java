package com.airline.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.airline.models.Passenger;

@WebListener
public class AirlineListener implements ServletContextListener {

    public AirlineListener() {
    }

    public void contextDestroyed(ServletContextEvent sce)  { 
    }

    public void contextInitialized(ServletContextEvent sce)  {
    	
    	ServletContext sc = sce.getServletContext();
    	
    	List<Passenger> passengers = new ArrayList<Passenger>();
    	
    	sc.setAttribute("passengers", passengers);
    }
	
}
