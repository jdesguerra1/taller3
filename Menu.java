import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;
public class Menu{
    public static void main (String[] args) {

        Scanner sc=new Scanner(System.in);
        int opcion=0;

        while (opcion!=5) {
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
                    //Jose
                    break;
                case 2:
                    //Jairo
                    break;
                case 3:
                    //Jesus
                    break;
                case 4:
                    //Daniela
                    
                    try {

        ArrayList<Cliente> clientes = new ArrayList<>();
        ArrayList<Pedido> pedidos = new ArrayList<>();
        ArrayList<Cliente> compradores = new ArrayList<>();

        // Leer clientes
        BufferedReader brClientes = new BufferedReader(new FileReader("pedidos.csv"));
        String linea = brClientes.readLine(); // saltar encabezado

        while ((linea = brClientes.readLine()) != null) {
            String[] datos = linea.split(",");
            clientes.add(new Cliente(
                    Integer.parseInt(datos[0]),
                    datos[1],
                    datos[2]
            ));
        }
        brClientes.close();

        // Leer pedidos
        BufferedReader brPedidos = new BufferedReader(new FileReader("pedidos.csv"));
        brPedidos.readLine(); // saltar encabezado

        while ((linea = brPedidos.readLine()) != null) {
            String[] datos = linea.split(",");
            pedidos.add(new Pedido(
                    Integer.parseInt(datos[0]),
                    Integer.parseInt(datos[1]),
                    Integer.parseInt(datos[2]),
                    Integer.parseInt(datos[3]),
                    datos[4]
            ));
        }
        brPedidos.close();

        // Buscar clientes que han comprado
        for (Cliente c : clientes) {
            for (Pedido p : pedidos) {
                if (c.id == p.clienteId) {
                    compradores.add(c);
                    break; // evita repetir cliente
                }
            }
        }

        // ORDENAMIENTO BURBUJA (alfabético por nombre)
        for (int i = 0; i < compradores.size() - 1; i++) {
            for (int j = 0; j < compradores.size() - i - 1; j++) {
                if (compradores.get(j).nombre
                        .compareToIgnoreCase(compradores.get(j + 1).nombre) > 0) {

                    Cliente temp = compradores.get(j);
                    compradores.set(j, compradores.get(j + 1));
                    compradores.set(j + 1, temp);
                }
            }
        }

        // Mostrar resultado
        System.out.println("\nClientes que han realizado compras:");
        for (Cliente c : compradores) {
            System.out.println(c.nombre + " - " + c.email);
        }

    } catch (Exception e) {
        System.out.println("Error al leer archivos.");
    }

    break;
                case 5:
                    //  Quin sea
                default:
                    break;
            }
            
        }
    }
}