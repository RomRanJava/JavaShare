package com.myorg.javacourse;

import java.io.IOException;
//import java.Math;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class MathManager extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

		double radius = 50;
		double area;
		
		area = Math.PI * Math.pow(radius, 2);
		
		resp.getWriter().println("1. Area of circle with radius " + radius + " is: " + area + " square­cm \n");
		
		double angleB = 30;
		double hypotenuse = 50;
		double opposite;
		double radian;
		
		radian = Math.toRadians(angleB);
		opposite = Math.sin(radian) * hypotenuse;
		resp.getWriter().println("22. Length of opposite where angle B is 30 degrees and Hypotenuse length is 50 cm is: " + opposite + "\n");
		
		double base = 20;
		double exp = 13;
		double result;
		
		result = Math.pow(base, exp);
		resp.getWriter().println("3. Power of 20 with exp of 13 is: " + result + "\n");
		
	}
}
