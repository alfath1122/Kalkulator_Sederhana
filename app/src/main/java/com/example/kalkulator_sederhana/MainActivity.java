package com.example.kalkulator_sederhana;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText angkaPertamaEditText;
    private EditText angkaKeduaEditText;
    private TextView hasilPenjumlahanTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        angkaPertamaEditText = findViewById(R.id.edit_angka_pertama);
        angkaKeduaEditText = findViewById(R.id.edit_angka_kedua);
        hasilPenjumlahanTextView = findViewById(R.id.hasil_penjumlahan);

        Button btnTambah = findViewById(R.id.btn_tambah);
        Button btnKurang = findViewById(R.id.btn_kurang);
        Button btnKali = findViewById(R.id.btn_kali);
        Button btnBagi = findViewById(R.id.btn_bagi);
        ImageView btnProfile = findViewById(R.id.btnprofile); // Menambahkan ImageView untuk gambar profil

        btnProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Mengatur aksi ketika gambar profil diklik
                Intent intent = new Intent(MainActivity.this, About.class);
                startActivity(intent);
            }
        });

        btnTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hitung("+");
            }
        });

        btnKurang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hitung("-");
            }
        });

        btnKali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hitung("*");
            }
        });

        btnBagi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hitung("/");
            }
        });
    }

    private void hitung(String operator) {
        double angka1 = Double.parseDouble(angkaPertamaEditText.getText().toString());
        double angka2 = Double.parseDouble(angkaKeduaEditText.getText().toString());
        double hasil = 0;

        switch (operator) {
            case "+":
                hasil = angka1 + angka2;
                break;
            case "-":
                hasil = angka1 - angka2;
                break;
            case "*":
                hasil = angka1 * angka2;
                break;
            case "/":
                if (angka2 != 0) {
                    hasil = angka1 / angka2;
                } else {
                    hasilPenjumlahanTextView.setText("Tidak bisa dibagi oleh nol!");
                    return;
                }
                break;
        }

        String formattedResult;
        if (hasil == (int) hasil) {
            formattedResult = String.valueOf((int) hasil);
        } else {
            formattedResult = new DecimalFormat("0.#####").format(hasil);
        }

        hasilPenjumlahanTextView.setText("Hasil penjumlahan : " + formattedResult);
    }
}