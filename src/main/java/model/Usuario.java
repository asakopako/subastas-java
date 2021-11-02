package model;

import java.util.LinkedList;
import java.util.List;

public class Usuario {
    private String nombre;
    private Double credito;
    private LinkedList<Subasta> subastas;
    private LinkedList<Puja> pujasAceptadas;
    private LinkedList<Subasta> subastasGanadas;


    public Usuario(String nombre, Double credito) {
        this.nombre = nombre;
        this.credito = credito;
        subastas = new LinkedList<>();
        pujasAceptadas = new LinkedList<>();
        subastasGanadas = new LinkedList<>();
    }

    public void incrementarCredito(Double incremento) {
        this.credito += incremento;
    }

    public void decrementarCredito(Double decremento) {
        this.credito -= decremento;
    }

    public String getNombre() {
        return nombre;
    }

    public Double getCredito() {
        return credito;
    }

    public List<Subasta> getSubastas() {
        return subastas;
    }

    public List<Puja> getPujasAceptadas() {
        return pujasAceptadas;
    }

    public List<Subasta> getSubastasGanadas() {
        return subastasGanadas;
    }

    public void addSubasta(Subasta subasta) {
        subastas.add(subasta);
    }

    public void addPuja(Puja puja) {
        pujasAceptadas.add(puja);
    }

    public void addSubastaGanada(Subasta subasta) {
        subastasGanadas.add(subasta);
    }
}
