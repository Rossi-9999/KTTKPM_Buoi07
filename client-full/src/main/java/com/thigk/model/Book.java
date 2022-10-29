package com.thigk.model;



import java.io.Serializable;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Data
public class Book implements Serializable{

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
	
	
	public Book() {
		// TODO Auto-generated constructor stub
	}

	public Book(int subId, String name, String creadit) {
		super();
		SubId = subId;
		this.name = name;
		this.creadit = creadit;
	}

	@Override
	public String toString() {
		return "Book [SubId=" + SubId + ", name=" + name + ", creadit=" + creadit + "]";
		
	}
	
}
