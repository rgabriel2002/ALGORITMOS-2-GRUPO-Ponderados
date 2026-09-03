import Cola_Estatica.ColaEstatica;
import Cola_Estatica.ColaTDA;
import Cola_Prioridad_Estatica.ColaPrioridadEstatica;
import Cola_Prioridad_Estatica.ColaPrioridadTDA;
import Pilas_estaticas.*;


public class GuiaClase4 {
    //EJERCICIO 1
    /*
    * a) Indicá los tres valores mostrados por pantalla.
    *  b) Escribí el estado final de la pila en formato: base -> ... -> tope. c)
    *  ¿Qué elemento fue el primero en ingresar a la pila?
    * d) ¿Qué elemento sería
    *
    *Los 3 valores mostrados son 5,3 y 15
    * estado final 15
    * el primer elemento en ingresar fue 8
    * Proximo elemento en salir 15
    *  */
    //EJERCICIO 2
    public static int contarElmentosPila(PilaTDA p1){
        int cont=0;
        PilaTDA aux = new Estrategia_1();
        aux.InicializarPila();

        while (!p1.PilaVacia()){
            cont++;
            aux.Apilar(p1.Tope());
            p1.Desapilar();
        }

        while (!aux.PilaVacia()){
            p1.Apilar(aux.Tope());
            aux.Desapilar();
        }

        return cont;
    }

    //EJERCICIO 3
    public static boolean buscarElmentosPila(PilaTDA p1 ,int elemento){
        PilaTDA aux = new Estrategia_1();
        aux.InicializarPila();
        boolean flag=false;
        while (!p1.PilaVacia()){
            aux.Apilar(p1.Tope());
            if (p1.Tope()==elemento)
                flag=true;
            p1.Desapilar();

        }

        while (!aux.PilaVacia()){
            p1.Apilar(aux.Tope());
            aux.Desapilar();
        }


        return flag;

    }
    // EJERCICIO 4

    //EJERCICIO 5
    public static  int sumElmentosCola(ColaTDA c1){
        int total=0;
        ColaTDA aux= new ColaEstatica();
        aux.InicializarCola();

        while (!c1.ColaVacia()){
            int val = c1.Primero();
            aux.Acolar(val);
            total+=val;
            c1.Desacolar();

        }

        while (!aux.ColaVacia()){
            c1.Acolar(aux.Primero());
            c1.Desacolar();
        }
        return total;
    }

    //EJERCICIO 6
    public  static void eliminarElementosCola (ColaTDA c1 , int x){
        ColaTDA aux = new ColaEstatica();
        aux.InicializarCola();


        while (!c1.ColaVacia()){
            int elemento = c1.Primero();
            if (elemento!=x){
                aux.Acolar(elemento);
            }
            c1.Desacolar();
        }

        while (!aux.ColaVacia()){
            c1.Acolar(aux.Primero());
            aux.Desacolar();
        }

    }

    // EJERCICIO 7
    /*Los valores de (a), (b), (c) y (d). El estado de las tres subcolas antes de los dos Desacolar. El estado de las tres subcolas después de los dos Desacolar
    VALOR DE A=15 VALOR B=0
    VALOR DE C=8 VALOR D=1
    ESTADO 8,1 - 6,130, 2 - 20,2 - 30, 2
    * */


    // EJERCICIO 8
    public static int contarElementosPrioridad (ColaPrioridadTDA cp, int p){
        int cont=0;
        ColaPrioridadTDA aux = new ColaPrioridadEstatica();
        aux.InicializarColaPrioridad();

        while (!cp.ColaVacia()){
            int prioirdad=cp.Prioridad();
            int elemento = cp.Primero();


            if (prioirdad==p){
                cont++;
            }
            aux.AcolarPrioridad(elemento,prioirdad);
            cp.Desacolar();

        }


        while (!aux.ColaVacia()){
            cp.AcolarPrioridad(aux.Primero(),aux.Prioridad());
            aux.Desacolar();
        }
       return cont;
    }


    //EJERCICIO 9
    public static void eliminarPrioridad(ColaPrioridadTDA cp, int p){
        ColaPrioridadTDA aux = new ColaPrioridadEstatica();
        aux.InicializarColaPrioridad();

        while (!cp.ColaVacia()){
            int prioirdad=cp.Prioridad();
            int elemento = cp.Primero();


            if (prioirdad!=p){
                aux.AcolarPrioridad(elemento,prioirdad);
            }
            cp.Desacolar();

        }


        while (!aux.ColaVacia()){
            cp.AcolarPrioridad(aux.Primero(),aux.Prioridad());
            aux.Desacolar();
        }


    }

    // EJERCICIO 10

    /*
    * Para cada situación, indicá si corresponde utilizar Pila, Cola o Cola con Prioridad y justificá brevemente la elección.
    * 1. Sistema que mantiene las últimas acciones realizadas para implementar Deshacer.
    *  2. Turnos atendidos estrictamente por orden de llegada.
    * 3. Procesamiento de incidentes donde los críticos deben atenderse antes que los normales.
    * 4. Historial de páginas para implementar el botón Atrás.
    *  5. Trabajos enviados a una impresora y atendidos por orden de llegada.
    *  6. Solicitudes de soporte clasificadas como crítica, alta, media y baja.
    *
    *
    * 1)pila
    * 2) cola
    * 3) cola prioridad
    * 4)pila
    * 5) cola
    * 6) cola prioridad
    * */

    public static void main(String[] args) {
        PilaTDA p1 = new Estrategia_1();

        p1.InicializarPila();
        p1.Apilar(10);
        p1.Apilar(20);
        p1.Apilar(30);



        ColaTDA t1 = new ColaEstatica();
        t1.InicializarCola();
        t1.Acolar(8);
        t1.Acolar(3);
        t1.Acolar(5);
        t1.Acolar(3);
        t1.Acolar(9);
        t1.Acolar(3);


        ColaPrioridadTDA c = new ColaPrioridadEstatica();
        c.InicializarColaPrioridad();

        c.AcolarPrioridad(2,3);
        c.AcolarPrioridad(1,3);
        c.AcolarPrioridad(5,1);
        c.AcolarPrioridad(7,0);


        eliminarPrioridad(c,3);




        while (!c.ColaVacia()){
            System.out.println(c.Primero() + " /"+ c.Prioridad());
            c.Desacolar();
        }

        //eliminarElementosCola(t1,3);


    }
}
