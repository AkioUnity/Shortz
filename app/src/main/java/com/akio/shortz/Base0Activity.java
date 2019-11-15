package com.akio.shortz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

public abstract class Base0Activity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResource());

        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        );

        ImageView menuBtn= findViewById(R.id.first_back_btn);
        if (menuBtn!=null)
            menuBtn.setOnClickListener(this);
    }

    protected abstract int getLayoutResource();

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.first_back_btn: {
                finish();
                break;
            }
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
