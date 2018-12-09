package lin_ge.restaurantadvisor.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.room.Room;
import lin_ge.restaurantadvisor.R;
import lin_ge.restaurantadvisor.components.Restaurant;
import lin_ge.restaurantadvisor.components.Review;
import lin_ge.restaurantadvisor.databases.ReviewDatabase;

public class ReviewActivity extends AppCompatActivity {
    private RatingBar mRBar;
    private Button mButton;
    private TextView mTView;
    private EditText mEText;
    public ReviewDatabase reviewDb = Room.databaseBuilder(getApplicationContext(), ReviewDatabase.class, "reviews").build();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);

        mRBar = (RatingBar) findViewById(R.id.ratingBar);
        mButton = (Button) findViewById(R.id.Submit);
        mTView = (TextView) findViewById(R.id.textView);
        mEText = (EditText) findViewById(R.id.editText);




        mTView.setText("Write a Review");

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Restaurant curRestaurant = SearchActivity.restaurants;
                //Add to all review list
                Review newRating = new Review(0, LoginActivity.USER_EMAIL,mEText.getText().toString(),mRBar.getRating(), curRestaurant.getId());
                MainActivity.reviews.enqueue(newRating);

                ArrayList<Review> restaurantReviews = new ArrayList<Review>();
                float totalRating = 0;
                for(int i = 0; i < MainActivity.reviews.size(); i++)
                {
                    Review cur = MainActivity.reviews.dequeue();
                    if(cur.getRestaurantID() == curRestaurant.getId()) {
                        restaurantReviews.add(cur);
                        totalRating += cur.getRating();
                    }
                    MainActivity.reviews.enqueue(cur);
                }

                curRestaurant.setRating(totalRating / restaurantReviews.size());

                Intent intent = new Intent();
                startActivity(new Intent(ReviewActivity.this, RestaurantActivity.class));
            }
        });
    }
}
