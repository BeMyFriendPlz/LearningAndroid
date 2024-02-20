package com.example.learningandroid.model;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.learningandroid.R;

import java.util.ArrayList;
import java.util.List;

public class NhanVienAdapter extends RecyclerView.Adapter<NhanVienAdapter.NhanVienHolder> {
    private Context context;
    private List<NhanVien> lst;
    private NhanVienListener listener;

    public NhanVienAdapter(Context context) {
        this.context = context;
        this.lst = new ArrayList<>();
    }

    public void setListener(NhanVienListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public NhanVienHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_class_excer_1, parent, false);
        return new NhanVienHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull NhanVienHolder holder, int position) {
        NhanVien nv = lst.get(position);
        if (nv == null)
            return;
        holder.iv.setImageResource(nv.isGioiTinh() ? R.drawable.boy_icon : R.drawable.girl_icon);
        holder.tv.setText(nv.getMa() + "-" + nv.getTen());
        holder.cb.setChecked(nv.isCheck());
    }

    @Override
    public int getItemCount() {
        return lst == null ? 0 : lst.size();
    }

    public boolean isNVCheck() {
        if (lst != null) {
            for (NhanVien i : lst) {
                if (i.isCheck()) {
                    return true;
                }
            }
        }
        return false;
    }

    @SuppressLint("NotifyDataSetChanged")
    public void add(NhanVien nv) {
        lst.add(nv);
        notifyDataSetChanged();
    }

    @SuppressLint("NotifyDataSetChanged")
    public void erase() {
        if (lst.size() != 0) {
            for (int i = lst.size()-1; i >= 0; i--) {
                if (lst.get(i).isCheck()) {
                    lst.remove(i);
                }
            }
            notifyDataSetChanged();
        }
    }

    public class NhanVienHolder extends RecyclerView.ViewHolder implements CompoundButton.OnCheckedChangeListener {
        private ImageView iv;
        private TextView tv;
        private CheckBox cb;

        public NhanVienHolder(@NonNull View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.iv);
            tv = itemView.findViewById(R.id.tv);
            cb = itemView.findViewById(R.id.cb);
            cb.setOnCheckedChangeListener(this);
        }

        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            lst.get(getAdapterPosition()).setCheck(isChecked);
            if (listener != null) {
                listener.OnCheckListener(buttonView.getRootView(), getAdapterPosition());
            }
        }
    }

    public interface NhanVienListener {
        public void OnCheckListener(View view, int position);
    }
}

