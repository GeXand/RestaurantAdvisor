package lin_ge.restaurantadvisor.components;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.Iterator;

//sources
//https://stackoverflow.com/questions/27409718/java-reading-multiple-objects-from-a-file-as-they-were-in-an-array

public class Review implements Serializable{

    private static final long serialVersionUID = 1L;

    private String user;
    private String text;
    private int rating; //0-5
    private int restaurantID;
    private LocalDate date;

    public Review()
    {
        text = new String();
        rating = 0;
    }

    public Review(String username, String reviewText, int rate, int id) {
        user = username;
        text = reviewText;
        rating = rate;
        restaurantID = id;
        date = LocalDate.now();
    }

    public String getUser() { return user; }

    public int getRestaurantID() { return restaurantID; }

    /**
     * gets the text
     * @return text
     */
    public String getText()
    {
        return text;
    }

    /**
     * sets review to text
     * @param text
     */
    public void setText(String text)
    {
        this.text = text;
    }

    /**
     * get reviewer rating
     * @return rating
     */
    public int getRating()
    {
        return rating;
    }

    /**
     * sets the rating to something new
     * @param rating
     */
    public void setRating(int rating)
    {
        this.rating = rating;
    }

    @Override
    /**
     * return string representation of review
     */
    public String toString()
    {
        return rating + "\n" + text;
    }

    /**
     * @return restaurantID
     */
    public int getID()
    {
        return restaurantID;
    }
}
