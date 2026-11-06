import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class Productos {
    record Producto(String nombre, String categoria, double precio, int stock) {}

    static final List<Producto> productos = List.of(
        new Producto("Teclado", "Perifericos", 35, 12),
        new Producto("Mouse", "Perifericos", 18, 25),
        new Producto("Monitor", "Pantallas", 180, 6),
        new Producto("SSD", "Almacenamiento", 65, 15),
        new Producto("Memoria RAM", "Componentes", 80, 9),
        new Producto("Webcam", "Perifericos", 45, 0),
        new Producto("Disco HDD", "Almacenamiento", 55, 4),
        new Producto("Audifonos", "Audio", 40, 20),
        new Producto("Parlantes", "Audio", 70, 7),
        new Producto("Laptop", "Computadoras", 750, 3)
    );

    public static void main(String[] args) {
        // Filtra los productos con precio mayor a 50.
        String seleccion = productos.stream().filter(p -> p.precio() > 50)
            .map(Producto::nombre).collect(Collectors.joining(", "));
        System.out.println("1. Seleccion: " + seleccion);

        String descuentos = productos.stream()
            .map(p -> String.format(Locale.US, "%s: %.2f", p.nombre(), p.precio() * 0.9))
            .collect(Collectors.joining(" | "));
        System.out.println("2. Transformacion: " + descuentos);

        boolean agotados = productos.stream().anyMatch(p -> p.stock() == 0);
        System.out.println("3. Validacion: " + agotados);

        long stockBajo = productos.stream().filter(p -> p.stock() < 10).count();
        System.out.println("4. Conteo: " + stockBajo);

        Producto masCaro = productos.stream()
            .max((a, b) -> Double.compare(a.precio(), b.precio())).orElseThrow();
        System.out.println("5. Extremos: " + masCaro.nombre() + " ($" + (int)masCaro.precio() + ")");
    }
}
