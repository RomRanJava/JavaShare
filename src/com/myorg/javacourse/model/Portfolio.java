package com.myorg.javacourse.model;
import com.myorg.javacourse.*;
/**
 * class which hold some stocks and their values.
 *
 * @author Rom Vahav
 */
public class Portfolio {

	private final static int MAX_PORTFOLIO_SIZE = 5;
	private String title;
	private Stock[] stocks;
	private int portfolioSize;
	private float balance;
	public enum ALGO_RECOMMENDATION { BUY, SELL, REMOVE, HOLD};
	
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
	 * This method removes the first stock in the portfolio.
	 * The method checks if the portfolio is not empty, then the method removes the first stock
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
	 * This method changes the bid's value of the last stock in the portfolio.
	 * The method checks if the portfolio is not empty, then the method change
	 * the bid's value of the last stock.
	 * If the portfolio is empty, the method does nothing.
	 * 
	 * @param number
	 */
	public void changeLastStockBid(float number){
		if(getPortfolioSize()>0)
		{
			this.stocks[getPortfolioSize()-1].setBid(number);
		}
	}
	/**
	 * This method add new stock to the stocks array in the portfolio.
	 * 
	 * @param stock
	 */
	public void addStock (Stock stock){
		if (this.portfolioSize < MAX_PORTFOLIO_SIZE)
		{
			for (int i = 0 ; i < this.getPortfolioSize(); i++)
			{
				if(stock.getSymbol() == this.stocks[i].getSymbol()){
					return;
				}
			}
			this.stocks[getPortfolioSize()] = stock;
			this.stocks[getPortfolioSize()].setStockQuantity(0);
			this.portfolioSize++;
		}
		else
			System.out.println("Can’t add new stock, portfolio can have only" + MAX_PORTFOLIO_SIZE + "stocks");
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
	/**
	 * This method adds the amount to current balance (in case of buying stocks the amount can be negative also).
	 * The method makes sure the balance should not become negative.
	 * 
	 * @param amount
	 */
	public void updateBalance(float amount){
		if (this.balance + amount > 0)
		{
			this.balance += amount;
		}
		else
			System.out.println("Your balance is not enough to buy new stocks.");
	}
	/**
	 * This method removes a stock from the stocks array in the portfolio.
	 * 
	 * @param stockSymbol
	 * @return
	 */
	public boolean removeStock(String stockSymbol){
		boolean result = this.sellStock(stockSymbol, -1);
		if(result){
			for (int i = 0 ; i < this.getPortfolioSize(); i++){
				if(stocks[i].getSymbol() == stockSymbol){
					for (; i < this.getPortfolioSize(); i++)
					{
						this.stocks[i] = this.stocks[i+1];
					}
					this.portfolioSize--;
					return true;
				}	
			}
		}
		return false;		
	}
	/**
	 * This method sells quantity of stocks from the portfolio.
	 * If quantity is(­1) then the method sells whole quantity of this stock but not to remove it from portfolio.
	 * The method also update the balance.
	 * 
	 * @param stockSymbol
	 * @param quantity
	 * @return
	 */
	public boolean sellStock(String stockSymbol, int quantity){
		for (int i = 0 ; i < this.getPortfolioSize(); i++)
		{
			if(stocks[i].getSymbol() == stockSymbol){
				if( quantity <= 0 && quantity != -1){
					System.out.println("ERROR!");
					return false;
				}
				else if (quantity == -1){
					this.updateBalance(stocks[i].getStockQuantity() * stocks[i].getBid());
					this.stocks[i].setStockQuantity(0);
					return true;
				}
				else if(this.stocks[i].getStockQuantity() >= quantity){
					this.updateBalance(stocks[i].getStockQuantity() * stocks[i].getBid());
					this.stocks[i].setStockQuantity(this.stocks[i].getStockQuantity() - quantity);
					return true;
				}
				else if(this.stocks[i].getStockQuantity() < quantity){
					System.out.println("Not enough stocks to sell");
					return false;
				}
			}
		}
		System.out.println("You can't sell stock that you don't own.");
		return false;
	}
	/**
	 * This method buys quantity of stocks from the portfolio.
	 * If quantity is(­1) then the method buys the max quntity of this stock that the balance allowed.
	 * The method also update the balance.
	 * 
	 * @param stock
	 * @param quantity
	 * @return
	 */
	public boolean buyStock(Stock stock, int quantity){
		int maxQuantity;
		if (quantity <= 0 && quantity != -1){
			System.out.println("ERROR!");
			return false;
		}
		else{	
			maxQuantity = (int)(this.balance/stock.getAsk());
			if (quantity > maxQuantity){
				System.out.println("Not enough balance to complete purchase");
				return false;
			}
			for (int i = 0 ; i < this.getPortfolioSize(); i++)
			{
				if(this.stocks[i].getSymbol() == stock.getSymbol()){
					if (quantity == -1){
						this.stocks[i].setStockQuantity(this.stocks[i].getStockQuantity()+ maxQuantity);
						this.updateBalance(-(maxQuantity*stock.getAsk()));
						return true;
						}
					else
					{
						this.stocks[i].setStockQuantity(this.stocks[i].getStockQuantity()+ quantity);
						this.updateBalance(-(quantity*stock.getAsk()));
						return true;
					}
				}
			}
			this.addStock(stock);
			if (quantity == -1){
				this.stocks[this.getPortfolioSize()-1].setStockQuantity(maxQuantity);
				this.updateBalance(-(maxQuantity*stock.getAsk()));
				return true;
				}
			else{
				this.stocks[this.getPortfolioSize()-1].setStockQuantity(quantity);
				this.updateBalance(-(quantity*stock.getAsk()));
				return true;
				}
		}
	}
	
	public float getStocksValue(){
		float totalStocksValue = 0;
		for (int i = 0; i<this.getPortfolioSize(); i++)
		{
			totalStocksValue += (this.stocks[i].getStockQuantity() * this.stocks[i].getBid());
		}
		return totalStocksValue;
	}
	
	public float getBalance(){
		return this.balance;
	}
	
	public float getTotalValue(){
		return getStocksValue()+getBalance();
	}

	public String getHtmlString(){
		
		String portfolioTitle = "<h1>"  + this.title + "</h1>";
		String stocksDetails = "";
		String totalPortfolioValue;
		for(int i = 0; i < portfolioSize; i++)
		{
			stocksDetails = stocksDetails +"<br>"+this.stocks[i].getHtmlDescription();
		}
		totalPortfolioValue = this.getTotalValue() + "$ Total Stocks value:" + this.getStocksValue() + "$ Balance:" + this.getBalance() + "$";
		return (portfolioTitle + "<br><br>" + "Total Portfolio Value:" + totalPortfolioValue + "<br><br>" + stocksDetails);	
	}
}
