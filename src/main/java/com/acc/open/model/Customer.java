package com.acc.open.model;

public class Customer {

    private Long id;
    private String name;


    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	protected Customer() {}

    public Customer(Long id, String firstName) {
    	this.id = id;
        this.name = firstName;
    }




}
