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

	@EJB(beanName = "FlightServiceStateless")
	private FlightServiceLocal fsStateless;

	@EJB(beanName = "FlightServiceStateless")
	private FlightServiceLocal fsStateless2;

	@EJB(beanName = "FlightServiceStatelful")
	private FlightServiceLocal fsStateful;

	@EJB(beanName = "FlightServiceStatelful")
	private FlightServiceLocal fsStateful2;

	public FlightDetails() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		response.setContentType("text/html");

		out.println("<h3>Flight Details (via Local Interface)</h3>");

		out.println("<h4>Stateless</h4>");
		out.println("<p>fsStateless :From <i>" + fsStateless.getFrom() +
				"</i> to <i>" + fsStateless.getTo() + "</i></p>");

		out.println("-------------------- After --------------------");

		fsStateless2.setFrom("Durban");
		fsStateless.setTo("Cape Town");
		out.println("<p>fsStateless: From <i>" + fsStateless.getFrom() +
				"</i> to <i>" + fsStateless.getTo() + "</i></p>");
		out.println("<p>fsStateless2: From <i>" + fsStateless.getFrom() +
				"</i> to <i>" + fsStateless2.getTo() + "</i></p>");

		out.println("<h4>Stateful</h4>");
		out.println("<p>From <i>" + fsStateful.getFrom() +
				"</i> to <i>" + fsStateful.getTo() + "</i></p>");
		
		out.println("-------------------- After --------------------");
		
		fsStateful2.setFrom("Durban");
		fsStateful2.setTo("Cape Town");
		out.println("<p>From <i>" + fsStateful.getFrom() +
				"</i> to <i>" + fsStateful.getTo() + "</i></p>");
		out.println("<p>From <i>" + fsStateful2.getFrom() +
				"</i> to <i>" + fsStateful2.getTo() + "</i></p>");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
