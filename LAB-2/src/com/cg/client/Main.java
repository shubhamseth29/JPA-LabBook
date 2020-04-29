package com.cg.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.cg.entities.Author;
import com.cg.entities.Book;
import com.cg.service.AuthorBookServiceImpl;

public class Main {
	public static void main(String[] args) throws IOException {
		AuthorBookServiceImpl service = new AuthorBookServiceImpl();
		List<Book> list;
		List<String> list1;
		String choice;
		String authorName;
		double min,max;
		while(true) {
		
			System.out.println("Enter 1 for retrieving all the books");
			System.out.println("Enter 2 for retrieving books by author");
			System.out.println("Enter 3 for retrieving books by price");
			System.out.println("Enter 4 for retrieving the author name");
			System.out.println("Enter 5 for exit");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			choice=br.readLine();
			switch(choice) {
			
			case "1": list=service.getAllBooks();
						for(Book b: list)
							System.out.println(b.getBookIsbn()+"\t"+b.getPrice()+"\t"+b.getTitle());
					  break;
			
			case "2": System.out.println("Enter the name of the author");
					  authorName=br.readLine();
					  list=service.getBooksByAuthor(authorName);
						for(Book b: list)
						System.out.println(b.getTitle());
					  break;
			case "3": System.out.println("Enter the price");
						min=Double.parseDouble(br.readLine());
						max=Double.parseDouble(br.readLine());
						list=service.getBooksByPriceRange(min, max);
						for(Book b: list)
							System.out.println(b.getBookIsbn()+"\t"+b.getPrice()+"\t"+b.getTitle());
						break;
			case "4": 	System.out.println("Enter the book id");
						list1=service.getAuthorName(Long.parseLong(br.readLine()));
						for(String s: list1)
							System.out.println(s);
						break;
			case "5":   System.exit(0);

			default:    System.out.println("Please enter a valid choice");
			}
			
			
		}
			
	}

}
