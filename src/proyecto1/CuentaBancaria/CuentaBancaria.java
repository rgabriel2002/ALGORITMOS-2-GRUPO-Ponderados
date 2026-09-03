package CuentaBancaria;

public class CuentaBancaria {
    private String nombres;
    private String apellidos;
    private String numeroCuenta;
    private TipoCuenta tipoCuenta;
    private double saldo;
    private double tasaInteresMensual;
    private boolean activa;

    public CuentaBancaria(String nombres, String apellidos, String numeroCuenta, TipoCuenta tipoCuenta) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.numeroCuenta = numeroCuenta;
        this.tipoCuenta = tipoCuenta;
        this.saldo = 0;
        this.tasaInteresMensual = 0;
        this.activa = true;
    }

    public void mostrarDatos() {
        System.out.println("Titular: " + nombres + " " + apellidos);
        System.out.println("Número de cuenta: " + numeroCuenta);
        System.out.println("Tipo de cuenta: " + tipoCuenta);
        System.out.println("Saldo: " + saldo);
        System.out.println("Activa: " + activa);
        System.out.println("-----------------------------");
    }

    public double consultarSaldo() {
        return saldo;
    }

    public void consignar(double valor) {
        if (!activa) {
            System.out.println("No se puede consignar: la cuenta está inactiva.");
            return;
        }

        if (valor<=0){
            System.out.println("el valor debe ser mayor a cero");
            return;
        }
        saldo += valor;
    }

    public boolean retirar(double valor) {
        if (!activa) {
            System.out.println("No se puede retirar: la cuenta está inactiva.");
            return false;
        }

        if (valor<=0) { 
             System.out.println("El valor debe ser mayor a cero");
            return false;
        }
        if (valor > saldo) {
            System.out.println("No se puede retirar: fondos insuficientes.");
            return false;
        }
        saldo -= valor;
        if (saldo == 0) {
            activa = false;
        }
        return true;
    }

    public void setTasaInteres(double tasaInteresMensual) {
        this.tasaInteresMensual = tasaInteresMensual;
    }

    public double aplicarInteres() {
        saldo += saldo * (tasaInteresMensual / 100);
        return saldo;
    }

    public boolean compararSaldo(CuentaBancaria otraCuenta) {
        return this.saldo >= otraCuenta.saldo;
    }

    public boolean transferir(CuentaBancaria destino, double valor) {
        if(destino == null){
            System.out.println("la cuenta destino no existe");
            return false;
        }
        if (!destino.activa){
            System.out.println("la cuenta destino esta inactiva");
            return false;
            
        }
        
        if (retirar(valor)) {
            destino.consignar(valor);
            return true;
        }
        return false;
    }
}
