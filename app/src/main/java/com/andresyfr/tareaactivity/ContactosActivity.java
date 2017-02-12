package com.andresyfr.tareaactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ContactosActivity extends AppCompatActivity implements Button.OnClickListener{

    private Button btnEditarDatos;
    private EditText etxtNombre=null;
    private EditText fechaNacimiento=null;
    private EditText etxtTelefono=null;
    private EditText etxtEmail=null;
    private EditText etxtDescripcion=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactos);
        btnEditarDatos= (Button)findViewById(R.id.button6);
        btnEditarDatos.setOnClickListener(this);
        etxtNombre= (EditText) findViewById(R.id.Nombre);
        etxtNombre.clearComposingText();
        fechaNacimiento= (EditText) findViewById(R.id.fechaNacimiento);
        fechaNacimiento.clearComposingText();
        etxtTelefono= (EditText) findViewById(R.id.Telefono);
        etxtTelefono.clearComposingText();
        etxtEmail= (EditText) findViewById(R.id.Email);
        etxtEmail.clearComposingText();
        etxtDescripcion= (EditText) findViewById(R.id.Descripcion);
        etxtDescripcion.clearComposingText();
        llenarEditText();
    }

    private void llenarEditText(){

        Bundle parametros = getIntent().getExtras();
        String nombre = parametros.getString(getResources().getString(R.string.mA_nombre));//nombre
        String fechaNace = parametros.getString(getResources().getString(R.string.mA_Nacimiento));//fecha nacimiento
        String telefono = parametros.getString(getResources().getString(R.string.mA_Telefono));//Telefono
        String email = parametros.getString(getResources().getString(R.string.mA_email));//Emai
        String descripcion = parametros.getString(getResources().getString(R.string.mA_Descripcion));//Descripcion

        etxtNombre.setText(nombre);
        fechaNacimiento.setText(fechaNace);
        etxtTelefono.setText(telefono);
        etxtEmail.setText(email);
        etxtDescripcion.setText(descripcion);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(ContactosActivity.this, MainActivity.class);
        intent.putExtra(getResources().getString(R.string.mA_nombre), etxtNombre.getText().toString());
        intent.putExtra(getResources().getString(R.string.mA_Nacimiento), fechaNacimiento.getText().toString());
        intent.putExtra(getResources().getString(R.string.mA_Telefono), etxtTelefono.getText().toString());
        intent.putExtra(getResources().getString(R.string.mA_email), etxtEmail.getText().toString());
        intent.putExtra(getResources().getString(R.string.mA_Descripcion), etxtDescripcion.getText().toString());
        startActivity(intent);
        finish();
    }
}
