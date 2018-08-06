package com.mis.domain;

public class ProductVO {

	private String name;
	private double price;
	private int count;
	private int size;
	
	
	public ProductVO(String name, double price) {
		super();
		this.name = name;
		this.price = price;
	}

	public ProductVO(String name, double price, int size, int count) {
		super();
		this.name = name;
		this.price = price;
		this.size = size;
		this.count = count;
	}
	
	public String getName() {
		return name;
	}
	
	public double getPrice() {
		return price;
	}

	public int getCount() {
		return count;
	}
	
	public int getSize() {
		return size;
	}

	@Override
	public String toString() {
		return "ProductVO [name=" + name + ", price=" + price + ", count=" + count + ", size=" + size + "]";
	}



	
	
	
	
}
