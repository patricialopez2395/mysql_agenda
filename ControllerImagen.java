package com.example.argem.agenda_mysql.controller;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import com.example.argem.agenda_mysql.Conexion;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ControllerImagen extends AsyncTask<Void, Void, Bitmap> {

    private int id_contacto;
    public ControllerImagen(int id_contacto)
    {
        this.id_contacto=id_contacto;
    }
    @Override
    protected Bitmap doInBackground(Void... strings) {
        try {
            URL url = new URL(Conexion.url+"upload/"+id_contacto+".jpg");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream input = connection.getInputStream();
            Bitmap myBitmap = BitmapFactory.decodeStream(input);
            return myBitmap;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
