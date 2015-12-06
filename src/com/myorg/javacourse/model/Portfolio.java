package com.myorg.javacourse.model;
import com.myorg.javacourse.*;

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
