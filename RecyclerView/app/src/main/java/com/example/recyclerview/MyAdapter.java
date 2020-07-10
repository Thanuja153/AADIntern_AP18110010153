package com.example.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
Context context;
int myimages[];
String name[],vers[],ap[],rel[];
    public MyAdapter(MainActivity mainActivity, int[] image, String[] names, String[] version, String[] api, String[] release) {
        myimages=image;
        name=names;
        vers=version;
        ap=api;
        rel=release;
        context=mainActivity;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.myitem,parent,false);
        MyViewHolder viewHolder=new MyViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int pos) {
        holder.imageView.setImageResource(myimages[pos]);
        holder.t1.setText(name[pos]);
        holder.t2.setText(vers[pos]);
        holder.t3.setText(ap[pos]);
        holder.t4.setText(rel[pos]);

    }

    @Override
    public int getItemCount() {

        return myimages.length;
    }
    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView t1,t2,t3,t4;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.imgview);
            t1=itemView.findViewById(R.id.txt1);
            t2=itemView.findViewById(R.id.txt2);
            t3=itemView.findViewById(R.id.txt3);
            t4=itemView.findViewById(R.id.txt4);

        }
    }
}
