package com.myorg.javacourse.servlet;

import java.io.IOException;
import javax.servlet.http.*;
import com.myorg.javacourse.model.Portfolio;
import com.myorg.javacourse.service.PortfolioManager;

@SuppressWarnings("serial")
/**
 * This class provide information about all the portfolio that created.
 */
	public class PortfolioServlet extends HttpServlet {
	/*
	 * This method creats new portfolios and manage all commands of them.
	 * At last, the method is present all the portfolio detailes.7
	 */
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
