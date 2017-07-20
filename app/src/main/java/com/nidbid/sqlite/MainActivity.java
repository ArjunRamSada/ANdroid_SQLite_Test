package com.nidbid.sqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button BTLGN, BTSUP;
    public static DBHelper MYDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MYDB = new DBHelper(this);

        BTLGN = (Button) findViewById(R.id.BTLGN);
        BTSUP = (Button) findViewById(R.id.BTSUP);

        BTLGN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Login = new Intent(MainActivity.this, LoginActivity.class);
                MainActivity.this.startActivity(Login);
            }
        });

        BTSUP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Signup = new Intent(MainActivity.this, SignupActivity.class);
                MainActivity.this.startActivity(Signup);
            }
        });
    }
}
