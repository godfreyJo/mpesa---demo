package com.mobidev.mpesa;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by lawrence on 7/1/15.
 */
public class SendMoneyActivity extends AppCompatActivity {
    private Button btnSearchSimContacts, btnEnterPhoneNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_money);

        btnSearchSimContacts = (Button) findViewById(R.id.search);
        btnSearchSimContacts.setOnClickListener(btnClickListener);
        btnEnterPhoneNo = (Button) findViewById(R.id.enter_phone_no);
        btnEnterPhoneNo.setOnClickListener(btnClickListener);

    }

    View.OnClickListener btnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.search:
                    Toast.makeText(getApplicationContext(), "This feature is not available yet", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.enter_phone_no:
                    startActivity(new Intent(getApplicationContext(), PhoneNoActivity.class));
                    break;
                default:
                    break;
            }
        }
    };

}
