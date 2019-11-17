package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.akio.shortz.R;

public class BoardingGridViewAdapter extends BaseAdapter {
    private Context mContext;
    private LayoutInflater inflater;
    String nameList[];

    public BoardingGridViewAdapter(Context c,String[] names) {
        mContext = c;
        this.nameList = names;
    }

    public int getCount() {
        return nameList.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View view, ViewGroup parent) {
        inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.boarding_grid_list_item, parent, false);
        TextView name = view.findViewById(R.id.grid_item_text0);
        name.setText(nameList[position]);
        name = view.findViewById(R.id.grid_item_text1);
        name.setText(nameList[position]);
        return view;
    }
}