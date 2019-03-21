package com.example.nhi.dating;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Login_Activity extends AppCompatActivity {
    private EditText et_email_login,et_password_login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_);

        et_email_login = findViewById(R.id.et_email_login);
        et_password_login = findViewById(R.id.et_password_login);

        et_email_login.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                EditText text = (EditText) getCurrentFocus();
                if ( text.length()==8 ||text.length()==28){
                    View next = text.focusSearch(View.FOCUS_DOWN);
                    if(next!=null) {
                        next.requestFocus();
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}
