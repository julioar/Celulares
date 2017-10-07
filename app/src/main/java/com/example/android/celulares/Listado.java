package com.example.android.celulares;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

public class Listado extends AppCompatActivity {

    private TableLayout tabla;
    private ArrayList<Celular> celular;
    private String marca[];
    private String precio[];
    private String color[];
    private String sistema[];
    private String capacidad[];
    private Resources resources;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);

        tabla = (TableLayout)findViewById(R.id.tblListado);
        celular = Datos.getCelulares();
        resources = this.getResources();
        marca = resources.getStringArray(R.array.marcas);
        precio = resources.getStringArray(R.array.precio);
        color = resources.getStringArray(R.array.colores);
        sistema = resources.getStringArray(R.array.sistema);
        capacidad = resources.getStringArray(R.array.capacidad);

        for (int i = 0; i< celular.size(); i++){
            TableRow fila = new TableRow(this);
            TextView c1 = new TextView(this);
            TextView c2 = new TextView(this);
            TextView c3 = new TextView(this);
            TextView c4 = new TextView(this);
            TextView c5 = new TextView(this);
            TextView c6= new TextView(this);

            c1.setText(""+(i+1));
            c2.setText(marca[celular.get(i).getMarca()]);
            c3.setText(precio[celular.get(i).getPrecio()]);
            c4.setText(color [celular.get(i).getColor()]);
            c5.setText(sistema[celular.get(i).getSistema()]);
            c6.setText(capacidad[celular.get(i).getCapacidad()]);
            fila.addView(c1);
            fila.addView(c2);
            fila.addView(c3);
            fila.addView(c4);
            fila.addView(c5);
            fila.addView(c6);
            tabla.addView(fila);
        }

    }
}
