package com.nidbid.sqlite;

import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class LoggedinActivity extends AppCompatActivity {

    private TextView TVLIN, TVDAT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loggedin);

        TVLIN = (TextView) findViewById(R.id.TVLIN);
        TVDAT = (TextView) findViewById(R.id.TVDAT);

        Bundle bnd = getIntent().getExtras();
        boolean result = bnd.getBoolean("result");
        if (result) {
            TVLIN.setText("Log In Successful!");
            Cursor res = MainActivity.MYDB.getAllData();
            if (res.getCount()==0 ) {
                showMessage("ERROR", "No data available to print!");
                return;
            }
            StringBuffer sbuff = new StringBuffer();
            res.moveToFirst();
            while (res.moveToNext()) {
                sbuff.append("Serial   : "+res.getString(0)+"\n");
                sbuff.append("Name     : "+res.getString(1)+"\n");
                sbuff.append("Email ID : "+res.getString(2)+"\n");
                sbuff.append("UserName : "+res.getString(3)+"\n");
                sbuff.append("Password : "+res.getString(4)+"\n\n");
            }
            TVDAT.setText(bnd.getString("data"));
            showMessage("DATA", sbuff.toString());
        }
        else {
            TVLIN.setText("Log In Failure!");
        }
    }

    public void showMessage(String title, String Message) {
        AlertDialog.Builder bldr = new AlertDialog.Builder(this);
        bldr.setCancelable(true);
        bldr.setTitle(title);
        bldr.setMessage(Message);
        bldr.show();
    }
}
