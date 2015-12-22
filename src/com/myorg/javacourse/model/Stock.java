package com.myorg.javacourse.model;
import com.myorg.javacourse.model.Portfolio;
import com.myorg.javacourse.model.Portfolio.ALGO_RECOMMENDATION;

import java.text.SimpleDateFormat;
import com.myorg.javacourse.model.Portfolio;
import java.util.Date;

import org.algo.model.StockInterface;
/**
 * This class represent all values of a specipic stock.
 */
public class Stock implements StockInterface {

	private String symbol;
	private float ask, bid;
	private int stockQuantity;
	private ALGO_RECOMMENDATION recommendation;
	
	SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
	Date date = new Date();
	/**
	 * a consturctor that create stock instens after getting the values  
	 * 
	 * @param symbolSource
	 * @param dateSource
	 * @param askVal
	 * @param bidVal
	 */
	
	public Stock(String symbol, float ask, float bid){
		this.symbol=symbol;
		this.ask=ask;
		this.bid=bid;
	}
	
	public Stock(StockInterface stocks){
		this(stocks.getSymbol(),stocks.getAsk(),stocks.getBid());
		this.date=new Date(stocks.getDate().getTime());
		this.recommendation=((Stock)stocks).recommendation;
		this.stockQuantity=((Stock)stocks).stockQuantity;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public float getAsk() {
		return ask;
	}
	public void setAsk(float ask) {
		this.ask = ask;
	}
	public float getBid() {
		return bid;
	}
	public void setBid(float bid) {
		this.bid = bid;
	}
	
	public ALGO_RECOMMENDATION getRecommendation() {
		return recommendation;
	}

	public void setRecommendation(ALGO_RECOMMENDATION recommendation) {
		this.recommendation = recommendation;
	}

	public int getStockQuantity() {
		return stockQuantity;
	}

	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}

	public String getHtmlDescription(){		
		String stringStr = ("<b>Stock symbol</b>:" + getSymbol() + "," + "<b> ask</b>:" + getAsk()
						+ ","  + "<b> bid</b>:" + getBid() + ","  + "<b> date</b>:" + df.format(getDate()) + "<b> Stock quantity</b>:" + getStockQuantity());
				
		return stringStr;
	}
	
	
}
