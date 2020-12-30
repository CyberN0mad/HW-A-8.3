package com.example.hw8andr1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterClass extends RecyclerView.Adapter<AdapterClass.AdapterSubClass>{

    private ArrayList<String> list = new ArrayList<>();

    public AdapterClass(ArrayList<String> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public AdapterSubClass onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item,parent,false);
        return new AdapterSubClass(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterSubClass holder, int position) {
        holder.onBind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class AdapterSubClass extends RecyclerView.ViewHolder {
      TextView textView;
        public AdapterSubClass(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.textView);
        }
        public void onBind(String text){
            textView.setText(text);
        }
    }
}
