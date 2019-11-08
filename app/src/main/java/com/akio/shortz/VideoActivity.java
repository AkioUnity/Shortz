package com.akio.shortz;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import adapter.ImageAdapterGridView;

public class VideoActivity extends AppCompatActivity implements View.OnClickListener {
    private VideoView videoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        videoView = (VideoView)findViewById(R.id.videoView);
        String uriPath="http://2019fun.justmy.com/upload/video1.mp4";
        Uri uri = Uri.parse(uriPath);
        videoView.setVideoURI(uri);
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
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
