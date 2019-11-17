package com.akio.shortz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

public abstract class Base1Activity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResource());

        ImageView menuBtn= findViewById(R.id.backBtn);
        if (menuBtn!=null)
            menuBtn.setOnClickListener(this);
    }

    protected abstract int getLayoutResource();

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.backBtn: {
                finish();
                break;
            }
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
