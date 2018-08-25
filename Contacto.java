package com.example.argem.agenda_mysql.model;

import java.util.ArrayList;

public class Contacto {
    private int id_contacto;
    private String nombre;
    private String telefono;
    private String direccion;
    private String alias;
    private Usuario usuario;
    private Imagen imagen;
    private ArrayList<Grupo> lstGrupo;
    private ArrayList<Contacto> lista;

    @Override
    public String toString() {
        return this.nombre + "\n"+this.telefono;
    }
    public int getId_contacto() {
        return id_contacto;
    }

    public void setId_contacto(int id_contacto) {
        this.id_contacto = id_contacto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public ArrayList<Contacto> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Contacto> lista) {
        this.lista = lista;
    }

    public ArrayList<Grupo> getLstGrupo() {
        return lstGrupo;
    }

    public void setLstGrupo(ArrayList<Grupo> lstGrupo) {
        this.lstGrupo = lstGrupo;
    }

    public Imagen getImagen() {
        return imagen;
    }

    public void setImagen(Imagen imagen) {
        this.imagen = imagen;
    }
}
