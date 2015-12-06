package com.myorg.javacourse.service;
import java.util.Date;

import com.myorg.javacourse.model.Portfolio;
import com.myorg.javacourse.model.Stock;

/**
 * This class generate new portfolio and adding some stocks and their values by using method getPortfolio.  
 */
public class PortfolioManager {
	/**
	 * This method generate new portfolio and adding some stocks and their values and then return 
	 * the portfolio.  
	 */
	public Portfolio getPortfolio(){
		
		Portfolio portfolio = new Portfolio();
		portfolio.setTitle("Portfolio #1");
		Stock stock1 = new Stock ("PIH", new Date ("11/15/2014"), 13.1f , 12.4f);
		portfolio.addStock(stock1);
		Stock stock2 = new Stock ("AAL", new Date ("11/15/2014"), 5.78f , 5.5f);
		portfolio.addStock(stock2);
		Stock stock3 = new Stock ("CAAS", new Date ("11/15/2014"), 32.2f , 31.5f);
		portfolio.addStock(stock3);
		return portfolio;
	}

}
