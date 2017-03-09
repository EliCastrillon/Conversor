package com.elicastrillon.conversor;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    EditText ePesos, eDolares;
    Button bConvertir,lLimpiar;
    Double pesos, dolares;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // metodo cuando se presione el boton convertir
        ePesos = (EditText) findViewById (R.id.ePesos);
        eDolares = (EditText) findViewById(R.id.eDolares);
        bConvertir = (Button) findViewById(R.id.bConvertir);
        lLimpiar = (Button)  findViewById(R.id.lLimpiar);
        // accion al dar clik
        bConvertir.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                // Convertir de  pesos a dolares
                if (!ePesos.getText().toString().equals("") && eDolares.getText().toString().equals("")) {
                    pesos = Double.parseDouble(ePesos.getText().toString());
                    dolares = pesos / 3000;
                    eDolares.setText(String.valueOf(dolares));
                }// Convertir de dolares a pesos
                else if (ePesos.getText().toString().equals("") && !eDolares.getText().toString().equals("")) {
                    dolares = Double.parseDouble(eDolares.getText().toString());
                    pesos = dolares * 3000;
                    ePesos.setText(String.valueOf(pesos));
                }// mensajes por valor vacios o repetidos
                else if (ePesos.getText().toString().equals("") && eDolares.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "Debe digitar un valor", Toast.LENGTH_SHORT).show();
                } else if (!ePesos.getText().toString().equals("") && !eDolares.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(), "ERROR Solo debe digitar un valor", Toast.LENGTH_SHORT).show();
                }


            }


        });
           // borrar campos al dar clik en el boton limpiar campos
        lLimpiar.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
               limpiarCampos();
            }
        });



    }

    // Metodo limpiar campos

    public void limpiarCampos(){
        ePesos.setText("");
        eDolares.setText("");

    }


}
