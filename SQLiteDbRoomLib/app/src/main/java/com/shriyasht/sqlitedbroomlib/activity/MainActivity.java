package com.shriyasht.sqlitedbroomlib.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.shriyasht.sqlitedbroomlib.Daos.Appdatabase;
import com.shriyasht.sqlitedbroomlib.R;
import com.shriyasht.sqlitedbroomlib.adapter.CarAdapter;
import com.shriyasht.sqlitedbroomlib.entity.Car;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    RecyclerView recyclerView;
    CarAdapter carAdapter;
    List<Car> carlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        recyclerView = findViewById(R.id.recyclerView);
        carlist = new ArrayList<>();
        carAdapter = new CarAdapter(this,carlist);
        recyclerView.setAdapter(carAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this,1));

    }

    @Override
    protected void onStart() {
        super.onStart();
        getData();
    }

    private void getData() {
        carlist = Appdatabase.getInstance(this).cardao().getAllCars();
        carAdapter.setCarList(carlist);
        carAdapter.notifyDataSetChanged();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return  super.onCreateOptionsMenu(menu);
    }



    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent = new Intent(this, InputCarActivity.class);
        startActivity(intent);
        return super.onOptionsItemSelected(item);
    }
}