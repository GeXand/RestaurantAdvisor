package lin_ge.restaurantadvisor.components;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.ArrayList;

public class JsonRestaurantLoader {
    public static ArrayList<Restaurant> loadRestaurants(String restaurantJsonFile) throws Exception {
        ArrayList<Restaurant> restaurantArrayList = new ArrayList<Restaurant>();
        Object JSONFile = new JSONParser().parse(new FileReader(restaurantJsonFile));
        JSONObject jsonObject = (JSONObject) JSONFile;
        JSONArray restaurants = (JSONArray) jsonObject.get("restaurants");

        for (int i = 0; i < restaurants.size(); i++) {
            JSONObject joCur = (JSONObject) restaurants.get(i);
            JSONObject curRestaurant = (JSONObject) joCur.get("restaurant");

            JSONObject location = (JSONObject) curRestaurant.get("location");
            String address = (String) location.get("address");
            String name = (String) curRestaurant.get("name");
            String cuisines = (String) curRestaurant.get("cuisines");
            String priceRange = "";
            long priceRangeNum = (long) curRestaurant.get("price_range");
            for (int j = 0; j < priceRangeNum; j++) {
                priceRange += "$";
            }

            restaurantArrayList.add(new Restaurant(name, i,0,"","","",cuisines,priceRange,address));
        }

        return restaurantArrayList;
    }
}
