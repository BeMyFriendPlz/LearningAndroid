package com.example.learningandroid.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.learningandroid.R;

import java.util.List;

public class CatAdapter extends RecyclerView.Adapter<CatAdapter.CatViewHolder> {
//    private Context context;
    private List<Cat> lst;
    private CatItemListener catItemListener;

    public CatAdapter(List<Cat> lst) {
//        this.context = context;
        this.lst = lst;
    }

    public void setCatItemListener(CatItemListener catItemListener) {
        this.catItemListener = catItemListener;
    }

    @NonNull
    @Override
    public CatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_cat, parent, false);
        return new CatViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CatViewHolder holder, int position) {
        Cat cat = lst.get(position);
        if (cat == null)
            return;
        holder.iv.setImageResource(cat.getImg());
        holder.tv.setText(cat.getName());
//        holder.cv.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(context.getApplicationContext(), cat.getName(), Toast.LENGTH_SHORT).show();
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return lst == null ? 0 : lst.size();
    }

    public class CatViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private ImageView iv;
        private TextView tv;
//        private CardView cv;

        public CatViewHolder(@NonNull View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.iv);
            tv = itemView.findViewById(R.id.tv);
//            cv = itemView.findViewById(R.id.cv);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (catItemListener != null) {
                catItemListener.onItemClick(v, getAdapterPosition());
            }
        }
    }

    public interface CatItemListener {
        public void onItemClick(View view, int position);
    }
}
