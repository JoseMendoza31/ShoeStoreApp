package com.example.master.shoestoreapp;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class FotoActivity extends AppCompatActivity {
    private ImageView iV_imagen;
    static final int REQUEST_IMAGE_CAPTURE=100;
    private Button btnTomarFoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foto);
        iV_imagen = (ImageView) findViewById(R.id.iV_imagen);
        btnTomarFoto = (Button)findViewById(R.id.btnTomarFoto);

        btnTomarFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Camerapermission();
                    accesoCamara();
                }catch (Exception ex){
                    Log.v("Error-btn",ex.getMessage());
                }

            }
        });
    }

    private void accesoCamara(){
        Intent TomarFotoIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        if(TomarFotoIntent.resolveActivity(getPackageManager())!=null){
            startActivityForResult(TomarFotoIntent,REQUEST_IMAGE_CAPTURE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK){
            Bundle extra = data.getExtras();
            //Log.v("Error",extra.toString());
            Bitmap imgBitmap = (Bitmap)  extra.get("data") ;
            iV_imagen.setImageBitmap(imgBitmap);
        }
    }

    public static final int MY_PERMISSIONS_REQUEST_CAMERA = 0;
    private void Camerapermission() {
        // Here, thisActivity is the current activity
        if (ContextCompat.checkSelfPermission(FotoActivity.this
                ,
                android.Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {

            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(FotoActivity.this,
                    android.Manifest.permission.CAMERA)) {

                // Show an expanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.

            } else {

                // No explanation needed, we can request the permission.

                ActivityCompat.requestPermissions(FotoActivity.this,
                        new String[]{Manifest.permission.CAMERA},
                        MY_PERMISSIONS_REQUEST_CAMERA);

                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.
            }
        }
    }
}
