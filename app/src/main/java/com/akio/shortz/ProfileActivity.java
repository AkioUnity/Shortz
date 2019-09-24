package com.akio.shortz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import adapter.ImageAdapterGridView;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener {
    GridView androidGridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        ImageView backBtn = findViewById(R.id.backBtn);
        backBtn.setOnClickListener(this);
        ImageView shareBtn = findViewById(R.id.shareBtn);
        shareBtn.setVisibility(View.GONE);
        TextView title=findViewById(R.id.toolbar_title);
        title.setText("Profile");

        androidGridView = (GridView) findViewById(R.id.watch_list_view);
        androidGridView.setAdapter(new ImageAdapterGridView(this));

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
