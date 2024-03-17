package com.example.learningandroid.model;

import androidx.fragment.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.learningandroid.R;

public class FragmentC extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dynamic_fragment_c, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        EditText etAdd = view.findViewById(R.id.etAdd);
        Button bt = view.findViewById(R.id.bt);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String add = etAdd.getText().toString();
                etAdd.setText("Your address: " + add);
                etAdd.setBackgroundColor(Color.YELLOW);
            }
        });
        etAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etAdd.setBackgroundResource(R.drawable.edittext_shape);
                etAdd.setText("");
            }
        });
    }
}
