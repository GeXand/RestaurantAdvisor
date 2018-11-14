package lin_ge.restaurantadvisor;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.ListIterator;

public class Reviews implements Serializable{

    private static final long serialVersionUID = 1L;
    private LinkedList<Review> list;//stores all reviews of restaurant

    public Reviews()
    {
        list = new LinkedList<Review>();
    }

    /**
     * adds review to review list
     * @param review
     */
    private void addReview(Review review)
    {
        list.addLast(review);
    }

    /**
     * creates review
     */
    public void createReview(String text, int rating)
    {
        Review newReview = new Review();
        newReview.setText(text);
        newReview.setRating(rating);
        addReview(newReview);
    }

    /**
     * if user wants to delete the review
     * then delete review
     */
    public void deleteReview(String text, int rating)
    {
        createReview(text, rating);
        list.removeLast();
    }

    @Override
    /**
     * creates public representation of reviews
     */
    public String toString()
    {
        String reviews = "";
        ListIterator<Review> revs = list.listIterator(0);
        while(revs.hasNext())
        {
            reviews += revs.next().toString() + "\n\n";
        }
        return reviews;
    }

    /**
     * saves reviews for use later on
     * @param review list of reviews
     */
    public static void serializeOBJ(Reviews review)
    {
        try
        {
            FileOutputStream file = new FileOutputStream("reviews.dat");
            ObjectOutputStream out = new ObjectOutputStream(file);
            out.writeObject(review);
            out.close();
            file.close();
        }
        catch(Exception e)
        {
            return;
        }
    }

    /**
     * @return obj of reviews for restaurant
     */
    public static Reviews deserializeOBJ()
    {
        Reviews review = new Reviews();
        try
        {
            FileInputStream file = new FileInputStream("reviews.dat");
            @SuppressWarnings("resource")
            ObjectInputStream in = new ObjectInputStream(file);
            review = (Reviews)in.readObject();
        }
        catch(Exception e)
        {
            return review;
        }
        return review;
    }
}

