package com.wdharmana.coinmonitor.ui.base;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.wdharmana.coinmonitor.R;
import com.wdharmana.coinmonitor.ui.rate.RateFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.e("TAG", "OKE MASUK 1");

        getSupportFragmentManager().beginTransaction().replace(R.id.frame, RateFragment.newInstance(), "")
                .addToBackStack(null)
                .commit();

    }
}
