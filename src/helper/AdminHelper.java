package helper;

import java.sql.SQLException;
import java.util.Scanner;

import dao.AdminDao;
import dao.CustomerDao;
import dao.RestaurantDao;
import pojo.Admin;
import pojo.Customer;
import pojo.Restaurant;

public class AdminHelper {

	static Scanner sc = new Scanner(System.in);
	private static AdminDao adminDao = new AdminDao();
	private static CustomerDao customerDao = new CustomerDao();
	private static RestaurantDao restaurantDao = new RestaurantDao();

	public static void admin() throws SQLException {

		System.out.println("\n\n---------- ADMIN ----------");

		Admin admin = new Admin();

		// Admin login
		boolean loginStatus = false;

		while (!loginStatus) {
			// Get username and password from admin
			System.out.print("\nEnter your username: ");
			admin.setUsername(sc.next());

			System.out.print("Enter your password: ");
			admin.setPassword(sc.next());

			loginStatus = adminDao.getAdmin(admin);

			System.out.println(loginStatus ? "\nWELCOME " + admin.getName().toUpperCase() + "!" : "\nLogin Failed");

		}

		// Admin options
		boolean optionStatus = true;

		while (optionStatus) {
			System.out.println(
					"\nSelect operation to perform: \n1) Add Customer \n2) Update Customer \n3) Delete Customer"
							+ "\n4) Add Restaurant \n5) Update Restaurant \n6) Delete Restaurant \n\n7) Logout");
			System.out.print("\nEnter your choice: ");

			int option = sc.nextInt();

			switch (option) {
			case 1: {
				// Get customer details from the admin
				System.out.println("\n--- Add Customer ---");
				Customer customer = new Customer();

				System.out.print("\nEnter username: ");
				sc.nextLine();
				customer.setUsername(sc.nextLine());

				System.out.print("Enter password: ");
				customer.setPassword(sc.nextLine());

				System.out.print("Enter name: ");
				customer.setName(sc.nextLine());

				System.out.print("Enter email: ");
				customer.setEmail(sc.nextLine());

				System.out.print("Enter phone number: ");
				customer.setPhoneNo(sc.nextLine());

				System.out.print("Enter address: ");
				customer.setAddress(sc.nextLine());

				boolean addCustomerStatus = customerDao.addCustomer(customer);

				System.out.println(addCustomerStatus ? "\nAdd customer successful!" : "\nAdd customer failed!");
				break;
			}

			case 2: {
				// Get address and username of the customer to be updated
				System.out.println("\n--- Update Customer ---");

				System.out.print("\nEnter username: ");
				sc.nextLine();
				String username = sc.nextLine();

				System.out.print("Enter new address: ");
				String address = sc.nextLine();

				boolean updateCustomerStatus = customerDao.updateCustomerAddress(username, address);

				System.out
						.println(updateCustomerStatus ? "\nUpdate customer successful!" : "\nUpdate customer failed!");
				break;
			}

			case 3: {
				// Get username of the customer to be deleted
				System.out.println("\n--- Delete Customer ---");

				System.out.print("\nEnter username: ");
				sc.nextLine();
				String username = sc.nextLine();

				boolean deleteCustomerStatus = customerDao.deleteCustomer(username);

				System.out
						.println(deleteCustomerStatus ? "\nDelete customer successful!" : "\nDelete customer failed!");
				break;
			}

			case 4: {
				// Get restaurant details from the admin
				System.out.println("\n--- Add Restaurant ---");
				Restaurant restaurant = new Restaurant();

				System.out.print("\nEnter restaurant id: ");
				restaurant.setRestaurantId(sc.nextInt());
				sc.nextLine();

				System.out.print("Enter password: ");
				restaurant.setPassword(sc.nextLine());

				System.out.print("Enter name: ");
				restaurant.setName(sc.nextLine());

				System.out.print("Enter email: ");
				restaurant.setEmail(sc.nextLine());

				System.out.print("Enter phone number: ");
				restaurant.setPhoneNo(sc.nextLine());

				System.out.print("Enter address: ");
				restaurant.setAddress(sc.nextLine());

				boolean addRestaurantStatus = restaurantDao.addRestaurant(restaurant);

				System.out.println(addRestaurantStatus ? "\nAdd restaurant successful!" : "\nAdd restaurant failed!");
				break;
			}

			case 5: {
				// Get address and username of the restaurant to be updated
				System.out.println("\n--- Update Restaurant ---");

				System.out.print("\nEnter restaurant id: ");
				int restaurantId = sc.nextInt();
				sc.nextLine();

				System.out.print("Enter new address: ");
				String address = sc.nextLine();

				boolean updateRestaurantStatus = restaurantDao.updateRestaurantAddress(restaurantId, address);

				System.out.println(
						updateRestaurantStatus ? "\nUpdate restaurant successful!" : "\nUpdate restaurant failed!");
				break;
			}

			case 6: {
				// Get username of the restaurant to be deleted
				System.out.println("\n--- Delete Restaurant ---");

				System.out.print("\nEnter restaurant id: ");
				int restaurantId = sc.nextInt();
				sc.nextLine();

				boolean deleteRestaurantStatus = restaurantDao.deleteRestaurant(restaurantId);

				System.out.println(
						deleteRestaurantStatus ? "\nDelete restaurant successful!" : "\nDelete restaurant failed!");
				break;
			}

			case 7: {
				optionStatus = false;
				break;
			}

			default: {
				System.out.println("Enter a valid choice!");
			}
			}
		}

	}

}
