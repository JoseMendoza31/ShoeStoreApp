package com.example.master.shoestoreapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;


public class MenuActivity extends AppCompatActivity {
    ImageButton Foto;
    ImageButton Registrar;
    ImageButton Catalogo;
    ImageButton Carrito;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        // TOMAR FOTO
        Foto=(ImageButton)findViewById(R.id.imageButtonFoto);
        Foto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Foto=  new Intent(MenuActivity.this, FotoActivity.class);
                startActivity(Foto);
            }
        });

        //REGISTRAR PRODUCTO
        Registrar=(ImageButton)findViewById(R.id.imageButtonRegistrar);
        Registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Registrar= new Intent(MenuActivity.this, RegistrarActivity.class);
                startActivity(Registrar);
            }
        });

        //CATALOGO
        Catalogo=(ImageButton)findViewById(R.id.imageButtonCatalogo);
        Catalogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Catalogo= new Intent(MenuActivity.this, CatalogoActivity.class);
                startActivity(Catalogo);
            }
        });

        //CARRITO
        Carrito=(ImageButton)findViewById(R.id.imageButtonCarrito);
        Carrito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Carrito= new Intent(MenuActivity.this, CarritoActivity.class);
                startActivity(Carrito);
            }
        });

    }
}
