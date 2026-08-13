import Producto.Producto;

public class Main {
    public static void main(String[] args) {
        Producto producto1 = new Producto(23, "Martillo", 2000);
        Producto producto2 = new Producto(24, "Destornillador", 1500);

        producto1.mostrarDatos();
        producto2.mostrarDatos();
    }
}
