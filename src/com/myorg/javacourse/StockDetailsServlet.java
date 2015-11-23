package com.myorg.javacourse;

import java.io.IOException;
import javax.servlet.http.*;
import java.util.Date;

public class StockDetailsServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		resp.setContentType("text/html");
		Stock stock1 = new Stock ("PIH", new Date ("11/15/2014"), 13.1f , 12.4f);
		Stock stock2 = new Stock ("AAL", new Date ("11/15/2014"), 5.78f , 5.5f);
		Stock stock3 = new Stock ("CAAS", new Date ("11/15/2014"), 32.2f , 31.5f);
		
		resp.getWriter().println(stock1.getHtmlDescription() + "<br><br>");
		resp.getWriter().println(stock2.getHtmlDescription() + "<br><br>");
		resp.getWriter().println(stock3.getHtmlDescription());
	}
}