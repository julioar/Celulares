package com.example.android.celulares;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class CrearCelular extends AppCompatActivity {
    private Spinner spinner_Marca;
    private Spinner spinner_Precio;
    private Spinner spinner_Color;
    private Spinner spinner_capacidad;
    private EditText num;
    private Resources resources;
    private String op_Marcas[];
    private String op_Precio[];
    private String op_Color[];
    private String op_Capacidad[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_celular);

        spinner_Marca = (Spinner)findViewById(R.id.spMarca);
        spinner_Precio = (Spinner)findViewById(R.id.spPrecio);
        spinner_Color = (Spinner)findViewById(R.id.spColor);
        spinner_capacidad = (Spinner)findViewById(R.id.spCapacidad);
        num = (EditText)findViewById(R.id.txtNumero);
        resources = getResources();
        op_Marcas = resources.getStringArray(R.array.marcas);
        op_Precio = resources.getStringArray(R.array.precio);
        op_Color = resources.getStringArray(R.array.colores);
        op_Capacidad = resources.getStringArray(R.array.capacidad);

        ArrayAdapter<String> adapter_Marca = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,op_Marcas);
        spinner_Marca.setAdapter(adapter_Marca);

        ArrayAdapter<String> adapter_Precio = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,op_Precio);
        spinner_Precio.setAdapter(adapter_Precio);

        ArrayAdapter<String> adapter_Color = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,op_Color);
        spinner_Color.setAdapter(adapter_Color);

        ArrayAdapter<String> adapter_Capacidad = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,op_Capacidad);
        spinner_capacidad.setAdapter(adapter_Capacidad);
    }

    public void crear(View v){
        int marca, precio, color, capacidad;

        marca = spinner_Marca.getSelectedItemPosition();
        precio = spinner_Precio.getSelectedItemPosition();
        color = spinner_Color.getSelectedItemPosition();
        capacidad = spinner_capacidad.getSelectedItemPosition();

        Celular c = new Celular(marca, precio, color, capacidad);
        c.guardar();

        Toast.makeText(this,resources.getString(R.string.mensaje_guardado),Toast.LENGTH_SHORT).show();

    }
}
