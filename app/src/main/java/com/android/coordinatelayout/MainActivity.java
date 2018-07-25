package com.android.coordinatelayout;

import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.coordinatorLayout)
    CoordinatorLayout coordinatorLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    public void onClick(View view){
        switch (view.getId()){
            case R.id.showSnackbarButton:{
                Snackbar.make(coordinatorLayout,
                        "This is a simple Snackbar", Snackbar.LENGTH_LONG).show();
                break;
            }
        }
    }
}
