package pojo;

public class Orders {

	private String customerUsername;
	private String customerName;
	private int restaurantId;
	private String restaurantName;
	private int foodId;
	private String foodName;
	private double price;

	public Orders() {
		super();
	}

	public Orders(String customerUsername, String customerName, int restaurantId, String restaurantName, int foodId,
			String foodName, double price) {
		super();
		this.customerUsername = customerUsername;
		this.customerName = customerName;
		this.restaurantId = restaurantId;
		this.restaurantName = restaurantName;
		this.foodId = foodId;
		this.foodName = foodName;
		this.price = price;
	}

	public String getCustomerUsername() {
		return customerUsername;
	}

	public void setCustomerUsername(String customerUsername) {
		this.customerUsername = customerUsername;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public int getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public int getFoodId() {
		return foodId;
	}

	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
