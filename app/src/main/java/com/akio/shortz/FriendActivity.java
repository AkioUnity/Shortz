package com.akio.shortz;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import adapter.FriendArrayAdapter;


public class FriendActivity extends BaseActivity {
    ListView friendListView;
    LinearLayout toolbar1;
    LinearLayout toolbarSearch;
    EditText search_text;
    TextView mEmptyView;

    String nameList[] = {"A_Lum007", "BadMamaJama", "DTSugar", "Eric_El90", "ErikaGellar88", "LoreleiGilmore", "M4m4cit4", "norris_f22", "opensesam3", "akio"};
    int pics[] = {R.drawable.friend_pic1, R.drawable.friend_pic2, R.drawable.friend_pic0, R.drawable.friend_pic3, R.drawable.friend_pic0, R.drawable.friend_pic4, R.drawable.friend_pic5, R.drawable.friend_pic6, R.drawable.friend_pic7, R.drawable.friend_pic8, R.drawable.friend_pic0};

    String recent_nameList[] = {"GCizzle", "HVZer0", "SuperHels2", "J_Cheesman"};
    int recent_pics[] = {R.drawable.friend_pic1, R.drawable.friend_pic4, R.drawable.friend_pic2, R.drawable.friend_pic3};

    FriendArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ImageView searchBtn = findViewById(R.id.search_menu);
        searchBtn.setOnClickListener(this);
        searchBtn = findViewById(R.id.back_friend_toolbar);
        searchBtn.setOnClickListener(this);
        searchBtn = findViewById(R.id.search_close_btn);
        searchBtn.setOnClickListener(this);

        toolbar1 = findViewById(R.id.friend_toolbar);
        toolbar1.setVisibility(View.VISIBLE);
        toolbarSearch = findViewById(R.id.search_bar);

        mEmptyView = (TextView) findViewById(R.id.recent_view);
        friendListView = findViewById(R.id.friend_list_view);

        adapter = new FriendArrayAdapter(getApplicationContext(), nameList, pics);
        friendListView.setAdapter(adapter);

        search_text = findViewById(R.id.search_src_text);
        search_text.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
                mEmptyView.setVisibility(View.GONE);
                Log.d("akio", s.toString());
                adapter = new FriendArrayAdapter(getApplicationContext(), nameList, pics);
                friendListView.setAdapter(adapter);
                adapter.getFilter().filter(s);
//                friendListView.setAdapter(adapter);
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_friend;
    }


    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.back_friend_toolbar: {
                toolbar1.setVisibility(View.VISIBLE);
                toolbarSearch.setVisibility(View.GONE);
                mEmptyView.setVisibility(View.GONE);
                adapter = new FriendArrayAdapter(getApplicationContext(), nameList, pics);
                friendListView.setAdapter(adapter);
                break;
            }
            case R.id.search_menu: {
                Log.d("btn", "Search Menu click");
                toolbar1.setVisibility(View.GONE);
                toolbarSearch.setVisibility(View.VISIBLE);
                mEmptyView.setVisibility(View.VISIBLE);
                adapter = new FriendArrayAdapter(getApplicationContext(), recent_nameList, recent_pics);
                friendListView.setAdapter(adapter);
                break;
            }
            case R.id.search_close_btn: {
                search_text.setText("");
                adapter = new FriendArrayAdapter(getApplicationContext(), recent_nameList, recent_pics);
                friendListView.setAdapter(adapter);
                mEmptyView.setVisibility(View.VISIBLE);
                break;
            }
            //.... etc
        }
    }

}
