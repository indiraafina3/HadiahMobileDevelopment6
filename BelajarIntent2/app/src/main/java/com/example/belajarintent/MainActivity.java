package com.example.belajarintent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // deklarasi variabel
    EditText etAngka1,etAngka2;
    TextView tvHasil;

    Button btnTambah, btnKurang;
    double hasil;
    int angka1Int, angka2Int;


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putDouble("hasil_hitung",hasil);
        //outState.putString("angka_satu",etAngka1.getText().toString());
        //outState.putString("angka_dua",etAngka2.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        double result = savedInstanceState.getDouble("hasil_hitung");
        tvHasil.setText(String.valueOf(result));
        hasil = result;
        //String angka1 = savedInstanceState.getString("angka_satu");
        //String angka2 = savedInstanceState.getString("angka_dua");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etAngka1 = findViewById(R.id.etAngka1);
        etAngka2 = findViewById(R.id.etAngka2);
        tvHasil = findViewById(R.id.hasil);
        btnTambah = findViewById(R.id.tambah);
        btnKurang = findViewById(R.id.kurang);
        btnTambah.setOnClickListener(new View.OnClickListener(){
            @Override

            public void onClick(View view) {
                //kode program tambah
                String angka1 = etAngka1.getText().toString();
                String angka2 = etAngka2.getText().toString();

                angka1Int = Integer.parseInt(angka1);
                angka2Int = Integer.parseInt(angka2);
                hasil = angka1Int + angka2Int;
                tvHasil.setText(String.valueOf(hasil));
                // tvHasil.setText(""+hasil);
                // tvHasil.setText(hasil);
            }
        });

    }

    public void kurang(View view) {
        String angka1 = etAngka1.getText().toString();
        String angka2 = etAngka2.getText().toString();

        angka1Int = Integer.parseInt(angka1);
        angka2Int = Integer.parseInt(angka2);
        hasil = angka1Int - angka2Int;
        tvHasil.setText(String.valueOf(hasil));
    }


    //Pindah page Intent Explicit
    public void pindah (View view) {
        Intent intent = new Intent(MainActivity.this, ResultActivity.class);
        intent.putExtra("hasil_perhitungan", hasil);
        startActivity(intent);
    }
}