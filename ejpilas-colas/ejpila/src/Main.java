package ejpila;

public class Main {

    public static void main(String[] args) {

        Pila pila = new Pila(5);

        pila.Apilar(13);
        pila.Apilar(22);
        pila.Apilar(37);

        System.out.println("Tope: " + pila.Tope());

        pila.Desapilar();

        System.out.println("Nuevo tope: " + pila.Tope());

        if (pila.PilaVacia()) {
            System.out.println("La pila esta vacia");
        } else {
            System.out.println("La pila tiene elementos");
        }
    }
}