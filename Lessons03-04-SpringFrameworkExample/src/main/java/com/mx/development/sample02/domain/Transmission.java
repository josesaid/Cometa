package com.mx.development.sample02.domain;

public class Transmission {

	private final String type;

	public Transmission(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return String.format("%s", type);
	}
}
