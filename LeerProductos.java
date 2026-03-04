import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LeerProductos {

    public static List<Producto> leerProductos() throws IOException {

        List<Producto> lista = new ArrayList<>();
        Scanner sc = new Scanner(new File("Productos.csv"));

        sc.nextLine();

        while (sc.hasNextLine()) {
            String[] datos = sc.nextLine().split(",");

            lista.add(new Producto(
                Integer.parseInt(datos[0]),
                datos[1],
                datos[2],
                Double.parseDouble(datos[3]),
                Integer.parseInt(datos[4])
            ));
        }

        sc.close();
        return lista;
    }
}