package lin_ge.restaurantadvisor.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import lin_ge.restaurantadvisor.R;
import lin_ge.restaurantadvisor.components.Restaurant;
import lin_ge.restaurantadvisor.components.Review;
import lin_ge.restaurantadvisor.components.Login_System;
import lin_ge.restaurantadvisor.dataStructures.DSUnboundedQueue;
import lin_ge.restaurantadvisor.databases.RestaurantDatabase;
import lin_ge.restaurantadvisor.databases.ReviewDatabase;

public class MainActivity extends AppCompatActivity {

    public static Login_System login;//login system that holds all emails and passwords
    public static DSUnboundedQueue<Review> reviews;
    public static RestaurantDatabase restaurantdb;
    public static ReviewDatabase reviewdb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        restaurantdb = Room.databaseBuilder(getApplicationContext(), RestaurantDatabase.class, "restaurants").build();
        reviewdb = Room.databaseBuilder(getApplicationContext(), ReviewDatabase.class, "reviews").build();

        login = Login_System.deserializeOBJ();
        reviews = new DSUnboundedQueue<Review>();
        Restaurant r1 = new Restaurant(0, "---", "Domino's", 0, "262-9369-493", "10AM-9PM", "Fine Dining", "Fast Food", "$2-$6");
        Restaurant r2 = new Restaurant(1, "---", "Applebee's", 0, "262-9369-493", "10AM-9PM", "Fine Dining", "Fast Food", "$2-$6");
        Restaurant r3 = new Restaurant(2, "---", "Friday's", 0, "262-9369-493", "10AM-9PM", "Fine Dining", "Fast Food", "$2-$6");
        Restaurant[] restaurantsToAdd = {r1, r2, r3};
        restaurantdb.restaurantDAO().insertAll(restaurantsToAdd);

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
