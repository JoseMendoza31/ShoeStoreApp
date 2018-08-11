package com.example.master.shoestoreapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ConsultaActivity extends AppCompatActivity {
    private DatabaseReference pdt;
    private String coleccionProductos = "productos";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta);
        pdt = FirebaseDatabase.getInstance().getReference().child(coleccionProductos);
        consultar();
    }

    private void consultar() {
        pdt.orderByKey().limitToFirst(10);
        pdt.orderByKey().limitToLast(10);
        pdt.orderByKey().startAt(11);
        pdt.orderByKey().endAt(15);
        pdt.orderByKey().startAt(11).endAt(20);
        pdt.orderByChild("Marca").addChildEventListener(new ChildEventListener() {

            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Producto pdt = dataSnapshot.getValue(Producto.class);
                System.out.println(dataSnapshot.getKey() + " es " + pdt.getMarca());
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}