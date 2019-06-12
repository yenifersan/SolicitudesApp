package com.santiago.solicitudesapp.models;

public class Solicitud {
    private Integer id;
    private String correo;
    private String tipo;
    private String motivo;
    private String imagen;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    @Override
    public String toString() {
        return "Solicitud{" +
                "id=" + id +
                ", correo='" + correo + '\'' +
                ", tipo='" + tipo + '\'' +
                ", motivo='" + motivo + '\'' +
                ", imagen='" + imagen + '\'' +
                '}';
    }
}
