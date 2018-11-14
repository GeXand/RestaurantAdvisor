package lin_ge.restaurantadvisor;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;

public class ReviewAcitivity extends AppCompatActivity {
    private RatingBar mRBar = (RatingBar) findViewById(R.id.ratingBar);
    private Button mButton = (Button) findViewById(R.id.Submit);
    private TextView mTView = (TextView) findViewById(R.id.textView);
    private EditText mEText = (EditText) findViewById(R.id.editText);

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTView.setText(mEText.getText().toString());
            }
        });
    }
}
