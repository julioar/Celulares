package com.example.android.celulares;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

public class ReporteUno extends AppCompatActivity {
    private TableLayout tabla_reporte;
    private ArrayList<Celular> celular;
    private String marca[];
    private String capacidad[];
    private String precio[];
    private String color[];
    private String sistema[];
    private Resources resources;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reporte_uno);

        tabla_reporte = (TableLayout)findViewById(R.id.tblReporteUno);
        celular = Datos.getCelulares();
        resources = this.getResources();
        precio = resources.getStringArray(R.array.precio);
        capacidad = resources.getStringArray(R.array.capacidad);



        for (int i = 0; i< celular.size(); i++){
            if(celular.get(i).getColor()==1 && celular.get(i).getSistema()==0){
                TableRow fila = new TableRow(this);
                TextView c1 = new TextView(this);
                TextView c2 = new TextView(this);
                TextView c3 = new TextView(this);


                c1.setText(""+(i+1));
                c2.setText(precio[celular.get(i).getPrecio()]);
                c3.setText(capacidad[celular.get(i).getCapacidad()]);
                fila.addView(c1);
                fila.addView(c2);
                fila.addView(c3);

                tabla_reporte.addView(fila);
            }
        }


    }
}
