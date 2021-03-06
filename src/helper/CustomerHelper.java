package helper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import dao.CustomerDao;
import dao.FoodDao;
import dao.OrdersDao;
import dao.RestaurantDao;
import pojo.Customer;
import pojo.Food;
import pojo.Orders;
import pojo.Restaurant;

public class CustomerHelper {

	static Scanner sc = new Scanner(System.in);
	private static CustomerDao customerDao = new CustomerDao();
	private static RestaurantDao restaurantDao = new RestaurantDao();
	private static FoodDao foodDao = new FoodDao();
	private static OrdersDao ordersDao = new OrdersDao();

	public static void customer() {
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
			case 1:
				viewFoodMenuByRestaurant(customer);
				break;

			case 2:
				viewFoodMenuByCategory(customer);
				break;

			case 3:
				viewOrders(customer);
				break;

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

	private static void viewFoodMenuByRestaurant(Customer customer) {
		System.out.println("\n--- View Food Menu by Restaurant---");

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

		System.out.print("\nEnter your choice: ");
		int restaurantChoice = sc.nextInt();

		List<Food> foodMenu = foodDao.viewFoodMenuByRestaurant(restaurantChoice);

		System.out.println("-------------------------------------------------------------------------------------");
		System.out.printf("%8s %27s %15s %15s %15s", "FOOD ID", "NAME", "DESCRIPTION", "PRICE", "CATEGORY");
		System.out.println();
		System.out.println("-------------------------------------------------------------------------------------");

		for (Food food : foodMenu) {
			System.out.format("%8s %27s %15s %15s %15s", food.getFoodId(), food.getName(), food.getDescription(),
					food.getPrice(), food.getCategory());
			System.out.println();
		}
		System.out.println("-------------------------------------------------------------------------------------");

		System.out.print("\nEnter your food choice to order: ");
		int foodChoice = sc.nextInt();

		Orders order = new Orders();
		order.setCustomerUsername(customer.getUsername());
		order.setRestaurantId(restaurantChoice);
		order.setFoodId(foodChoice);

		boolean orderStatus = ordersDao.placeOrder(order);

		System.out.println(orderStatus ? "\nOrder successful!" : "\nOrder failed!");
	}

	private static void viewFoodMenuByCategory(Customer customer) {
		System.out.println("\n--- View Food Menu by Category---");

		List<String> categoryList = foodDao.viewCategory();

		System.out.println("------------");
		System.out.printf("%11s", "CATEGORIES");
		System.out.println();
		System.out.println("------------");

		for (String category : categoryList) {
			System.out.format("%11s", category);
			System.out.println();
		}
		System.out.println("------------");

		System.out.print("\nEnter your choice: ");
		String categoryChoice = sc.next();

		List<Food> foodMenu = foodDao.viewFoodMenuByCategory(categoryChoice);
		Map<Integer, Restaurant> map = new HashMap<>();

		System.out.println("-------------------------------------------------------------------------------------");
		System.out.printf("%8s %15s %27s %15s %15s", "FOOD ID", "RESTAURANT", "NAME", "DESCRIPTION", "PRICE");
		System.out.println();
		System.out.println("-------------------------------------------------------------------------------------");

		for (Food food : foodMenu) {
			Restaurant restaurant = new Restaurant();
			restaurant.setRestaurantId(food.getRestaurantId());

			restaurantDao.getRestaurantName(restaurant);
			map.put(food.getFoodId(), restaurant);

			System.out.format("%8s %15s %27s %15s %15s", food.getFoodId(), restaurant.getName(), food.getName(),
					food.getDescription(), food.getPrice());
			System.out.println();

		}
		System.out.println("-------------------------------------------------------------------------------------");

		System.out.print("\nEnter your food choice to order: ");
		int foodChoice = sc.nextInt();

		Orders order = new Orders();
		order.setCustomerUsername(customer.getUsername());
		order.setRestaurantId(map.get(Integer.valueOf(foodChoice)).getRestaurantId());
		order.setFoodId(foodChoice);

		boolean orderStatus = ordersDao.placeOrder(order);

		System.out.println(orderStatus ? "\nOrder successful!" : "\nOrder failed!");
	}

	private static void viewOrders(Customer customer) {
		System.out.println("\n--- View Orders---");

		List<Orders> orderList = ordersDao.viewCustomerOrders(customer.getUsername());

		System.out.println("----------------------------------------------------------");
		System.out.printf("%25s %15s %15s", "FOOD", "RESTAURANT", "PRICE");
		System.out.println();
		System.out.println("----------------------------------------------------------");

		for (Orders order : orderList) {
			System.out.format("%25s %15s %15s", order.getFoodName(), order.getRestaurantName(), order.getPrice());
			System.out.println();
		}
		System.out.println("----------------------------------------------------------");
	}

}
