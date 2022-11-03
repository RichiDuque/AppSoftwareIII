package com.venta.appecomerce.metodosDb;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.venta.appecomerce.bd.Constantes;
import com.venta.appecomerce.bd.DbHelper;
import com.venta.appecomerce.models.Productos;

import java.util.ArrayList;

public class ProductosDb extends DbHelper {

    Context context;

    public ProductosDb(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    public ArrayList<Productos> mostrarProductos() {

        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ArrayList<Productos> listaProductos = new ArrayList<>();
        Productos productos;
        Cursor cursorProducto;

        cursorProducto = db.rawQuery("SELECT * FROM " + Constantes.TABLA_PRODUCTOS , null);

        if (cursorProducto.moveToFirst()) {
            do {
                productos = new Productos();
                productos.setId(cursorProducto.getInt(0));
                productos.setNombre(cursorProducto.getString(1));
                productos.setImagen(cursorProducto.getString(2));
                productos.setCantidad(Integer.parseInt(cursorProducto.getString(3)));
                productos.setPrecio(Integer.parseInt(cursorProducto.getString(4)));
                productos.setDescripcion(cursorProducto.getString(5));
                System.out.println(Integer.parseInt(cursorProducto.getString(3)));
                listaProductos.add(productos);
            } while (cursorProducto.moveToNext());
        }

        cursorProducto.close();

        return listaProductos;
    }

    public long insertarProducto() {

        try {
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("NOMBRE", "Papa limon");
            values.put("IMAGEN", "xx");
            values.put("CANTIDAD", 50);
            values.put("PRECIO", 2500);
            values.put("DESCRIBCION", "Paquete de papas con sabor a limon");

            return db.insert(Constantes.TABLA_PRODUCTOS, null, values);
        } catch (Exception ex) {
            ex.toString();
            return 0;
        }

    }

}
