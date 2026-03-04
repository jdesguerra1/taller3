public class Opcion2 {
        public static void AgregarunNuevoCliente(){


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

    sc2.close();

} catch (IOException e) {
    System.out.println("Error al agregar cliente.");
}}}