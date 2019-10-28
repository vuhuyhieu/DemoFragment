package com.example.demofragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;

public class MainActivity extends AppCompatActivity implements Fragment1.DemoPassData {
    private FragmentManager mManager;
    private FragmentTransaction mTransaction;
    private Fragment1 fragment1;
    private Fragment2 fragment2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {

        mManager = getSupportFragmentManager();
        mTransaction = mManager.beginTransaction();
        fragment1 = new Fragment1();
        fragment2 = new Fragment2();
        mTransaction.add(R.id.fragment1, fragment1);
        mTransaction.add(R.id.fragment2, fragment2);
        mTransaction.commit();

        fragment1.setCallback(this);
    }

    @Override
    public void passData(String message) {
        Log.d("hieuvh", "MainActivity passData");
        fragment2 = (Fragment2) getSupportFragmentManager().findFragmentById(R.id.fragment2);
        if (fragment2 != null || fragment2.isInLayout()) {
            fragment2.showInfo(message);
        }
    }
}
