package com.jsp.hibernateJpqlProject.Controller;

import java.time.LocalDate;
import java.util.Scanner;

import com.jsp.hibernateJpqlProject.dto.User;
import com.jsp.hibernateJpqlProject.service.UserService;

/**
 * This controller class interacts with the user or console, handling user input
 * and invoking appropriate service methods.
 * 
 * @author Shivshankar Mishra
 */
public class UserController {
	public static void main(String[] args) {
		UserService service = new UserService();
		Scanner in = new Scanner(System.in);
		boolean flag = true;
		System.out.println("************** Hibernate Crud Operation using Jpql **************");
		while (flag) {
			System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
			System.out.println(
					"1. Insert Data\n2. Update Data\n3. Delete Data\n4. Display One Data\n5. Display All Product Data\n6. Press any key other than options to exit");
			System.out.println("-----------------------");
			System.out.println("Choose your option: ");
			int choice = in.nextInt();
			switch (choice) {
			case 1:
				System.out.println("__________You want to insert data__________");
				System.out.println("Please insert User Details One by One: ");
				System.out.println("Enter user name: ");
				in.nextLine();
				String name = in.nextLine();
				System.out.println("Enter user email: ");
				String email = in.next();
				System.out.println("Enter user date of birth details: ");
				System.out.println("    date(dd): ");
				int date = in.nextInt();
				System.out.println("    month(mm): ");
				int month = in.nextInt();
				System.out.println("    year(yyyy): ");
				int year = in.nextInt();
				System.out.println("Enter user phone: ");
				long phone = in.nextLong();
				int rowaffected = service.insertOneData(new User(name, email, LocalDate.of(year, month, date), phone));
				System.out.println("Your data inserted\naffected row: " + rowaffected);
				break;
			case 2:
				System.out.println("__________You want to update data__________");
				System.out.println("Please insert User Details One by One: ");
				System.out.println("Enter user id which have to update: ");
				int uid = in.nextInt();
				System.out.println("Enter user name: ");
				in.nextLine();
				String uname = in.nextLine();
				System.out.println("Enter user email: ");
				String uemail = in.next();
				System.out.println("Enter user date of birth details: ");
				System.out.println("    date(dd): ");
				int udate = in.nextInt();
				System.out.println("    month(mm): ");
				int umonth = in.nextInt();
				System.out.println("    year(yyyy): ");
				int uyear = in.nextInt();
				System.out.println("Enter user phone: ");
				long uphone = in.nextLong();
				int urowaffected = service
						.updateUserData(new User(uid, uname, uemail, LocalDate.of(uyear, umonth, udate), uphone));
				System.out.println("Your data updated\naffected row: " + urowaffected);
				break;
			case 3:
				System.out.println("__________You want to delete specific data__________");
				System.out.println("Enter user id: ");
				int drowaffected = service.deleteUserData(in.nextInt());
				System.out.println("Data deleted....");
				System.out.println("Affected Row: " + drowaffected);
				break;
			case 4:
				System.out.println("__________You want to display specific data__________");
				System.out.println("Enter user id: ");
				User user = service.getOneUser(in.nextInt());
				System.out.println(user);
				break;
			case 5:
				System.out.println("__________Displaying All User data__________");
				service.getAllUser().forEach(u -> System.out.println(u));
				break;
			default:
				flag = false;
				System.out.println("Thank You for your time");
			}

		}
		in.close();
	}
}
