package com.venta.appecomerce.adaptadores;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.venta.appecomerce.R;
import com.venta.appecomerce.models.Productos;

import java.util.ArrayList;

public class ListaProductosAdapter extends RecyclerView.Adapter<ListaProductosAdapter.ProductosViewHolder>{

    ArrayList<Productos> listaProductos;
    ArrayList<Productos> listaOriginal;

    public ListaProductosAdapter(ArrayList<Productos> listaProductos) {
        this.listaProductos = listaProductos;
        listaOriginal = new ArrayList<>();
        listaOriginal.addAll(listaProductos);
    }

    @NonNull
    @Override
    public ProductosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_producto, null, false);
        return new ProductosViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductosViewHolder holder, int position) {
        holder.viewNombre.setText(listaProductos.get(position).getNombre());
        holder.viewCantidad.setText("Cantidad disponible: "+listaProductos.get(position).getCantidad()+"");
        holder.viewPrecio.setText("Precio: "+listaProductos.get(position).getPrecio()+"");

        holder.itemView.setOnClickListener(view -> {
            Context context = view.getContext();
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setMessage(listaProductos.get(position).getDescripcion())
                    .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    }).show();
        });

    }

    @Override
    public int getItemCount() {
        return listaProductos.size();
    }

    public class ProductosViewHolder extends RecyclerView.ViewHolder {

        TextView viewNombre, viewCantidad, viewPrecio;

        public ProductosViewHolder(@NonNull View itemView) {
            super(itemView);

            viewNombre = itemView.findViewById(R.id.textNombreProducto);
            viewCantidad = itemView.findViewById(R.id.textCantidad);
            viewPrecio = itemView.findViewById(R.id.textPrecio);

        }
    }
}
