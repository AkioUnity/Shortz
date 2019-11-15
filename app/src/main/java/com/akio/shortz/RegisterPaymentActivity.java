package com.akio.shortz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class RegisterPaymentActivity extends Base0Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TextView textBtn= findViewById(R.id.sign_in_toolbar_title);
        textBtn.setText("Payment Information");

        LinearLayout layoutBtn= findViewById(R.id.dlg_payment_btn);
        layoutBtn.setOnClickListener(this);
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_register_payment;
    }

    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.dlg_payment_btn: {
                Intent i = new Intent(this, RegisterPayment2Activity.class);
                this.startActivity(i);
                break;
            }
            //.... etc
        }
    }
}
