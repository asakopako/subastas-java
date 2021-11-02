import model.Puja;
import model.Subasta;
import model.Usuario;

import java.util.ArrayList;

public class Inicio {
    public static void main(String[] args) {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario("Juan", 100.0));
        usuarios.add(new Usuario("Pedro", 150.0));
        usuarios.add(new Usuario("Enrique", 300.0));

        Subasta subasta = new Subasta(usuarios.get(0), "Teléfono Móvil");

        subasta.pujar(usuarios.get(1), 100.0);

        Puja puja = subasta.getPujaMayor();
        System.out.println("Producto: " + puja.getSubasta().getDescripcion() + " Usuario: " + puja.getUsuario().getNombre() + " Cantidad: " + puja.getCantidad());

        subasta.pujar(usuarios.get(2), 50.0);

        puja = subasta.getPujaMayor();
        System.out.println("Producto: " + puja.getSubasta().getDescripcion() + " Usuario: " + puja.getUsuario().getNombre() + " Cantidad: " + puja.getCantidad());

        subasta.cerrar();

        subasta.pujar(usuarios.get(2), 200.0);

        puja = subasta.getPujaMayor();
        System.out.println("Producto: " + puja.getSubasta().getDescripcion() + " Usuario: " + puja.getUsuario().getNombre() + " Cantidad: " + puja.getCantidad());

        subasta.ejecutar();

        for(Usuario usuario : usuarios){
            System.out.println("Saldo de " + usuario.getNombre() + ": " + usuario.getCredito());
        }

        for(Usuario usuario : usuarios){
            System.out.println(usuario.getNombre() + " subastas:");
            for(Subasta s : usuario.getSubastas()) {
                System.out.println(s.getDescripcion());
            }

            System.out.println(usuario.getNombre() + " subastas ganadas:");
            for(Subasta s : usuario.getSubastasGanadas()) {
                System.out.println(s.getDescripcion());
            }

            System.out.println(usuario.getNombre() + " pujas aceptadas:");
            for(Puja p : usuario.getPujasAceptadas()) {
                System.out.println("Subasta: " + p.getSubasta().getDescripcion() + " cantidad pujada: " + p.getCantidad());
            }
        }

    }
}
