package com.mobidev.mpesa;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class PhoneNoActivity extends AppCompatActivity {

    private EditText edPhoneNo;
    private Button btnOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_no);

        edPhoneNo = (EditText) findViewById(R.id.phone_no);
        btnOk = (Button) findViewById(R.id.ok);
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone_no = edPhoneNo.getText().toString();
                if (TextUtils.isEmpty(phone_no)) {
                    Toast.makeText(getApplicationContext(), "Please provide phone number", Toast.LENGTH_SHORT).show();
                    return;
                }
                

                Intent intent = new Intent(getApplicationContext(), AmountActivity.class);
                intent.putExtra(AmountActivity.ARG_PHONE_NO, phone_no);
                startActivity(intent);
            }
        });
    }

}
