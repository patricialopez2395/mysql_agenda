package com.example.argem.agenda_mysql.controller;

import android.app.AlertDialog;
import android.content.Context;
import android.os.AsyncTask;

import com.example.argem.agenda_mysql.Conexion;

import org.json.JSONArray;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class ControllerContact extends AsyncTask<String, Void, String> {

    Context context;
    AlertDialog alertDialog;
    public ControllerContact(Context ctx)
    {
        context=ctx;
    }

    private String consultaServidor(String url)
    {
        try {
            URL url_login = new URL(url);
            HttpURLConnection urlConnection = (HttpURLConnection) url_login.openConnection();
            urlConnection.setRequestMethod("POST");

            int rta = urlConnection.getResponseCode();
            StringBuilder result = new StringBuilder();
            String line;

            if (rta == HttpURLConnection.HTTP_OK) {
                InputStream inputStream = urlConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                while ((line = bufferedReader.readLine()) != null) {
                    result.append(line);
                }
                bufferedReader.close();
                inputStream.close();
                urlConnection.disconnect();
                return result.toString();
            } else
                return null;
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    protected String doInBackground(String... voids) {
        // c contacto i imagen g lista del grupo
        if (voids[0].equals("c")) {
            String url = Conexion.url + "contact/listContact.php?id="+voids[1];
            return consultaServidor(url);
        }
        else
        {
            if (voids[0].equals("i"))
            {
                String url = Conexion.url+"contact/getImage.php?id=" + voids[1];
                return  consultaServidor(url);
            }
            else
            {
                String url = Conexion.url+"contact/listGroup.php?id=" + voids[1];
                return consultaServidor(url);
            }
        }
    }

    @Override
    protected void onPreExecute() {
        //alertDialog=new AlertDialog.Builder(context).create();
        //alertDialog.setTitle("Cargando datos");
    }

    @Override
    protected void onPostExecute(String aVoid) {
        //alertDialog.setMessage("Datos cargados");
        //alertDialog.show();
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        //alertDialog.setMessage("Por favor espere......");
    }
}
