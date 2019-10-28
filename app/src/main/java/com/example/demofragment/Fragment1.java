package com.example.demofragment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
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

public class Fragment1 extends Fragment implements View.OnClickListener{
    EditText editTextFragment1;
    TextView textViewFragment1;
    Button buttonFragment1;
    DemoPassData listener;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment1, container, false);
        Log.d("hieuvh", "inflate");
        editTextFragment1 = view.findViewById(R.id.editTextFragment1);
        textViewFragment1 = view.findViewById(R.id.textViewFragment1);
        buttonFragment1 = view.findViewById(R.id.buttonFragment1);
        Log.d("hieuvh", "create event");

        buttonFragment1.setOnClickListener(this);
        return view;
    }

    private void xuly() {
        textViewFragment1.setText(editTextFragment1.getText());
        Log.d("hieuvh", "da xu ly");
        listener.passData(editTextFragment1.getText().toString());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonFragment1:
                xuly();
                Intent intent = new Intent();
                intent.setAction("asddasd");
                break;
        }
    }


    public interface DemoPassData {
        void passData(String message);
    }

    public void setCallback(DemoPassData demoPassData){
        listener = demoPassData;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof MainActivity){
            this.listener = (MainActivity) context;
        }else {
            throw new RuntimeException(context.toString() + "must implement onViewSelected");
        }
    }


    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);


    }
}
