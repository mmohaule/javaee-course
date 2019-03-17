package com.airline.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.airline.service.FlightServiceLocal;

@WebServlet("/FlightDetails")
public class FlightDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private FlightServiceLocal fsStateless;
	private FlightServiceLocal fsStateful;

	public FlightDetails() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		
		try {
			Context context = new InitialContext();
			fsStateless = (FlightServiceLocal) context.lookup("java:global/ejb10/FlightServiceStatelessBean!com.airline.service.FlightServiceLocal");
			fsStateful = (FlightServiceLocal) context.lookup("java:global/ejb10/FlightServiceStatelfulBean!com.airline.service.FlightServiceLocal");
			
		} catch (NamingException e) {
			System.out.println("Failed to find Session Bean");
			e.printStackTrace();
		}

		response.setContentType("text/html");

		out.println("<h3>Flight Details (via Local Interface)</h3>");

		out.println("<h4>Stateless</h4>");
		out.println("<p>From <i>" + fsStateless.getFrom() +
				"</i> to <i>" + fsStateless.getTo() + "</i></p>");

		out.println("<h4>Stateful</h4>");
		out.println("<p>From <i>" + fsStateful.getFrom() +
				"</i> to <i>" + fsStateful.getTo() + "</i></p>");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
