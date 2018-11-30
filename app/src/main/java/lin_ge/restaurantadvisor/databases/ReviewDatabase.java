package lin_ge.restaurantadvisor.databases;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.util.Log;

import java.io.IOException;

import lin_ge.restaurantadvisor.components.Restaurant;
import lin_ge.restaurantadvisor.components.Review;

public class ReviewDatabase {

    private static final String TAG = "RestaurantDatabase";

    //The columns we'll include in the dictionary table
    public static final String COL_USERNAME = "USERNAME";
    public static final String COL_REVIEWTEXT = "REVIEWTEXT";
    public static final String COL_RATING = "RATING";
    public static final String COL_RESTAURANTID = "RESTAURANTID";

    private static final String DATABASE_NAME = "REVIEWS";
    private static final String FTS_VIRTUAL_TABLE = "FTS";
    private static final int DATABASE_VERSION = 1;

    private final DatabaseOpenHelper mDatabaseOpenHelper;

    public ReviewDatabase(Context context) {
        mDatabaseOpenHelper = new DatabaseOpenHelper(context);
    }

    public Cursor getMatches(String query, String[] columns) {
        String selection = COL_REVIEWTEXT + " MATCH ?";
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
                        COL_USERNAME + ", " +
                        COL_REVIEWTEXT + ", " +
                        COL_RATING + ", " +
                        COL_RESTAURANTID + ") ";

        DatabaseOpenHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
            mHelperContext = context;
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            mDatabase = db;
            mDatabase.execSQL(FTS_TABLE_CREATE);
            addReview(new Review("Bob", "This is a great restaurant. Great fries.", 5, 0));
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

        public long addReview(Review review) {
            ContentValues initialValues = new ContentValues();
            initialValues.put(COL_USERNAME, review.getUser());
            initialValues.put(COL_REVIEWTEXT, review.getText());
            initialValues.put(COL_RATING, review.getRating());
            initialValues.put(COL_RESTAURANTID, review.getRestaurantID());

            return mDatabase.insert(FTS_VIRTUAL_TABLE, null, initialValues);
        }
    }
}