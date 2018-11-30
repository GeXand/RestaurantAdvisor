package lin_ge.restaurantadvisor.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Iterator;

import lin_ge.restaurantadvisor.data.structures.DSUnboundedQueue;
import lin_ge.restaurantadvisor.R;
import lin_ge.restaurantadvisor.components.Restaurant;
import lin_ge.restaurantadvisor.components.Review;

public class RestaurantActivity extends AppCompatActivity {

    private Button order;
    private Button prev;
    private Button next;
    private TextView name;
    private TextView descript;
    private RatingBar restaurantRatingBar;
    private RatingBar reviewRatingBar;
    private Button addReview;
    private TextView review;
    private ArrayList<String> writing;
    private static int index = 0;
    private ArrayList<Float> rating;
    private static int size = 3;
    private Restaurant restaurant;
    DSUnboundedQueue<Review> reviews;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        order = findViewById(R.id.button);
        prev = findViewById(R.id.prev);
        next = findViewById(R.id.Next);
        name = findViewById(R.id.name);
        addReview = findViewById(R.id.add);
        restaurantRatingBar = findViewById(R.id.restaurantRating);
        descript = findViewById(R.id.description);
        reviewRatingBar = findViewById(R.id.reviewRatingBar);
        review = findViewById(R.id.review);
        writing = new ArrayList<String>();
        rating = new ArrayList<Float>();
        restaurant = (Restaurant) getIntent().getSerializableExtra("RestaurantClick");
        reviews = new DSUnboundedQueue<Review>();

        getRestaurantDetail();


        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //try {
                //startActivity(new Intent(getApplicationContext(), OrderActivity.class));

                startActivity(new Intent(getApplicationContext(), FoodListActivity.class));
                //} catch (Exception e)
                //{
                //   e.printStackTrace();
                // }
            }
        });

        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                index = changeIndex("previous");
                reviewRatingBar.setRating(rating.get(index));
                review.setText(writing.get(index));
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                index = changeIndex("Next");
                reviewRatingBar.setRating(rating.get(index));
                review.setText(writing.get(index));
            }
        });
    }


    private void getRestaurantDetail()
    {
        getRestaurantReviews(restaurant.getID());
        if(!reviews.isEmpty())
            changeRestaurantRating();
        restaurantRatingBar.setRating(restaurant.getRating());
        descript.setText(restaurant.toDescription());
        name.setText(restaurant.getName());
    }

    private int changeIndex(String way)
    {
        if(way.equals("previous")) {
            index -= 1;
            if(index == -1)
                index = size-1;
            return index;
        }
        else{
            index = (index+1)%size;
            return index;
        }
    }

    private void getRestaurantReviews(int id)
    {
        Iterator<Review> revs= MainActivity.reviews.getIterator();
        while(revs.hasNext())
        {
            Review rev = revs.next();
            if(rev.getID() == restaurant.getID())
                reviews.enqueue(rev);
        }
    }

    private void changeRestaurantRating()
    {
        DSUnboundedQueue<Review> temp = new DSUnboundedQueue<Review>();
        while(!reviews.isEmpty())
        {
            Review secondaryReview = reviews.dequeue();
            //add more
        }
    }
}
