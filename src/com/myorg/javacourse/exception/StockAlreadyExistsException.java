package com.myorg.javacourse.exception;

import org.algo.exception.PortfolioException;

public class StockAlreadyExistsException extends PortfolioException{

	public StockAlreadyExistsException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StockAlreadyExistsException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public StockAlreadyExistsException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public StockAlreadyExistsException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public StockAlreadyExistsException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
}
