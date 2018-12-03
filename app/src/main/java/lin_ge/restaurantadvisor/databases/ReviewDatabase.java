package lin_ge.restaurantadvisor.databases;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import lin_ge.restaurantadvisor.components.Restaurant;
import lin_ge.restaurantadvisor.components.Review;

@Database(entities = {Review.class, Restaurant.class}, version = 1)
public abstract class ReviewDatabase extends RoomDatabase {
    public abstract ReviewDAO reviewDAO();
}
