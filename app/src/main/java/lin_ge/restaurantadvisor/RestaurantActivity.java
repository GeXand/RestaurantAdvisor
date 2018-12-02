package lin_ge.restaurantadvisor;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;

public class RestaurantActivity extends AppCompatActivity {

    public final int REQUEST_CODE = 1;

    private Button order;
    private Button prev;
    private Button next;
    private TextView name;
    private TextView descript;
    private RatingBar restaurantRatingBar;
    private RatingBar reviewRatingBar;
    private Button addReview;
    private TextView review;
    public static ArrayList<String> reviews;
    private static int index = 0;
    public static ArrayList<Float> rating;
    public static int size = 0;
    private static Restaurant restaurant;
    public static ArrayList<FoodItems> food;


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
        restaurant = SearchActivity.restaurants;
        food = restaurant.getFood();
        addReview = findViewById(R.id.addReview);

        getRestaurantDetail();
        getReviews();

        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getApplicationContext(), FoodListActivity.class));

            }
        });

        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                index = changeIndex("previous");
                if(index != -1) {
                    reviewRatingBar.setRating(rating.get(index));
                    review.setText(reviews.get(index));
                }
                else
                    index = 0;
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                index = changeIndex("Next");
                if(index != -1) {
                    reviewRatingBar.setRating(rating.get(index));
                    review.setText(reviews.get(index));
                }
                else
                    index = 0;
            }
        });

        addReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(RestaurantActivity.this, ReviewActivity.class), 1);
            }
        });
    }

    //startActivityForResult(Intent intent, int REQUEST_CODE);
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {

        if(requestCode == 1)
        {
            switch(resultCode)
            {
                case RESULT_OK:
                    this.getReviews();
                    index = changeIndex("Next");
                    if(index != -1) {
                        reviewRatingBar.setRating(rating.get(index));
                        review.setText(reviews.get(index));
                    }
                    else
                        index = 0;
            }
        }


    }

    private void getRestaurantDetail()
    {
        restaurantRatingBar.setRating(restaurant.getRating());
        descript.setText(restaurant.toDescription());
        name.setText(restaurant.getName());
    }

    private int changeIndex(String way)
    {
        if(size == 0) return -1;
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

    public void getReviews()
    {
        reviews.clear();
        rating.clear();
        size = MainActivity.reviews.size();
        for(int i = 0; i < size; i++)
        {
            Review temp = MainActivity.reviews.dequeue();
            if(temp.getRestaurantID() == restaurant.getID()) {
                reviews.add(temp.getText());
                rating.add((float)temp.getRating());
            }
            MainActivity.reviews.enqueue(temp);
        }
        if(size != 0)
            changeIndex("Next");
    }
}
