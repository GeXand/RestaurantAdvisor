package lin_ge.restaurantadvisor.components;

import java.io.Serializable;
import java.util.ArrayList;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Fts4;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Fts4
@Entity
public class Restaurant implements Serializable {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "rowid")
    private int id;//predetermined
    @ColumnInfo
    private String website;
    @ColumnInfo
    private String name;
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
    @Ignore
    private ArrayList<FoodItems> food;

    public Restaurant(int id, String website, String name, int rating, String phoneNumber, String hoursOfOperation, String typeOfDining, String typeOfCuisine, String priceRange)
    {
        this.name = name;
        this.id = id;
        this.rating = rating;
        this.phoneNumber = phoneNumber;
        this.hoursOfOperation = hoursOfOperation;
        this.website = website;
        this.typeOfDining = typeOfDining;
        this.typeOfCuisine = typeOfCuisine;
        this.priceRange = priceRange;
        food = new ArrayList<FoodItems>();
    }

    public void setName(String newName) { name = newName; }
    public String getName()
    {
        return name;
    }

    public void setId(int id) {this.id = id; }
    public int getId()
    {
        return id;
    }

    public void setRating(float rating) { this.rating = rating; }
    public float getRating()
    {
        return rating;
    }

    public void setPhoneNumber(String newPhoneNumber) { phoneNumber = newPhoneNumber; }
    public String getPhoneNumber()
    {
        return phoneNumber;
    }


    public void setHoursOfOperation(String newHoursOfOperation) { hoursOfOperation = newHoursOfOperation; }
    public String getHoursOfOperation()
    {
        return hoursOfOperation;
    }

    public void setWebsite(String url) { website = url; }
    public String getWebsite()
    {
        return website;
    }

    public void setTypeOfDining(String newTypeof) { typeOfDining = newTypeof;}
    public String getTypeOfDining() { return typeOfDining; }

    public void setTypeOfCuisine(String newTypeOf) { typeOfCuisine  = newTypeOf; }
    public String getTypeOfCuisine()
    {
        return typeOfCuisine;
    }


    public void setPriceRange(String newPrice) {priceRange = newPrice; }
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
        return name + "" + "website:" + website + " phoneNumber:" + phoneNumber + " Cuisine type:" + typeOfCuisine + " Dining type:" +
                 typeOfDining + "" + "priceRange" + priceRange + " rating" +
                rating + " hour of operations" + hoursOfOperation;
    }

    public String toDescription()
    {
        return "website: " + website + "\nphoneNumber: " + phoneNumber + "\nCuisine type: " + typeOfCuisine + "\nDining type:" +
                typeOfDining + "\n" + "priceRange: " + priceRange + "\nhour of operations: " + hoursOfOperation;
    }
}
