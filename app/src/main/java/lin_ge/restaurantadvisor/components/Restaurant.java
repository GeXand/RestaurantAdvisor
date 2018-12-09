package lin_ge.restaurantadvisor.components;

import java.io.Serializable;
import java.util.ArrayList;

public class Restaurant implements Serializable {
    private String address;
    private String name;
    private int id;//predetermined
    private float rating;//we will figure this out by taking the average of all reviews: if none then we'll just take it from another site like zomato
    private String phoneNumber;
    private String hoursOfOperation;
    private String typeOfDiningCuisine;
    private String priceRange;
    private ArrayList<FoodItems> food;

    public Restaurant(String name, int id, int rating, String phoneNumber, String hourOfOperation, String typeOfDiningCuisine, String priceRange, String email)
    {
        this.name = name;
        this.id = id;
        this.rating = rating;
        this.phoneNumber = phoneNumber;
        this.hoursOfOperation = hourOfOperation;
        this.address = email;
        this.typeOfDiningCuisine = typeOfDiningCuisine;
        this.priceRange = priceRange;
        food = new ArrayList<FoodItems>();
    }

    public String getName()
    {
        return name;
    }

    public int getID()
    {
        return id;
    }

    public void setRating(float rating) { this.rating = rating; }
    public float getRating()
    {
        return rating;
    }

    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    public String getHoursOfOperation()
    {
        return hoursOfOperation;
    }
    public String getEmail()
    {
        return address;
    }

    public String getTypeOfDining()
    {
        return typeOfDiningCuisine;
    }

    public String getPriceRange()
    {
        return priceRange;
    }

    public void addFoodItems(FoodItems foodItems)
    {
        food.add(foodItems);
    }

    public ArrayList<FoodItems> getFood()
    {
        return food;
    }


    public String toString()
    {
        return name + "" + "email:" + address + " phoneNumber:" + phoneNumber + " Cuisine type:" +
                 typeOfDiningCuisine + "" + "priceRange" + priceRange + " rating" +
                rating + " hour of operations" + hoursOfOperation;
    }

    public String toDescription()
    {
        return "Address: " + address + "\nPhone Number: " + phoneNumber + "\nCuisine\\Dining: " +
                typeOfDiningCuisine + "\n" + "Price Range: " + priceRange + "\nHours of Operation: " + hoursOfOperation;
    }
}
