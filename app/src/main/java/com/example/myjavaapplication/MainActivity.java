package com.example.myjavaapplication;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.PhoneNumberUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    EditText login;
    EditText email;
    EditText phone;
    EditText password;
    EditText password_conf;
    Button btnValidate;
    TextView result;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login = (EditText) findViewById(R.id.login);
        email = (EditText) findViewById(R.id.email);
        phone = (EditText) findViewById(R.id.phone);
        password = (EditText) findViewById(R.id.password);
        password_conf = (EditText) findViewById(R.id.password_conf);
        btnValidate = (Button) findViewById(R.id.btnValidate);
        result = (TextView) findViewById(R.id.result);


        btnValidate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if (login.length()<1) {
                    result.setText(R.string.enter_login);
                    result.setTextColor(Color.RED);

                } else if (email.length()<1) {
                    result.setText(R.string.enter_email);
                    result.setTextColor(Color.RED);

                } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email.getText().toString()).matches()) {
                    result.setText(R.string.incorrect_email);
                    result.setTextColor(Color.RED);

                } else if (phone.length()<1) {
                    result.setText(R.string.enter_phone);
                    result.setTextColor(Color.RED);

                } else if (!isValidPhone(phone.getText().toString())) {
                    result.setText(R.string.incorrect_phone);
                    result.setTextColor(Color.RED);

                } else if (password.length()<1) {
                    result.setText(R.string.enter_password);
                    result.setTextColor(Color.RED);

                } else if (password_conf.length()<1) {
                    result.setText(R.string.enter_password_conf);
                    result.setTextColor(Color.RED);

                } else if (! new String(password.getText().toString()).equals( new String(password_conf.getText().toString()) ) ) {
                    result.setText(R.string.passwords_incorrect);
                    result.setTextColor(Color.RED);

                } else {
                    result.setText(R.string.validation_ok);
                    result.setTextColor(Color.GREEN);
                }
            }

            private boolean isValidPhone(String phone)
            {
                String expression = "^([0-9\\+]|\\(\\d{1,3}\\))[0-9\\-\\. ]{3,13}$";
                CharSequence inputString = phone;
                Pattern pattern = Pattern.compile(expression);
                Matcher matcher = pattern.matcher(inputString);
                if (matcher.matches())
                {
                    return true;
                }
                else{
                    return false;
                }
            }
        });
    }
}