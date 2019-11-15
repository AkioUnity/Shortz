package com.akio.shortz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SignInActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        );

        ImageView menuBtn= findViewById(R.id.first_back_btn);
        menuBtn.setOnClickListener(this);
        LinearLayout layoutBtn= findViewById(R.id.register_btn);
        layoutBtn.setOnClickListener(this);
        TextView textBtn= findViewById(R.id.dlg_sign_in_btn);
        textBtn.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.first_back_btn: {
                finish();
                break;
            }
            case R.id.register_btn: {
                Intent i = new Intent(this, RegisterActivity.class);
                this.startActivity(i);
                break;
            }
            case R.id.dlg_sign_in_btn: {
                Intent i = new Intent(this, HomeActivity.class);
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
