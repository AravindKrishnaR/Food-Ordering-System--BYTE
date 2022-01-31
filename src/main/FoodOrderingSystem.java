package main;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import dao.AdminDao;
import dao.CustomerDao;
import dao.FoodDao;
import dao.OrdersDao;
import dao.RestaurantDao;
import pojo.Admin;
import pojo.Customer;
import pojo.Food;
import pojo.Orders;
import pojo.Restaurant;

public class FoodOrderingSystem {

	static Scanner sc = new Scanner(System.in);
	private static AdminDao adminDao = new AdminDao();
	private static CustomerDao customerDao = new CustomerDao();
	private static RestaurantDao restaurantDao = new RestaurantDao();
	private static FoodDao foodDao = new FoodDao();
	private static OrdersDao ordersDao = new OrdersDao();

	private static void admin() throws SQLException {

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

	private static void customer() {
		System.out.println("\n\n---------- CUSTOMER ----------");

		Customer customer = new Customer();

		// Customer login
		boolean loginStatus = false;

		while (!loginStatus) {
			// Get username and password from customer
			System.out.print("\nEnter your username: ");
			customer.setUsername(sc.next());

			System.out.print("Enter your password: ");
			customer.setPassword(sc.next());

			loginStatus = customerDao.getCustomer(customer);

			System.out.println(loginStatus ? "\nWELCOME " + customer.getName().toUpperCase() + "!" : "\nLogin Failed");

		}

		// Customer options
		boolean optionStatus = true;

		while (optionStatus) {
			System.out.println(
					"\nSelect operation to perform: \n1) View Food Menu by Restaurant \n2) View Food Menu by Category \n3) View Orders \n\n4) Logout");
			System.out.print("\nEnter your choice: ");

			int option = sc.nextInt();

			switch (option) {
			case 1: {
				System.out.println("\n--- View Food by Restaurant---");

				List<Restaurant> restaurantList = restaurantDao.viewRestaurants();

				System.out.println("\nRestaurant ID \tName \tEmail \tPhone no \tAddress");

				for (Restaurant restaurant : restaurantList) {
					System.out.println(restaurant.getRestaurantId() + "\t\t" + restaurant.getName() + "\t"
							+ restaurant.getEmail() + "\t" + restaurant.getPhoneNo() + "\t" + restaurant.getAddress());
				}

				System.out.print("\nEnter your choice: ");
				int restaurantChoice = sc.nextInt();

				List<Food> foodMenu = foodDao.viewFoodMenuByRestaurant(restaurantChoice);

				System.out.println("\nFood ID \tName \tDescription \tPrice \tCategory");

				for (Food food : foodMenu) {
					System.out.println(food.getFoodId() + "\t\t" + food.getName() + "\t" + food.getDescription() + "\t"
							+ food.getPrice() + "\t" + food.getCategory());
				}

				System.out.print("\nEnter your food choice to order: ");
				int foodChoice = sc.nextInt();

				Orders order = new Orders();
				order.setCustomerUsername(customer.getUsername());
				order.setRestaurantId(restaurantChoice);
				order.setFoodId(foodChoice);

				boolean orderStatus = ordersDao.placeOrder(order);

				System.out.println(orderStatus ? "\nOrder successful!" : "\nOrder failed!");
				break;
			}

			case 2: {
				System.out.println("\n--- View Food by Category---");

				List<String> categoryList = foodDao.viewCategory();

				System.out.println("\nCategories");

				for (String category : categoryList) {
					System.out.println(category);
				}

				System.out.print("\nEnter your choice: ");
				String categoryChoice = sc.next();

				List<Food> foodMenu = foodDao.viewFoodMenuByCategory(categoryChoice);
				Map<Integer, Restaurant> map = new HashMap<>();

				System.out.println("\nFood ID \tRestaurant \tName \tDescription \tPrice");

				for (Food food : foodMenu) {
					Restaurant restaurant = new Restaurant();
					restaurant.setRestaurantId(food.getRestaurantId());

					restaurantDao.getRestaurantName(restaurant);
					map.put(food.getFoodId(), restaurant);

					System.out.println(food.getFoodId() + "\t\t" + restaurant.getName() + "\t" + food.getName() + "\t"
							+ food.getDescription() + "\t" + food.getPrice());
				}

				System.out.print("\nEnter your food choice to order: ");
				int foodChoice = sc.nextInt();

				Orders order = new Orders();
				order.setCustomerUsername(customer.getUsername());
				order.setRestaurantId(map.get(Integer.valueOf(foodChoice)).getRestaurantId());
				order.setFoodId(foodChoice);

				boolean orderStatus = ordersDao.placeOrder(order);

				System.out.println(orderStatus ? "\nOrder successful!" : "\nOrder failed!");
				break;
			}

			case 3: {
				System.out.println("\n--- View Orders---");

				List<Orders> orderList = ordersDao.viewCustomerOrders(customer.getUsername());

				System.out.println("\nFood \tRestaurant \tPrice");

				for (Orders order : orderList) {
					System.out.println(
							order.getFoodName() + "\t" + order.getRestaurantName() + "\t" + order.getPrice());
				}
				break;
			}

			case 4: {
				optionStatus = false;
				break;
			}

			default: {
				System.out.println("Enter a valid choice!");
			}
			}
		}
	}

	private static void restaurant() {
		System.out.println("\n\n---------- RESTAURANT ----------");

		Restaurant restaurant = new Restaurant();

		// Restaurant login
		boolean loginStatus = false;

		while (!loginStatus) {
			// Get restaurant id and password from restaurant
			System.out.print("\nEnter your restaurant id: ");
			restaurant.setRestaurantId(sc.nextInt());

			System.out.print("Enter your password: ");
			restaurant.setPassword(sc.next());

			loginStatus = restaurantDao.getRestaurant(restaurant);

			System.out
					.println(loginStatus ? "\nWELCOME " + restaurant.getName().toUpperCase() + "!" : "\nLogin Failed");

		}

		// Restaurant options
		boolean optionStatus = true;

		while (optionStatus) {
			System.out.println(
					"\nSelect operation to perform: \n1) Add Food \n2) View Food Menu \n3) View Orders \n\n4) Logout");
			System.out.print("\nEnter your choice: ");

			int option = sc.nextInt();

			switch (option) {
			case 1: {
				// Get food details from the admin
				System.out.println("\n--- Add Food ---");
				Food food = new Food();

				System.out.print("\nEnter food name: ");
				sc.nextLine();
				food.setName(sc.nextLine());

				System.out.print("Enter food description: ");
				food.setDescription(sc.nextLine());

				System.out.print("Enter price: ");
				food.setPrice(sc.nextDouble());
				sc.nextLine();

				System.out.print("Enter food category: ");
				food.setCategory(sc.nextLine());

				boolean addFoodStatus = FoodDao.addFood(restaurant, food);

				System.out.println(addFoodStatus ? "\nAdd food successful!" : "\nAdd food failed!");
				break;
			}
			case 2: {
				System.out.println("\n--- View Food Menu ---");

				List<Food> foodMenu = foodDao.viewFoodMenuByRestaurant(restaurant.getRestaurantId());

				System.out.println("\nFood ID \tName \tDescription \tPrice \tCategory");

				for (Food food : foodMenu) {
					System.out.println(food.getFoodId() + "\t\t" + food.getName() + "\t" + food.getDescription() + "\t"
							+ food.getPrice() + "\t" + food.getCategory());
				}
				break;
			}

			case 3: {
				System.out.println("\n--- View Orders---");

				List<Orders> orderList = ordersDao.viewRestaurantOrders(restaurant.getRestaurantId());

				System.out.println("\nFood \tCustomer \tPrice");

				for (Orders order : orderList) {
					System.out.println(
							order.getFoodName() + "\t" + order.getRestaurantName() + "\t" + order.getPrice());
				}
				break;
			}

			case 4:
				optionStatus = false;
				break;
			default:
				System.out.println("\nEnter a valid choice!");
			}
		}
	}

	public static void main(String[] args) throws SQLException {

		int user;

		do {

			System.out.println("\n\n---------- Welcome to Food Ordering System by Aravind! ----------");

			System.out.println("\nPlease identify yourself \n1) Admin \n2) Customer \n3) Restaurant \n\n4) Exit");
			System.out.print("\nEnter your choice: ");
			user = sc.nextInt();

			switch (user) {
			case 1:
				admin();
				break;
			case 2:
				customer();
				break;
			case 3:
				restaurant();
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
