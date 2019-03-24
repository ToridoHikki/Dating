package com.example.nhi.dating;

import android.app.ProgressDialog;
import android.content.Intent;
import android.nfc.Tag;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login_Activity extends AppCompatActivity implements View.OnClickListener{
    private EditText et_email_login,et_password_login;
    private FirebaseAuth mAuth;
    private ProgressDialog loading;
    private static final String TAG = "EmailPassword";
    private FirebaseUser currentUser;
    private CardView cv_login_login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_);

        mAuth = FirebaseAuth.getInstance();
        et_email_login = findViewById(R.id.et_email_login);
        et_password_login = findViewById(R.id.et_password_login);
        cv_login_login = findViewById(R.id.cv_login_login);
        currentUser= mAuth.getCurrentUser();
        loading = new ProgressDialog(this);

        findViewById(R.id.cv_login_login).setOnClickListener(this);

        final String email=et_email_login.getText().toString().trim();
        final String pass=et_password_login.getText().toString().trim();

        et_email_login.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                EditText text = (EditText) getCurrentFocus();
                if (text.length()==28){
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

    @Override
    public void onClick(View v) {
        int i=v.getId();
        if(i==R.id.cv_login_login){
            SignIn(et_email_login.getText().toString().trim(),et_password_login.getText().toString().trim());
        }
    }
    private void changeUI(FirebaseUser user){
        if(user!=null){
            Intent intent = new Intent(Login_Activity.this,MixCouple.class);
            startActivity(intent);
        }
        else{
            et_password_login.setText("");
        }
    }
    private void SignIn(String email, String pass){

        Log.d(TAG,"SignIn: "+ email);
        if(pass.equals("")){
            Toast.makeText(Login_Activity.this,"Please enter password",Toast.LENGTH_LONG).show();
        }
        else{
            loading.setTitle("Loading....");
            loading.show();
            mAuth.signInWithEmailAndPassword(email,pass)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Log.d(TAG,"signInEmail:success");
                                FirebaseUser user = mAuth.getCurrentUser();
                                changeUI(user);
                            }
                            else{
                                Log.w(TAG,"signInEmail:fail",task.getException());
                                Toast.makeText(Login_Activity.this,"Authentication failed.",Toast.LENGTH_LONG).show();
                                changeUI(null);
                            }
                            loading.dismiss();
                        }
                    });
        }
    }

}
