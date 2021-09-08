package com.vti.backend;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.vti.entity.Ex5.Question4.Article;
import com.vti.entity.Ex5.Question4.Book;
import com.vti.entity.Ex5.Question4.Document;
import com.vti.entity.Ex5.Question4.Magazine;

public class QLTV {

	// Khai bao Array List
	private List<Document> documents;

	public static int ID = 0;

	public QLTV() {
		documents = new ArrayList<Document>();
	}

	public void addDocument() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("Bạn muốn thêm loại tài liệu nào?");
		System.out.println("1- Sách");
		System.out.println("2- Tạp chí");
		System.out.println("3- Báo");
		int choose = scanner.nextInt();

		boolean isTypeDocument = false;

		do {
			switch (choose) {
			case 1:
				addBook();
				isTypeDocument = true;
				break;
			case 2:
				addMagazine();
				isTypeDocument = true;
				break;
			case 3:
				addArticle();
				isTypeDocument = true;
				break;
			default:
				System.out.println("Mời bạn nhập lại! (Giá trị trong khoảng 1-3)");
				break;
			}
		} while (isTypeDocument == false);
	}

	public void addBook() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);

		System.out.println("Nhập vào tên nhà xuất bản: ");
		String publisher = scanner.nextLine();
		System.out.println("Nhập vào số bản phát hành: ");
		int numRelease = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Nhập vào tên tác giả: ");
		String author = scanner.nextLine();
		System.out.println("Nhập vào số trang: ");
		int numPage = scanner.nextInt();
		ID++;
		Document book = new Book(ID, publisher, numRelease, author, numPage);
		documents.add(book);

		System.out.println("Thêm thành công!" + book);
	}

	public void addMagazine() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);

		System.out.println("Nhập vào tên nhà xuất bản: ");
		String publisher = scanner.nextLine();
		System.out.println("Nhập vào số bản phát hành: ");
		int numRelease = scanner.nextInt();
		System.out.println("Nhập vào số phát hành: ");
		int idRelease = scanner.nextInt();
		System.out.println("Nhập vào ngày phát hành: ");
		int day = scanner.nextInt();
		System.out.println("Nhập vào tháng phát hành: ");
		int month = scanner.nextInt();
		System.out.println("Nhập vào năm phát hành: ");
		int year = scanner.nextInt();
		LocalDate monthRelease = LocalDate.of(year, month, day);
		ID++;
		
		Document magazine = new Magazine(ID, publisher, numRelease, idRelease, monthRelease);
		documents.add(magazine);
		System.out.println("Thêm thành công!" + magazine);
	}

	public void addArticle() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);

		System.out.println("Nhập vào tên nhà xuất bản: ");
		String publisher = scanner.nextLine();
		System.out.println("Nhập vào số bản phát hành: ");
		int numRelease = scanner.nextInt();
		System.out.println("Nhập vào ngày phát hành: ");
		int day = scanner.nextInt();
		System.out.println("Nhập vào tháng phát hành: ");
		int month = scanner.nextInt();
		System.out.println("Nhập vào năm phát hành: ");
		int year = scanner.nextInt();
		LocalDate dayRelease = LocalDate.of(year, month, day);
		ID++;
		
		Document artice = new Article(ID, publisher, numRelease, dayRelease);
		documents.add(artice);
		System.out.println("Thêm thành công!" + artice);
	}
	
	public void deleteDocument() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhập vào mã tài liệu muốn xoá: ");
		int idDelete = scanner.nextInt();
		
		boolean isExist = false;
		for (Document document : documents) {
			if (document.getId() == idDelete) {
				isExist = true;
				documents.remove(document);
				System.out.println("Xoá tài liệu thành công!");
			}
		}
		if (isExist == false) {
			System.out.println("Mã tài liệu không tồn tại!");
		}
	}
	
	public void printDocuments() {
		for (Document document : documents) {
			System.out.println(document);
		}
		
		if (documents.size() == 0) {
			System.out.println("Danh sách trống!");
		}
	}
	
	public void findByCategory() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhập vào loại tài liệu muốn tìm kiếm: ");
		System.out.println("1- Sách");
		System.out.println("2- Tạp chí");
		System.out.println("3- Báo");
		int choose = scanner.nextInt();

		boolean isTypeDocument = false;

		do {
			switch (choose) {
			case 1:
				for (Document document : documents) {
					if (document instanceof Book) {
						System.out.println(document);		
					}
				}
				isTypeDocument = true;
				break;
			case 2:
				for (Document document : documents) {
					if (document instanceof Magazine) {
						System.out.println(document);		
					}
				}
				isTypeDocument = true;
				break;
			case 3:
				for (Document document : documents) {
					if (document instanceof Article) {
						System.out.println(document);		
					}
				}
				isTypeDocument = true;
				break;
			default:
				System.out.println("Mời bạn nhập lại! (Giá trị trong khoảng 1-3)");
				break;
			}
		} while (isTypeDocument == false);
	}
}
