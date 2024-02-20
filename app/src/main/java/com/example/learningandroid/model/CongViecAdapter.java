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

public class CongViecAdapter extends RecyclerView.Adapter<CongViecAdapter.CongViecHolder>{
    private Context context;
    private List<CongViec> backUpLst;
    private List<CongViec> lst;
    private CongViecListener listener;

    public CongViecAdapter(Context context) {
        this.context = context;
        backUpLst = new ArrayList<>();
        lst = new ArrayList<>();
    }

    public void setListener(CongViecListener listener) {
        this.listener = listener;
    }

    public List<CongViec> getBackUpLst() {
        return backUpLst;
    }

    public void setFilterLst(List<CongViec> filterLst) {
        lst = filterLst;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CongViecHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_test_2, parent, false);
        return new CongViecHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CongViecHolder holder, int position) {
        CongViec cv = lst.get(position);
        if (cv == null)
            return;
        holder.iv.setImageResource(cv.isGender() ? R.drawable.boy_icon : R.drawable.girl_icon);
        holder.tv.setText(cv.getName() + " - " + cv.getContent() + " - " + cv.getDate());
        holder.bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backUpLst.remove(holder.getAdapterPosition());
                lst.remove(holder.getAdapterPosition());
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return lst == null ? 0 : lst.size();
    }

    public CongViec getItem(int position) {
        return lst.get(position);
    }

    public void add(CongViec cv) {
        backUpLst.add(cv);
        lst.add(cv);
        notifyDataSetChanged();
    }

    public void update(CongViec cv, int position) {
        backUpLst.set(position, cv);
        lst.set(position, cv);
        notifyDataSetChanged();
    }

    public class CongViecHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView iv;
        private TextView tv;
        private Button bt;
        public CongViecHolder(@NonNull View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.iv);
            tv = itemView.findViewById(R.id.tv);
            bt = itemView.findViewById(R.id.bt);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (listener != null) {
                listener.OnClickListener(v, getAdapterPosition());
            }
        }
    }

    public interface CongViecListener {
        public void OnClickListener(View view, int position);
    }
}
