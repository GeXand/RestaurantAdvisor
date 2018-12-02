package lin_ge.restaurantadvisor.databases;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import lin_ge.restaurantadvisor.components.Restaurant;

@Database(entities = {Restaurant.class}, version = 1)
public abstract class RestaurantDatabase extends RoomDatabase{
    public abstract RestaurantDAO restuarantDAO();
}
