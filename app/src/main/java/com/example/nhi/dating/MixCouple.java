package com.example.nhi.dating;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.nhi.dating.ui.mixcouple.MixCoupleFragment;

public class MixCouple extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mix_couple_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, MixCoupleFragment.newInstance())
                    .commitNow();
        }
    }
}
