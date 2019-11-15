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

    Integer  images[][]={
            {R.drawable.channel1_0,R.drawable.channel1_1,R.drawable.channel1_2}
            ,{R.drawable.channel2_0,R.drawable.channel2_1,R.drawable.channel2_2,R.drawable.channel2_3}
            ,{R.drawable.channel3_0,R.drawable.channel3_1,R.drawable.channel3_2,R.drawable.channel3_3}
            ,{R.drawable.channel4_0,R.drawable.channel4_1,R.drawable.channel4_2,R.drawable.channel4_3}
        };

    String   channel_name[]={"Continue Watching","New Releases","Pangea Originals","Because you Watched Chicago Fire…"};

    public static boolean isLogined=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ImageView shareBtn = findViewById(R.id.notification_btn);
        shareBtn.setOnClickListener(this);

        LinearLayout parent = findViewById(R.id.linear_layout);

        for (int i=0;i<channel_name.length;i++) {
            channel_layout= (LinearLayout) getLayoutInflater().inflate(R.layout.channel_layout,parent,false);
            parent.addView(channel_layout);

            TextView title= channel_layout.findViewById(R.id.channel_title);
            title.setText(channel_name[i]);

            recyclerView = channel_layout.findViewById(R.id.recycler_view);
//            if (i==0){
//                ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) recyclerView.getLayoutParams();
//                params.topMargin = (int)getResources().getDimension(R.dimen.top_channel_margin_top);
//                recyclerView.setLayoutParams(params);
//            }

            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(HomeActivity.this);
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

            channel_modelArrayList = new ArrayList<>();

            for (int j = 0; j < images[i].length; j++) {
                Channel_Model view = new Channel_Model(images[i][j]);
                channel_modelArrayList.add(view);
            }
            channel_adapter = new ChannelAdapter(HomeActivity.this,channel_modelArrayList,i);
            recyclerView.setAdapter(channel_adapter);
        }
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_home;
    }

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
