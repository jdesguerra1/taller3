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

                    try {

                        //LEER PRODUCTOS
                        BufferedReader brProductos =
                                new BufferedReader(new FileReader("productos.csv"));

                        String linea = brProductos.readLine();

                        int MAX = 100;

                        int[] idProductos = new int[MAX];
                        String[] nombres = new String[MAX];
                        double[] precios = new double[MAX];
                        double[] totalVentas = new double[MAX];

                        int nProductos = 0;

                        while ((linea = brProductos.readLine()) != null) {

                            String[] datos = linea.split(",");

                            idProductos[nProductos] = Integer.parseInt(datos[0]);
                            nombres[nProductos] = datos[1];
                            precios[nProductos] = Double.parseDouble(datos[3]);
                            totalVentas[nProductos] = 0;

                            nProductos++;
                        }

                        brProductos.close();

                        //LEER PEDIDOS
                        BufferedReader brPedidos =
                                new BufferedReader(new FileReader("pedidos.csv"));

                        linea = brPedidos.readLine();

                        while ((linea = brPedidos.readLine()) != null) {

                            String[] datos = linea.split(",");

                            int productoId = Integer.parseInt(datos[2]);
                            int cantidad = Integer.parseInt(datos[3]);

                            for (int i = 0; i < nProductos; i++) {

                                if (idProductos[i] == productoId) {
                                    totalVentas[i] += cantidad * precios[i];
                                    break;
                                }
                            }
                        }

                        brPedidos.close();

                        //ORDENAR 
                        for (int i = 0; i < nProductos - 1; i++) {

                            for (int j = 0; j < nProductos - 1 - i; j++) {

                                if (totalVentas[j] < totalVentas[j + 1]) {

                                    double tempTotal = totalVentas[j];
                                    totalVentas[j] = totalVentas[j + 1];
                                    totalVentas[j + 1] = tempTotal;

                                    String tempNombre = nombres[j];
                                    nombres[j] = nombres[j + 1];
                                    nombres[j + 1] = tempNombre;

                                    int tempId = idProductos[j];
                                    idProductos[j] = idProductos[j + 1];
                                    idProductos[j + 1] = tempId;
                                }
                            }
                        }

                        //MOSTRAR 
                        System.out.println("\nproducto_id,nombre_producto,total");

                        for (int i = 0; i < nProductos; i++) {

                            if (totalVentas[i] > 0) {
                                System.out.println(
                                        idProductos[i] + "," +
                                        nombres[i] + "," +
                                        totalVentas[i]);
                            }
                        }

                        // GUARDAR CSV 
                        PrintWriter pw =
                                new PrintWriter(new FileWriter("total_ventas.csv"));

                        pw.println("producto_id,nombre_producto,total");

                        for (int i = 0; i < nProductos; i++) {

                            if (totalVentas[i] > 0) {
                                pw.println(
                                        idProductos[i] + "," +
                                        nombres[i] + "," +
                                        totalVentas[i]);
                            }
                        }

                        pw.close();

                        System.out.println("\nArchivo total_ventas.csv generado correctamente.");

                    } catch (IOException e) {
                        System.out.println("Error leyendo archivos: " + e.getMessage());
                    }

                    break;

                case 4:
                    //jesus;
                    break;

                case 5:
                    // Quin sea
                default:
                    break;

                default:
                    System.out.println("Opción inválida");
            }

        }

        sc.close();
    }
}
            
        