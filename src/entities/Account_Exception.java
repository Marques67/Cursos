package entities;

import model.exceptions.AccountException;

public class Account_Exception {
	
	private Integer number;
	private String holder;
	private Double balance;
	private Double withdrawLimit;
	
	public Account_Exception() {
	}

	public Account_Exception(Integer number, String holder, Double balance, Double withdrawLimit) {
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withdrawLimit = withdrawLimit;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public Double getBalance() {
		return balance;
	}

	public Double getWithdrawLimit() {
		return withdrawLimit;
	}

	public void setWithdrawLimit(Double withdrawLimit) {
		this.withdrawLimit = withdrawLimit;
	}
	
	public void deposit (Double amount) {
		amount += getBalance();
	}
	
	public void withdraw (Double amount) {
		if(getBalance() == 0.0 || amount > getBalance()) {
			throw new AccountException("Not enough balance");
		}
		if(amount > withdrawLimit) {
			throw new AccountException("The amount exceeds withdraw limit");
		}
		double balance = getBalance() - amount;
		System.out.printf("New Balance: $ %.2f%n", balance);
	}
	
}