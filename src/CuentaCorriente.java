public class CuentaCorriente implements OperacionesBancarias, Transferible{
    private String numeroCuenta;
    private String titular;
    private double saldo;
    private double sobregiro = -500;

    public CuentaCorriente(String numeroCuenta, String titular, double saldo) {
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
        if (saldo > sobregiro){
            saldo -= monto;
            System.out.println("Retiro $" + monto + " - Saldo: $" + consultarSaldo()  + " (sobregiro usado)");
            return true;
        }
        return false;
    }

    @Override
    public double consultarSaldo() {
        return saldo;
    }

    @Override
    public boolean trasnferir(double monto, String cuentaDestino) {
        if (saldo > sobregiro){
            saldo -= monto;
            System.out.println("Transferencia: $" + monto + " a cuenta " + cuentaDestino + " - saldo: $" + consultarSaldo());
            return true;
        }
        return false;
    }
}
