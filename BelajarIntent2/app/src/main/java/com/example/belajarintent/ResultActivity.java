package com.example.belajarintent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class ResultActivity extends AppCompatActivity {
    TextView tvHasil2;
    double result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        tvHasil2 = findViewById(R.id.hasil);

        //mengambil value yg dipindahkan
        Intent intent = getIntent();
        double result = intent.getDoubleExtra("hasil_perhitungan",0);
        Toast.makeText(this, "Data yang dikirim :" + result, Toast.LENGTH_SHORT).show();
        tvHasil2.setText(String.valueOf(result));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return true;
    }

    //intente Implicit
    public void share(View view) {
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT,String.valueOf(result));
        sendIntent.setType("text/plain");
        startActivity(sendIntent);;
    }
}