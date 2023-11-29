package com.example.eva3_3_interfaz_grafica;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements  RadioGroup.OnCheckedChangeListener{

    Button btnNombreCompleto;
    TextView txtVwNombre;
    TextView txtVwApellido;
    RadioGroup rdEstadoCivil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rdEstadoCivil = findViewById(R.id.rdGrpEstadoCivil);
        btnNombreCompleto = findViewById(R.id.btnNomCompleto);
        txtVwApellido = findViewById(R.id.edtTxtNombre);
        txtVwNombre = findViewById(R.id.edtTxtNombre);

        rdEstadoCivil.setOnCheckedChangeListener(this);
        btnNombreCompleto.setOnClickListener(btnNombreCompleto.findViewById(R.id.btnNomCompleto));
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        String nombre = txtVwNombre.getText().toString();
        String apellido = txtVwApellido.getText().toString();

        Toast.makeText(MainActivity.this, nombre + " " + apellido, Toast.LENGTH_SHORT).show();
        finish();
    }



}