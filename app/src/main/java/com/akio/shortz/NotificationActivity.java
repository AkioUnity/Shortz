package com.akio.shortz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class NotificationActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        ImageView backBtn = findViewById(R.id.backBtn);
        backBtn.setOnClickListener(this);
        ImageView shareBtn = findViewById(R.id.shareBtn);
        shareBtn.setVisibility(View.GONE);
        TextView title=findViewById(R.id.toolbar_title);
        title.setText("Notification");
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
