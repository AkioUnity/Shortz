package com.akio.shortz;

import android.content.Intent;
import android.support.transition.Visibility;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import adapter.BoardingGridViewAdapter;
import adapter.ImageAdapterGridView;

public class Boarding3Activity extends Base0Activity {
    GridView gridView;
    public int step=3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ImageView menuBtn= findViewById(R.id.boarding_next_btn);
        menuBtn.setOnClickListener(this);
        gridView = findViewById(R.id.grid_view);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent,
                                    View v, int position, long id) {
                LinearLayout layout= v.findViewById(R.id.grid_item_box0);
                if (layout.getVisibility()==View.GONE)
                    layout.setVisibility(View.VISIBLE);
                else
                    layout.setVisibility(View.GONE);
//                Toast.makeText(getBaseContext(), "Grid Item " + (position + 1) + " Selected", Toast.LENGTH_LONG).show();
            }
        });
        Update();
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_boarding3;
    }

    public void Update(){
        TextView title= findViewById(R.id.boarding_title);
        String nameList[];
        if (step<3){
            step=3;
            finish();
        }
        if (step==3){
            title.setText("Which devices will you be using?");
            nameList= new String[]{"Tablet", "Playstation", "Phone", "Computer", "Smart TV", "FireTV Stick", "XBox"};
        }
        else if (step==4)
        {
            title.setText("Select your favorite genres.");
            nameList= new String[]{"Action", "History", "Adventure", "Horror", "Comedy", "Music", "Cooking", "News", "Documentary", "Reality TV", "Drama", "Romance", "Family", "Sports", "Fantasy", "Talk Shows", "Game Show"};
        }
        else{
            nameList= new String[]{"Generations", "Big Brother", "7 de Laan", "The Curse of Oak...", "Muvhango", "E! News", "Uzalo", "Just for Laughs", "Skeem Saam", "Ellen", "Isidingo", "The Price is Right", "Harry", "Masterchef", "Last Week tonight", "Law & Order", "Big Bang Theory"};
        }

        gridView.setAdapter(new BoardingGridViewAdapter(this,nameList));
    }

    public void onClick(View v) {
//        super.onClick(v);
        switch (v.getId()) {
            case R.id.boarding_next_btn: {
                step++;
                if (step>5){
                    step=5;
                    Intent i = new Intent(this, HomeActivity.class);
                    this.startActivity(i);
                }
                else
                    Update();
                break;
            }
            case R.id.first_back_btn: {
                step--;
                Update();
                break;
            }
        }
    }
}
