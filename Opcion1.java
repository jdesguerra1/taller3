import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Opcion1 {

    public static void mostrarProductosOrdenados() {

        try {
            List<Producto> productos = LeerProductos.leerProductos();

            Ordenamiento.ordenarPorPrecio((ArrayList<Producto>) productos);

            System.out.println("Productos ordenados por precio:");

            for (Producto p : productos) {
                System.out.println(
                    p.getNombre() + " - $" + p.getPrecio() + " - Stock: " + p.getStock()
                );
            }
        } catch (IOException e) {
            System.err.println("Error al leer productos: " + e.getMessage());
        }
    }
}