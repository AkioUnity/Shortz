package com.akio.shortz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Boarding3Activity extends Base0Activity {

    public int step=3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ImageView menuBtn= findViewById(R.id.boarding_next_btn);
        menuBtn.setOnClickListener(this);
        Update();
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_boarding3;
    }

    public void Update(){
        TextView title= findViewById(R.id.boarding_title);
        if (step==3){
            title.setText("Which devices will you be using?");
        }
        else if (step==4)
        {
            title.setText("Select your favorite genres.");
        }
        else{
            title.setText("Choose four shows you liked.");
        }
    }

    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.boarding_next_btn: {
                step++;
                if (step>5){
                    Intent i = new Intent(this, HomeActivity.class);
                    this.startActivity(i);
                }
                else
                    Update();
                break;
            }
        }
    }
}
