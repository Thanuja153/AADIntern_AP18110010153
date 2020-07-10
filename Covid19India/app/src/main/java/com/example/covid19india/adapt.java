package com.example.covid19india;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class adapt extends RecyclerView.Adapter<adapt.MyViewHolder>{
    Context contxt;
    List<CovidData> cd;
    public adapt(Context contxt, List<CovidData> cd) {
        this.contxt=contxt;
        this.cd=cd;
    }


    @NonNull
    @Override
    public adapt.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(contxt).inflate(R.layout.myitem,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull adapt.MyViewHolder holder, int position) {
        CovidData cvdData=cd.get(position);
        holder.tv1.setText(cvdData.getDate());
        holder.tv2.setText(cvdData.getActive());
        holder.tv3.setText(cvdData.getRecovered());
        holder.tv4.setText(cvdData.getDeaths());


    }

    @Override
    public int getItemCount() {
        return cd.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv1,tv2,tv3,tv4;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv1=itemView.findViewById(R.id.date);
            tv2=itemView.findViewById(R.id.active);
            tv3=itemView.findViewById(R.id.recover);
            tv4=itemView.findViewById(R.id.death);

        }
    }
}
