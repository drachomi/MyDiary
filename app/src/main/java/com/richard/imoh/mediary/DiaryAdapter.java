package com.richard.imoh.mediary;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by LENOVO on 6/30/2018.
 */

public class DiaryAdapter extends RecyclerView.Adapter<DiaryAdapter.MyViewHolder> {
List<Message> messageList;

    public DiaryAdapter(List<Message> messageList) {
        this.messageList = messageList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.diary_item,parent,false);

        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Message message = messageList.get(position);
        holder.title.setText(message.getTitle());
        holder.time.setText(message.getTimeStamp());
        Glide.with(holder.emojy.getContext())
                .load(message.getFeelingEmoji())
                .into(holder.emojy);

    }



    @Override
    public int getItemCount() {
        return messageList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView title,time;
        ImageView emojy;


        public MyViewHolder(View itemView) {
            super(itemView);
            time = itemView.findViewById(R.id.timeStamp);
            title = itemView.findViewById(R.id.message_title);
            emojy = itemView.findViewById(R.id.emoji);



        }
    }
}
