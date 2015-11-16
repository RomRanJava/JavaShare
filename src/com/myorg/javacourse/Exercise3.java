package com.myorg.javacourse;
import java.io.IOException;
//import java.Math;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class Exercise3 extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		resp.setContentType("text/html");
		
		MathManager mathManager = new MathManager(50, 20, 13, 30, 50);
		resp.getWriter().println(mathManager.getResults());
		
	}
}