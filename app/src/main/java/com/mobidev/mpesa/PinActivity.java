package com.mobidev.mpesa;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by lawrence on 7/1/15.
 */
public class PinActivity extends AppCompatActivity {


    public static final String ARG_PHONE_NO = "my_phone_no";
    public static final String ARG_AMOUNT = "amount";

    private Bundle extras;
    private static String phoneNo, amount;

    private EditText edPin;
    private Button btnOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pin);

        extras = getIntent().getExtras();
        if (extras != null) {
            phoneNo = extras.getString(ARG_PHONE_NO);
            amount = extras.getString(ARG_AMOUNT);
        }

        edPin = (EditText) findViewById(R.id.pin);
        btnOk = (Button) findViewById(R.id.ok);
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String amount = edPin.getText().toString();
                if (TextUtils.isEmpty(amount)) {
                    Toast.makeText(getApplicationContext(), "Please provide your pin", Toast.LENGTH_SHORT).show();
                    return;
                }

                new ConfirmDialogFragment().show(getSupportFragmentManager(), "");

            }
        });

    }


    public static class ConfirmDialogFragment extends DialogFragment {
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the Builder class for convenient dialog construction
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setMessage("Send ksh" + amount + " to " + phoneNo)
                    .setPositiveButton("OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog,
                                                    int id) {
                                    Intent login = new Intent(getActivity(),
                                            MainActivity.class);
                                    startActivity(login);
                                    getActivity().finish();
                                }
                            })
                    .setNegativeButton("Cancel",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog,
                                                    int id) {
                                    // User cancelled the dialog
                                }
                            });
            // Create the AlertDialog object and return it
            return builder.create();
        }
    }
}
