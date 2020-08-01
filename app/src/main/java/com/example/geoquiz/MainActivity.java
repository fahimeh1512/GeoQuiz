package com.example.geoquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView mTextView;
    private Button mButtonTrue;
    private Button mButtonFalse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();

        setListener();
    }

    public void setListener() {

        mButtonTrue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showToast(MainActivity.this, R.string.toast_correct, Color.GREEN, Gravity.BOTTOM, 0, 0);
            }
        });

        mButtonFalse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showToast(MainActivity.this, R.string.toast_incorrect, Color.RED, Gravity.TOP, 0, 130);
            }
        });
    }

    public void showToast(Context context, int string, int color, int gravity, int xOffset, int yOffset) {
        // Sets text for toast
        Toast toast = Toast.makeText(context, string, Toast.LENGTH_LONG);

        // Set color for toast text
        View view1 = toast.getView();
        TextView textView = view1.findViewById(android.R.id.message);
        textView.setTextColor(color);

        // Sets gravity for toast
        toast.setGravity(gravity, xOffset, yOffset);

        // Sets size for toast
        ViewGroup group = (ViewGroup) view1;
        TextView messageTextView = (TextView) group.getChildAt(0);
        messageTextView.setTextSize(23);

        // Shows toast
        toast.show();

        mTextView.setTextColor(color);
    }

    // Gets reference to views
    public void findViews() {
        mTextView = findViewById(R.id.question);
        mButtonTrue = findViewById(R.id.true_button);
        mButtonFalse = findViewById(R.id.false_button);
    }
}