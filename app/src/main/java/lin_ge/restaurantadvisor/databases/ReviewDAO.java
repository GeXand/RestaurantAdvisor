package lin_ge.restaurantadvisor.databases;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import lin_ge.restaurantadvisor.components.Restaurant;
import lin_ge.restaurantadvisor.components.Review;

@Dao
public interface ReviewDAO {
    @Query("SELECT * FROM reviews")
    List<Review> getAll();

    @Query("SELECT * FROM reviews WHERE restaurantID IN (:restaurantIDs)")
    List<Review> findByRestaurantID(int[] restaurantIDs);

    @Insert
    void insertAll(Review...reviews);

    @Delete
    void delete(Review review);
}