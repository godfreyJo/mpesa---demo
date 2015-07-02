package com.mobidev.mpesa;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by lawrence on 7/1/15.
 */
public class MpesaActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnSendMoney;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mpesa);


        btnSendMoney = (Button) findViewById(R.id.send_money);
        btnSendMoney.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.send_money:
                startActivity(new Intent(getApplicationContext(), SendMoneyActivity.class));
                break;
            default:
                break;
        }
    }



}
