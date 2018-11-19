package lin_ge.restaurantadvisor;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class RestaurantActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton addReview = (FloatingActionButton) findViewById(R.id.addReview);
        addReview.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startActivity(new Intent(RestaurantActivity.this, ReviewActivity.class));
            }
        });
    }
}
