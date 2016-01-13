package com.myorg.javacourse.exception;

public class PortfolioFullException extends Exception{
	
	public PortfolioFullException() {
		super("Can’t add new stock, portfolio is full");
	}
}

