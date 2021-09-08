package com.vti.entity;

import java.util.Scanner;

import com.vti.utils.ScannerUtils;

public class Position {
	private int id;
	private PositionName name;
	private static Scanner scanner = new Scanner(System.in);

	@Override
	public String toString() {
		return "Position [id=" + id + ", name=" + name + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public PositionName getName() {
		return name;
	}

	public void setName(PositionName name) {
		this.name = name;
	}
	
	public Position(int id, PositionName name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Position() {
		input();
	}

	private void input() {
		System.out.println("Nhap ID: ");
		id = ScannerUtils.inputInt(scanner);
		System.out.println("Chon ten vi tri muon nhap: ");
		System.out.println("1.Dev ");
		System.out.println("2.Test ");
		System.out.println("3.Scrum Master ");
		System.out.println("4.PM ");
		while (true) {
			int choose = ScannerUtils.inputPositiveInt(scanner);
			switch (choose) {
			case 1:
				name = PositionName.DEV;
				return;
			case 2:
				name = PositionName.TEST;
				return;
			case 3:
				name = PositionName.SCRUM_MASTER;
				return;
			case 4:
				name = PositionName.PM;
				return;
			default:
				System.out.println("Moi ban chon lai! Gia tri trong khoang (1-4)");
			}
		}
	}

}
