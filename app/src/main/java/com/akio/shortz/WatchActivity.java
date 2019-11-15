package com.akio.shortz;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;

import adapter.TabproductpageAdapter;
import fragment.BottomSheetFragment;

public class WatchActivity extends AppCompatActivity implements View.OnClickListener {

    ViewPager viewpager1;
    TabLayout tablayout1;
    TabproductpageAdapter adapter;
    VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watch);

//        Button subscribeBtn= findViewById(R.id.subscribeBtn);
//        subscribeBtn.setOnClickListener(this);
        ImageView backBtn= findViewById(R.id.backBtn);
        backBtn.setOnClickListener(this);
        ImageView shareBtn= findViewById(R.id.shareBtn);
        shareBtn.setOnClickListener(this);

        shareBtn= findViewById(R.id.watch_list_btn);
        shareBtn.setOnClickListener(this);
        shareBtn= findViewById(R.id.watch_party_btn);
        shareBtn.setOnClickListener(this);

//        InitVideo();
    }

    public void InitVideo(){

        videoView =  (VideoView) findViewById(R.id.videoplayer);
        String uriPath="http://2019fun.justmy.com/upload/video1.mp4";
        Uri uri = Uri.parse(uriPath);
        videoView.setVideoURI(uri);
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);
        videoView.setVisibility(View.VISIBLE);
        videoView.start();
        viewpager1.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case  R.id.video_btn1: {
                videoView.setVisibility(View.VISIBLE);
                videoView.start();
                // do something for button 1 click
                break;
            }
            case  R.id.video_btn2: {
                videoView.setVisibility(View.VISIBLE);
                videoView.start();
                // do something for button 1 click
                break;
            }
            case  R.id.video_btn3: {
                videoView.setVisibility(View.VISIBLE);
                videoView.start();
                // do something for button 1 click
                break;
            }
            case R.id.backBtn: {
                finish();
                break;
            }
            case R.id.watch_list_btn: {
                Intent i = new Intent(this, WatchListActivity.class);
                this.startActivity(i);
                break;
            }
            case R.id.watch_party_btn: {
                Intent i = new Intent(this, WatchPartyActivity.class);
                this.startActivity(i);
                break;
            }
            case R.id.shareBtn: {
                Log.d("btn","click");
//                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
//                sharingIntent.setType("text/plain");
//                String shareBody = "Here is the share content body";
//                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject Here");
//                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
//                startActivity(Intent.createChooser(sharingIntent, "Share via"));
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
