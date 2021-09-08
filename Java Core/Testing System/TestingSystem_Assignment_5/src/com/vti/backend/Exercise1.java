package com.vti.backend;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.vti.entity.Ex1.News;

public class Exercise1 {
	private List<News> listNews;

	public Exercise1() {
		listNews = new ArrayList<News>();
	}

	public void question1() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);

		System.out.println("***** MY NEWS *****");
		System.out.println("1. Inserts news ");
		System.out.println("2. View list news ");
		System.out.println("3. Average rate ");
		System.out.println("4. Exit ");

		int menuChoose;

		do {
			System.out.println("Please choose function: (1-4)");
			menuChoose = scanner.nextInt();
			scanner.nextLine();

			switch (menuChoose) {
			case 1:
				insertNews();
				break;
			case 2:
				viewListNews();
				break;
			case 3:
				averateRate();
				break;
			case 4:
				System.out.println("See you again!");
				return;
			default:
				System.out.println("The input is wrong, please re-enter the number on the menu (1-4) !");
				break;
			}
		} while (menuChoose != 4);
	}

	public void insertNews() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhap vao Id: ");
		int id = scanner.nextInt();
		scanner.nextLine();
		
		System.out.println("Nhap vao Title: ");
		String title = scanner.nextLine();
		System.out.println("Nhap vao PublishDate: ");
		String publishDate = scanner.nextLine();
		System.out.println("Nhap vao Author: ");
		String author = scanner.nextLine();
		System.out.println("Nhap vao Content: ");
		String content = scanner.nextLine();

		System.out.println("Nhap vao danh gia 1: ");
		int rate1 = scanner.nextInt();
		System.out.println("Nhap vao danh gia 2: ");
		int rate2 = scanner.nextInt();
		System.out.println("Nhap vao danh gia 3: ");
		int rate3 = scanner.nextInt();
		int[] rates = { rate1, rate2, rate3 };
		
		News news = new News(id, title, publishDate, author, content, rates);
		listNews.add(news);
		System.out.println("Them moi thanh cong!");
	}

	public void viewListNews() {
		if (listNews.size() == 0) {
			System.out.println("Danh sach trong!");
		}
		
		for (News news : listNews) {
			news.display();
		}
	}

	public void averateRate() {
		System.out.println("Danh gia trung binh Rate: ");
		for (News news : listNews) {
			news.calculate();
			news.display();
		}

	}
}
