package com.myorg.javacourse.model;
import com.myorg.javacourse.*;
/**
 * class which hold some stocks and their values.
 *
 */
public class Portfolio {

	private final static int MAX_PORTFOLIO_SIZE = 5;
	private String title;
	private Stock[] stocks;
	private int portfolioSize;
	
	public Portfolio(){
		this.stocks = new Stock[MAX_PORTFOLIO_SIZE];
	}
	
	public Portfolio(Portfolio portfolio){
		
		this.title = portfolio.getTitle();
		this.stocks = new Stock[MAX_PORTFOLIO_SIZE];
		for(int i= 0; i < portfolio.portfolioSize; i++){
			this.stocks[i] = new Stock(portfolio.stocks[i]);
		}
		this.portfolioSize = portfolio.getPortfolioSize();
	}
	/**
	 * This method remove the first stock in the portfolio.
	 * The method checks if the portfolio is not empty, then the method remove the first stock
	 * by overwriting his place with the next stock after him.
	 * If the portfolio is empty, the method does nothing.
	 */
	public void removeFirstStock(){
		if(getPortfolioSize()>0)
		{
			for (int i = 0; i < getPortfolioSize()-1; i++)
			{
				this.stocks[i] = this.stocks[i+1];
			}
			this.portfolioSize--;
		}
	}
	/**
	 * This method change the bid's value of the last stock in the portfolio.
	 * The method checks if the portfolio is not empty, then the method change
	 * the bid's value of the last stock.
	 * If the portfolio is empty, the method does nothing.
	 */
	public void changeLastStockBid(float number){
		if(getPortfolioSize()>0)
		{
			this.stocks[getPortfolioSize()-1].setBid(number);
		}
	}
	/**
	 * This method add new stock to the portfolio.
	 * The method check if there is space in the portfolio to add another
	 * stock, then it adds the stock to the end of the portfolio and increase the portfolio size by 1.
	 */
	public void addStock (Stock stock){
		
		if (portfolioSize < MAX_PORTFOLIO_SIZE)
		{
			this.stocks[portfolioSize] = stock;
			portfolioSize++;
		}
	}
	
	public Stock[] getStocks (){		
		return this.stocks;
	}	
	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public int getPortfolioSize() {
		return portfolioSize;
	}

	public String getHtmlString(){
		
		String str = "<h1>"  + this.title + "</h1>";	
		for(int i = 0; i < portfolioSize; i++)
		{
			str = str +"<br>"+this.stocks[i].getHtmlDescription();
		}
		return str;	
	}
}
