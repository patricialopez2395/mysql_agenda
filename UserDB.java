package com.example.argem.agenda_mysql.controller;
import android.content.Context;
import android.os.AsyncTask;

import com.example.argem.agenda_mysql.Conexion;
import com.example.argem.agenda_mysql.model.*;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class UserDB {
    private Usuario usuario;

    public Usuario getUsuario() {
        if (usuario==null)
        {
            usuario = new Usuario();
        }
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String geUser(String email, String pass)
    {
        try {
            String url= Conexion.url+"user/getUser.php?email=" + URLEncoder.encode(email, "UTF-8") + "&clave=" + URLEncoder.encode(pass, "UTF-8");
            URL url_login=new URL(url);
            HttpURLConnection urlConnection= (HttpURLConnection) url_login.openConnection();
            urlConnection.setRequestMethod("POST");

            int rta=urlConnection.getResponseCode();
            StringBuilder result= new StringBuilder();
            String line;

            if (rta==HttpURLConnection.HTTP_OK)
            {
                InputStream inputStream = urlConnection.getInputStream();
                BufferedReader bufferedReader= new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                while ((line=bufferedReader.readLine())!=null)
                {
                    result.append(line);
                }
                bufferedReader.close();
                inputStream.close();
                urlConnection.disconnect();
                return result.toString();
            }
            else
                return null;
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
