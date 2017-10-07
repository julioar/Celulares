package com.example.android.celulares;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

public class Principal extends AppCompatActivity {

    private ListView lstOpciones;
    private ArrayList<Celular> cel;
    private Resources res;
    private String marca[];
    private String capacidad[];
    private String precio[];
    private String color[];
    private String sistema[];
    private String opc[];
    private Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);


        lstOpciones = (ListView)findViewById(R.id.lstOpciones);
        res = this.getResources();

        opc =  res.getStringArray(R.array.opciones);
        ArrayAdapter<String>adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,opc);
        lstOpciones.setAdapter(adapter);

        lstOpciones.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
                switch (pos){
                    case 0:
                        i = new Intent(Principal.this, CrearCelular.class);
                        startActivity(i);
                        break;
                    case 1:
                        i = new Intent(Principal.this, Listado.class);
                        startActivity(i);
                        break;
                    case 2:
                         i = new Intent(Principal.this, ReporteDos.class);
                        startActivity(i);
                        break;
                    case 3:
                        i = new Intent(Principal.this,ReporteCuatro.class);
                        startActivity(i);
                        break;
                    case 4:
                        i = new Intent(Principal.this,ReporteUno.class);
                        startActivity(i);
                        break;
                    case 5:
                        new AlertDialog.Builder(Principal.this).setMessage(masBarato()).show();
                        break;

                }
            }
        });


    }

    public String masBarato(){
        marca = res.getStringArray(R.array.marcas);
        precio = res.getStringArray(R.array.precio);
        capacidad = res.getStringArray(R.array.capacidad);
        color = res.getStringArray(R.array.colores);
        sistema = res.getStringArray(R.array.sistema);
        cel = Datos.getCelulares();
        String mar="",pre="",cap="",col="",sis="";
        String msg="";
        if (cel.size()!=0){
            for (int i=0;i<cel.size();i++){
                if (cel.get(i).getPrecio()==0){
                    mar = marca[cel.get(i).getMarca()];
                    pre = precio[cel.get(i).getPrecio()];
                    cap = capacidad[cel.get(i).getCapacidad()];
                    col = color[cel.get(i).getColor()];
                    sis = sistema[cel.get(i).getSistema()];
                }
            }
            msg="El celular mas barato es: "+mar+ ", con "+cap+", color "+col+", sistema "+sis+", precio "+pre;
        }else {
            msg="No hay registros";
        }
        return msg;
    }
}
