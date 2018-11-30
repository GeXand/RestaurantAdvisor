package lin_ge.restaurantadvisor;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.util.Log;

import java.io.IOException;

public class RestaurantDatabase {

    private static final String TAG = "RestaurantDatabase";

    //The columns we'll include in the dictionary table
    public static final String COL_EMAIL = "EMAIL";
    public static final String COL_NAME = "NAME";
    public static final String COL_RATING = "RATING";
    public static final String COL_PHONENUMBER = "PHONENUMBER";
    public static final String COL_HOURS = "HOURS";
    public static final String COL_DININGTYPE = "DININGTYPE";
    public static final String COL_CUISINETYPE = "CUISINETYPE";
    public static final String COL_PRICERANGE = "PRICERANGE";
    public static final String COL_REVIEWS = "REVIEWS";

    private static final String DATABASE_NAME = "RESTAURANTS";
    private static final String FTS_VIRTUAL_TABLE = "FTS";
    private static final int DATABASE_VERSION = 1;

    private final DatabaseOpenHelper mDatabaseOpenHelper;

    public RestaurantDatabase(Context context) {
        mDatabaseOpenHelper = new DatabaseOpenHelper(context);
    }

    public Cursor getMatches(String query, String[] columns) {
        String selection = COL_NAME + " MATCH ?";
        String[] selectionArgs = new String[] {query + "*"};

        return query(selection, selectionArgs, columns);
    }

    private Cursor query(String selection, String[] selectionArgs, String[] columns) {
        SQLiteQueryBuilder builder = new SQLiteQueryBuilder();
        builder.setTables(FTS_VIRTUAL_TABLE);

        Cursor cursor = builder.query(mDatabaseOpenHelper.getReadableDatabase(), columns, selection, selectionArgs, null, null, null);

        if (cursor == null) {
            return null;
        } else if (!cursor.moveToFirst()) {
            cursor.close();
            return null;
        }

        return cursor;
    }

    private static class DatabaseOpenHelper extends SQLiteOpenHelper {

        private final Context mHelperContext;
        private SQLiteDatabase mDatabase;

        private static final String FTS_TABLE_CREATE =
                "CREATE VIRTUAL TABLE " + FTS_VIRTUAL_TABLE +
                        " USING fts3 (" +
                        COL_EMAIL + ", " +
                        COL_NAME + ", " +
                        COL_RATING + ", " +
                        COL_PHONENUMBER + ", " +
                        COL_HOURS + ", " +
                        COL_DININGTYPE + ", " +
                        COL_CUISINETYPE + ", " +
                        COL_PRICERANGE + ", " +
                        COL_REVIEWS + ")";

        DatabaseOpenHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
            mHelperContext = context;
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            mDatabase = db;
            mDatabase.execSQL(FTS_TABLE_CREATE);
            addRestaurant(new Restaurant("Maxim's", 0, 4, "2627834501", "6AM-10PM", "Late-night", "American Comfort Food","$$", "N/A"));
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            Log.w(TAG, "Upgrading database from version " + oldVersion + " to "
                    + newVersion + ", which will destroy all old data");
            db.execSQL("DROP TABLE IF EXISTS " + FTS_VIRTUAL_TABLE);
            onCreate(db);
        }

        private void loadRestaurants() {
            new Thread(new Runnable() {
                public void run() {
                    try {
                        loadFromFile();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }).start();
        }

        private void loadFromFile() throws IOException {

        }

        public long addRestaurant(Restaurant restaurant) {
            ContentValues initialValues = new ContentValues();
            initialValues.put(COL_NAME, restaurant.getName());
            initialValues.put(COL_EMAIL, restaurant.getEmail());
            initialValues.put(COL_RATING, restaurant.getRating());
            initialValues.put(COL_PHONENUMBER, restaurant.getPhoneNumber());
            initialValues.put(COL_HOURS, restaurant.getHourOfOperation());
            initialValues.put(COL_DININGTYPE, restaurant.getTypeOfDining());
            initialValues.put(COL_CUISINETYPE, restaurant.getTypeOfCuisine());
            initialValues.put(COL_PRICERANGE, restaurant.priceRange());
            initialValues.put(COL_REVIEWS, restaurant.getReviews().toString());

            return mDatabase.insert(FTS_VIRTUAL_TABLE, null, initialValues);
        }
    }
}