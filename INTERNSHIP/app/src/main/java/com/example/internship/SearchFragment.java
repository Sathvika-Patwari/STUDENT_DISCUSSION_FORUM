package com.example.internship;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import androidx.fragment.app.Fragment;



public class SearchFragment extends Fragment {
    AutoCompleteTextView a;
    ArrayAdapter adapter;


    String[] countries={
            "India",
            "Korea",
            "Japan",
            "USA",
            "England",
            "Belgium",
            "South Africa",
            "SriLanka",
            "Afghanistan",
            "American Samoa"

    };
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container ,@Nullable Bundle savedInstanceState) {
        View rootView= inflater.inflate(R.layout.fragment_search,container,false);


        a = (AutoCompleteTextView)rootView.findViewById(R.id.autoCompleteTextView);
        adapter = new ArrayAdapter<>(getActivity(), R.layout.support_simple_spinner_dropdown_item,countries);
        a.setThreshold(1);
        a.setAdapter(adapter);
        return rootView;
    }

}





