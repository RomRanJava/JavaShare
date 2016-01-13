package com.myorg.javacourse.exception;

public class StockAlreadyExistsException extends Exception {
	
	public StockAlreadyExistsException(){
		super("stock already exists in the portfolio.");
	}

}
