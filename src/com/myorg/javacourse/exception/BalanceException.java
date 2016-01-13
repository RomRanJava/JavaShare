package com.myorg.javacourse.exception;

public class BalanceException extends Exception{
	
	public BalanceException () {
		super("Your balance is not enough to buy new stocks.");
	}
}
