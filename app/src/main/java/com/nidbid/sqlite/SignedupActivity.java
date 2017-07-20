package com.nidbid.sqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SignedupActivity extends AppCompatActivity {

    private RelativeLayout RLay;
    private TextView TVOUT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signedup);

        RLay = (RelativeLayout) findViewById(R.id.RLay);
        TVOUT = (TextView) findViewById(R.id.TVOUT);

        Bundle bnd = getIntent().getExtras();
        boolean result = bnd.getBoolean("result");
        if (result) {
            TVOUT.setText("Database Successfully Updated!");
        }
        else {
            TVOUT.setText("Database Error!");
        }

        RLay.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent me) {
                Intent MainIntent = new Intent(SignedupActivity.this, MainActivity.class);
                startActivity(MainIntent);
                return true;
            }
        });
    }
}
