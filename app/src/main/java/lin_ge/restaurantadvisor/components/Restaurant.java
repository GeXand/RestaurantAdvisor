package lin_ge.restaurantadvisor.components;

import java.io.Serializable;
import java.util.ArrayList;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Restaurant implements Serializable {
    @ColumnInfo
    private String email;
    @ColumnInfo
    private String name;
    @PrimaryKey
    private int id;//predetermined
    @ColumnInfo
    private float rating;//we will figure this out by taking the average of all reviews: if none then we'll just take it from another site like zomato
    @ColumnInfo
    private String phoneNumber;
    @ColumnInfo
    private String hoursOfOperation ;
    @ColumnInfo
    private String typeOfDining;
    @ColumnInfo
    private String typeOfCuisine;
    @ColumnInfo
    private String priceRange;
    private ArrayList<FoodItems> food;

    public Restaurant(String name, int id, int rating, String phoneNumber, String hourOfOperation, String typeOfDining, String typeOfCuisine, String priceRange, String email)
    {
        this.name = name;
        this.id = id;
        this.rating = rating;
        this.phoneNumber = phoneNumber;
        this.hoursOfOperation = hourOfOperation;
        this.email = email;
        this.typeOfDining = typeOfDining;
        this.typeOfCuisine = typeOfCuisine;
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
        return name + "" + "email:" + email + " phoneNumber:" + phoneNumber + " Cuisine type:" + typeOfCuisine + " Dining type:" +
                 typeOfDining + "" + "priceRange" + priceRange + " rating" +
                rating + " hour of operations" + hoursOfOperation;
    }

    public String toDescription()
    {
        return "email: " + email + "\nphoneNumber: " + phoneNumber + "\nCuisine type: " + typeOfCuisine + "\nDining type:" +
                typeOfDining + "\n" + "priceRange: " + priceRange + "\nhour of operations: " + hoursOfOperation;
    }
}
