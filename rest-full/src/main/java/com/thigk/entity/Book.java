package com.thigk.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table
public class Book implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int SubId;
	
	private String name;
	
	private String creadit;

	public int getSubId() {
		return SubId;
	}

	public void setSubId(int subId) {
		SubId = subId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCreadit() {
		return creadit;
	}

	public void setCreadit(String creadit) {
		this.creadit = creadit;
	}

	public Book(int subId, String name, String creadit) {
		super();
		SubId = subId;
		this.name = name;
		this.creadit = creadit;
	}
	
	public Book() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Book [SubId=" + SubId + ", name=" + name + ", creadit=" + creadit + "]";
	}
	
	
	
}
