package com.condingblocks.fragments;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView tvCounter;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    Button btnRed;
    Button btnBlue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        tvCounter = (TextView) findViewById(R.id.tvCounter);
        btnBlue = (Button) findViewById(R.id.blueBtn);
        btnRed = (Button) findViewById(R.id.redBtn);

        btnRed.setOnClickListener(this);
        btnBlue.setOnClickListener(this);

        fragmentManager = getSupportFragmentManager();


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.blueBtn:
                FramentBlue framentBlue = new FramentBlue();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentFrame , framentBlue);
                fragmentTransaction.commit();

                break;
            case R.id.redBtn:
                FragmentRed fragmentRed = new FragmentRed();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentFrame , fragmentRed);
                fragmentTransaction.commit();


                break;
        }
    }



    public void shiftCounter(int shift){
//        Toast.makeText(this, "Clicked", Toast.LENGTH_SHORT).show();
        tvCounter.setText(
                String.valueOf(Integer.parseInt(tvCounter.getText().toString()) + shift)
        );

    }


}
