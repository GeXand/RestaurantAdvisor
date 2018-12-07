package lin_ge.restaurantadvisor.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

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
    public static ArrayList<Restaurant> restaurantArrayList;
    public RestaurantDatabase restaurantDb = Room.databaseBuilder(getApplicationContext(), RestaurantDatabase.class, "restaurants").build();
    public ReviewDatabase reviewDb = Room.databaseBuilder(getApplicationContext(), ReviewDatabase.class, "reviews").build();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login = Login_System.deserializeOBJ();
        reviews = new DSUnboundedQueue<Review>();
        restaurantArrayList = new ArrayList<Restaurant>();
        Restaurant r1 = new Restaurant(0, "---", "Domino's", 0, "262-9369-493", "10AM-9PM", "Fine Dining", "Fast Food", "$2-$6");
        Restaurant r2 = new Restaurant(1, "---", "Applebee's", 0, "262-9369-493", "10AM-9PM", "Fine Dining", "Fast Food", "$2-$6");
        Restaurant r3 = new Restaurant(3, "---", "Friday's", 0, "262-9369-493", "10AM-9PM", "Fine Dining", "Fast Food", "$2-$6");
        restaurantArrayList.add(r1);
        restaurantArrayList.add(r2);
        restaurantArrayList.add(r3);

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
