package com.cg.pl;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.cg.bean.Author;
import com.cg.service.AuthorServiceImpl;

public class Application {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		AuthorServiceImpl service = new AuthorServiceImpl();
		try {
			while(true) {
				System.out.println("Menu");
				System.out.println("Enter 1 for new author");
				System.out.println("Enter 2 for update author");
				System.out.println("Enter 3 for delete author");
				System.out.println("Enter 4 for exit");
				System.out.println("Enter your choice");
				String choice = null;
				choice = br.readLine();
				switch(choice) {
					case "1":
						Author author = new Author();
						System.out.println("Enter the firstname");
						author.setFirstName(br.readLine());
						System.out.println("Enter the middlename");
						author.setMiddleName(br.readLine());
						System.out.println("Enter the lastname");
						author.setLastName(br.readLine());
						System.out.println("Enter the phone number");
						author.setPhoneNo(br.readLine());
						if(service.addAuthor(author)) {
							System.out.println("Author Added Successfully");
						}else {
							System.out.println("Author Not Added");
						}
						break;
					case "2":
					//Updating Author
						System.out.println("Enter the author id");
						Integer id = Integer.parseInt(br.readLine());
						author = service.findAuthor(id);
						if(author != null) {
							System.out.println("Author already eixsts");
							System.out.println(author.toString());
							Author temp = new Author();
							temp.setAuthorId(author.getAuthorId());
							System.out.println("Enter the first name");
							temp.setFirstName(br.readLine());
							System.out.println("Enter the middle name");
							temp.setMiddleName(br.readLine());
							System.out.println("Enter the last name");
							temp.setLastName(br.readLine());
							System.out.println("Enter the phone number");
							temp.setPhoneNo(br.readLine());
							if(service.updateAuthor(temp)!=null) {
								System.out.println("Author Updated Successfully");
							}else {
								System.out.println("Author Not Updated");
							}
						}else {
							System.out.println("Author does not exist");
						}
						break;
					case "3":
					//Deleting Author
						System.out.println("Enter the author id");
						id = Integer.parseInt(br.readLine());
						if(service.deleteAuthor(id)) {
							System.out.println("Author Deleted");
						}else {
							System.out.println("Author Is Not Deleted");
						}
						break;
					default:
						System.exit(0);
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
