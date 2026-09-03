import CuentaBancaria.CuentaBancaria;
import CuentaBancaria.TipoCuenta;

public class MainCuentaBancaria {
    public static void main(String[] args) {
        CuentaBancaria cuenta1 = new CuentaBancaria("Juan", "Pérez", "001-123", TipoCuenta.AHORROS);
        CuentaBancaria cuenta2 = new CuentaBancaria("Ana", "Gómez", "002-456", TipoCuenta.CORRIENTE);

        cuenta1.mostrarDatos();
        cuenta2.mostrarDatos();

        // Parte A: consignar, consultar saldo y retirar
        cuenta1.consignar(5000);
        cuenta2.consignar(3000);
        System.out.println("Saldo cuenta1: " + cuenta1.consultarSaldo());
        System.out.println("Saldo cuenta2: " + cuenta2.consultarSaldo());

        cuenta1.retirar(10000);
        cuenta1.retirar(2000);
        System.out.println("Saldo cuenta1 tras retiros: " + cuenta1.consultarSaldo());

        // Parte B: interés mensual
        cuenta1.setTasaInteres(2);
        System.out.println("Saldo cuenta1 con interés: " + cuenta1.aplicarInteres());

        // Parte C: comparar saldos y transferir
        System.out.println("¿cuenta1 >= cuenta2? " + cuenta1.compararSaldo(cuenta2));

        cuenta1.transferir(cuenta2, 1000);
        System.out.println("Saldo cuenta1 tras transferencia: " + cuenta1.consultarSaldo());
        System.out.println("Saldo cuenta2 tras transferencia: " + cuenta2.consultarSaldo());

        // Retirar todo el saldo deja la cuenta inactiva
        cuenta2.retirar(cuenta2.consultarSaldo());
        cuenta2.mostrarDatos();
        cuenta2.consignar(500);
    }
}
