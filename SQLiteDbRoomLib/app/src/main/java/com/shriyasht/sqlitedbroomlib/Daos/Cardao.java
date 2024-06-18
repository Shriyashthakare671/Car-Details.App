package com.shriyasht.sqlitedbroomlib.Daos;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.shriyasht.sqlitedbroomlib.entity.Car;

import java.util.List;

@Dao
public interface Cardao {

    @Query("SELECT * FROM car")
    List<Car> getAllCars();

    @Insert
    void insertCar(Car car);
}
