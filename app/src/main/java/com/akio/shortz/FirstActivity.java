package com.akio.shortz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class FirstActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        );

        setContentView(R.layout.activity_first);

        LinearLayout btn= findViewById(R.id.sign_in_btn);
        btn.setOnClickListener(this);
        TextView menuBtn= findViewById(R.id.sign_up_btn);
        menuBtn.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.sign_in_btn: {
                Intent i = new Intent(this, SignInActivity.class);
                this.startActivity(i);
                break;
            }
            case R.id.sign_up_btn: {
                Intent i = new Intent(this, RegisterActivity.class);
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
