package com.akio.shortz;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import fragment.BottomSheetFragment;

public class FriendActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ImageView searchBtn= findViewById(R.id.search_menu);
        searchBtn.setOnClickListener(this);
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_watch_list;
    }



    public void onClick(View v) {
        switch (v.getId()) {
            case  R.id.subscribeBtn: {
                // do something for button 1 click
                break;
            }
            case R.id.search_menu: {
                Log.d("btn","Search Menu click");
                BottomSheetFragment bottomSheetFragment = new BottomSheetFragment();
                bottomSheetFragment.show(getSupportFragmentManager(), bottomSheetFragment.getTag());
                break;
            }

            //.... etc
        }
    }

}
