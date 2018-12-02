package lin_ge.restaurantadvisor.databases;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import lin_ge.restaurantadvisor.components.Restaurant;

@Dao
public interface RestaurantDAO {

    @Query("SELECT * FROM restaurants")
    List<Restaurant> getAll();

    @Query("SELECT * FROM restaurants WHERE name LIKE :name")
    List<Restaurant> findByName(String name);

    @Insert
    void insertAll(Restaurant...restuarants);

    @Delete
    void delete(Restaurant restaurant);

}
