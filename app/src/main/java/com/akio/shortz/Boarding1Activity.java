package com.akio.shortz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Boarding1Activity extends Base0Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ImageView menuBtn= findViewById(R.id.boarding_next_btn);
        menuBtn.setOnClickListener(this);
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_boarding1;
    }

    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.boarding_next_btn: {
                Intent i = new Intent(this, Boarding2Activity.class);
                this.startActivity(i);
                break;
            }
        }
    }
}
