package Producto;

public class Producto {
    private int codigo;
    private String nombre;
    private float precio;
    private int cantidad;

    public Producto(int codigo, String nombre, float precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = 0;
    }

    public void mostrarDatos() {
        System.out.println("Código: " + codigo);
        System.out.println("Nombre: " + nombre);
        System.out.println("Precio unitario: " + precio);
        System.out.println("Cantidad en stock: " + cantidad);
        System.out.println("-----------------------------");
    }
}
