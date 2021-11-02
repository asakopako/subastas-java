package model;

import java.util.LinkedList;
import java.util.List;

public class Subasta {
    private final Usuario propietario;
    private final String descripcion;
    private LinkedList<Puja> pujas;
    private Estado estado;


    public Subasta(Usuario propietario, String descripcion) {
        this.propietario = propietario;
        this.descripcion = descripcion;
        this.pujas = new LinkedList<>();
        this.estado = Estado.ABIERTA;
        propietario.addSubasta(this);
    }

    public boolean pujar(Usuario usuario, Double cantidad) {
        if(estado != Estado.ABIERTA) return false;
        if(usuario.getNombre().equals(propietario.getNombre())) return false;
        if(usuario.getCredito() < cantidad) return false;
        if(pujas.isEmpty() && cantidad < 1) return false;
        if(!pujas.isEmpty() && cantidad <= getPujaMayor().getCantidad()) return false;

        Puja puja = new Puja(this, usuario, cantidad);
        pujas.add(puja);
        usuario.addPuja(puja);

        return true;
    }

    public boolean pujar(Usuario usuario) {
        if(pujas.isEmpty()) return pujar(usuario,1.0);
        return pujar(usuario, getPujaMayor().getCantidad() + 1);
    }

    public Puja getPujaMayor() {
        if(pujas.isEmpty()) return null;
        return pujas.getLast();
    }

    public String getDescripcion() {
        return descripcion;
    }

    public List<Puja> getPujas() {
        return new LinkedList<>(pujas);
    }

    public void cerrar() {
        if(estado != Estado.EJECUTADA) estado = Estado.CERRADA;
    }

    public boolean isCerrada() {
        return estado == Estado.CERRADA || estado == Estado.EJECUTADA;
    }

    public void ejecutar() {
        if(!pujas.isEmpty()) {
            getPujaMayor().getUsuario().decrementarCredito(getPujaMayor().getCantidad());
            propietario.incrementarCredito(getPujaMayor().getCantidad());
            getPujaMayor().getUsuario().addSubastaGanada(this);
        }

        estado = Estado.EJECUTADA;
    }

    public boolean isEjecutada() {
        return estado == Estado.EJECUTADA;
    }
}
