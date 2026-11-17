public interface MetodoPago {
    boolean procesarPago(double monto);
    String obtenerNombreMetodo();
    double calcularComision();   // comisión sobre el último monto procesado
}
