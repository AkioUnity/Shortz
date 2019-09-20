package com.akio.shortz;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import fragment.BottomSheetFragment;

public class WatchListActivity extends BaseActivity {
    GridView androidGridView;

    Integer[] imageIDs = {
            R.drawable.top_channel1,R.drawable.top_channel2,R.drawable.top_channel3,R.drawable.watch_list_item0
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ImageView shareBtn= findViewById(R.id.shareBtn);
        shareBtn.setOnClickListener(this);

        androidGridView = (GridView) findViewById(R.id.watch_list_view);
        androidGridView.setAdapter(new ImageAdapterGridView(this));

        androidGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent,
                                    View v, int position, long id) {
//                Toast.makeText(getBaseContext(), "Grid Item " + (position + 1) + " Selected", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_watch_list;
    }

    public class ImageAdapterGridView extends BaseAdapter {
        private Context mContext;

        public ImageAdapterGridView(Context c) {
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

    public void onClick(View v) {
        switch (v.getId()) {
            case  R.id.subscribeBtn: {
                // do something for button 1 click
                break;
            }
            case R.id.shareBtn: {
                Log.d("btn","click");
                BottomSheetFragment bottomSheetFragment = new BottomSheetFragment();
                bottomSheetFragment.show(getSupportFragmentManager(), bottomSheetFragment.getTag());
                break;
            }

            //.... etc
        }
    }

}
