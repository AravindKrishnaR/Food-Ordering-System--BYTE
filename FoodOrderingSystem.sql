CREATE DATABASE FoodOrderingSystem;
use FoodOrderingSystem;

-- -------------------------------------------------- ADMIN TABLE --------------------------------------------------

CREATE table Admin(username varchar(20) primary key, password varchar(20), name varchar(30), email varchar(30), phoneNo varchar(10));
-- TRUNCATE Admin;
DESC Admin;

INSERT into Admin values("aravind@123", "password", "Aravind Krishna", "aravindk@gmail.com", "9494494994");
SELECT * from Admin ;

-- -------------------------------------------------- CUSTOMER TABLE --------------------------------------------------

CREATE table Customer(username varchar(20) primary key, password varchar(20), name varchar(30), email varchar(30), phoneNo varchar(10), address varchar(60));
-- TRUNCATE Customer;
DESC Customer;

INSERT into Customer values("aravind@cust", "password", "Aravind", "aravind@gmail.com", "6161161661", "Tambaram");
INSERT into Customer values("tharun@cust", "password", "Tharun", "tharun@gmail.com", "6262262662", "Medavakkam");
INSERT into Customer values("rakshana@cust", "password", "Rakshana", "rakshana@gmail.com", "6363363663", "Anna Nagar");
INSERT into Customer values("gokul@cust", "password", "Gokul", "gokul@gmail.com", "6464464664", "Porur");
INSERT into Customer values("surya@cust", "password", "Surya", "surya@gmail.com", "6565565665", "Thiruvallur");
SELECT * from customer;

UPDATE Customer SET address = 'sar' WHERE username = 'ar';

-- -------------------------------------------------- RESTAURANT TABLE --------------------------------------------------

CREATE table Restaurant(restaurantId int primary key, password varchar(20), name varchar(30), email varchar(30), phoneNo varchar(10), address varchar(60));
-- TRUNCATE Restaurant;
DESC Restaurant;

INSERT into Restaurant values(101, "password", "Dominos", "dominos@gmail.com", "7171171771", "Medavakkam");
INSERT into Restaurant values(102, "password", "Pizza Hut", "pizzahut@gmail.com", "7272272772", "Porur");
INSERT into Restaurant values(103, "password", "KFC", "kfc@gmail.com", "7373373773", "Tambaram");
INSERT into Restaurant values(104, "password", "McD", "mcd@gmail.com", "7474474774", "Thiruvallur");
INSERT into Restaurant values(105, "password", "Ovenstory", "ovenstory@gmail.com", "7575575775", "Anna Nagar");
SELECT * from Restaurant;

-- -------------------------------------------------- FOOD TABLE --------------------------------------------------

CREATE table Food(foodId int primary key auto_increment, restaurantId int, name varchar(30), description varchar(50), price double, category varchar(20));
ALTER TABLE Food AUTO_INCREMENT=1001;
-- DROP table Food;
-- TRUNCATE Food;
DESC Food;

INSERT into Food(restaurantId, name, description, price, category) values (101, "Pepper Barbeque Pizza", "description", 139.00, "Pizza");
INSERT into Food(restaurantId, name, description, price, category) values (101, "Choco Lava Cake", "description", 99.00, "Dessert");
INSERT into Food(restaurantId, name, description, price, category) values (101, "Pepsi", "description", 57.14, "Drinks");
INSERT into Food(restaurantId, name, description, price, category) values (101, "Indi Tandoori Pizza", "description", 279.00, "Pizza");

INSERT into Food(restaurantId, name, description, price, category) values (102, "Chicken Pepperoni Pizza", "description", 299.00, "Pizza");
INSERT into Food(restaurantId, name, description, price, category) values (102, "Choco Volcano Cake", "description", 99.00, "Dessert");
INSERT into Food(restaurantId, name, description, price, category) values (102, "Mirinda", "description", 57.14, "Drinks");
INSERT into Food(restaurantId, name, description, price, category) values (102, "Corn & Cheese Pizza", "description", 179.00, "Pizza");

INSERT into Food(restaurantId, name, description, price, category) values (103, "Chicken Zinger Burger", "description", 170.00, "Burger");
INSERT into Food(restaurantId, name, description, price, category) values (103, "Chick n Wings", "description", 99.00, "Snacks");
INSERT into Food(restaurantId, name, description, price, category) values (103, "7UP", "description", 57.14, "Drinks");
INSERT into Food(restaurantId, name, description, price, category) values (103, "Tandoori Zinger Burge", "description", 180.00, "Burger");

INSERT into Food(restaurantId, name, description, price, category) values (104, "American Cheese Burger", "description", 119.00, "Burger");
INSERT into Food(restaurantId, name, description, price, category) values (104, "Soft Serve Hot Fudge", "description", 82.86, "Dessert");
INSERT into Food(restaurantId, name, description, price, category) values (104, "Fountain Coke", "description", 91.42, "Drinks");
INSERT into Food(restaurantId, name, description, price, category) values (104, "Chicken Maharaja Burger", "description", 219.00, "Burger");

INSERT into Food(restaurantId, name, description, price, category) values (105, "Margherita Pizza", "description", 299.00, "Pizza");
INSERT into Food(restaurantId, name, description, price, category) values (105, "Mango Cheese Cake", "description", 159.00, "Dessert");
INSERT into Food(restaurantId, name, description, price, category) values (105, "Coca-Cola", "description", 57, "Drinks");
INSERT into Food(restaurantId, name, description, price, category) values (105, "Exotica Paneer Pizza", "description", 469.00, "Pizza");

SELECT * from Food;
SELECT distinct category from Food;

-- -------------------------------------------------- ORDERS TABLE --------------------------------------------------

CREATE table Orders(customerUsername varchar(20), restaurantId int, foodId int);
DESC orders;
-- TRUNCATE Orders;

SELECT * from Orders;

SELECT Orders.customerUsername, Customer.name, Orders.restaurantId, Restaurant.name, Orders.foodId, Food.name, Food.price FROM Orders 
	JOIN Food ON Orders.foodId = Food.foodId 
    JOIN Restaurant ON Orders.restaurantId = Restaurant.restaurantId 
	JOIN Customer ON Orders.customerUsername = Customer.username 
	WHERE Customer.username = "ara";

SELECT Orders.customerUsername, Customer.name, Orders.restaurantId, Restaurant.name, Orders.foodId, Food.name, Food.price FROM Orders 
	JOIN Food ON Orders.foodId = Food.foodId 
	JOIN Restaurant ON Orders.restaurantId = Restaurant.restaurantId 
	JOIN Customer ON Orders.customerUsername = Customer.username 
	WHERE Restaurant.restaurantId = 123;