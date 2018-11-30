package lin_ge.restaurantadvisor.components;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Iterator;

//sources
//https://stackoverflow.com/questions/27409718/java-reading-multiple-objects-from-a-file-as-they-were-in-an-array

public class Review implements Serializable{

    private static final long serialVersionUID = 1L;

    private int id;
    private String text;
    private int rating; //0-5

    public Review()
    {
        text = new String();
        rating = 0;
    }

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
     * saves reviews for use later on
     * @param review
     */
    public static void serializeOBJ(Reviews review)
    {
        try
        {
            FileOutputStream file = new FileOutputStream("review.dat");
            ObjectOutputStream out = new ObjectOutputStream(file);
            Iterator<Review> iterator = review.getIterator();
            while(iterator.hasNext())
            {
                out.writeObject(iterator.next());
            }
            out.close();
            file.close();
        }
        catch(Exception e)
        {
            return;
        }
    }

    /**
     * @return restaurantID
     */
    public int getID()
    {
        return id;
    }

    /**
     * @return obj of reviews
     */
    public static Reviews deserializeOBJ()
    {
        Reviews review = new Reviews();
        try
        {
            FileInputStream file = new FileInputStream("review.dat");
            boolean cont = true;
            @SuppressWarnings("resource")
            ObjectInputStream input = new ObjectInputStream(file);
            while(cont){
                Review obj = (Review) input.readObject();
                if(obj != null)
                    review.addReview(obj);
                else
                    cont = false;
            }
        }
        catch(Exception e)
        {
            return review;
        }
        return review;
    }
}
