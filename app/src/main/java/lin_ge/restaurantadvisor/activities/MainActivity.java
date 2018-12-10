package lin_ge.restaurantadvisor.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

import lin_ge.restaurantadvisor.R;
import lin_ge.restaurantadvisor.components.Restaurant;
import lin_ge.restaurantadvisor.components.Review;
import lin_ge.restaurantadvisor.components.Login_System;
import lin_ge.restaurantadvisor.dataStructures.DSUnboundedQueue;

public class MainActivity extends AppCompatActivity {

    public static Login_System login;//login system that holds all emails and passwords
    public static DSUnboundedQueue<Review> reviews;
    public static ArrayList<Restaurant> restaurantArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login = Login_System.deserializeOBJ();
        reviews = new DSUnboundedQueue<Review>();
        restaurantArrayList = new ArrayList<Restaurant>();
        Restaurant r0 = new Restaurant("Comet Cafe", 0, 0, "(414) 273-7677", "10AM-2AM", "Breakfast, Diner, Bar Food", "$$", "1947 N Farwell Ave, Milwaukee 53202");
        Restaurant r1 = new Restaurant("Guanajuato Mexican", 1, 0, "(414) 482-2269", "10AM-10PM", "Mexican", "$", "2317 South Howell Ave, Milwaukee 53207");
        Restaurant r2 = new Restaurant("Centro Cafe", 2, 0, "(414) 455-3751", "5PM-9PM", "Italian", "$$", "808 E Center St, Milwaukee 53212");
        Restaurant r3 = new Restaurant("Transfer Pizzeria Cafe", 3, 0, "(414) 763-0438", "11AM-10PM", "Pizza", "$$", "101 W Mitchell St, Milwaukee 53204");
        Restaurant r4 = new Restaurant("Le Reve Patisserie & Cafe", 4, 0, "(414) 778-3333", "8AM-9PM", "Breakfast, French", "$$$", "7610 Harwood Ave, Wauwatosa 53213");
        Restaurant r5 = new Restaurant("Pat's Rib Place", 5, 0, "(262) 544-4099", "11AM-8PM", "BBQ, Sandwich, Southern", "$$", "151 E Sunset Drive, Waukesha 53189");
        Restaurant r6 = new Restaurant("Classic Slice", 6, 0, "(414) 727-0761", "11AM-10PM", "Pizza, Vegetarian", "$", "2797 S Kinnickinnic Ave, Milwaukee 53207");
        Restaurant r7 = new Restaurant("EE Sane Thai Cuisine", 7, 0, "(414) 224-8284", "11AM-8:30PM", "Asian, Thai", "$$", "1806 N Farwell Ave, Milwaukee 53202");
        Restaurant r8 = new Restaurant("Kopp's Frozen Custard Stand", 8, 0, "(262) 789-1393", "10:30AM-10PM", "Burger, Desserts, Fast Food", "$", "18880 W Bluemound Rd, Brookfield 53045");
        Restaurant r9 = new Restaurant("Oakland Gyros", 9, 0, "(414) 963-1393", "10:30AM-3AM", "Fast Food, Greek", "$", "2867 N Oakland Ave, Milwaukee 53211");
        Restaurant r10 = new Restaurant("Cafe Corazon", 10, 0, "(414) 810-3941", "11AM-10PM", "Latin American, Mexican", "$$", "3129 N Bremen St, Milwaukee 53212");
        Restaurant r11 = new Restaurant("Honeypie", 11, 0, "(414) 489-7437", "7AM-8PM", "Breakfast, Desserts, Diner", "$$", "2643 S Kinnickinnic Ave, Milwaukee 53207");
        Restaurant r12 = new Restaurant("Maxie's", 12, 0, "(414) 292-3969", "4PM-10PM", "BBQ, Southern, Cajun", "$$$", "6732 W Fairview Avenue, Milwaukee 53213");
        Restaurant r13 = new Restaurant("Beans & Barley Market & Cafe", 13, 0, "(414) 278-7878", "11AM-9PM", "American", "$", "1901 E North Ave, Milwaukee 53202");
        Restaurant r14 = new Restaurant("Cafe LuLu", 14, 0, "(414) 294-5858", "11AM-10PM", "Diner, Sandwich", "$", "2265 S Howell Ave, Milwaukee 53207");
        Restaurant r15 = new Restaurant("Kopp's Frozen Custard Stand", 15, 0, "(414) 961-3288", "10:30AM-11PM", "Burger, Desserts", "$", "5373 N Port Washington Rd, Milwaukee 53217");
        Restaurant r16 = new Restaurant("Buckley's Restaurant & Bar", 16, 0, "(414) 277-1111", "11AM-10PM", "American, International", "$$$", "801 North Cass Street 53202");
        Restaurant r17 = new Restaurant("Cosmos Cafe", 17, 0, "(414) 257-2005", "11AM-8PM", "Greek, Mediterranean", "$", "7203 W North Ave, Wauwatosa 53213");
        Restaurant r18 = new Restaurant("Golosi Gelato Cafe", 18, 0, "(262) 391-0637", "10AM-8PM", "Coffee and Tea, Desserts, Sandwich", "$", "162 E Wisconsin Ave, Oconomowoc 53066");
        Restaurant r19 = new Restaurant("Sobelman's Pub and Grill", 19, 0, "(414) 931-1919", "11AM-8PM", "Burger, Bar Food", "$", "1900 W Saint Paul Ave, Milwaukee 53233");
        Restaurant r20 = new Restaurant("Blues Egg", 20, 0, "(414) 299-3180", "6AM-1PM", "Breakfast, Diner, Sandwich", "$$", "317 North 76th Street, Milwaukee/ West Milwaukee/ West Allis/ Wauwatosa 53213");
        Restaurant r21 = new Restaurant("La Merenda", 21, 0, "(414) 931-1919", "11AM-8PM", "International, Tapas", "$", "125 E National Ave, Milwaukee 53204");
        Restaurant r22 = new Restaurant("Thai-Namite Thai Bistro and Sushi Bar", 22, 0, "(414) 931-1919", "11AM-8PM", "Asian, Sushi, Thai", "$$", "932 E Brady, Milwaukee 53202");
        Restaurant r23 = new Restaurant("Three Brothers", 23, 0, "(414) 931-1919", "11AM-8PM", "Eastern European", "$$$", "2414 S Saint Clair St, Milwaukee 53207");
        Restaurant r24 = new Restaurant("McBob's Pub & Grill", 24, 0, "(414) 931-1919", "11AM-8PM", "Breakfast, Burger, Bar Food", "$$", "4919 W North Ave, Milwaukee 53208");
        Restaurant r25 = new Restaurant("Kyoto", 25, 0, "(414) 931-1919", "11AM-8PM", "Japanese, Sushi", "$$", "7453 W Layton Ave, Greenfield 53220");
        Restaurant r26 = new Restaurant("Glorioso's Italian Market", 26, 0, "(414) 931-1919", "11AM-8PM", "Italian, Pizza, Sandwich", "$", "1011 East Brady Street 53202");
        Restaurant r27 = new Restaurant("Sakura Japan Sushi and Grill", 27, 0, "(414) 931-1919", "11AM-8PM", "Japanese, Sushi", "$$", "332 W Broadway, Waukesha 53186");
        Restaurant r28 = new Restaurant("Wells Brothers Italian", 28, 0, "(414) 931-1919", "11AM-8PM", "Italian, Pizza", "$", "2148 Mead St, Racine 53403");
        Restaurant r29 = new Restaurant("Lisa's Pizzeria", 29, 0, "(414) 931-1919", "11AM-8PM", "Italian, Pizza", "$$", "2961 N Oakland Ave, Milwaukee 53211");
        Restaurant r30 = new Restaurant("Farmstead", 30, 0, "(414) 931-1919", "11AM-8PM", "American, Steak", "$$$", "W62 N238 Washington Ave, Cedarburg 53012");
        Restaurant r31 = new Restaurant("Hong Anh Palace", 31, 0, "(414) 931-1919", "11AM-8PM", "Chinese", "$", "10046 North Port Washington Rd, Mequon 53092");
        Restaurant r32 = new Restaurant("Big Star Drive In", 32, 0, "(414) 931-1919", "11AM-8PM", "Burger, Fast Food, Sandwich", "$", "1500 Washington Rd, Kenosha 53140");
        Restaurant r33 = new Restaurant("Cafe Centraal", 33, 0, "(414) 931-1919", "11AM-8PM", "International, Seafood, Cafe", "$$", "2306 S Kinnickinnic Ave, Milwaukee 53207");
        Restaurant r34 = new Restaurant("Conejito's Place", 34, 0, "(414) 931-1919", "11AM-8PM", "Mexican", "$", "539 W Virginia St, Milwaukee 53204");
        Restaurant r35 = new Restaurant("Elsa's On the Park", 35, 0, "(414) 931-1919", "11AM-8PM", "American, Burger", "$$", "833 North Jefferson Street 53202");
        Restaurant r36 = new Restaurant("Crazy Water", 36, 0, "(414) 931-1919", "11AM-8PM", "American, International, Fusion", "$$$", "839 South 2nd Street 53204");
        Restaurant r37 = new Restaurant("Tenuta's", 37, 0, "(414) 931-1919", "11AM-8PM", "Italian", "$$$", "2995 S Clement Ave, Milwaukee 53207");
        Restaurant r38 = new Restaurant("Maharaja", 38, 0, "(414) 931-1919", "11AM-8PM", "Indian", "$$", "1550 N Farwell Ave, Milwaukee 53202");
        Restaurant r39 = new Restaurant("Palmers Steakhouse", 39, 0, "(414) 931-1919", "11AM-8PM", "American, Seafood, Steak", "$$$", "122 East Capitol Drive, Downtown Hartland 53029");

        restaurantArrayList.add(r0);
        restaurantArrayList.add(r1);
        restaurantArrayList.add(r2);
        restaurantArrayList.add(r3);
        restaurantArrayList.add(r4);
        restaurantArrayList.add(r5);
        restaurantArrayList.add(r6);
        restaurantArrayList.add(r7);
        restaurantArrayList.add(r8);
        restaurantArrayList.add(r9);
        restaurantArrayList.add(r10);
        restaurantArrayList.add(r11);
        restaurantArrayList.add(r12);
        restaurantArrayList.add(r13);
        restaurantArrayList.add(r14);
        restaurantArrayList.add(r15);
        restaurantArrayList.add(r16);
        restaurantArrayList.add(r17);
        restaurantArrayList.add(r18);
        restaurantArrayList.add(r19);
        restaurantArrayList.add(r20);


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
