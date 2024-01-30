package com.example.learningandroid.model;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.learningandroid.R;

import java.util.ArrayList;
import java.util.List;

public class Cat_crudApdater extends RecyclerView.Adapter<Cat_crudApdater.Cat_crudHolder>{
    private Context context;
    private List<Cat_crud> lst;
    private Cat_crubItemListener listener;

    public Cat_crudApdater(Context context) {
        this.context = context;
        this.lst = new ArrayList<>();
    }

    public void setListener(Cat_crubItemListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public Cat_crudHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_crud, parent, false);
        return new Cat_crudHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull Cat_crudHolder holder, @SuppressLint("RecyclerView") int position) {
        Cat_crud cat_crud = lst.get(position);
        if (cat_crud == null)
            return;
        holder.iv.setImageResource(cat_crud.getImg());
        holder.tv1.setText(cat_crud.getName());
        holder.tv2.setText(cat_crud.getPrice()+"");
        holder.tv3.setText(cat_crud.getDescription());
        holder.bt.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onClick(View v) {
                lst.remove(position);
                notifyDataSetChanged();
            }
        });
    }


    @Override
    public int getItemCount() {
        return lst == null ? 0 : lst.size();
    }

    public Cat_crud getItem(int position) {
        return lst.get(position);
    }

    @SuppressLint("NotifyDataSetChanged")
    public void add(Cat_crud cat) {
        lst.add(cat);
        notifyDataSetChanged();
    }

    @SuppressLint("NotifyDataSetChanged")
    public void update(Cat_crud cat, int position) {
        lst.set(position, cat);
        notifyDataSetChanged();
    }

    public class Cat_crudHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView iv;
        private TextView tv1, tv2, tv3;
        private Button bt;

        public Cat_crudHolder(@NonNull View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.iv);
            tv1 = itemView.findViewById(R.id.tv1);
            tv2 = itemView.findViewById(R.id.tv2);
            tv3 = itemView.findViewById(R.id.tv3);
            bt = itemView.findViewById(R.id.bt);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (listener != null) {
                listener.onItemClick(v, getAdapterPosition());
            }
        }
    }

    public interface Cat_crubItemListener {
        public void onItemClick(View view, int position);
    }
}