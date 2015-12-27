package com.myorg.javacourse.model;
import org.algo.model.PortfolioInterface;
import java.text.DecimalFormat;
import org.algo.model.StockInterface;

import com.myorg.javacourse.*;
/**
 * class which hold some stocks and their values.
 *
 * @author Rom Vahav
 */
public class Portfolio implements PortfolioInterface {

	public enum ALGO_RECOMMENDATION { BUY, SELL, REMOVE, HOLD};
	private final static int MAX_PORTFOLIO_SIZE = 5;
	private String title;
	private StockInterface[] stocks;
	private int portfolioSize;
	private float balance;
	
	public Portfolio(String title){
		this.title=title;
		this.stocks=new Stock[MAX_PORTFOLIO_SIZE];
	}
	
	public Portfolio(Portfolio portfolio){
		this(portfolio.getTitle());
		this.portfolioSize=portfolio.getPortfolioSize();
		for(int i=0; i<this.getPortfolioSize();i++){
			addStock((Stock)portfolio.stocks[i]);
		}
	}
	
	public Portfolio() {
		this.stocks=new Stock[MAX_PORTFOLIO_SIZE];
	}

	public Portfolio(Stock[] stockArray) {
		this();
		for (int i = 0; i<stockArray.length ; i++){
			this.stocks[i] = stockArray[i];	
		}
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
			((Stock) this.stocks[getPortfolioSize()-1]).setBid(number);
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
				if(stock.getSymbol().equals(this.stocks[i].getSymbol())){
					return;
				}
			}
			this.stocks[getPortfolioSize()] = stock;
			((Stock) this.stocks[getPortfolioSize()]).setStockQuantity(0);
			this.portfolioSize++;
		}
		else
			System.out.println("Can’t add new stock, portfolio can have only " + MAX_PORTFOLIO_SIZE + " stocks.");
	}
	
	public Stock[] getStocks (){		
		return (Stock[]) this.stocks;
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
	
	public void setPortfolioSize(int porttfolioSize) {
		this.portfolioSize = porttfolioSize;	
	}
	/**
	 * This method adds the amount to current balance (in case of buying stocks the amount can be negative also).
	 * The method makes sure the balance should not become negative.
	 * 
	 * @param amount
	 */
	public void updateBalance(float amount){
		if (this.balance + amount >= 0)
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
				if(stockSymbol.equals(stocks[i].getSymbol())){
					for (; i < this.getPortfolioSize()-1; i++)
					{
						this.stocks[i] = this.stocks[i+1];
					}
					this.portfolioSize--;
					this.stocks[getPortfolioSize()] = null;
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
			if(stockSymbol.equals(stocks[i].getSymbol())){
				if( quantity <= 0 && quantity != -1){
					System.out.println("ERROR!");
					return false;
				}
				else if (quantity == -1){
					this.updateBalance(((Stock) stocks[i]).getStockQuantity() * stocks[i].getBid());
					((Stock) this.stocks[i]).setStockQuantity(0);
					return true;
				}
				else if(((Stock) this.stocks[i]).getStockQuantity() >= quantity){
					this.updateBalance(((Stock) stocks[i]).getStockQuantity() * stocks[i].getBid());
					((Stock) this.stocks[i]).setStockQuantity(((Stock) this.stocks[i]).getStockQuantity() - quantity);
					return true;
				}
				else if(((Stock) this.stocks[i]).getStockQuantity() < quantity){
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
	public boolean buyStock(String symbol, int quantity){
		int maxQuantity;
		Stock stock = (Stock) this.findStock(symbol);
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
				if(this.stocks[i].getSymbol().equals(stock.getSymbol())){
					if (quantity == -1){
						((Stock) this.stocks[i]).setStockQuantity(((Stock) this.stocks[i]).getStockQuantity()+ maxQuantity);
						this.updateBalance(-(maxQuantity*stock.getAsk()));
						return true;
						}
					else
					{
						((Stock) this.stocks[i]).setStockQuantity(((Stock) this.stocks[i]).getStockQuantity()+ quantity);
						this.updateBalance(-(quantity*stock.getAsk()));
						return true;
					}
				}
			}
			this.addStock(stock);
			if (quantity == -1){
				((Stock) this.stocks[this.getPortfolioSize()-1]).setStockQuantity(maxQuantity);
				this.updateBalance(-(maxQuantity*stock.getAsk()));
				return true;
				}
			else{
				((Stock) this.stocks[this.getPortfolioSize()-1]).setStockQuantity(quantity);
				this.updateBalance(-(quantity*stock.getAsk()));
				return true;
				}
		}
	}
	
	public float getStocksValue(){
		float totalStocksValue = 0;
		for (int i = 0; i<this.getPortfolioSize(); i++)
		{
			totalStocksValue += (((Stock) this.stocks[i]).getStockQuantity() * this.stocks[i].getBid());
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
			stocksDetails = stocksDetails +"<br>"+((Stock) this.stocks[i]).getHtmlDescription();
		}
		totalPortfolioValue = this.getTotalValue() + "$ Total Stocks value:" + this.getStocksValue() + "$ Balance:" + this.getBalance() + "$";
		return (portfolioTitle + "<br><br>" + "Total Portfolio Value:" + totalPortfolioValue + "<br><br>" + stocksDetails);	
	}

	public static int getMaxSize() {
		return MAX_PORTFOLIO_SIZE;
	}

	public StockInterface findStock(String symbol) {	
		for (int i = 0; i< this.getPortfolioSize(); i++){
			
			if (symbol.equals(this.stocks[i].getSymbol()))
			{
				return this.stocks[i];
			}
		}
		return null;
	}

	

}
