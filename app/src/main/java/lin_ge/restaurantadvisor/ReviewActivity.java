package lin_ge.restaurantadvisor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;

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

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Take in Review list from Restaurant and add review to it
                finish();
                startActivity(new Intent(ReviewActivity.this, RestaurantActivity.class));
            }
        });
    }
}
