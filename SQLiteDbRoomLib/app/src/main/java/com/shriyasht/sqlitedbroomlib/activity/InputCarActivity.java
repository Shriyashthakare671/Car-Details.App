package com.shriyasht.sqlitedbroomlib.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.shriyasht.sqlitedbroomlib.Daos.Appdatabase;
import com.shriyasht.sqlitedbroomlib.R;
import com.shriyasht.sqlitedbroomlib.entity.Car;

public class InputCarActivity extends AppCompatActivity {
    EditText editCarNo,editcarName,editcarPrice;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_car);
        editCarNo = findViewById(R.id.editCarNo);
        editcarName =findViewById(R.id.editcarName);
        editcarPrice = findViewById(R.id.editcarPrice);
    }

    public void Add(View view) {
        Car car = new Car();
        car.setCarNo(Integer.parseInt(editCarNo.getText().toString()));
        car.setCarName(editcarName.getText().toString());
        car.setPrice(Double.parseDouble(editcarPrice.getText().toString()));

        Appdatabase.getInstance(this).cardao().insertCar(car);
        finish();
    }

    public void Cancel(View view) {
        finish();

    }
}