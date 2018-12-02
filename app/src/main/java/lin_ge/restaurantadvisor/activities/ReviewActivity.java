package lin_ge.restaurantadvisor.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;

import lin_ge.restaurantadvisor.R;
import lin_ge.restaurantadvisor.components.Review;

public class ReviewActivity extends AppCompatActivity {
    private RatingBar mRBar;
    private Button mButton;
    private TextView mTView;
    private EditText mEText;

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
                //Add to all review list
                Review temp = new Review(LoginActivity.USER_EMAIL,mEText.getText().toString(),mRBar.getRating(), SearchActivity.restaurants.getID());
                MainActivity.reviews.enqueue(temp);

                Intent intent = new Intent();
                //startActivity(new Intent(ReviewActivity.this, RestaurantActivity.class));
                setResult(RESULT_OK);

                finish();
            }
        });
    }
}
