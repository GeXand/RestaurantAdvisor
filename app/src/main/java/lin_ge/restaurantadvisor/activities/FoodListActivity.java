package lin_ge.restaurantadvisor.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import lin_ge.restaurantadvisor.R;
import lin_ge.restaurantadvisor.components.FoodItems;

public class FoodListActivity extends AppCompatActivity {
    private ListView listView;
    private ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_list);

        listView = (ListView) findViewById(R.id.listView);

        FoodItems f1 = new FoodItems("Cheese Burger","a fat yellow sandwich",2.03);
        FoodItems f2 = new FoodItems("Cheese Burger","a fat yellow sandwich",2.03);
        FoodItems f3 = new FoodItems("Cheese Burger","a fat yellow sandwich",2.03);
        FoodItems f4 = new FoodItems("Cheese Burger","a fat yellow sandwich",2.03);
        FoodItems f5 = new FoodItems("Cheese Burger","a fat yellow sandwich",2.03);
        FoodItems f6 = new FoodItems("Cheese Burger","a fat yellow sandwich",2.03);
        FoodItems f7 = new FoodItems("Cheese Burger","a fat yellow sandwich",2.03);
        FoodItems f8 = new FoodItems("Cheese Burger","a fat yellow sandwich",2.03);
        FoodItems f9 = new FoodItems("Cheese Burger","a fat yellow sandwich",2.03);
        FoodItems f10 = new FoodItems("Cheese Burger","a fat yellow sandwich",2.03);

        final ArrayList<FoodItems> arrayList = new ArrayList<FoodItems>();
        arrayList.add(f1);
        arrayList.add(f2);
        arrayList.add(f3);
        arrayList.add(f4);
        arrayList.add(f5);
        arrayList.add(f6);
        arrayList.add(f7);
        arrayList.add(f8);
        arrayList.add(f9);
        arrayList.add(f10);

        FoodListAdapter foodListAdapter = new FoodListAdapter(this, R.layout.activity_food_list_view, arrayList);
        listView.setAdapter(foodListAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                FoodItems food = arrayList.get(position);
                CharSequence text = "You Have Ordered a " + food.getName();
                Toast toast  = Toast.makeText(getApplicationContext(),text, Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }
}
