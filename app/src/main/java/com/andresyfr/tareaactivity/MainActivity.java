package com.andresyfr.tareaactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements Button.OnClickListener{

    private Button btnSiguiente=null;
    private EditText etxtNombre=null;
    private DatePicker fechaNacimiento=null;
    private EditText etxtTelefono=null;
    private EditText etxtEmail=null;
    private EditText etxtDescripcion=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSiguiente= (Button)findViewById(R.id.button);
        btnSiguiente.setOnClickListener(this);
        etxtNombre= (EditText) findViewById(R.id.editText);
        fechaNacimiento= (DatePicker) findViewById(R.id.datePicker);
        etxtTelefono= (EditText) findViewById(R.id.editText2);
        etxtEmail= (EditText) findViewById(R.id.editText3);
        etxtDescripcion= (EditText) findViewById(R.id.editText4);

        etxtNombre.setText("andresyfr");
        fechaNacimiento.updateDate(2015,03,9);
        etxtTelefono.setText("3384213");
        etxtEmail.setText("aaaa@aaa.com");
        etxtDescripcion.setText("jdgshH");

        llenarEditText();
    }

    private void llenarEditText(){

        Bundle parametros = getIntent().getExtras();

        if(parametros!=null) {
            String fechaNace = parametros.getString(getResources().getString(R.string.mA_Nacimiento));//fecha nacimiento
            String nombre = parametros.getString(getResources().getString(R.string.mA_nombre));//nombre
            String telefono = parametros.getString(getResources().getString(R.string.mA_Telefono));//Telefono
            String email = parametros.getString(getResources().getString(R.string.mA_email));//Emai
            String descripcion = parametros.getString(getResources().getString(R.string.mA_Descripcion));//Descripcion

            if(fechaNace!=null) {
                fechaNacimiento.updateDate(Integer.parseInt(fechaNace.split("/")[2]), Integer.parseInt(fechaNace.split("/")[1]), Integer.parseInt(fechaNace.split("/")[0]));
                etxtNombre.setText(nombre);
                etxtTelefono.setText(telefono);
                etxtEmail.setText(email);
                etxtDescripcion.setText(descripcion);
            }
        }
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(MainActivity.this, ContactosActivity.class);
        intent.putExtra(getResources().getString(R.string.mA_nombre), etxtNombre.getText().toString());
        intent.putExtra(getResources().getString(R.string.mA_Nacimiento), fechaNacimiento.getDayOfMonth()+"/"+fechaNacimiento.getMonth()+"/"+fechaNacimiento.getYear());
        intent.putExtra(getResources().getString(R.string.mA_Telefono), etxtTelefono.getText().toString());
        intent.putExtra(getResources().getString(R.string.mA_email), etxtEmail.getText().toString());
        intent.putExtra(getResources().getString(R.string.mA_Descripcion), etxtDescripcion.getText().toString());
        startActivity(intent);
        finish();
    }
}
