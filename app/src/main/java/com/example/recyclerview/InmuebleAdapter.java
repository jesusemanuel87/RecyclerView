package com.example.recyclerview;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.recyclerview.modelo.Inmueble;

import java.util.List;

public class InmuebleAdapter extends RecyclerView.Adapter<InmuebleAdapter.ViewHolder> {

    private List<Inmueble> inmuebles;
    private Context context;
    private LayoutInflater li;

    public InmuebleAdapter(List<Inmueble> inmuebles, Context context, LayoutInflater li) {
        this.inmuebles = inmuebles;
        this.context = context;
        this.li = li;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=li.inflate(R.layout.item_inmueble,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Log.d("salida ",inmuebles.get(position).getUrl());

        holder.direccion.setText(inmuebles.get(position).getDireccion());
        holder.precio.setText(inmuebles.get(position).getPrecion()+"");

        Glide.with(context)
                .load(inmuebles.get(position).getUrl())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .fitCenter()
                .override(210,238)
                .into(holder.foto);
    }

    @Override
    public int getItemCount() {
        return inmuebles.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView direccion, precio;
        private ImageView foto;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            direccion=itemView.findViewById(R.id.tvDireccion);
            precio=itemView.findViewById(R.id.tvPrecio);
            foto=itemView.findViewById(R.id.foto);


        }
    }
}
