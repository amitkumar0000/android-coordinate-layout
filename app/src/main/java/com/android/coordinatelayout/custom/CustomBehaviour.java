package com.android.coordinatelayout.custom;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CustomBehaviour extends CoordinatorLayout.Behavior<TextView> {
    private final static String TAG = "CustomBehaviour";

    public CustomBehaviour(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, TextView child, View dependency) {
        return dependency instanceof FloatingActionButton;
    }

    boolean flag = false;
    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, TextView child, View dependency) {
        int[] dependencyLocation = new int[2];
        int[] childLocation = new int[2];

        dependency.getLocationInWindow(dependencyLocation);
        child.getLocationInWindow(childLocation);

        float diff = childLocation[1] - dependencyLocation[1];
        if(diff > 0 && flag) {
            float scale = diff/(float)childLocation[1];
            Log.d(TAG, "scale == " + scale);
            child.setScaleX(1+scale+10);
            child.setScaleY(1+scale+10);
        }
        flag = true;
        return false;
    }
}
