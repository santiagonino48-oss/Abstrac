public class PayPal implements MetodoPago {
    private String email;
    private double saldoDisponible;
    private double ultimoMonto;

    public PayPal(String email, double saldoDisponible) {
        this.email = email;
        this.saldoDisponible = saldoDisponible;
    }

    @Override
    public boolean procesarPago(double monto) {
        ultimoMonto = monto;
        double total = monto + calcularComision();
        if (saldoDisponible < total) {
            System.out.printf("  Rechazado: saldo insuficiente (disponible $%.2f, requerido $%.2f).%n",
                    saldoDisponible, total);
            return false;
        }
        saldoDisponible -= total;
        return true;
    }

    @Override
    public String obtenerNombreMetodo() { return "PayPal (" + email + ")"; }

    @Override
    public double calcularComision() { return ultimoMonto * 0.018; }

    public double getSaldoDisponible() { return saldoDisponible; }
}
