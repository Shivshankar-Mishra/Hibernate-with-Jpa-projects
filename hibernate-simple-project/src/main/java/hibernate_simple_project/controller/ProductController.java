package hibernate_simple_project.controller;

import java.util.Scanner;

import hibernate_simple_project.dto.Product;
import hibernate_simple_project.service.ProductService;

public class ProductController {
	public static void main(String[] args) {
		ProductService service = new ProductService();
		Scanner sc = new Scanner(System.in);
		boolean flag = true;
		System.out.println("************* Hibernate Crud Operation *************");
		while (flag) {
			System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");
			System.out.println("1. Insert Data\n2. Update Data\n3. Delete Data\n4. Display One Data\n5. Display All Product Data\n6. Press any key other than options to exit");
			System.out.println("-----------------------");
			System.out.println("Choose your option: ");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.println("...... You want to insert data ......");
				System.out.println("Enter product name: ");
				sc.nextLine();
				String name = sc.nextLine();
				System.out.println("Enter product color: ");
				String color = sc.next();
				System.out.println("Enter product price: ");
				double price = sc.nextDouble();
				System.out.println("Product inserted successfully");
				System.out.println(service.insertData((new Product(name, color, price))));
				break;
			case 2:
				System.out.println("...... You want to update data ......");
				System.out.println("Enter product id which have to update: ");
				int upid = sc.nextInt();
				System.out.println("Enter product name: ");
				sc.nextLine();
				String upname = sc.nextLine();
				System.out.println("Enter product color: ");
				String upcolor = sc.next();
				System.out.println("Enter product price: ");
				double upprice = sc.nextDouble();
				System.out.println("Product updated successfully");
				System.out.println(service.updateData((new Product(upid,upname, upcolor, upprice))));
				break;
			case 3:
				System.out.println("...... You want to delete data ......");
				System.out.println("Enter product id which have to delete: ");
				int did = sc.nextInt();
				service.deleteData(did);
				System.out.println("product deleted successfully");
				break;
			case 4:
				System.out.println("Displaying Product data....");
				System.out.println("Enter product id: ");

				System.out.println(service.getOneProduct(sc.nextInt()));
				break;
			case 5:
				System.out.println("Displaying All Product data....");
				service.getAllProduct().forEach(p->System.out.println(p));
				break;
			default:
				flag = false;
				System.out.println("Thank you for your time!!!");
			}
		}
		sc.close();
	}

}
