package com.example.master.shoestoreapp;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;


public class InicioActivity extends AppCompatActivity {

    ImageButton Iniciar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        Iniciar= (ImageButton)findViewById(R.id.imageButtonInicio);
        Iniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Iniciar= new Intent(InicioActivity.this, MenuActivity.class);
                startActivity(Iniciar);
               // finish();

            }
    });
        }
    }


