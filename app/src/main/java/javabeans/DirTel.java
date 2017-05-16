package javabeans;

import java.io.Serializable;

/**
 * Created by USUARIO on 03/05/2017.
 */

public class DirTel implements Serializable {
    private String direccion, telefono;

    public DirTel(String direccion, String telefono) {
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
