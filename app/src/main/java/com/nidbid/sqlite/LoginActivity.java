package com.nidbid.sqlite;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    private EditText ETNM, ETPWD;
    private Button BTOK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ETNM = (EditText) findViewById(R.id.ETNM);
        ETPWD = (EditText) findViewById(R.id.ETPWD);

        BTOK = (Button) findViewById(R.id.BTOK);

        BTOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Loggedin = new Intent(LoginActivity.this, LoggedinActivity.class);
                Cursor res = MainActivity.MYDB.checkPasswordRet(ETNM.getText().toString(),
                        ETPWD.getText().toString());
                boolean result = (res.getCount()==0)?false:true;
                Loggedin.putExtra("result", result);
                if (result) {
                    StringBuffer sbuf = new StringBuffer();
                    res.moveToFirst();
                    sbuf.append("Serial   : "+res.getString(0)+"\n");
                    sbuf.append("Name     : "+res.getString(1)+"\n");
                    sbuf.append("Email ID : "+res.getString(2)+"\n");
                    sbuf.append("UserName : "+res.getString(3)+"\n");
                    sbuf.append("Password : "+res.getString(4)+"\n\n");
                    Loggedin.putExtra("data", sbuf.toString());
                }
                startActivity(Loggedin);
            }
        });
    }
}
