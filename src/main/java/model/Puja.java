package model;

public class Puja {
    private final Subasta subasta;
    private final Usuario usuario;
    private final Double cantidad;


    public Puja(Subasta subasta, Usuario usuario, Double cantidad) {
        this.subasta = subasta;
        this.usuario = usuario;
        this.cantidad = cantidad;
    }

    public Subasta getSubasta() {
        return subasta;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Double getCantidad() {
        return cantidad;
    }
}
