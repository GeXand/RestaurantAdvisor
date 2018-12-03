package lin_ge.restaurantadvisor.components;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Iterator;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

//sources
//https://stackoverflow.com/questions/27409718/java-reading-multiple-objects-from-a-file-as-they-were-in-an-array

@Entity(foreignKeys = @ForeignKey(entity = Restaurant.class, parentColumns = "rowid", childColumns = "restaurantID"))
public class Review implements Serializable{

    private static final long serialVersionUID = 1L;

    @PrimaryKey
    private int id;
    @ColumnInfo
    private String user;
    @ColumnInfo
    private String text;
    @ColumnInfo
    private float rating; //0-5
    @ColumnInfo
    private int restaurantID;

    public Review()
    {
        text = new String();
        rating = 0;
    }

    public Review(int id, String username, String reviewText, float rate, int restaurantID) {
        this.id = id;
        user = username;
        text = reviewText;
        rating = rate;
        this.restaurantID = restaurantID;
    }

    public void setId(int newID) { id = newID; }
    public int getId() { return id; }

    public void setUser(String newUser) { user = newUser; }
    public String getUser() { return user; }

    public void setRestaurantID(int newRestaurantID) { restaurantID = newRestaurantID; }
    public int getRestaurantID() { return restaurantID; }

    public void setText(String text)
    {
        this.text = text;
    }
    public String getText() { return text; }

    public String getReviewText()
    {
        return user + ": " + text;
    }

    public void setRating(int rating)
    {
        this.rating = rating;
    }
    public float getRating()
    {
        return rating;
    }

    @Override
    /**
     * return string representation of review
     */
    public String toString()
    {
        return rating + "\n" + text;
    }

}
