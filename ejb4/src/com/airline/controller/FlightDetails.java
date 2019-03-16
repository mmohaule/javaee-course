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
	private FlightService fs;
       
    public FlightDetails() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		response.setContentType("text/html");
		
		out.println("<h3>Stateless EJB Nature I</h3>");
		
		fs.setTo("London");
		out.println("<p>To	: " + fs.getTo() + "</p>");
		
		fs.setTo("CapeTown"); //Could be refering to a different instance than above or below 
		out.println("<p>To	: " + fs.getTo() + "</p>");
		
		fs.setTo("Polokwane");
		out.println("<p>To	: " + fs.getTo() + "</p>");
		
		fs.setTo("Bloemfontein");
		out.println("<p>To	: " + fs.getTo() + "</p>");
		
		fs.setTo("Durban");
		out.println("<p>To	: " + fs.getTo() + "</p>");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
