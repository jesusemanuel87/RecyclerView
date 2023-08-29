package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.recyclerview.modelo.Inmueble;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private MainActivityViewModel mv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mv= ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(MainActivityViewModel.class);
        mv.getListaMutable().observe(this, new Observer<List<Inmueble>>() {
            @Override
            public void onChanged(List<Inmueble> inmuebles) {
                RecyclerView rv=findViewById(R.id.rvInmuebles);
                GridLayoutManager glm=new GridLayoutManager(MainActivity.this,1,GridLayoutManager.VERTICAL,false);
                rv.setLayoutManager(glm);
                InmuebleAdapter iad=new InmuebleAdapter(inmuebles,MainActivity.this,getLayoutInflater());
                rv.setAdapter(iad);
            }
        });
        mv.armarLista();
    }
}