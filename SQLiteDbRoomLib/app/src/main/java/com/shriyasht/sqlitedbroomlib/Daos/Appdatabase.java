package com.shriyasht.sqlitedbroomlib.Daos;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.shriyasht.sqlitedbroomlib.entity.Car;

@Database(entities = {Car.class}, version = 1)
public abstract class Appdatabase extends RoomDatabase {

    public abstract Cardao cardao();

    public static Appdatabase getInstance(Context context) {
        return Room.databaseBuilder(context, Appdatabase.class, "cardb")
                .allowMainThreadQueries()
                .build();

    }
}
