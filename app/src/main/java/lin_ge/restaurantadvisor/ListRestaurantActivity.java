package lin_ge.restaurantadvisor;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ListRestaurantActivity extends AppCompatActivity {

    ListView myListView;
    List<Restaurant> list = new ArrayList<Restaurant>();

    public void onCreate(Bundle savedInstanceBundle)
    {
        super.onCreate(savedInstanceBundle);
        setContentView(R.layout.activity_restaurant);
        //Restaurant nres = new Restaurant("",1,3,"","",
          //      "","","","");
       // list.add();

        myListView.setAdapter(new ArrayAdapter<Restaurant>(this, R.layout.activity_restaurant_detail));
    }
}
