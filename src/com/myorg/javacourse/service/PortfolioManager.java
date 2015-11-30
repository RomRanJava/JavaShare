package com.myorg.javacourse.service;
import java.util.Date;

import com.myorg.javacourse.Stock;
import com.myorg.javacourse.model.Portfolio;

public class PortfolioManager {
	
	public Portfolio getPortfolio(){
		
		Portfolio portfolio = new Portfolio();
		portfolio.setTitle("Ran&Avi&Rom's Portfolio");
		Stock stock1 = new Stock ("PIH", new Date ("11/15/2014"), 13.1f , 12.4f);
		portfolio.addStock(stock1);
		Stock stock2 = new Stock ("AAL", new Date ("11/15/2014"), 5.78f , 5.5f);
		portfolio.addStock(stock2);
		Stock stock3 = new Stock ("CAAS", new Date ("11/15/2014"), 32.2f , 31.5f);
		portfolio.addStock(stock3);
		
		return portfolio;
	}

}
