package com.pojo;

public class sbi {
//acctnum | balance | name    | location |
	private int acctnum;
	private double balance;
	private String name;
	private String location;
	public int getAcctnum() {
		return acctnum;
	}
	public void setAcctnum(int acctnum) {
		this.acctnum = acctnum;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	public sbi() {
	super();	// TODO Auto-generated constructor stub
	}
	public sbi(int acctnum,double balance,String name,String location )
	{
	this.acctnum=acctnum;
	this.balance=balance;
	this.name=name;
	this.location=location;
	}
	public sbi(double balance,String name,String location )
	{

	this.balance=balance;
	this.name=name;
	this.location=location;
	}
	
	@Override
	public String toString() {
		return "Bank [acctnum=" + acctnum + ", balance=" + balance + ", name=" + name + ", location=" + location + "]";
	}
	
	
	
}
