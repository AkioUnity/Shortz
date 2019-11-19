package com.akio.shortz;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import adapter.FriendArrayAdapter;
import adapter.FriendWatchArrayAdapter;

public class WatchParty0Activity extends Base1Activity {
    ListView friendListView;
    FriendWatchArrayAdapter adapter;
    String nameList[] = {"A_Lum007", "BadMamaJama", "DTSugar", "Eric_El90", "ErikaGellar88", "LoreleiGilmore", "M4m4cit4"};

    int pics[] = {R.drawable.friend_pic1, R.drawable.friend_pic2, R.drawable.friend_pic0, R.drawable.friend_pic3, R.drawable.friend_pic0, R.drawable.friend_pic4, R.drawable.friend_pic5, R.drawable.friend_pic6, R.drawable.friend_pic7};

    public int step=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ImageView menuBtn= findViewById(R.id.boarding_next_btn);
        menuBtn.setOnClickListener(this);
        menuBtn= findViewById(R.id.shareBtn);
        menuBtn.setVisibility(View.INVISIBLE);
        TextView toolbar_title= findViewById(R.id.toolbar_title);
        toolbar_title.setText("Watch Party");
        Update();
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_watch_party0;
    }

    public void Update(){
        TextView title= findViewById(R.id.watch_party_title);
        DatePicker datePicker=findViewById(R.id.datePicker1);
        friendListView = findViewById(R.id.friend_list_view);
//        LinearLayout shadow=findViewById(R.id.watch_shadow);
//        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) shadow.getLayoutParams();
        if (step==0){
            title.setText("Set a date and time for your party.");
            datePicker.setVisibility(View.VISIBLE);
            friendListView.setVisibility(View.GONE);
//            layoutParams.topMargin =  (int) getResources().getDimension(R.dimen.watch_shadow_top_margin);
        }
        else if (step==1)
        {
            title.setText("Invite your friends.");
            datePicker.setVisibility(View.GONE);
            friendListView.setVisibility(View.VISIBLE);
            adapter = new FriendWatchArrayAdapter(getApplicationContext(), nameList, pics);
            friendListView.setAdapter(adapter);
        }
        else if (step>1){
            step=1;
            Intent i = new Intent(this, WatchPartyActivity.class);
            this.startActivity(i);
        }
        else { //step<0
            step=0;
            finish();
        }

//        shadow.setLayoutParams(layoutParams);
    }


    public void onClick(View v) {
//        super.onClick(v);
        switch (v.getId()) {
            case R.id.boarding_next_btn: {
                step++;
                Update();
                break;
            }
            case R.id.backBtn: {
                step--;
                Update();
                break;
            }
        }
    }
}
