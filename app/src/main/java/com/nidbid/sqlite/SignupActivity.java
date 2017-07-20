package com.nidbid.sqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignupActivity extends AppCompatActivity {

    private EditText ETNM, ETUNM, ETEML, ETPWD, ETCPWD;
    private Button BTCNF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        ETNM = (EditText) findViewById(R.id.ETNM);
        ETUNM = (EditText) findViewById(R.id.ETUNM);
        ETEML = (EditText) findViewById(R.id.ETEML);
        ETPWD = (EditText) findViewById(R.id.ETPWD);
        ETCPWD = (EditText) findViewById(R.id.ETCPWD);

        BTCNF = (Button) findViewById(R.id.BTCNF);

        BTCNF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent SignedUp = new Intent(SignupActivity.this, SignedupActivity.class);
                SignedUp.putExtra("result",SignupActivity.this.AddtoDB());
                SignupActivity.this.startActivity(SignedUp);
            }
        });
    }

    protected boolean AddtoDB() {
        MainActivity.MYDB.insertintoDB(ETNM.getText().toString(),
                                        ETEML.getText().toString(),
                                        ETUNM.getText().toString(),
                                        ETPWD.getText().toString());
        return true;
    }
}
