import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.agregarLibro(new Libro("001", "Java"));
        biblioteca.agregarLibro(new Libro("002", "POO"));
        int opcion;
        do {
            System.out.println("\n===== BIBLIOTECA =====");
            System.out.println("1. Consultar libros");
            System.out.println("2. Prestar libro");
            System.out.println("3. Devolver libro");
            System.out.println("4. Verificar inventario");
            System.out.println("5. Salir");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                case 1:

                    biblioteca.consultarLibros();
                    break;

                case 2:

                    System.out.print("ISBN: ");
                    String isbnPrestamo = sc.nextLine();

                    biblioteca.prestarLibro(isbnPrestamo);
                    break;

                case 3:

                    System.out.print("ISBN: ");
                    String isbnDevolver = sc.nextLine();

                    System.out.print("Fecha limite (AAAA-MM-DD): ");
                    String fecha = sc.nextLine();

                    LocalDate fechaLimite = LocalDate.parse(fecha);

                    biblioteca.devolverLibro(isbnDevolver, fechaLimite);
                    break;

                case 4:

                    System.out.print("ISBN: ");
                    String isbnBuscar = sc.nextLine();

                    Libro libro = biblioteca.verificarInventario(isbnBuscar);

                    if (libro != null) {
                        System.out.println(libro);
                    } else {
                        System.out.println("Libro no encontrado.");
                    }

                    break;

                case 5:

                    System.out.println("Saliendo...");
                    break;

                default:

                    System.out.println("Opcion invalida.");
            }

        } while (opcion != 5);
    }
}