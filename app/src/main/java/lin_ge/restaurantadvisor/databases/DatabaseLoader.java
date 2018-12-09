package lin_ge.restaurantadvisor.databases;

import android.util.JsonReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Iterator;

import lin_ge.restaurantadvisor.components.Restaurant;

import static java.lang.System.in;

public class DatabaseLoader {

    public static void fillDatabase(String restaurantJsonFile, RestaurantDatabase db) throws Exception {
        Object JSONFile = new JSONParser().parse(new FileReader(restaurantJsonFile));
        JSONObject jsonObject = (JSONObject) JSONFile;
        JSONArray restaurants = (JSONArray) jsonObject.get("restaurants");

        for (int i = 0; i < restaurants.size(); i++) {
            JSONObject joCur = (JSONObject) restaurants.get(i);
            JSONObject curRestaurant = (JSONObject) joCur.get("restaurant");

        }
    }
}
