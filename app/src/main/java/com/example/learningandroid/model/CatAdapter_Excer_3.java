package com.example.learningandroid.model;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.learningandroid.Class_Excer_3_Activity;
import com.example.learningandroid.MainActivity;
import com.example.learningandroid.R;

import java.util.ArrayList;
import java.util.List;

public class CatAdapter_Excer_3 extends RecyclerView.Adapter<CatAdapter_Excer_3.Cat_crudHolder> {
    private Class_Excer_3_Activity mainActivity;
    private Context context;
    private List<Cat_crud> lstBackUp;
    private List<Cat_crud> lst;
    private CatExcer3ItemListener listener;

    public CatAdapter_Excer_3(Context context, Class_Excer_3_Activity mainActivity) {
        this.mainActivity = mainActivity;
        this.context = context;
        this.lst = new ArrayList<>();
        this.lstBackUp = new ArrayList<>();
    }

    public List<Cat_crud> getLstBackUp() {
        return lstBackUp;
    }

    public void setListener(CatExcer3ItemListener listener) {
        this.listener = listener;
    }

    public void setLstBackUp(List<Cat_crud> lstBackUp) {
        this.lstBackUp = lstBackUp;
    }

    @NonNull
    @Override
    public Cat_crudHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_crud, parent, false);
        return new Cat_crudHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Cat_crudHolder holder, @SuppressLint("RecyclerView") int position) {
        Cat_crud cat_crud = lst.get(position);
        if (cat_crud == null)
            return;
        holder.iv.setImageResource(cat_crud.getImg());
        holder.tv1.setText(cat_crud.getName());
        holder.tv2.setText(cat_crud.getPrice() + "");
        holder.tv3.setText(cat_crud.getDescription());
        holder.bt.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Thông báo xóa");
                builder.setMessage("Bạn có chắc chắn muốn xóa " + cat_crud.getName() + "?");
                builder.setIcon(R.drawable.cancel_icon);
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        lstBackUp.remove(position);
                        lst.remove(position);
                        mainActivity.lst = lstBackUp;
                        notifyDataSetChanged();
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
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
    public void filterLst(List<Cat_crud> filterLst) {
        lst = filterLst;
        notifyDataSetChanged();
    }

    @SuppressLint("NotifyDataSetChanged")
    public void add(Cat_crud cat) {
        lstBackUp.add(cat);
        lst.add(cat);
        mainActivity.lst = lstBackUp;
        notifyDataSetChanged();
    }

    @SuppressLint("NotifyDataSetChanged")
    public void update(Cat_crud cat, int position) {
        lstBackUp.set(position, cat);
        lst.set(position, cat);
        mainActivity.lst = lstBackUp;
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

    public interface CatExcer3ItemListener {
        public void onItemClick(View view, int position);
    }
}
