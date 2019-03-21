package com.example.nhi.dating;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Register_Activity extends AppCompatActivity {
    private EditText et_email_register, et_password_register, et_password2_register;
    private CardView cv_register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_);

        et_email_register=findViewById(R.id.et_email_register);
        et_password_register=findViewById(R.id.et_password_register);
        et_password2_register=findViewById(R.id.et_password2_register);
        cv_register=findViewById(R.id.cv_register);

        et_email_register.addTextChangedListener(new TextWatcher() {
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
        cv_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pass, pass2;
                pass=et_password_register.getText().toString().trim();
                pass2=et_password2_register.getText().toString().trim();
                if(pass.equals(pass2)){
                    Toast.makeText(Register_Activity.this,"Sign Up Success",Toast.LENGTH_LONG).show();
                    Intent login_intent = new Intent(Register_Activity.this,EditProfile_Activity.class);
                    startActivity(login_intent);
                }
                else{
                    Toast.makeText(Register_Activity.this,"Sign Up Fail, Please retype password",Toast.LENGTH_LONG).show();
                    et_password_register.setText("");
                    et_password2_register.setText("");
                }


            }
        });

    }
}
