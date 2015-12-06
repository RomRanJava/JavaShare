package com.myorg.javacourse.model;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * This class represent all values of a specipic stock.
 */
public class Stock {

	private String symbol;
	private float ask, bid;
	private int recommendation, stockQuantity;
	private static final int BUY = 0, SELL=1, REMOVE=2, HOLD=3;
	
	SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
	Date date = new Date();
	/**
	 * a consturctor that create stock instens after getting the values  
	 */
	public Stock(String symbolSource, Date dateSource, float askVal, float bidVal) {
		setSymbol(symbolSource);
		setDate(dateSource);
		setAsk(askVal);
		setBid(bidVal);
	}
	
	public Stock(Stock stock){
		this.symbol = stock.getSymbol();
		this.ask = stock.getAsk();
		this.bid = stock.getBid();
		this.date = new Date(stock.getDate().getTime());
		this.recommendation = stock.getRecommendation();
		this.stockQuantity = stock.getStockQuantity();
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
	
	public int getRecommendation() {
		return recommendation;
	}

	public void setRecommendation(int recommendation) {
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
						+ ","  + "<b> bid</b>:" + getBid() + ","  + "<b> date</b>:" + df.format(getDate()));
				
		return stringStr;
	}
	
	
}
