package com.airline.controller;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AddPassenger")
public class AddPassenger extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddPassenger() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/add_passenger.jsp");
		
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String gender = request.getParameter("gender");
		String dob_raw = request.getParameter("dob");
		
		String dobArray[] = dob_raw.split("\\/");
		
		String day = dobArray[0];
		String month = dobArray[1];
		String year = dobArray[2];
		
		Calendar cal = Calendar.getInstance();
		
		cal.set(Calendar.YEAR, Integer.parseInt(year));
		cal.set(Calendar.MONTH, Integer.parseInt(month));
		cal.set(Calendar.DAY_OF_MONTH, Integer.parseInt(day));
		
		Date dob = cal.getTime();
	}

}
