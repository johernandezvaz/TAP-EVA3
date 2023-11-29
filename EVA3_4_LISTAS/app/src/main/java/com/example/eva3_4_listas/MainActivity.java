package com.example.eva3_4_listas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView lstVwDatos;

    String[] datos = {
            "Tacos",
            "Tortas",
            "Tamales",
            "Comida",
            "Coca",
            "Billetes",
            "Molletes",
            "Sapos",
            "Anfibios",
            "Cables"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lstVwDatos = findViewById(R.id.lstDatos);
        lstVwDatos.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,datos ));
        lstVwDatos.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Toast.makeText(MainActivity.this, "Valor seleccionado " + datos[i], Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this, OtraPantalla.class);
                        intent.putExtra("DATO", datos[i]);
                        startActivity(intent);
                    }
                }
        );
    }
}