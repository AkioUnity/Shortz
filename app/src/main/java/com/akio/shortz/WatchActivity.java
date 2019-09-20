package com.akio.shortz;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import adapter.TabproductpageAdapter;
import fragment.BottomSheetFragment;

public class WatchActivity extends AppCompatActivity implements View.OnClickListener {

    ViewPager viewpager1;
    TabLayout tablayout1;
    TabproductpageAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watch);

        Button subscribeBtn= findViewById(R.id.subscribeBtn);
        subscribeBtn.setOnClickListener(this);
        ImageView backBtn= findViewById(R.id.backBtn);
        backBtn.setOnClickListener(this);
        ImageView shareBtn= findViewById(R.id.shareBtn);
        shareBtn.setOnClickListener(this);

        tablayout1 = findViewById(R.id.tablayout1);
        viewpager1 = findViewById(R.id.viewpager1);

        tablayout1.setTabGravity(TabLayout.GRAVITY_FILL);
        tablayout1.addTab(tablayout1.newTab().setText("Free Videos"));
        tablayout1.addTab(tablayout1.newTab().setText("Latest Videos"));

        adapter = new TabproductpageAdapter(getSupportFragmentManager(), tablayout1.getTabCount());
        viewpager1.setAdapter(adapter);
        viewpager1.setOffscreenPageLimit(2);
        viewpager1.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tablayout1));
        tablayout1.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewpager1.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case  R.id.subscribeBtn: {
                // do something for button 1 click
                break;
            }
            case R.id.backBtn: {
                finish();
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

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
    }
}
