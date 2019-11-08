package fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.akio.shortz.R;
import com.akio.shortz.VideoActivity;

public class Infoproductpage extends Fragment implements View.OnClickListener {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.item_info, container, false);

        ImageView video_btn=view.findViewById(R.id.video_btn1);
        video_btn.setOnClickListener(this);
        video_btn=view.findViewById(R.id.video_btn2);
        video_btn.setOnClickListener(this);
        video_btn=view.findViewById(R.id.video_btn3);
        video_btn.setOnClickListener(this);
        return view;
    }

    public void startVideo(){
        Intent j = new Intent(getActivity().getApplicationContext(), VideoActivity.class);
        startActivity(j);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.video_btn1: {
                startVideo();
                break;
            }
            case R.id.video_btn2: {
                startVideo();
                break;
            }
            case R.id.video_btn3: {
                startVideo();
                break;
            }
            //.... etc
        }
    }
}
