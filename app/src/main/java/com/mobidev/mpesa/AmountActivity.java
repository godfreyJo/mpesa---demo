package com.mobidev.mpesa;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by lawrence on 7/1/15.
 */
public class AmountActivity extends AppCompatActivity {

    public static final String ARG_PHONE_NO = "my_phone_no";

    private Bundle extras;
    private String phoneNo;

    private EditText edAmount;
    private Button btnOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amount);

        extras = getIntent().getExtras();
        if (extras != null) {
            phoneNo = extras.getString(ARG_PHONE_NO);
        }

        edAmount = (EditText) findViewById(R.id.amount);
        btnOk = (Button) findViewById(R.id.ok);
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String amount = edAmount.getText().toString();
                if (TextUtils.isEmpty(amount)) {
                    Toast.makeText(getApplicationContext(), "Please provide phone number", Toast.LENGTH_SHORT).show();
                    return;
                }

                Intent intent = new Intent(getApplicationContext(), PinActivity.class);
                intent.putExtra(PinActivity.ARG_PHONE_NO, phoneNo);
                intent.putExtra(PinActivity.ARG_AMOUNT, amount);
                startActivity(intent);

            }
        });


    }
}
