package com.example.learningandroid.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.learningandroid.R;

import java.util.List;

public class StadiumAdapter extends RecyclerView.Adapter<StadiumAdapter.StadiumHolder> {
    private Context context;
    private List<Stadium> lst;
    private StadiumListener listener;

    public StadiumAdapter(Context context, List<Stadium> lst) {
        this.context = context;
        this.lst = lst;
    }

    public void setListener(StadiumListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public StadiumHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_class_excer_2, parent, false);
        return new StadiumHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StadiumHolder holder, int position) {
        Stadium stadium = lst.get(position);
        if (stadium == null)
            return;
        holder.img.setImageResource(stadium.getImg());
        holder.name.setText(stadium.getName());
        holder.address.setText(stadium.getAddress());
    }

    @Override
    public int getItemCount() {
        return lst == null ? 0 : lst.size();
    }

    public class StadiumHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView img;
        private TextView name;
        private TextView address;

        public StadiumHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.iv1);
            name = itemView.findViewById(R.id.tv1);
            address = itemView.findViewById(R.id.tv2);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (listener != null) {
                listener.OnClickListener(v, getAdapterPosition());
            }
        }
    }

    public interface StadiumListener {
        public void OnClickListener(View view, int position);
    }
}
