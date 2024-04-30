package com.jsp.one_to_one_uni.controller;

import java.time.LocalDate;
import java.util.Scanner;

import com.jsp.one_to_one_uni.dto.Adhar;
import com.jsp.one_to_one_uni.dto.Person;
import com.jsp.one_to_one_uni.service.PersonService;

/**
 * This class provides a console-based user interface to interact with Person entities.
 * 
 * @author Shivshankar Mishra
 */
public class PersonController {
    public static void main(String[] args) {
        PersonService service = new PersonService();
        Scanner in = new Scanner(System.in);
        boolean flag = true;
        System.out.println("************* Hibernate Crud Operation One to One Mapping *************");
        while (flag) {
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println(
                    "1. Insert Data\n2. Update Data\n3. Delete Data\n4. Display One Data\n5. Display All Product Data\n6. Press any key other than options to exit");
            System.out.println("-----------------------");
            System.out.println("Choose your option: ");
            int choice = in.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("_________You want to insert data_________");
                    System.out.println("Please enter the person details: ");
                    System.out.println("Enter person name: ");
                    in.nextLine();
                    String pname = in.nextLine();
                    System.out.println("Enter person email: ");
                    String pemail = in.next();
                    System.out.println("Enter person gender: ");
                    String pgender = in.next();
                    System.out.println("Enter person date of birth: ");
                    System.out.println("	date(dd): ");
                    int date = in.nextInt();
                    System.out.println("	month(mm): ");
                    int month = in.nextInt();
                    System.out.println("	year(yyyy): ");
                    int year = in.nextInt();
                    System.out.println("Enter person father name: ");
                    in.nextLine();
                    String pfather_name = in.nextLine();
                    System.out.println("Enter person address: ");
                    String paddress = in.nextLine();
                    System.out.println("Enter person adhar number: ");
                    long padhar_num = in.nextLong();
                    System.out.println("Enter person phone: ");
                    long pphone = in.nextLong();
                    Adhar adhar = new Adhar(padhar_num, LocalDate.of(year, month, date), pfather_name, paddress);
                    Person person = new Person(pname, pemail, pgender, pphone, adhar);
                    Person p = service.insertPersonData(person);
                    System.out.println("Data Inserted.....: " + p);
                    break;
                case 2:
                    System.out.println("_________You want to update data_________");
                    System.out.println("Please enter the person details: ");
                    System.out.println("Enter person id that have to update: ");
                    int uid = in.nextInt();
                    System.out.println("Enter person name: ");
                    in.nextLine();
                    String uname = in.nextLine();
                    System.out.println("Enter person email: ");
                    String uemail = in.next();
                    System.out.println("Enter person gender: ");
                    String ugender = in.next();
                    System.out.println("Enter person date of birth: ");
                    System.out.println("	date(dd): ");
                    int udate = in.nextInt();
                    System.out.println("	month(mm): ");
                    int umonth = in.nextInt();
                    System.out.println("	year(yyyy): ");
                    int uyear = in.nextInt();
                    System.out.println("Enter person father name: ");
                    in.nextLine();
                    String ufather_name = in.nextLine();
                    System.out.println("Enter person address: ");
                    String uaddress = in.nextLine();
                    System.out.println("Enter person adhar number: ");
                    long uadhar_num = in.nextLong();
                    System.out.println("Enter person phone: ");
                    long uphone = in.nextLong();
                    Adhar uadhar = new Adhar(uadhar_num, LocalDate.of(uyear, umonth, udate), ufather_name, uaddress);
                    Person uperson = new Person(uid, uname, uemail, ugender, uphone, uadhar);
                    System.out.println("Data Inserted.....: " + service.updatePersonData(uperson));
                    break;
                case 3:
                    System.out.println("_________You want to display data_________");
                    System.out.println("Enter person id: ");
                    service.deletePersonData(in.nextInt());
                    System.out.println("Deleted data....");
                    break;
                case 4:
                    System.out.println("_________You want to display data_________");
                    System.out.println("Enter person id: ");
                    Person person2 = service.getPersonData(in.nextInt());
                    System.out.println(person2);
                    break;
                case 5:
                    System.out.println("_________Displaying All Person data_________");
                    service.getAllPerson().forEach(prs -> System.out.println(prs));
                    break;
                default:
                    flag = false;
                    System.out.println("Thank You for your time");
                    System.out.println("*****************************************************");
            }
        }
        in.close();
    }
}
