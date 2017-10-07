package com.example.android.celulares;

import android.content.res.Resources;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class CrearCelular extends AppCompatActivity {
    private Spinner spinner_Marca;
    private Spinner spinner_Precio;
    private Spinner spinner_Color;
    private Spinner spinner_capacidad;
    private Spinner spinner_Sistema;
    private EditText num;
    private Resources resources;
    private String op_Marcas[];
    private String op_Precio[];
    private String op_Color[];
    private String op_Capacidad[];
    private String op_Sistema[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_celular);

        spinner_Marca = (Spinner)findViewById(R.id.spMarca);
        spinner_Precio = (Spinner)findViewById(R.id.spPrecio);
        spinner_Color = (Spinner)findViewById(R.id.spColor);
        spinner_capacidad = (Spinner)findViewById(R.id.spCapacidad);
        spinner_Sistema = (Spinner)findViewById(R.id.spSistema);
        //num = (EditText)findViewById(R.id.txtNumero);
        resources = getResources();
        op_Marcas = resources.getStringArray(R.array.marcas);
        op_Precio = resources.getStringArray(R.array.precio);
        op_Color = resources.getStringArray(R.array.colores);
        op_Capacidad = resources.getStringArray(R.array.capacidad);
        op_Sistema = resources.getStringArray(R.array.sistema);

        ArrayAdapter<String> adapter_Marca = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,op_Marcas);
        spinner_Marca.setAdapter(adapter_Marca);

        ArrayAdapter<String> adapter_Precio = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,op_Precio);
        spinner_Precio.setAdapter(adapter_Precio);

        ArrayAdapter<String> adapter_Color = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,op_Color);
        spinner_Color.setAdapter(adapter_Color);

        ArrayAdapter<String> adapter_Capacidad = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,op_Capacidad);
        spinner_capacidad.setAdapter(adapter_Capacidad);

        ArrayAdapter<String> adapter_Sistema = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,op_Sistema);
        spinner_Sistema.setAdapter(adapter_Sistema);
    }

    public void crear(View v){

        int marca, precio, color, sistema, capacidad;

        marca = spinner_Marca.getSelectedItemPosition();
        precio = spinner_Precio.getSelectedItemPosition();
        color = spinner_Color.getSelectedItemPosition();
        sistema = spinner_Sistema.getSelectedItemPosition();
        capacidad = spinner_capacidad.getSelectedItemPosition();

        Celular c = new Celular(marca, precio, color, sistema, capacidad);

        if ((sistema==0 && marca==2) || (marca!=2 && sistema==1) ){
            new AlertDialog.Builder(CrearCelular.this).setMessage("Este marca no maneja ese sistema").show();
            return;
        }
        c.guardar();
        Toast.makeText(this,resources.getString(R.string.mensaje_guardado),Toast.LENGTH_SHORT).show();

    }


}
