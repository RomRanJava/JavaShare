package com.myorg.javacourse;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Stock {

	private String symbol;
	private float ask, bid;
	
	SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
	Date d = new Date();
	
	public Stock(String symbolSource, Date dateSource, float askVal, float bidVal) {
		setSymbol(symbolSource);
		setD(dateSource);
		setAsk(askVal);
		setBid(bidVal);
	}

	public Date getD() {
		return d;
	}

	public void setD(Date d) {
		this.d = d;
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
	
	public String getHtmlDescription(){
		
		String stringStr = ("<b>Stock symbol</b>:" + getSymbol() + "," + "<b> ask</b>:" + getAsk()
						+ ","  + "<b> bid</b>:" + getBid() + ","  + "<b> date</b>:" + df.format(getD()));
				
		return stringStr;
	}
	
	
}
