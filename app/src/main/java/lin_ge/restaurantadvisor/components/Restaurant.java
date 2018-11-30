package lin_ge.restaurantadvisor.components;

import java.util.ArrayList;

public class Restaurant{
    private String email;
    private String name;
    private int id;//predetermined
    private int rating;//we will figure this out by taking the average of all reviews: if none then we'll just take it from another site like zomato
    private String phoneNumber;
    private String hourOfOperation;
    private String typeOfDining;
    private String typeOfCuisine;
    private String priceRange;
    private ArrayList<FoodItems> food;
    private Reviews reviews;//this contains all reviews so we will need to sort them by id for the restaurant

    public Restaurant(String name, int id, int rating, String phoneNumber, String hourOfOperation, String typeOfDining, String typeOfCuisine, String priceRange, String email)
    {
        this.name = name;
        this.id = id;
        this.rating = rating;
        this.phoneNumber = phoneNumber;
        this.hourOfOperation = hourOfOperation;
        this.email = email;
        this.typeOfDining = typeOfDining;
        this.typeOfCuisine = typeOfCuisine;
        this.priceRange = priceRange;
        food = new ArrayList<FoodItems>();
        reviews = Review.deserializeOBJ();
    }

    public String getName()
    {
        return name;
    }

    public int getID()
    {
        return id;
    }

    public int getRating()
    {
        return rating;
    }

    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    public String getHourOfOperation()
    {
        return hourOfOperation;
    }
    public String getEmail()
    {
        return email;
    }

    public String getTypeOfDining()
    {
        return typeOfDining;
    }

    public String getTypeOfCuisine()
    {
        return typeOfCuisine;
    }

    public String priceRange()
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

    public Reviews getReviews()
    {
        return reviews;
    }

    public String toString()
    {
        return name + "" + "email:" + email + " phoneNumber:" + phoneNumber + " Cuisine type:" + typeOfCuisine + " Dining type:" +
                 typeOfDining + "" + "priceRange" + priceRange + " rating" +
                rating + " hour of operations" + hourOfOperation;
    }

    public String toDescription()
    {
        return "email: " + email + "\nphoneNumber: " + phoneNumber + "\nCuisine type: " + typeOfCuisine + "\nDining type:" +
                typeOfDining + "\n" + "priceRange: " + priceRange + "\nrating: " +
                rating + "\nhour of operations: " + hourOfOperation;
    }
}
