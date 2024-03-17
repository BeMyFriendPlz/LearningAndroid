package com.example.learningandroid.model;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.learningandroid.R;

public class FragmentA extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dynamic_fragment_a, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        EditText etName = view.findViewById(R.id.etName);
        Button bt = view.findViewById(R.id.bt);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString();
                etName.setText("Hello " + name + "!");
                etName.setBackgroundColor(Color.RED);
            }
        });
        etName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etName.setBackgroundResource(R.drawable.edittext_shape);
                etName.setText("");
            }
        });
    }
}
