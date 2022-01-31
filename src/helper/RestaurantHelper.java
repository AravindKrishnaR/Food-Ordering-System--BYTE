package helper;

import java.util.List;
import java.util.Scanner;

import dao.FoodDao;
import dao.OrdersDao;
import dao.RestaurantDao;
import pojo.Food;
import pojo.Orders;
import pojo.Restaurant;

public class RestaurantHelper {

	static Scanner sc = new Scanner(System.in);
	private static RestaurantDao restaurantDao = new RestaurantDao();
	private static FoodDao foodDao = new FoodDao();
	private static OrdersDao ordersDao = new OrdersDao();

	public static void restaurant() {
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
			case 1:
				addFood(restaurant);
				break;

			case 2:
				viewFoodMenu(restaurant);
				break;

			case 3:
				viewOrders(restaurant);
				break;

			case 4:
				optionStatus = false;
				break;

			default:
				System.out.println("\nEnter a valid choice!");
			}
		}
	}

	private static void addFood(Restaurant restaurant) {
		// Get food details from the restaurant
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
	}

	private static void viewFoodMenu(Restaurant restaurant) {
		System.out.println("\n--- View Food Menu ---");

		List<Food> foodMenu = foodDao.viewFoodMenuByRestaurant(restaurant.getRestaurantId());

		System.out.println("-----------------------------------------------------------------------------------");
		System.out.printf("%8s %25s %15s %15s %15s", "FOOD", "NAME", "DESCRIPTION", "PRICE", "CATEGORY");
		System.out.println();
		System.out.println("-----------------------------------------------------------------------------------");

		for (Food food : foodMenu) {
			System.out.format("%8s %25s %15s %15s %15s", food.getFoodId(), food.getName(), food.getDescription(),
					food.getPrice(), food.getCategory());
			System.out.println();
		}
		System.out.println("-----------------------------------------------------------------------------------");
	}

	private static void viewOrders(Restaurant restaurant) {
		System.out.println("\n--- View Orders---");

		List<Orders> orderList = ordersDao.viewRestaurantOrders(restaurant.getRestaurantId());

		System.out.println("--------------------------------------------------------------------------");
		System.out.printf("%25s %15s %15s %15s", "FOOD", "USERNAME", "CUSTOMER NAME", "PRICE");
		System.out.println();
		System.out.println("--------------------------------------------------------------------------");

		for (Orders order : orderList) {
			System.out.format("%25s %15s %15s %15s", order.getFoodName(), order.getCustomerUsername(),
					order.getCustomerName(), order.getPrice());
			System.out.println();
		}
		System.out.println("--------------------------------------------------------------------------");
	}

}
