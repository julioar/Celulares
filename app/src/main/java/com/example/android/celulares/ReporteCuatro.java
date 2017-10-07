package com.example.android.celulares;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

public class ReporteCuatro extends AppCompatActivity {

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
        setContentView(R.layout.activity_reporte_cuatro);

        tabla_reporte = (TableLayout)findViewById(R.id.tblReporteCuatro);
        celular = Datos.getCelulares();
        resources = this.getResources();
        marca = resources.getStringArray(R.array.marcas);
        precio = resources.getStringArray(R.array.precio);
        capacidad = resources.getStringArray(R.array.capacidad);
        color = resources.getStringArray(R.array.colores);
        sistema = resources.getStringArray(R.array.sistema);

        for (int i = 0; i < celular.size(); i++){
            Celular c = celular.get(i);
            if(c.getMarca()==2 && c.getColor()==1){
                TableRow fila = new TableRow(this);
                TextView c1 = new TextView(this);
                TextView c2 = new TextView(this);
                TextView c3 = new TextView(this);
                TextView c4 = new TextView(this);
                TextView c5 = new TextView(this);
                TextView c6 = new TextView(this);

                c1.setText(""+(i+1));
                c2.setText(marca[c.getMarca()]);
                c3.setText(precio[c.getPrecio()]);
                c4.setText(color[c.getColor()]);
                c5.setText(sistema[c.getSistema()]);
                c6.setText(capacidad[c.getCapacidad()]);
                fila.addView(c1);
                fila.addView(c2);
                fila.addView(c3);
                fila.addView(c4);
                fila.addView(c5);
                fila.addView(c6);
                tabla_reporte.addView(fila);
            }
        }
    }
}
