package com.example.learningandroid.model;

import android.graphics.Color;
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

public class FragmentB extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dynamic_fragment_b, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        EditText etAge = view.findViewById(R.id.etAge);
        Button bt = view.findViewById(R.id.bt);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String age = etAge.getText().toString();
                etAge.setText("Your age: " + age);
                etAge.setBackgroundColor(Color.GREEN);
            }
        });
        etAge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etAge.setBackgroundResource(R.drawable.edittext_shape);
                etAge.setText("");
            }
        });
    }
}
