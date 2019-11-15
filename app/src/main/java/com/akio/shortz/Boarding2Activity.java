package com.akio.shortz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

public class Boarding2Activity extends Base0Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ImageView menuBtn= findViewById(R.id.boarding_next_btn);
        menuBtn.setOnClickListener(this);

        Spinner dropdown = findViewById(R.id.boarding_spinner1);
        String[] items = new String[]{"Select Age", "23", "24"};
//create an adapter to describe how the items are displayed, adapters are used in several places in android.
//There are multiple variations of this, but this is the basic variant.
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
//set the spinners adapter to the previously created one.
        dropdown.setAdapter(adapter);

        Spinner dropdown2 = findViewById(R.id.boarding_spinner2);
        String[] items2 = new String[]{"Select Gender", "Male", "Female"};
//create an adapter to describe how the items are displayed, adapters are used in several places in android.
//There are multiple variations of this, but this is the basic variant.
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items2);
//set the spinners adapter to the previously created one.
        dropdown2.setAdapter(adapter2);
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_boarding2;
    }

    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.boarding_next_btn: {
                Intent i = new Intent(this, Boarding3Activity.class);
                this.startActivity(i);
                break;
            }
        }
    }
}

