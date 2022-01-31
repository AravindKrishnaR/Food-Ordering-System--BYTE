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
					System.out
							.println(order.getFoodName() + "\t" + order.getRestaurantName() + "\t" + order.getPrice());
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

}
