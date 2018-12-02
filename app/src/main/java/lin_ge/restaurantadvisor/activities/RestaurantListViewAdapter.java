package lin_ge.restaurantadvisor.activities;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import lin_ge.restaurantadvisor.R;
import lin_ge.restaurantadvisor.components.Restaurant;

public class RestaurantListViewAdapter extends BaseAdapter {

    // Declare Variables

    Context mContext;
    LayoutInflater inflater;
    private List<Restaurant> restaurantNameList = null;
    private ArrayList<Restaurant> arraylist;

    public RestaurantListViewAdapter(Context context, List<Restaurant> restaurantNameList) {
        mContext = context;
        this.restaurantNameList = restaurantNameList;
        inflater = LayoutInflater.from(mContext);
        this.arraylist = new ArrayList<Restaurant>();
        this.arraylist.addAll(restaurantNameList);
    }

    public class ViewHolder {
        TextView name;
        TextView price;
    }

    @Override
    public int getCount() {
        return restaurantNameList.size();
    }

    @Override
    public Restaurant getItem(int position) {
        return restaurantNameList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(final int position, View view, ViewGroup parent) {
        final ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.activity_restaurant_list_view_item, null);
            // Locate the TextViews in listview_item.xml
            holder.name = (TextView) view.findViewById(R.id.RestaurantName);
            holder.price = (TextView) view.findViewById(R.id.priceRange);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        // Set the results into TextViews
        holder.name.setText(restaurantNameList.get(position).getName());
        holder.price.setText(restaurantNameList.get(position).getPriceRange());
        return view;
    }

    // Filter Class
    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        restaurantNameList.clear();
        if (charText.length() == 0) {
            restaurantNameList.addAll(arraylist);
        } else {
            for (Restaurant wp : arraylist) {
                if (wp.getName().toLowerCase(Locale.getDefault()).contains(charText)) {
                    restaurantNameList.add(wp);
                }
            }
        }
        notifyDataSetChanged();
    }
}
