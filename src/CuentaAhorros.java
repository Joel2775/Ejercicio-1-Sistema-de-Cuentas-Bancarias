public class CuentaAhorros implements OperacionesBancarias{
    private String numeroCuenta;
    private String titular;
    private double saldo;

    public CuentaAhorros(String numeroCuenta, String titular, double saldo) {
        if(saldo < 0){
            throw new IllegalArgumentException("el saldo no debe ser una cantidad negativa");
        }
        this.numeroCuenta = numeroCuenta;
        this.titular = titular;
        this.saldo = saldo;
    }

    @Override
    public void depositar(double monto) {
        saldo += monto;
        System.out.println("Deposito: $" + monto + " - Saldo: $" + consultarSaldo());
    }

    @Override
    public boolean retirar(double monto) {
        if (saldo >= monto) {
            saldo -= monto;
            System.out.println("Retiro $" + monto + " - Saldo: $" + consultarSaldo());
            if (saldo < 100) {
                saldo -= 5;
                System.out.println("Comisión aplicada: $5.0 - Saldo: $" + consultarSaldo());
            }
            return true;
        }
        return false;
    }


    @Override
    public double consultarSaldo() {
        return saldo;
    }
}
