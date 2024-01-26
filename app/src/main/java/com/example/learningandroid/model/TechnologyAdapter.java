package com.example.learningandroid.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.learningandroid.R;

public class TechnologyAdapter extends ArrayAdapter<Technology> {
    private Context context;
    private Technology[] lst;

    public TechnologyAdapter(@NonNull Context context, Technology[] lst) {
        super(context, R.layout.item_tech, lst);
        this.context = context;
        this.lst = lst;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_tech, null, true);
        ImageView img = view.findViewById(R.id.iv);
        TextView name = view.findViewById(R.id.tv1);
        TextView sub = view.findViewById(R.id.tv2);
        TextView des = view.findViewById(R.id.tv3);
        Technology t = lst[position];
        img.setImageResource(t.getImg());
        name.setText(t.getName());
        sub.setText(t.getSub());
        des.setText(t.getDescribe());
        return view;
    }

    public Technology getItem(int position) {
        return lst[position];
    }
}
