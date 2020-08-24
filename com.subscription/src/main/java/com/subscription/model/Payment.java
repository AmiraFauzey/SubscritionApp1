package com.subscription.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private  int price;
	private  String subcriptionType;
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getSubcriptionType() {
		return subcriptionType;
	}
	public void setSubcriptionType(String subcriptionType) {
		this.subcriptionType = subcriptionType;
	}



}
