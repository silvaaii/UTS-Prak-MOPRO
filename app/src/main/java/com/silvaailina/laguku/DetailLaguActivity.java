package com.silvaailina.laguku;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailLaguActivity extends AppCompatActivity {
    ImageView imgView;
    TextView tvJudul;
    TextView tvPenyanyi;
    TextView tvGenre;
    TextView desc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_lagu);
        setData();
    }     public void setData(){
        imgView = findViewById(R.id.img_lagu);
        tvJudul = findViewById(R.id.txt_judul);
        tvPenyanyi = findViewById(R.id.txt_penyanyi);
        tvGenre = findViewById(R.id.txt_genre);

        tvJudul.setText(getIntent().getStringExtra("judul"));
        tvPenyanyi.setText(getIntent().getStringExtra("penyanyi"));
        tvGenre.setText(getIntent().getStringExtra("genre"));

    }
}

