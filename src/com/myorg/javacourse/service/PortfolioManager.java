package com.myorg.javacourse.service;
import java.util.Date;

import com.myorg.javacourse.model.Portfolio;
import com.myorg.javacourse.model.Stock;

/**
 * This class generate new portfolio and adding some stocks and their values by using method getPortfolio.  
 * 
 * @author Rom Vahav
 */
public class PortfolioManager {
	/**
	 * This method generate new portfolio and adding some stocks and their values and then return 
	 * the portfolio.  
	 */
	public Portfolio getPortfolio(){
		
		Portfolio myPortfolio = new Portfolio();
		myPortfolio.setTitle("Exercise 7 portfolio");
		myPortfolio.updateBalance(10000);
		Stock stock1 = new Stock ("PIH", new Date ("12/15/2014"), 10.0f , 8.5f);
		myPortfolio.addStock(stock1);
		Stock stock2 = new Stock ("AAL", new Date ("12/15/2014"), 30.0f , 25.5f);
		myPortfolio.addStock(stock2);
		Stock stock3 = new Stock ("CAAS", new Date ("12/15/2014"), 20.0f , 15.5f);
		myPortfolio.addStock(stock3);
		
		myPortfolio.buyStock(stock1, 20);
		myPortfolio.buyStock(stock2, 30);
		myPortfolio.buyStock(stock3, 40);
		
		myPortfolio.sellStock("AAL",-1);
		myPortfolio.removeStock("CAAS");
		return myPortfolio;
	}

}
