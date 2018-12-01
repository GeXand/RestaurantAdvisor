package lin_ge.restaurantadvisor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;

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
    private ArrayList<String> reviews;
    private static int index = 0;
    private ArrayList<Float> rating;
    private static int size = 3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);

        order = findViewById(R.id.button);
        prev = findViewById(R.id.prev);
        next = findViewById(R.id.Next);
        name = findViewById(R.id.name);
        addReview = findViewById(R.id.add);
        restaurantRatingBar = findViewById(R.id.restaurantRating);
        descript = findViewById(R.id.description);
        reviewRatingBar = findViewById(R.id.reviewRatingBar);
        review = findViewById(R.id.review);
        reviews = new ArrayList<String>();
        rating = new ArrayList<Float>();

        getRestaurantDetail();

        reviews.add("Hello");
        reviews.add("Hi");
        reviews.add("Happy");
        rating.add(1.0F);
        rating.add(2.0F);
        rating.add(3.0F);

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
                review.setText(reviews.get(index));
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                index = changeIndex("Next");
                reviewRatingBar.setRating(rating.get(index));
                review.setText(reviews.get(index));
            }
        });
    }


    private void getRestaurantDetail()
    {
        restaurantRatingBar.setRating(2);
        descript.setText("Address Hello Staple \n Steam");
        name.setText("My Name");
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
}
