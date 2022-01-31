package main;

import java.sql.SQLException;
import java.util.Scanner;

import helper.AdminHelper;
import helper.CustomerHelper;
import helper.RestaurantHelper;

public class FoodOrderingSystem {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws SQLException {

		int user;

		do {
			System.out.println("\n\n*****************************************************************");
			System.out.println("**********                                             **********");
			System.out.println("********** Welcome to Food Ordering System by Aravind! **********");
			System.out.println("**********                                             **********");
			System.out.println("*****************************************************************");

			System.out.println("\nPlease identify yourself \n1) Admin \n2) Customer \n3) Restaurant \n\n4) Exit");
			System.out.print("\nEnter your choice: ");
			user = sc.nextInt();

			switch (user) {
			case 1:
				AdminHelper.admin();
				break;
			case 2:
				CustomerHelper.customer();
				break;
			case 3:
				RestaurantHelper.restaurant();
				break;
			case 4:
				System.out.println("\n---------- THANK YOU! ----------");
				break;
			default:
				System.out.println("\nEnter a valid choice!");
			}
		} while (user != 4);

	}
}
