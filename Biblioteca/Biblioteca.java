import java.time.LocalDate;
import java.util.ArrayList;

public class Biblioteca {
    private ArrayList<Libro> libros;
    public Biblioteca() {
        libros = new ArrayList<>();
    }
    public void agregarLibro(Libro libro) {
        libros.add(libro);
    }
    public void consultarLibros() {
        for (Libro libro : libros) {
            System.out.println(libro);
        }
    }
    public Libro verificarInventario(String isbn) {
        for (Libro libro : libros) {
            if (libro.getIsbn().equals(isbn)) {
                return libro;
            }
        }
        return null;
    }
    public void prestarLibro(String isbn) {

        Libro libro = verificarInventario(isbn);
        if (libro == null) {
            System.out.println("Libro no encontrado.");
            return;
        }
        if (!libro.isDisponible()) {
            System.out.println("Libro no disponible.");
            return;
        }
        libro.setDisponible(false);
        System.out.println("Libro prestado correctamente.");
    }
    public void devolverLibro(String isbn, LocalDate fechaLimite) {
        Libro libro = verificarInventario(isbn);
        if (libro == null) {
            System.out.println("Libro no encontrado.");
            return;
        }
        libro.setDisponible(true);

        System.out.println("Libro devuelto.");

        if (fechaLimite.isBefore(LocalDate.now())) {
            System.out.println("Aplicar multa por retraso.");
        }
    }
}
