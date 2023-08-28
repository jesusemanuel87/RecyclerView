package com.example.recyclerview;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.recyclerview.modelo.Inmueble;

import java.util.ArrayList;
import java.util.List;

public class MainActivityViewModel extends AndroidViewModel {

    private Context context;

    private MutableLiveData<List<Inmueble>> listaMutable;
    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        this.context=application.getApplicationContext();

    }
    public LiveData<List<Inmueble>> getListaMutable(){
        if (listaMutable==null){
            listaMutable=new MutableLiveData<>();
        }
        return listaMutable;
    }

    public void armarLista(){
        List<Inmueble> lista =new ArrayList<>();
        lista.add(new Inmueble( "Colon 720", 100000, "http://www.secsanluis.com.ar/servicios/casa1.jpg"));
        lista.add(new Inmueble( "San Martin 80", 80000, "http://www.secsanluis.com.ar/servicios/casa2.jpg"));
        lista.add(new Inmueble( "Falucho 150", 50000, "http://www.secsanluis.com.ar/servicios/casa3.jpg"));
        lista.add(new Inmueble( "Belgrano 1720", 60000, "http://www.secsanluis.com.ar/servicios/casa1.jpg"));

        listaMutable.setValue(lista);
    }

}
