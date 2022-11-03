package com.venta.appecomerce;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Toast;

import com.venta.appecomerce.adaptadores.ListaProductosAdapter;
import com.venta.appecomerce.bd.Constantes;
import com.venta.appecomerce.bd.DbHelper;
import com.venta.appecomerce.metodosDb.ProductosDb;

public class MainActivity extends AppCompatActivity {

    RecyclerView listaProductos;
    ListaProductosAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaProductos = findViewById(R.id.ryProductos);
        listaProductos.setLayoutManager(new LinearLayoutManager(this));

        ProductosDb db = new ProductosDb(MainActivity.this);

        adapter = new ListaProductosAdapter(db.mostrarProductos());
        listaProductos.setAdapter(adapter);
        //db.insertarProducto();
    }

}