package com.example.learningandroid.model;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.learningandroid.Class_Excer_3_Activity;
import com.example.learningandroid.MainActivity;
import com.example.learningandroid.R;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Fragment_Search extends Fragment {
    private SearchView sv;
    private RecyclerView rv;
    private Cat_crudAdapter adapter;
    private List<Cat_crud> list;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        sv = view.findViewById(R.id.search);
        rv = view.findViewById(R.id.rv);
        adapter = new Cat_crudAdapter(view.getContext());
        LinearLayoutManager manager = new LinearLayoutManager(view.getContext(), LinearLayoutManager.VERTICAL, false);
        rv.setLayoutManager(manager);
        rv.setAdapter(adapter);

        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                List<Cat_crud> filter = new ArrayList<>();
                for (Cat_crud i : list) {
                    if (i.getName().toLowerCase().contains(newText.toLowerCase())) {
                        filter.add(i);
                    }
                }
                if (filter.isEmpty()) {
                    adapter.filterLst(filter);
                    Toast.makeText(view.getContext(), "No data found!!!", Toast.LENGTH_SHORT).show();
                } else {
                    adapter.filterLst(filter);
                }
                return false;
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        list = ((Class_Excer_3_Activity) getActivity()).lst;
    }
}
