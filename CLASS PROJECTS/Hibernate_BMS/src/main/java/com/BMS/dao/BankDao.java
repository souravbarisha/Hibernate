package com.BMS.dao;

public interface BankDao {
	public void createAccount(); // for create Account in DB
	public void deposit(); // for deposit 
	public void withdrawal(); // for withdrawal
	public void update(); // for update
	public void delete();  // for delete
	public void showAccount(); // for show Account
}
