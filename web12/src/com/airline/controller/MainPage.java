package com.airline.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.airline.models.Passenger;

@WebServlet("")
public class MainPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MainPage() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		response.setContentType("text/html");
		
		ServletContext sc = this.getServletContext();
		@SuppressWarnings("unchecked")
		List<Passenger> passengers = (ArrayList<Passenger>) sc.getAttribute("passengers");
		out.println("New Passenger has been added");
		out.println("<p>List Size: " + passengers.size() + "</p>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
