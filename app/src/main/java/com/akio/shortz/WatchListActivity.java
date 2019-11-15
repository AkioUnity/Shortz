package com.akio.shortz;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;

import adapter.ImageAdapterGridView;
import fragment.BottomSheetFragment;

public class WatchListActivity extends BaseActivity {
    GridView androidGridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ImageView shareBtn = findViewById(R.id.shareBtn);
        shareBtn.setOnClickListener(this);

        androidGridView = (GridView) findViewById(R.id.watch_list_view);
        androidGridView.setAdapter(new ImageAdapterGridView(this));

        androidGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent,
                                    View v, int position, long id) {
//                Toast.makeText(getBaseContext(), "Grid Item " + (position + 1) + " Selected", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_watch_list;
    }

    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.shareBtn: {
                Log.d("btn", "click");

//                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
//                sharingIntent.setType("text/plain");
//                String shareBody = "Here is the share content body";
//                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Watch Share");
//                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
//                startActivity(Intent.createChooser(sharingIntent, "Share via"));

                BottomSheetFragment bottomSheetFragment = new BottomSheetFragment();
                bottomSheetFragment.show(getSupportFragmentManager(), bottomSheetFragment.getTag());
                break;
            }

            //.... etc
        }
    }
}
