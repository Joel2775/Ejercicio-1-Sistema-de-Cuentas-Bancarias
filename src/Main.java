//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        try {
            System.out.println("=== CUENTA DE AHORROS ===");
            CuentaAhorros ca = new CuentaAhorros("1234567890", "Juan Perez", 200);
            ca.depositar(300);
            ca.retirar(450);

            System.out.println("\n=== CUENTA CORRIENTE ===");
            CuentaCorriente cc = new CuentaCorriente("0987654321", "Maria Nuñes", 1000);
            cc.retirar(1200);
            cc.trasnferir(300,"0147258369");

            System.out.println("\n=== SALDOS FINALES ===");
            System.out.println("Cuenta Ahooros: " + ca.consultarSaldo());
            System.out.println("Cuenta Corriente: " + cc.consultarSaldo());
        }catch (IllegalArgumentException e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}