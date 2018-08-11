package com.example.master.shoestoreapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegistrarActivity extends AppCompatActivity {
    //private FirebaseDatabase ShoeStoreData;
    private DatabaseReference ShoeStoreData;
    private DatabaseReference ShoeStoreReference;
    private String coleccionProductos="productos";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);
        ShoeStoreData=FirebaseDatabase.getInstance().getReference();
        ShoeStoreReference= ShoeStoreData.child(coleccionProductos);

    }

    public void imageButtonSave (View view){
        EditText editTextTipo =(EditText)findViewById(R.id.editTextTipo);
        EditText editTextMarca=(EditText)findViewById(R.id.editTextMarca);
        EditText editTextDescripcion=(EditText)findViewById(R.id.editTextDescripcion);
        EditText editTextCategoria=(EditText)findViewById(R.id.editTextCategoria);
        EditText editTextColor=(EditText)findViewById(R.id.editTextColor);
        EditText editTextPrecio=(EditText)findViewById(R.id.editTextPrecio);
        EditText editTextTalla=(EditText)findViewById(R.id.editTextTalla);

        Producto pdt=new Producto(editTextTipo.getText().toString(),
                editTextMarca.getText().toString(), editTextDescripcion.getText().toString(),
                editTextCategoria.getText().toString(), editTextColor.getText().toString(),
                editTextPrecio.getText().toString(), editTextTalla.getText().toString());

        RegistrarNuevo(pdt);
    }
    private  String Registrar(Producto pdt){
        String codigo= pdt.getCodigo();
        ShoeStoreReference.child(codigo).setValue(pdt);
        return codigo;
    }

   private String RegistrarNuevo(Producto pdt){
        String codigo= ShoeStoreReference.push().getKey();
        ShoeStoreData.child(codigo).setValue(pdt);
        return  codigo;
    }
}
