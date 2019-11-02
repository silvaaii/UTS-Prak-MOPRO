package com.silvaailina.laguku;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.silvaailina.laguku.adapter.LaguAdapter;
import com.silvaailina.laguku.model.LaguModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    LaguAdapter adapter;
    RecyclerView rv;
    List<LaguModel> listLagu = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initRecyclerView();
    }
    public void initRecyclerView(){
        adapter = new LaguAdapter(this);
        rv = findViewById(R.id.rv_lagu);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setItemAnimator(new DefaultItemAnimator());
        rv.setAdapter(adapter);
        rv.setNestedScrollingEnabled(false);
        rv.hasFixedSize();
        adapter.setOnItemClickListener(new LaguAdapter.OnItemClickListener() {
            @Override
            public void onClick(int position) {
                Intent i = new Intent(MainActivity.this, DetailLaguActivity.class);
                i.putExtra("judul",listLagu.get(position).getJudul());
                i.putExtra("penyanyi",listLagu.get(position).getPenyanyi());

                startActivity(i);
            }
        });
        loadItem();
    }
    public void loadItem(){
        listLagu.add(new LaguModel("Judul: Sepatu","Penyanyi : Tulus","Genre : Jazz","Description"));
        listLagu.add(new LaguModel("Judul: Monokrom","Penyanyi : Tulus","Genre : Jazz","Description"));
        listLagu.add(new LaguModel("Judul: Sewindu","Penyanyi : Tulus","Genre : Jazz","Description"));
        listLagu.add(new LaguModel("Judul: Ruang Sendiri","Penyanyi : Tulus","Genre : Jazz","Description"));
        listLagu.add(new LaguModel("Judul: Ragu","Penyanyi : Rizky Febian","Genre : POP","Description"));
        listLagu.add(new LaguModel("Judul: Pupus","Penyanyi : Dewa 19","Genre : POP","Description"));
        listLagu.add(new LaguModel("Judul: Kangen","Penyanyi : Dewa 10","Genre : POP","Description"));
        adapter.addAll(listLagu);
    }

}
