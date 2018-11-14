package lin_ge.restaurantadvisor;

import java.io.Serializable;

public class Review implements Serializable{

    private static final long serialVersionUID = 1L;

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
}
