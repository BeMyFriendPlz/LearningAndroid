package com.example.learningandroid.model;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.learningandroid.Class_Excer_3_Activity;
import com.example.learningandroid.MainActivity;
import com.example.learningandroid.R;

public class Fragment_Home extends Fragment implements CatAdapter_Excer_3.CatExcer3ItemListener {
    private RecyclerView rv;
    private Spinner sp;
    private EditText name, price, describe;
    private Button add, update;
    private CatAdapter_Excer_3 adapter;
    private int curPosition;
    private int[] imgs = {R.drawable.img_1, R.drawable.img_2, R.drawable.img_3,
            R.drawable.img_4, R.drawable.img_5, R.drawable.img_6};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        sp = view.findViewById(R.id.sp);
        name = view.findViewById(R.id.et1);
        price = view.findViewById(R.id.et2);
        describe = view.findViewById(R.id.et3);
        add = view.findViewById(R.id.bt1);
        update = view.findViewById(R.id.bt2);
        update.setVisibility(View.INVISIBLE);
        rv = view.findViewById(R.id.rv);

        // init Spinner
        SpinnerAdapter spinnerAdapter = new SpinnerAdapter(view.getContext());
        sp.setAdapter(spinnerAdapter);

        // init Recycle View
        adapter = new CatAdapter_Excer_3(view.getContext(),(Class_Excer_3_Activity) getActivity());
        adapter.setListener(this);
        LinearLayoutManager manager = new LinearLayoutManager(view.getContext(), LinearLayoutManager.VERTICAL, false);
        rv.setLayoutManager(manager);
        rv.setAdapter(adapter);

        // init Add
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cat_crud cat = new Cat_crud();
                try {
                    cat.setImg(Integer.parseInt(sp.getSelectedItem().toString()));
                    cat.setName(name.getText().toString());
                    cat.setPrice(Double.parseDouble(price.getText().toString()));
                    cat.setDescription(describe.getText().toString());
                    adapter.add(cat);
                } catch (NumberFormatException e) {
                    Toast.makeText(view.getContext(), e.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cat_crud cat = new Cat_crud();
                try {
                    cat.setImg(Integer.parseInt(sp.getSelectedItem().toString()));
                    cat.setName(name.getText().toString());
                    cat.setPrice(Double.parseDouble(price.getText().toString()));
                    cat.setDescription(describe.getText().toString());
                    adapter.update(cat, curPosition);
                    add.setVisibility(View.VISIBLE);
                    update.setVisibility(View.INVISIBLE);
                } catch (NumberFormatException e) {
                    Toast.makeText(view.getContext(), e.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onItemClick(View view, int position) {
        update.setVisibility(View.VISIBLE);
        add.setVisibility(View.INVISIBLE);
        curPosition = position;
        Cat_crud cat = adapter.getItem(position);
        for (int i = 0; i < imgs.length; i++) {
            if (cat.getImg() == imgs[i]) {
                sp.setSelection(i);
                break;
            }
        }
        name.setText(cat.getName());
        price.setText(cat.getPrice() + "");
        describe.setText(cat.getDescription());
    }
}
