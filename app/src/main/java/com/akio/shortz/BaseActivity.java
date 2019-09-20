package com.akio.shortz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResource());

        ImageView homeBtn= findViewById(R.id.menu_home);
        homeBtn.setOnClickListener(this);
        ImageView menuBtn= findViewById(R.id.menu_watch_list);
        menuBtn.setOnClickListener(this);
        menuBtn= findViewById(R.id.menu_friend);
        menuBtn.setOnClickListener(this);
    }

    protected abstract int getLayoutResource();

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.menu_home: {
                Intent i = new Intent(this, HomeActivity.class);
                this.startActivity(i);
                break;
            }
            case R.id.menu_watch_list: {
                Intent i = new Intent(this, WatchListActivity.class);
                this.startActivity(i);
                break;
            }
            case R.id.menu_friend: {
                Intent i = new Intent(this, FriendActivity.class);
                this.startActivity(i);
                break;
            }
            //.... etc
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
