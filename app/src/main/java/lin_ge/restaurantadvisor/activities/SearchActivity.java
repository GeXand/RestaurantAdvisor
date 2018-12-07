package lin_ge.restaurantadvisor.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;

import androidx.room.Room;
import lin_ge.restaurantadvisor.R;
import lin_ge.restaurantadvisor.activities.LoginActivity;
import lin_ge.restaurantadvisor.activities.RestaurantActivity;
import lin_ge.restaurantadvisor.activities.RestaurantListViewAdapter;
import lin_ge.restaurantadvisor.components.Restaurant;
import lin_ge.restaurantadvisor.databases.RestaurantDatabase;

public class SearchActivity extends AppCompatActivity implements SearchView.OnQueryTextListener{

    ListView list;
    RestaurantListViewAdapter adapter;
    SearchView editsearch;
    public static Restaurant restaurants;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_search);

        Intent i = getIntent();
        String email = i.getStringExtra(LoginActivity.USER_EMAIL);

        list = (ListView) findViewById(R.id.restaurantlistview);

        // Pass results to ListViewAdapter Class
        adapter = new RestaurantListViewAdapter(this, MainActivity.restaurantArrayList);

        // Binds the Adapter to the ListView
        list.setAdapter(adapter);

        // Set an item click listener for ListView
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(getApplicationContext(), RestaurantActivity.class);
                restaurants = MainActivity.restaurantArrayList.get(position);
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
