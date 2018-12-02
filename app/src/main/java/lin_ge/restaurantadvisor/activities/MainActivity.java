package lin_ge.restaurantadvisor.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import lin_ge.restaurantadvisor.R;
import lin_ge.restaurantadvisor.databases.RestaurantDatabase;
import lin_ge.restaurantadvisor.databases.ReviewDatabase;

public class MainActivity extends AppCompatActivity {

    public static RestaurantDatabase restaurantDatabase;
    public static ReviewDatabase reviewDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button loginButton = (Button) findViewById(R.id.login);
        Button guestButton = (Button) findViewById(R.id.guest);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
            }
        });

        guestButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, SearchActivity.class));
            }
        });

    }
}
