package ejpila;

public class Pila {

    private int[] datos;
    private int tope;

    public Pila(int tamaño) {
        datos = new int[tamaño];
        tope = -1;
    }

    public void Apilar(int dato) {
        if (tope < datos.length - 1) {
            tope++;
            datos[tope] = dato;
        } else {
            System.out.println("La pila esta llena");
        }
    }

    public void Desapilar() {
        if (!PilaVacia()) {
            tope--;
        } else {
            System.out.println("La pila esta vacia");
        }
    }

    public int Tope() {
        if (!PilaVacia()) {
            return datos[tope];
        } else {
            System.out.println("La pila esta vacia");
            return -1;
        }
    }

    public boolean PilaVacia() {
        return tope == -1;
    }
}