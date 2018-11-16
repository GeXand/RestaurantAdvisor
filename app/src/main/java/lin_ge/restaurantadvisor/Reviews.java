package lin_ge.restaurantadvisor;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class Reviews{
    private LinkedList<Review> list;//stores all reviews of restaurant

    public Reviews()
    {
        list = new LinkedList<Review>();
    }

    /**
     * adds review to review list
     * @param review
     */
    public void addReview(Review review)
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

    /**
     * @return size of list
     */
    public int getSize()
    {
        return list.size();
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
     * @return iterator of list
     */
    public Iterator<Review> getIterator()
    {
        return list.iterator();
    }
}