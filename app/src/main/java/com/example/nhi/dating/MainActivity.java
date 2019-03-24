package com.example.nhi.dating;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private CardView bt_login, bt_register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt_login = findViewById(R.id.cv_login_main);
        bt_register = findViewById(R.id.cv_register_main);

        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLogin_Activity();
            }
        });

        bt_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRegister_Activity();
            }
        });

    }

    public void openLogin_Activity(){
        Intent login_intent = new Intent(MainActivity.this,Login_Activity.class);
        startActivity(login_intent);
    }

    public void openRegister_Activity(){
        Intent register_intent = new Intent(MainActivity.this,Register_Activity.class);
        startActivity(register_intent);
    }
}
