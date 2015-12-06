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
			Portfolio portfolio = portfolioManager.getPortfolio();
			Portfolio portfolio2 = new Portfolio(portfolio);
			portfolio2.setTitle("Portfolio #2");
			resp.getWriter().println(portfolio.getHtmlString() + "<br><br>" + portfolio2.getHtmlString());
		}
	}
