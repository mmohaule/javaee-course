package com.airline.controller;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/add_passenger.jsp");

		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setAttribute("errors", false);

		String firstname = request.getParameter("firstname");
		if (firstname.isEmpty()) {
			System.out.println("Error: Empty firstname");
			request.setAttribute("errors", true);
			request.setAttribute("firstname_error", true);
		} else
			System.out.println("Firstname: " + firstname);

		String lastname = request.getParameter("lastname");
		if (lastname.isEmpty()) {
			System.out.println("Error: Empty lastname");
			request.setAttribute("errors", true);
			request.setAttribute("lastname_error", true);
		} else
			System.out.println("Lastname: " + lastname);

		String gender = request.getParameter("gender");
		System.out.println("Gender: " + gender);

		String dob_raw = request.getParameter("dob");

		String patternStr = "^\\d{1,2}\\/\\d{1,2}\\/\\d{4}$";
		Pattern pattern = Pattern.compile(patternStr);
		Matcher matcher = pattern.matcher(dob_raw);

		if (matcher.find()) {
			String dobArray[] = dob_raw.split("\\/");

			String day = dobArray[0];
			String month = dobArray[1];
			String year = dobArray[2];

			Calendar cal = Calendar.getInstance();

			cal.set(Calendar.YEAR, Integer.parseInt(year));
			cal.set(Calendar.MONTH, Integer.parseInt(month) - 1);
			cal.set(Calendar.DAY_OF_MONTH, Integer.parseInt(day));

			Date dob = cal.getTime();
			System.out.println("D.O.B: " + dob);
		} else {
			System.out.println("Invalid Date!");
			request.setAttribute("errors", true);
			request.setAttribute("date_error", true);
		}

		if ((Boolean)request.getAttribute("errors")) {

			RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/add_passenger.jsp");
			view.forward(request, response);
		}
	}

}
