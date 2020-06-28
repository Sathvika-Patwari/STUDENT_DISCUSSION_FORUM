package com.example.internship;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;



public class profileFragment extends Fragment  {



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        Button button=(Button)view.findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent in = new Intent(getActivity(),edit.class);

                startActivity(in);
            }
        });

        Button button1=(Button)view.findViewById(R.id.button2);
        button1.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View view) {
                Intent in2 = new Intent(getActivity(),post.class);

                startActivity(in2);
            }
        });
        return view;
    }
}


