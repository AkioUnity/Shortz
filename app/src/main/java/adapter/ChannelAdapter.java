package adapter;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import com.akio.shortz.HomeActivity;
import com.akio.shortz.R;
import com.akio.shortz.WatchActivity;

import java.util.ArrayList;

import model.Channel_Model;

public class ChannelAdapter extends RecyclerView.Adapter<ChannelAdapter.ViewHolder> {

    Context context;
    private ArrayList<Channel_Model> Channel_ModelArrayList;

    public ChannelAdapter(Context context, ArrayList<Channel_Model> Channel_ModelArrayList) {
        this.context = context;
        this.Channel_ModelArrayList = Channel_ModelArrayList;
    }

    @Override
    public ChannelAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.channel, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ChannelAdapter.ViewHolder holder, final int position) {
        holder.channelBtn.setImageResource(Channel_ModelArrayList.get(position).getImageView1());
        holder.channelBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.d("Button", "clicked" + position);

                if (HomeActivity.isLogined) {
                    Intent in = new Intent(context, WatchActivity.class);
                    context.startActivity(in);
                    return;
                }

                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

                @SuppressLint("InflateParams") View alertLayout = inflater.inflate(R.layout.login_dialog, null);

                final EditText etUsername = alertLayout.findViewById(R.id.textUsername);
                final EditText etPassword = alertLayout.findViewById(R.id.textPassword);

                AlertDialog.Builder login = new AlertDialog.Builder(v.getContext());

                login.setView(alertLayout);
                login.setCancelable(false);
                login.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
//                        Toast.makeText(getBaseContext(), "Cancel clicked.", Toast.LENGTH_SHORT).show();
                    }
                });
                login.setPositiveButton("sign in", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String user = etUsername.getText().toString();
                        String pass = etPassword.getText().toString();
                        HomeActivity.isLogined = true;
                        Intent in = new Intent(context, WatchActivity.class);
                        context.startActivity(in);
//                        Toast.makeText(getBaseContext(), "User: " + user + " Password: " + pass + " Logged in.", Toast.LENGTH_LONG).show();
                    }
                });
                final AlertDialog dialog = login.create();
                dialog.setOnShowListener(new DialogInterface.OnShowListener() {
                    @Override
                    public void onShow(DialogInterface arg0) {
                        dialog.getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(Color.parseColor("#8A000000"));
                        dialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(Color.parseColor("#017FB3"));
                    }
                });

                dialog.show();
// Do something in response to button click
            }
        });
//        holder.txtprice.setText(Channel_ModelArrayList.get(position).getTxtprice());
//        holder.txtproductname.setText(Channel_ModelArrayList.get(position).getTxtproductname());
//        holder.txtreviews.setText(Channel_ModelArrayList.get(position).getTxtreviews());
    }

    @Override
    public int getItemCount() {
        return Channel_ModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView channelBtn;
//        TextView txtprice,txtproductname,txtreviews;

        public ViewHolder(View itemView) {
            super(itemView);
            channelBtn = itemView.findViewById(R.id.channelBtn);
//            txtprice=itemView.findViewById(R.id.txtprice);
//            txtproductname=itemView.findViewById(R.id.txtproductname);
//            txtreviews=itemView.findViewById(R.id.txtreviews);


        }
    }
}
