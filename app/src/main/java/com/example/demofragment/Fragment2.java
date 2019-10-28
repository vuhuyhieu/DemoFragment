package com.example.demofragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Fragment2 extends Fragment {
    EditText editTextFragment2;
    TextView textViewFragment2;
    Button buttonFragment2;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment2, container, false);
        editTextFragment2 = view.findViewById(R.id.editTextFragment2);
        textViewFragment2 = view.findViewById(R.id.textViewFragment2);
        buttonFragment2 = view.findViewById(R.id.buttonFragment2);
        buttonFragment2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuly();
            }
        });
        return view;
    }
    public void xuly() {
        textViewFragment2.setText(editTextFragment2.getText());
    }

    public void showInfo(String message){
        textViewFragment2.setText(message);
        editTextFragment2.setText(message);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }
}
