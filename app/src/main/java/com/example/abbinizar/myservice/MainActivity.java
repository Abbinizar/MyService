package com.example.abbinizar.myservice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnStartService, btnStartIntentService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnStartService = (Button)findViewById(R.id.btn_startService);
        btnStartIntentService = (Button)findViewById(R.id.btn_intentStartService);
        btnStartIntentService.setOnClickListener((View.OnClickListener) this);
        btnStartService.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_startService:
                Intent mStartService = new Intent(MainActivity.this, OriginService.class);
                startService(mStartService);
                break;
            case R.id.btn_intentStartService:
                Intent mStartIntentService = new Intent(MainActivity.this, DicodingIntentService.class);
                mStartIntentService.putExtra(DicodingIntentService.EXTRA_DURATION, 5000);
                startService(mStartIntentService);
                break;
        }
    }
}
