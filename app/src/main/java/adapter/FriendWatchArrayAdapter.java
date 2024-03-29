package adapter;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.akio.shortz.ProfileActivity;
import com.akio.shortz.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FriendWatchArrayAdapter extends ArrayAdapter<String> implements Filterable {
    String nameList[];
    int pic[];
    private List<Integer> filteredData = null;
    private LayoutInflater inflater;
    Context context;
    private ItemFilter mFilter = new ItemFilter();

    public FriendWatchArrayAdapter(Context applicationContext, String[] names, int[] avatars) {
        super(applicationContext, R.layout.friend_list_item, names);
        this.nameList = names;
        this.pic = avatars;
        this.context = applicationContext;

        filteredData = new ArrayList<Integer>(names.length);
        for (int i = 0; i < names.length; i++) {
            filteredData.add(i);
        }
        inflater = (LayoutInflater.from(applicationContext));
    }


    @Override
    public int getCount() {
        return filteredData.size();
    }

    @Override
    public String getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.friend_watch_list_item, viewGroup, false);
        TextView name = view.findViewById(R.id.friend_name);
        ImageView icon = view.findViewById(R.id.friend_icon);
        name.setText(nameList[filteredData.get(i)]);
        icon.setImageResource(pic[filteredData.get(i)]);
        return view;
    }

    public Filter getFilter() {
        return mFilter;
    }

    public class ItemFilter extends Filter {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {

            String filterString = constraint.toString().toLowerCase();

            FilterResults results = new FilterResults();

            final List<String> list = Arrays.asList(nameList);

            int count = list.size();
            final ArrayList<Integer> nlist = new ArrayList<Integer>(count);

            String filterableString;

            for (int i = 0; i < count; i++) {
                filterableString = list.get(i);
                if (filterableString.toLowerCase().contains(filterString)) {
                    nlist.add(i);
                }
            }

            results.values = nlist;
            results.count = nlist.size();

            return results;
        }

        @SuppressWarnings("unchecked")
        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            filteredData = (ArrayList<Integer>) results.values;
            notifyDataSetChanged();
        }
    }
}
