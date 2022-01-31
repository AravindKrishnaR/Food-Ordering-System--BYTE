# Food Ordering System - BYTE - Case Study (Core Java)
**Aravind Krishna R**

-----

**Overview:**

The project has 3 types of users:

- Admin
- Customer
- Restaurant

The **Admin** has the following functionalities:

- Create/Update/Delete/View Customers
- Create/Update/Delete/View Customers

The **Customer** has the following functionalities:

- View food menu by Restaurant
- View food menu by Category
- Place Order
- View Orders

The **Restaurant** has the following functionalities:

- Add Food
- View Food Menu
- View Orders

**Output:**

```
*****************************************************************
**********                                             **********
********** Welcome to Food Ordering System by Aravind! **********
**********                                             **********
*****************************************************************

Please identify yourself 
1) Admin 
2) Customer 
3) Restaurant 

4) Exit

Enter your choice: 1


---------- ADMIN ----------

Enter your username: aravind@123
Enter your password: password

WELCOME ARAVIND KRISHNA!

Select operation to perform: 
1) Add Customer 
2) Update Customer 
3) View Customers 
4) Delete Customer
5) Add Restaurant 
6) Update Restaurant 
7) View Restaurants 
8) Delete Restaurant 

9) Logout

Enter your choice: 1

--- Add Customer ---

Enter username: krishna@cust
Enter password: password
Enter name: Krishna
Enter email: krishna@gmail.com
Enter phone number: 6666666666
Enter address: Tambaram

Add customer successful!

Select operation to perform: 
1) Add Customer 
2) Update Customer 
3) View Customers 
4) Delete Customer
5) Add Restaurant 
6) Update Restaurant 
7) View Restaurants 
8) Delete Restaurant 

9) Logout

Enter your choice: 3

--- View Customers---
---------------------------------------------------------------------------------------
       USERNAME            NAME                  EMAIL        PHONE NO         ADDRESS
---------------------------------------------------------------------------------------
   aravind@cust         Aravind      aravind@gmail.com      6161161661        Tambaram
     gokul@cust           Gokul        gokul@gmail.com      6464464664           Porur
   krishna@cust         Krishna      krishna@gmail.com      6666666666        Tambaram
  rakshana@cust        Rakshana     rakshana@gmail.com      6363363663      Anna Nagar
     surya@cust           Surya        surya@gmail.com      6565565665     Thiruvallur
    tharun@cust          Tharun       tharun@gmail.com      6262262662      Medavakkam
---------------------------------------------------------------------------------------

Select operation to perform: 
1) Add Customer 
2) Update Customer 
3) View Customers 
4) Delete Customer
5) Add Restaurant 
6) Update Restaurant 
7) View Restaurants 
8) Delete Restaurant 

9) Logout

Enter your choice: 2

--- Update Customer ---

Enter username: krishna@cust
Enter new address: Porur

Update customer successful!

Select operation to perform: 
1) Add Customer 
2) Update Customer 
3) View Customers 
4) Delete Customer
5) Add Restaurant 
6) Update Restaurant 
7) View Restaurants 
8) Delete Restaurant 

9) Logout

Enter your choice: 3

--- View Customers---
---------------------------------------------------------------------------------------
       USERNAME            NAME                  EMAIL        PHONE NO         ADDRESS
---------------------------------------------------------------------------------------
   aravind@cust         Aravind      aravind@gmail.com      6161161661        Tambaram
     gokul@cust           Gokul        gokul@gmail.com      6464464664           Porur
   krishna@cust         Krishna      krishna@gmail.com      6666666666           Porur
  rakshana@cust        Rakshana     rakshana@gmail.com      6363363663      Anna Nagar
     surya@cust           Surya        surya@gmail.com      6565565665     Thiruvallur
    tharun@cust          Tharun       tharun@gmail.com      6262262662      Medavakkam
---------------------------------------------------------------------------------------

Select operation to perform: 
1) Add Customer 
2) Update Customer 
3) View Customers 
4) Delete Customer
5) Add Restaurant 
6) Update Restaurant 
7) View Restaurants 
8) Delete Restaurant 

9) Logout

Enter your choice: 4

--- Delete Customer ---

Enter username: krishna@cust

Delete customer successful!

Select operation to perform: 
1) Add Customer 
2) Update Customer 
3) View Customers 
4) Delete Customer
5) Add Restaurant 
6) Update Restaurant 
7) View Restaurants 
8) Delete Restaurant 

9) Logout

Enter your choice: 5

--- Add Restaurant ---

Enter restaurant id: 106
Enter password: password
Enter name: Paradise
Enter email: paradise@gmail.com
Enter phone number: 7676676776
Enter address: Tambaram

Add restaurant successful!

Select operation to perform: 
1) Add Customer 
2) Update Customer 
3) View Customers 
4) Delete Customer
5) Add Restaurant 
6) Update Restaurant 
7) View Restaurants 
8) Delete Restaurant 

9) Logout

Enter your choice: 7

--- View Restaurants---
-------------------------------------------------------------------------------------
RESTAURANT ID            NAME                  EMAIL        PHONE NO         ADDRESS
-------------------------------------------------------------------------------------
          101         Dominos      dominos@gmail.com      7171171771      Medavakkam
          102       Pizza Hut     pizzahut@gmail.com      7272272772           Porur
          103             KFC          kfc@gmail.com      7373373773        Tambaram
          104             McD          mcd@gmail.com      7474474774     Thiruvallur
          105       Ovenstory    ovenstory@gmail.com      7575575775      Anna Nagar
          106        Paradise     paradise@gmail.com      7676676776        Tambaram
-------------------------------------------------------------------------------------

Select operation to perform: 
1) Add Customer 
2) Update Customer 
3) View Customers 
4) Delete Customer
5) Add Restaurant 
6) Update Restaurant 
7) View Restaurants 
8) Delete Restaurant 

9) Logout

Enter your choice: 6

--- Update Restaurant ---

Enter restaurant id: 106
Enter new address: Porur

Update restaurant successful!

Select operation to perform: 
1) Add Customer 
2) Update Customer 
3) View Customers 
4) Delete Customer
5) Add Restaurant 
6) Update Restaurant 
7) View Restaurants 
8) Delete Restaurant 

9) Logout

Enter your choice: 7

--- View Restaurants---
-------------------------------------------------------------------------------------
RESTAURANT ID            NAME                  EMAIL        PHONE NO         ADDRESS
-------------------------------------------------------------------------------------
          101         Dominos      dominos@gmail.com      7171171771      Medavakkam
          102       Pizza Hut     pizzahut@gmail.com      7272272772           Porur
          103             KFC          kfc@gmail.com      7373373773        Tambaram
          104             McD          mcd@gmail.com      7474474774     Thiruvallur
          105       Ovenstory    ovenstory@gmail.com      7575575775      Anna Nagar
          106        Paradise     paradise@gmail.com      7676676776           Porur
-------------------------------------------------------------------------------------

Select operation to perform: 
1) Add Customer 
2) Update Customer 
3) View Customers 
4) Delete Customer
5) Add Restaurant 
6) Update Restaurant 
7) View Restaurants 
8) Delete Restaurant 

9) Logout

Enter your choice: 8

--- Delete Restaurant ---

Enter restaurant id: 106

Delete restaurant successful!

Select operation to perform: 
1) Add Customer 
2) Update Customer 
3) View Customers 
4) Delete Customer
5) Add Restaurant 
6) Update Restaurant 
7) View Restaurants 
8) Delete Restaurant 

9) Logout

Enter your choice: 9


*****************************************************************
**********                                             **********
********** Welcome to Food Ordering System by Aravind! **********
**********                                             **********
*****************************************************************

Please identify yourself 
1) Admin 
2) Customer 
3) Restaurant 

4) Exit

Enter your choice: 2


---------- CUSTOMER ----------

Enter your username: aravind@cust
Enter your password: password

WELCOME ARAVIND!

Select operation to perform: 
1) View Food Menu by Restaurant 
2) View Food Menu by Category 
3) View Orders 

4) Logout

Enter your choice: 1

--- View Food Menu by Restaurant---
-------------------------------------------------------------------------------------
RESTAURANT ID            NAME                  EMAIL        PHONE NO         ADDRESS
-------------------------------------------------------------------------------------
          101         Dominos      dominos@gmail.com      7171171771      Medavakkam
          102       Pizza Hut     pizzahut@gmail.com      7272272772           Porur
          103             KFC          kfc@gmail.com      7373373773        Tambaram
          104             McD          mcd@gmail.com      7474474774     Thiruvallur
          105       Ovenstory    ovenstory@gmail.com      7575575775      Anna Nagar
-------------------------------------------------------------------------------------

Enter your choice: 101
-------------------------------------------------------------------------------------
 FOOD ID                        NAME     DESCRIPTION           PRICE        CATEGORY
-------------------------------------------------------------------------------------
    1001       Pepper Barbeque Pizza     description           139.0           Pizza
    1002             Choco Lava Cake     description            99.0         Dessert
    1003                       Pepsi     description           57.14          Drinks
    1004         Indi Tandoori Pizza     description           279.0           Pizza
-------------------------------------------------------------------------------------

Enter your food choice to order: 1002

Order successful!

Select operation to perform: 
1) View Food Menu by Restaurant 
2) View Food Menu by Category 
3) View Orders 

4) Logout

Enter your choice: 2

--- View Food Menu by Category---
------------
 CATEGORIES
------------
      Pizza
    Dessert
     Drinks
     Burger
     Snacks
------------

Enter your choice: Snacks
-------------------------------------------------------------------------------------
 FOOD ID      RESTAURANT                        NAME     DESCRIPTION           PRICE
-------------------------------------------------------------------------------------
    1010             KFC               Chick n Wings     description            99.0
-------------------------------------------------------------------------------------

Enter your food choice to order: 1010

Order successful!

Select operation to perform: 
1) View Food Menu by Restaurant 
2) View Food Menu by Category 
3) View Orders 

4) Logout

Enter your choice: 3

--- View Orders---
----------------------------------------------------------
                     FOOD      RESTAURANT           PRICE
----------------------------------------------------------
    Pepper Barbeque Pizza         Dominos           139.0
  Chicken Pepperoni Pizza       Pizza Hut           299.0
            Chick n Wings             KFC            99.0
  Chicken Maharaja Burger             McD           219.0
          Choco Lava Cake         Dominos            99.0
            Chick n Wings             KFC            99.0
----------------------------------------------------------

Select operation to perform: 
1) View Food Menu by Restaurant 
2) View Food Menu by Category 
3) View Orders 

4) Logout

Enter your choice: 4


*****************************************************************
**********                                             **********
********** Welcome to Food Ordering System by Aravind! **********
**********                                             **********
*****************************************************************

Please identify yourself 
1) Admin 
2) Customer 
3) Restaurant 

4) Exit

Enter your choice: 3


---------- RESTAURANT ----------

Enter your restaurant id: 101
Enter your password: password

WELCOME DOMINOS!

Select operation to perform: 
1) Add Food 
2) View Food Menu 
3) View Orders 

4) Logout

Enter your choice: 1

--- Add Food ---

Enter food name: Paneer & Onion Pizza
Enter food description: description
Enter price: 109
Enter food category: Pizza

Add food successful!

Select operation to perform: 
1) Add Food 
2) View Food Menu 
3) View Orders 

4) Logout

Enter your choice: 2

--- View Food Menu ---
-----------------------------------------------------------------------------------
    FOOD                      NAME     DESCRIPTION           PRICE        CATEGORY
-----------------------------------------------------------------------------------
    1001     Pepper Barbeque Pizza     description           139.0           Pizza
    1002           Choco Lava Cake     description            99.0         Dessert
    1003                     Pepsi     description           57.14          Drinks
    1004       Indi Tandoori Pizza     description           279.0           Pizza
    1021      Paneer & Onion Pizza     description           109.0           Pizza
-----------------------------------------------------------------------------------

Select operation to perform: 
1) Add Food 
2) View Food Menu 
3) View Orders 

4) Logout

Enter your choice: 3

--- View Orders---
--------------------------------------------------------------------------
                     FOOD        USERNAME   CUSTOMER NAME           PRICE
--------------------------------------------------------------------------
    Pepper Barbeque Pizza    aravind@cust         Aravind           139.0
          Choco Lava Cake     tharun@cust          Tharun            99.0
                    Pepsi      surya@cust           Surya           57.14
          Choco Lava Cake    aravind@cust         Aravind            99.0
--------------------------------------------------------------------------

Select operation to perform: 
1) Add Food 
2) View Food Menu 
3) View Orders 

4) Logout

Enter your choice: 4


*****************************************************************
**********                                             **********
********** Welcome to Food Ordering System by Aravind! **********
**********                                             **********
*****************************************************************

Please identify yourself 
1) Admin 
2) Customer 
3) Restaurant 

4) Exit

Enter your choice: 4

---------- THANK YOU! ----------

```
