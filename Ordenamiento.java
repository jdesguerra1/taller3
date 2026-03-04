import java.util.ArrayList;

public class Ordenamiento {

    public static void ordenarPorPrecio(ArrayList<Producto> productos) {

        for (int i = 0; i < productos.size() - 1; i++) {
            for (int j = 0; j < productos.size() - 1 - i; j++) {

                if (productos.get(j).getPrecio() > productos.get(j + 1).getPrecio()) {
                    Producto temp = productos.get(j);
                    productos.set(j, productos.get(j + 1));
                    productos.set(j + 1, temp);
                }
            }
        }
    }
}