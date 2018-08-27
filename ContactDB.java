package com.example.argem.agenda_mysql.controller;

import com.example.argem.agenda_mysql.Conexion;
import com.example.argem.agenda_mysql.model.Contacto;
import com.example.argem.agenda_mysql.model.Grupo;
import com.example.argem.agenda_mysql.model.Imagen;

import org.json.JSONArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

public class ContactDB {

    private Contacto contacto;

    public Contacto getContacto() {
        if (contacto==null)
        {
            contacto = new Contacto();
        }
        return contacto;
    }
    public void setContacto(Contacto contacto) {
        this.contacto = contacto;
    }

    private Imagen imagen;
    public Imagen getImagen() {
        if (imagen==null)
        {
            imagen = new Imagen();
        }
        return imagen;
    }
    public void setImagen(Imagen imagen) {
        this.imagen = imagen;
    }

    private Grupo grupo;

    private ArrayList<Grupo> lstGrupo;

    public ArrayList<Grupo> getLstGrupo() {
        if (lstGrupo==null)
        {
            lstGrupo = new ArrayList<>();
        }
        return lstGrupo;
    }

    public void setLstGrupo(ArrayList<Grupo> lstGrupo) {
        this.lstGrupo = lstGrupo;
    }

    public Grupo getGrupo() {
        if (grupo==null)
        {
            grupo = new Grupo();
        }
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }
}
