package com.airline.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.airline.service.FlightService;

@WebServlet("/FlightDetails")
public class FlightDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private FlightService flightService;
       
    public FlightDetails() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		response.setContentType("text/html");
		
		out.println("<h3>Flight Details</h3>");
		out.println("<p>To	: " + flightService.getTo() + "</p>");
		out.println("<p>From: " + flightService.getFrom() + "</p>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
