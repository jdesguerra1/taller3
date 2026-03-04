import java.io.IOException;
import java.util.List;
import java.util.Scanner;


public class Menu {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        int opcion = 0;

        while (opcion != 5) {
            System.out.println("===== SISTEMA E-COMMERCE =====");
            System.out.println("1. Ver productos ordenados por precio");
            System.out.println("2. Agregar un nuevo cliente");
            System.out.println("3. Calcular total de ventas por producto");
            System.out.println("4. Ver clientes que han realizado compras");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    Opcion1.mostrarProductosOrdenados();
                    break;
                case 2:
                    // Jairo
                    break;
                case 3:
                    // Jesus
                    break;
                case 4:
                    // Daniela
                    break;
                case 5:
                    // Quin sea
                default:
                    break;
            }

        }
    }
}