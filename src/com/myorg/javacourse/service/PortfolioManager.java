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
		
		Portfolio myPortfolio=new Portfolio("Exercise 7 portfolio");
		myPortfolio.updateBalance(10000);
		Stock stock1=new Stock("PIH",(float) 10.0,(float) 8.5);
		stock1.setDate(new Date ("12/15/2014"));
		Stock stock2=new Stock("AAL",(float) 30.0,(float) 25.5);
		stock2.setDate(new Date ("12/15/2014"));
		Stock stock3=new Stock("CAAS",(float) 20.0,(float) 15.5);
		stock3.setDate(new Date ("12/15/2014"));
		
		myPortfolio.buyStock(stock1, 20);
		myPortfolio.buyStock(stock2, 30);
		myPortfolio.buyStock(stock3, 40);
		
		myPortfolio.sellStock("AAL",-1);
		myPortfolio.removeStock("CAAS");
		return myPortfolio;
	}

}
