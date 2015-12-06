package com.myorg.javacourse.servlet;

import java.io.IOException;
import javax.servlet.http.*;
import com.myorg.javacourse.MathManager;
import com.myorg.javacourse.model.Portfolio;
import com.myorg.javacourse.service.PortfolioManager;

@SuppressWarnings("serial")

	public class PortfolioServlet extends HttpServlet {
		public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
			
			resp.setContentType("text/html");
			PortfolioManager portfolioManager = new PortfolioManager();
			Portfolio portfolio1 = portfolioManager.getPortfolio();
			Portfolio portfolio2 = new Portfolio(portfolio1);
			portfolio2.setTitle("Portfolio #2");
			resp.getWriter().println(portfolio1.getHtmlString() + "<br><br>" + portfolio2.getHtmlString());
			portfolio1.removeFirstStock();
			resp.getWriter().println(portfolio1.getHtmlString() + "<br><br>" + portfolio2.getHtmlString());
			portfolio2.changeLastStockBid(55.55f);
			resp.getWriter().println(portfolio1.getHtmlString() + "<br><br>" + portfolio2.getHtmlString());
		}
	}
