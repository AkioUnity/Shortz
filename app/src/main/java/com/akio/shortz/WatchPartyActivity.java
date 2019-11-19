package com.akio.shortz;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.VideoView;


public class WatchPartyActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watch_party);

        ImageView backBtn = findViewById(R.id.backBtn);
        backBtn.setOnClickListener(this);
        InitVideo();
    }

    public void InitVideo(){
        VideoView videoView =  (VideoView) findViewById(R.id.videoplayer);
//        "http://2019fun.justmy.com/upload/video2.mp4";
        String uriPath= "android.resource://" + getPackageName() + "/" + R.raw.video2;
        Uri uri = Uri.parse(uriPath);
        videoView.setVideoURI(uri);
//        MediaController mediaController = new MediaController(this);
//        mediaController.setAnchorView(videoView);
//        videoView.setMediaController(mediaController);
        videoView.start();
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.backBtn: {
                finish();
                break;
            }
            //.... etc
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
    }
}
