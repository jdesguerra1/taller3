import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

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
                    // Jose
                    break;
                case 2:
                    // Jairo

                    try {

                        Scanner sc2 = new Scanner(System.in);

                        BufferedReader br = new BufferedReader(new FileReader("clientes.csv"));
                        String linea;
                        int ultimoId = 0;

                        br.readLine();

                        while ((linea = br.readLine()) != null) {
                            String[] datos = linea.split(",");
                            ultimoId = Integer.parseInt(datos[0]);
                        }

                        br.close();

                        int nuevoId = ultimoId + 1;

                        System.out.print("Ingrese nombre del cliente: ");
                        String nombre = sc2.nextLine();

                        System.out.print("Ingrese email del cliente: ");
                        String email = sc2.nextLine();

                        FileWriter fw = new FileWriter("clientes.csv", true);
                        fw.write("\n" + nuevoId + "," + nombre + "," + email);
                        fw.close();

                        System.out.println("Cliente agregado correctamente.");

                    } catch (IOException e) {
                        System.out.println("Error al agregar cliente.");
                    }

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