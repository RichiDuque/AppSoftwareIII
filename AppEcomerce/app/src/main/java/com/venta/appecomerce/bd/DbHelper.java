package com.venta.appecomerce.bd;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends  SQLiteOpenHelper{

    private static final String CREAR_TABLA_PRODUCTOS = "CREATE TABLE " +
            Constantes.TABLA_PRODUCTOS +
            " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
            " NOMBRE TEXT NOT NULL, " +
            " IMAGEN TEXT NOT NULL, " +
            " CANTIDAD INTEGER NOT NULL, " +
            " PRECIO INTEGER NOT NULL, " +
            " DESCRIBCION TEXT NOT NULL)";

    public DbHelper(@Nullable Context context) {
        super(context, Constantes.NOMBRE_BD, null, Constantes.VERSION_BD);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREAR_TABLA_PRODUCTOS);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS PRODUCTOS");
        sqLiteDatabase.execSQL(CREAR_TABLA_PRODUCTOS);

    }
}
