package javabeans;

import java.io.Serializable;

/**
 * Created by USUARIO on 03/05/2017.
 */

public class Coordenadas implements Serializable {
    private double latitud, longitud;
    private String dni, nombre, direccion, servicio, email, cp, telefono,opcion;

    public Coordenadas(double latitud, double longitud, String dni, String nombre, String direccion, String servicio, String email, String cp, String telefono, String opcion) {
        this.latitud = latitud;
        this.longitud = longitud;
        this.dni = dni;
        this.nombre = nombre;
        this.direccion = direccion;
        this.servicio = servicio;
        this.email = email;
        this.cp = cp;
        this.telefono = telefono;
        this.opcion = opcion;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getOpcion() {
        return opcion;
    }

    public void setOpcion(String opcion) {
        this.opcion = opcion;
    }
}
