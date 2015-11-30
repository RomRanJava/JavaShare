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
	
	public void addStock (Stock stock){
		
		this.stocks[portfolioSize] = stock;
		portfolioSize++;
	}
	
	public Stock[] getStocks (){
		
		return this.stocks;
	}
	
	
	public void setTitle(String title) {
		this.title = title;
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