package lin_ge.restaurantadvisor;

import java.util.ArrayList;
import java.util.Comparator;

public class PriorityQueue {

    private ArrayList<Restaurant> list;

    public PriorityQueue()
    {
        list = new ArrayList<Restaurant>();
    }

    public void enqueue(Restaurant restaurant)
    {
        list.add(restaurant);
    }

    public boolean isFull()
    {
        return false;
    }

    public boolean isEmpty()
    {
        return list.size() == 0;
    }

    public Restaurant dequeue(Comparator<String> c, String search)
    {
        if(isEmpty())
            return null;
        for(int i = 0; i < list.size(); i++)
        {
            Restaurant temp = list.get(i);
            if(c.compare(temp.toString(), search) > 0)
            {
                list.remove(temp);
                return temp;
            }
        }
        return null;
    }

    public boolean contains(String search)
    {
        for(Restaurant r: list)
        {
            if(r.toString().contains(search))
                return true;
        }
        return false;
    }

    public Restaurant get(String search, Comparator<String> c)
    {
        if(isEmpty())
            return null;
        for(int i = 0; i < list.size(); i++)
        {
            Restaurant temp = list.get(i);
            if(c.compare(temp.toString(), search) > 0)
            {
                return temp;
            }
        }
        return null;
    }
}

