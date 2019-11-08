package com.akio.shortz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import java.util.ArrayList;

import adapter.ChannelAdapter;
import model.Channel_Model;

public class HomeActivity extends BaseActivity {

    private RecyclerView recyclerView;
    private ArrayList<Channel_Model> channel_modelArrayList;
    private ChannelAdapter channel_adapter;
    LinearLayout channel_layout;

    CarouselView carouselView;

    int[] sampleImages = {R.drawable.home_a, R.drawable.home_b, R.drawable.home_c, R.drawable.hero_logo};

    Integer  images[][]={
            {R.drawable.channel2_0,R.drawable.channel2_1,R.drawable.channel2_2,R.drawable.channel2_3}
            ,{R.drawable.channel1_0,R.drawable.channel1_1,R.drawable.channel1_2,R.drawable.channel1_3}
            ,{R.drawable.popular_0,R.drawable.channel3_1,R.drawable.channel3_2,R.drawable.channel2_3}
            ,{R.drawable.week_0,R.drawable.week_1,R.drawable.week_2,R.drawable.channel2_3}
            ,{R.drawable.channel3_0,R.drawable.continue_1,R.drawable.continue_2,R.drawable.channel2_3}
            ,{R.drawable.top_channel1,R.drawable.top_channel2,R.drawable.top_channel3,R.drawable.top_channel1}
        };

    String   channel_name[]={"Recommended","Trending","Most Popular","New This Week","Continue Watching","List by Channel"};

    public static boolean isLogined=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ImageView shareBtn = findViewById(R.id.notification_btn);
        shareBtn.setOnClickListener(this);

        carouselView = (CarouselView) findViewById(R.id.carouselView);
        carouselView.setPageCount(sampleImages.length);

        carouselView.setImageListener(imageListener);

        LinearLayout parent = findViewById(R.id.linear_layout);

        for (int i=0;i<channel_name.length;i++) {
            channel_layout= (LinearLayout) getLayoutInflater().inflate(R.layout.channel_layout,parent,false);
            parent.addView(channel_layout);

            TextView title= channel_layout.findViewById(R.id.channel_title);
            title.setText(channel_name[i]);

            recyclerView = channel_layout.findViewById(R.id.recycler_view);
            if (i==0){
                ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) recyclerView.getLayoutParams();
                params.topMargin = (int)getResources().getDimension(R.dimen.top_channel_margin_top);
                recyclerView.setLayoutParams(params);
            }

            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(HomeActivity.this);
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

            channel_modelArrayList = new ArrayList<>();

            for (int j = 0; j < images[i].length; j++) {
                Channel_Model view = new Channel_Model(images[i][j]);
                channel_modelArrayList.add(view);
            }
            channel_adapter = new ChannelAdapter(HomeActivity.this,channel_modelArrayList);
            recyclerView.setAdapter(channel_adapter);
        }
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_home;
    }

    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(sampleImages[position]);
        }
    };

    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.notification_btn: {
                Intent i = new Intent(this, NotificationActivity.class);
                this.startActivity(i);
                break;
            }
        }
    }
}
