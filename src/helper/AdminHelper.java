package helper;

import java.sql.SQLException;
import java.util.List;
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
					"\nSelect operation to perform: \n1) Add Customer \n2) Update Customer \n3) View Customers \n4) Delete Customer"
							+ "\n5) Add Restaurant \n6) Update Restaurant \n7) View Restaurants \n8) Delete Restaurant \n\n9) Logout");
			System.out.print("\nEnter your choice: ");

			int option = sc.nextInt();

			switch (option) {
			case 1:
				addCustomer();
				break;

			case 2:
				updateCustomer();
				break;

			case 3:
				viewCustomers();
				break;

			case 4:
				deleteCustomer();
				break;

			case 5:
				addRestaurant();
				break;

			case 6:
				updateRestaurant();
				break;

			case 7:
				viewRestaurants();
				break;

			case 8:
				deleteRestaurant();
				break;

			case 9:
				optionStatus = false;
				break;

			default:
				System.out.println("Enter a valid choice!");
			}
		}

	}

	private static void addCustomer() {
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
	}

	private static void updateCustomer() {
		// Get address and username of the customer to be updated
		System.out.println("\n--- Update Customer ---");

		System.out.print("\nEnter username: ");
		sc.nextLine();
		String username = sc.nextLine();

		System.out.print("Enter new address: ");
		String address = sc.nextLine();

		boolean updateCustomerStatus = customerDao.updateCustomerAddress(username, address);

		System.out.println(updateCustomerStatus ? "\nUpdate customer successful!" : "\nUpdate customer failed!");
	}

	private static void viewCustomers() {
		System.out.println("\n--- View Customers---");

		List<Customer> customerList = customerDao.viewCustomers();

		System.out.println("---------------------------------------------------------------------------------------");
		System.out.printf("%15s %15s %22s %15s %15s", "USERNAME", "NAME", "EMAIL", "PHONE NO", "ADDRESS");
		System.out.println();
		System.out.println("---------------------------------------------------------------------------------------");

		for (Customer customer : customerList) {
			System.out.format("%15s %15s %22s %15s %15s", customer.getUsername(), customer.getName(),
					customer.getEmail(), customer.getPhoneNo(), customer.getAddress());
			System.out.println();
		}
		System.out.println("---------------------------------------------------------------------------------------");
	}

	private static void deleteCustomer() {
		// Get username of the customer to be deleted
		System.out.println("\n--- Delete Customer ---");

		System.out.print("\nEnter username: ");
		sc.nextLine();
		String username = sc.nextLine();

		boolean deleteCustomerStatus = customerDao.deleteCustomer(username);

		System.out.println(deleteCustomerStatus ? "\nDelete customer successful!" : "\nDelete customer failed!");
	}

	private static void addRestaurant() {
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
	}

	private static void updateRestaurant() {
		// Get address and username of the restaurant to be updated
		System.out.println("\n--- Update Restaurant ---");

		System.out.print("\nEnter restaurant id: ");
		int restaurantId = sc.nextInt();
		sc.nextLine();

		System.out.print("Enter new address: ");
		String address = sc.nextLine();

		boolean updateRestaurantStatus = restaurantDao.updateRestaurantAddress(restaurantId, address);

		System.out.println(updateRestaurantStatus ? "\nUpdate restaurant successful!" : "\nUpdate restaurant failed!");
	}

	private static void viewRestaurants() {
		System.out.println("\n--- View Restaurants---");

		List<Restaurant> restaurantList = restaurantDao.viewRestaurants();

		System.out.println("-------------------------------------------------------------------------------------");
		System.out.printf("%13s %15s %22s %15s %15s", "RESTAURANT ID", "NAME", "EMAIL", "PHONE NO", "ADDRESS");
		System.out.println();
		System.out.println("-------------------------------------------------------------------------------------");

		for (Restaurant restaurant : restaurantList) {
			System.out.format("%13s %15s %22s %15s %15s", restaurant.getRestaurantId(), restaurant.getName(),
					restaurant.getEmail(), restaurant.getPhoneNo(), restaurant.getAddress());
			System.out.println();
		}
		System.out.println("-------------------------------------------------------------------------------------");
	}

	private static void deleteRestaurant() {
		// Get username of the restaurant to be deleted
		System.out.println("\n--- Delete Restaurant ---");

		System.out.print("\nEnter restaurant id: ");
		int restaurantId = sc.nextInt();
		sc.nextLine();

		boolean deleteRestaurantStatus = restaurantDao.deleteRestaurant(restaurantId);

		System.out.println(deleteRestaurantStatus ? "\nDelete restaurant successful!" : "\nDelete restaurant failed!");
	}

}
