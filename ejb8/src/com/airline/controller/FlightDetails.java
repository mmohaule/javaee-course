package com.airline.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.airline.service.FlightServiceLocal;

@WebServlet("/FlightDetails")
public class FlightDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB(beanName="FlightServiceStateless")
	private FlightServiceLocal fsStateless;
	
	@EJB(beanName="FlightServiceStatelful")
	private FlightServiceLocal fsStateful;

	public FlightDetails() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		response.setContentType("text/html");

		out.println("<h3>Flight Details (via Local Interface)</h3>");

		out.println("<h6>Stateless</h6>");
		out.println("<p>To	: " + fsStateless.getTo() + "</p>");
		out.println("<p>From	: " + fsStateless.getFrom() + "</p>");
		
		out.println("<h6>Stateful</h6>");
		out.println("<p>To	: " + fsStateful.getTo() + "</p>");
		out.println("<p>From	: " + fsStateful.getFrom() + "</p>");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
