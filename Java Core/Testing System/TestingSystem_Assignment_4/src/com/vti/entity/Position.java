package com.vti.entity;

public class Position {
	public byte id;
	public PositionName name;

	public String toString() {
		return "ID: " + this.id + " Name: " + this.name;
	}
	
	public Position() {
		
	}

	public Position(byte id, PositionName name) {
		this.id = id;
		this.name = name;

	}
}
