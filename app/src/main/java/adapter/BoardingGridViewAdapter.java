package adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.akio.shortz.R;

public class BoardingGridViewAdapter extends BaseAdapter {
    private Context mContext;
    Integer[] imageIDs = {
            R.drawable.top_channel0, R.drawable.top_channel1, R.drawable.top_channel2, R.drawable.top_channel3
    };

    public BoardingGridViewAdapter(Context c) {
        mContext = c;
    }

    public int getCount() {
        return imageIDs.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView mImageView;

        if (convertView == null) {
            mImageView = new ImageView(mContext);
//                mImageView.setLayoutParams(new GridView.LayoutParams(130, 130));
//                mImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
//                mImageView.setPadding(0, 5,0,10);
        } else {
            mImageView = (ImageView) convertView;
        }
        mImageView.setImageResource(imageIDs[position]);
        return mImageView;
    }
}