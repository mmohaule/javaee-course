package com.airline.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.airline.service.FlightService;

@WebServlet("/FlightDetails")
public class FlightDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private FlightService fs = null;

	public FlightDetails() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		response.setContentType("text/html");

		out.println("<h3>Stateless EJB Nature I</h3>");

		try {
			Context context = new InitialContext();
			fs = (FlightService) context.lookup("java:global/ejb5/FlightService!com.airline.service.FlightService");

		} catch (Exception e) {
			System.out.println("EJB Not Found!");
			e.printStackTrace();
		}

		out.println("<p>To	: " + fs.getTo() + "</p>");
		out.println("<p>From	: " + fs.getFrom() + "</p>");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
