package lin_ge.restaurantadvisor.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;

import lin_ge.restaurantadvisor.R;
import lin_ge.restaurantadvisor.activities.LoginActivity;
import lin_ge.restaurantadvisor.activities.RestaurantActivity;
import lin_ge.restaurantadvisor.activities.RestaurantListViewAdapter;
import lin_ge.restaurantadvisor.components.Restaurant;

public class SearchActivity extends AppCompatActivity implements SearchView.OnQueryTextListener{

    ListView list;
    RestaurantListViewAdapter adapter;
    SearchView editsearch;
    public static Restaurant restaurants;
    ArrayList<Restaurant> arraylist = new ArrayList<Restaurant>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_search);

        Intent i = getIntent();
        String email = i.getStringExtra(LoginActivity.USER_EMAIL);

        list = (ListView) findViewById(R.id.restaurantlistview);

        Restaurant r1 = new Restaurant("Dominos", 0, 2, "262-9369-493", "10AM-9PM", "Fine Dining", "Fast Food", "$2-$6", "---");
        Restaurant r2 = new Restaurant("Apple Bee", 1, 2, "262-9369-493", "10AM-9PM", "Fine Dining", "Fast Food", "$2-$6", "---");
        Restaurant r3 = new Restaurant("Friday", 2, 2, "262-9369-493", "10AM-9PM", "Fine Dining", "Fast Food", "$2-$6", "---");
        arraylist.add(r1);
        arraylist.add(r2);
        arraylist.add(r3);

        // Pass results to ListViewAdapter Class
        adapter = new RestaurantListViewAdapter(this, arraylist);

        // Binds the Adapter to the ListView
        list.setAdapter(adapter);

        // Set an item click listener for ListView
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(getApplicationContext(), RestaurantActivity.class);
                restaurants = arraylist.get(position);
                startActivity(intent);
            }
        });

        // Locate the EditText in listview_main.xml
        editsearch = (SearchView) findViewById(R.id.restaurantsearch);
        editsearch.setOnQueryTextListener(this);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {

        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        String text = newText;
        adapter.filter(text);
        return false;
    }
}
