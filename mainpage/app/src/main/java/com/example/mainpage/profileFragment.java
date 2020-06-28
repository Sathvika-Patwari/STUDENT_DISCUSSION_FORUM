package com.example.mainpage;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toolbar;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class profileFragment extends Fragment {
    public profileFragment(){


    }

    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container , Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_profile,container,false);
        Button button=(Button)view.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View view) {
                Intent in = new Intent(getActivity(),edit_profile.class);

                startActivity(in);
            }
        });
        return view;
    }
}
