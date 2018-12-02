package lin_ge.restaurantadvisor.activities;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import lin_ge.restaurantadvisor.R;
import lin_ge.restaurantadvisor.components.FoodItems;


public class FoodListAdapter extends ArrayAdapter<FoodItems> {

    private Context context;
    private int resource;
    private int lastPosition = -1;

    public FoodListAdapter(Context context, int resource, ArrayList<FoodItems> items)
    {
        super(context, resource, items);
        this.context = context;
        this.resource = resource;
    }


    static class ViewHolder {
        TextView description;
        TextView price;
        TextView food;
    }
    @Override
    @Nullable
    public View getView(int position, View convertView, ViewGroup container)
    {
        final View result;

        FoodItems item = getItem(position);
        ViewHolder holder;

        if(convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(resource, container, false);
            holder = new ViewHolder();
            holder.food = (TextView) convertView.findViewById(R.id.food);
            holder.description = (TextView) convertView.findViewById(R.id.food_text);
            holder.price = (TextView) convertView.findViewById(R.id.price);
            convertView.setTag(holder);

            result = convertView;
        }
        else
        {
            holder = (ViewHolder) convertView.getTag();
            result = convertView;
        }
        Animation animation = AnimationUtils.loadAnimation(context, (position > lastPosition)?  R.anim.anim_load_down: R.anim.anim_load_up);

        result.startAnimation(animation);
        lastPosition = position;

        holder.price.setText(item.getPrice() + "");
        holder.description.setText(item.getDescription());
        holder.food.setText(item.getName());

        return convertView;
    }
}

