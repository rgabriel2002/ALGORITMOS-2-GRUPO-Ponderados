package proyecto1.Producto;

import Producto.Producto;

public class Main {
    public static void main(String[] args) {
        Producto producto1 = new Producto(23, "Martillo", 2000);
        Producto producto2 = new Producto(24, "Destornillador", 1500);

        producto1.mostrarDatos();
        producto2.mostrarDatos();

        producto1.ingresarStock(10);
        producto1.ingresarStock(5);
        System.out.println("Stock actual de Martillo: " + producto1.consultarStock());
    }
}
